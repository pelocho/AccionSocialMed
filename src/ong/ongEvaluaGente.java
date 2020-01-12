package ong;

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

public class ongEvaluaGente {

	private JFrame frmAccionsocialmed;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					ongEvaluaGente window = new ongEvaluaGente(id);
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
	public ongEvaluaGente(int id) throws Exception {
		initialize(id);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize(int id) throws Exception {
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
				"Correo", "Nombre"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(160);
		table.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(table);
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		List<Usuario> lista = Usuario.listaUsuarios();
		
		for(Usuario us : lista) {
			if(us.estaParticipando(act) ) {
				Object[] prueba = {us.getEmail(), us.getNombre() } ;
				modelo.addRow(prueba) ;
			}
		}

		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(10, 11, 41, 23);
		frmAccionsocialmed.getContentPane().add(btnVolver);
		
		JButton btnVerAlumno = new JButton("Ver alumno");
		btnVerAlumno.setBackground(Color.LIGHT_GRAY);
		btnVerAlumno.setBounds(420, 11, 112, 23);
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
					ongEvaluaGente2.main((String)modelo.getValueAt(table.getSelectedRow(), 0), id);
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
		} );
		
		
	}
}


