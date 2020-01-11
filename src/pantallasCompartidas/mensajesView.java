package pantallasCompartidas;

import java.awt.EventQueue;
import pantallasCompartidas.editarPerfilView;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import alumno.alumnoMainView;
import gestor.vistaActividadDetallesActs;
import home.homeView;
import main.MySQLBD;
import modelos.Actividad;
import modelos.Usuario;
import ong.ongMainView;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class mensajesView {

	private JFrame frmAccionsocialmed;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mensajesView window = new mensajesView(user);
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
	 * @wbp.parser.entryPoint
	 */
	public mensajesView(String user) throws Exception {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */
	private void initialize(String user) throws Exception {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(alumnoMainView.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 635, 347);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 600, 219);
		frmAccionsocialmed.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Enviado por:", "Estado"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(315);
		table_1.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(table_1);
		
		
		
		JButton btnNuevoMensaje = new JButton("Nuevo mensaje");
		btnNuevoMensaje.setBackground(Color.LIGHT_GRAY);
		btnNuevoMensaje.setBounds(365, 11, 114, 23);
		frmAccionsocialmed.getContentPane().add(btnNuevoMensaje);
		
		JButton btnVerMensaje = new JButton("Ver mensaje");
		btnVerMensaje.setBackground(Color.LIGHT_GRAY);
		btnVerMensaje.setBounds(489, 11, 121, 23);
		frmAccionsocialmed.getContentPane().add(btnVerMensaje);
		
		JButton btnEliminarMensaje = new JButton("Eliminar mensaje");
		btnEliminarMensaje.setForeground(new Color(204, 0, 0));
		btnEliminarMensaje.setBackground(Color.LIGHT_GRAY);
		btnEliminarMensaje.setBounds(478, 276, 132, 23);
		frmAccionsocialmed.getContentPane().add(btnEliminarMensaje);
		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(10, 11, 41, 23);
		frmAccionsocialmed.getContentPane().add(btnVolver);
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ongMainView.main(user);
				frmAccionsocialmed.dispose();
			}
		});
	}
}
