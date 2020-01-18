package ong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JSlider;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.MySQLBD;
import modelos.Actividad;
import modelos.Usuario;

import javax.swing.JButton;
import java.awt.Color;

public class ongEvaluaGente {

	private JFrame frmAccionsocialmed;
	private JTable table;

	/**
	 * Launch the application.
	 * @param user 
	 */
	public static void main(String user, int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					ongEvaluaGente window = new ongEvaluaGente(user,id);
					window.frmAccionsocialmed.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param user 
	 * @throws Exception 
	 */
	public ongEvaluaGente(String user, int id) throws Exception {
		initialize(user,id);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param user 
	 * @throws Exception 
	 */
	private void initialize(String user, int id) throws Exception {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(ongEvaluaGente.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setBounds(100, 100, 557, 366);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		Actividad act = new Actividad(id);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 522, 272);
		frmAccionsocialmed.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Correo", "Nombre", "Actividad"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(140);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		scrollPane.setViewportView(table);
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		List<Usuario> lista = Usuario.listaUsuarios();
		
		
		for(Usuario us : lista) {
			if(us.estaParticipando(act) && !estaEvaluado(us,act) ) {
				Object[] prueba = {us.getEmail(), us.getNombre() } ;
				modelo.addRow(prueba) ;
			}
		}
	

		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(10, 11, 41, 23);
		frmAccionsocialmed.getContentPane().add(btnVolver);
		
		JButton btnVerAlumno = new JButton("Evaluar usuario\r\n");
		btnVerAlumno.setBackground(Color.LIGHT_GRAY);
		btnVerAlumno.setBounds(373, 11, 159, 23);
		frmAccionsocialmed.getContentPane().add(btnVerAlumno);
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(modelo.getRowCount() > 0) {
					JOptionPane.showMessageDialog(frmAccionsocialmed, "Aún quedan alumnos por evaluar" );

				}
				frmAccionsocialmed.dispose();
				ongMisActividadesTableView.main(user);
			}
		});
		
		btnVerAlumno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ongEvaluaGente2.main((String)modelo.getValueAt(table.getSelectedRow(), 0), id);
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
		} );
		
		
	}

	private boolean estaEvaluado(Usuario us, Actividad act) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		boolean res;
		
		List<String[]> l =  bd.select("select valoracionONG from eef_primera_iteracion.participacion "
				+ "WHERE (`correoUsuario` = '" + us.getEmail() + "') and (`idActividad` = '" + act.getCodigo() + "');; " );

		
			res = l.get(0)[0] != null;

		return res ;
	}
}


