package pdi;

import java.awt.EventQueue;

import javax.swing.JFrame;
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

public class pdiEvaluaGente {

	private JFrame frmAccionsocialmed;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					pdiEvaluaGente window = new pdiEvaluaGente(user);
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
	public pdiEvaluaGente(String user) throws Exception {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize(String user) throws Exception {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(pdiEvaluaGente.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setBounds(100, 100, 557, 366);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		Usuario us= new Usuario(user);

		
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
		
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		List<Object[]> lista = Usuario.listaUsuarios();
		
		for(Usuario us : lista) {
			if(us.estaParticipando(act) && noEstaEvaluado(us,act) ) {
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
				frmAccionsocialmed.dispose();
			}
		});
		
		btnVerAlumno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					pdiEvaluaGente2.main((String)modelo.getValueAt(table.getSelectedRow(), 0), user);
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
		} );
		
		
	}

	private boolean noEstaEvaluado(Usuario us, Actividad act) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		boolean res =  bd.select("select numeroHoras from participacion where correoUsuario = 'j' and idActividad = '43'; " ).get(0) != null ;
		System.out.println(res);
		return res;
	}
}


