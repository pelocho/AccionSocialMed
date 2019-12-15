package pdi;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import alumno.alumnoMainView;
import alumno.funcionesCompartidas;
import alumno.vistaActividad;
import home.homeView;
import main.MySQLBD;
import modelos.Actividad;
import modelos.Usuario;
import pantallasCompartidas.editarPerfilView;

public class pdiActividadesView {
	private JFrame frmAccionsocialmed;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pdiActividadesView window = new pdiActividadesView(user);
					window.frmAccionsocialmed.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public pdiActividadesView(String user) throws Exception {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize(String user) throws Exception {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(pdiActividadesView.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 736, 515);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 700, 388);
		frmAccionsocialmed.getContentPane().add(scrollPane);

		table = new JTable();
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titulo", "Lugar", "Horas"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(112);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(86);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(485);
		table.getColumnModel().getColumn(2).setMinWidth(1);
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		Usuario al = new Usuario(user); 
		
		for (Actividad a : funcionesCompartidas.listaOrdenada(al)) {
			Object[] prueba = {a.getTitulo(),a.getLugar(), a.getHoras() }; 		// Inserta todas las actividades de ese alumno de forma ordenada
			modelo.addRow(prueba);
		}
		scrollPane.setViewportView(table);

		JButton btnEditarPerfil = new JButton("Editar perfil");
		btnEditarPerfil.setBounds(230, 11, 117, 23);
		frmAccionsocialmed.getContentPane().add(btnEditarPerfil);

		JLabel label = new JLabel(user);
		label.setBounds(10, 11, 200, 23);
		frmAccionsocialmed.getContentPane().add(label);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(593, 11, 117, 23);
		frmAccionsocialmed.getContentPane().add(btnVolver);

		JButton btnVisualizarActividad = new JButton("Ver actividad");
		btnVisualizarActividad.setBackground(Color.LIGHT_GRAY);
		
		btnVisualizarActividad.setBounds(10, 444, 117, 23);
		frmAccionsocialmed.getContentPane().add(btnVisualizarActividad);
		
		btnVisualizarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int id = 0;
					MySQLBD bd = new MySQLBD();
					bd.readDataBase();
					String[] res = bd.select("SELECT Codigo FROM actividades WHERE Titulo = '"+ modelo.getValueAt(table.getSelectedRow(), 0) +"';").get(0);
					id = Integer.parseInt(res[0]);
					vistaActividad.main(id);
				} catch (Exception e1) {
					e1.printStackTrace();
				}		
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pdiMainView.main(user);
				frmAccionsocialmed.dispose();
			}
		});
		
		btnEditarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarPerfilView.main(user);
			}
		});
	}
}
