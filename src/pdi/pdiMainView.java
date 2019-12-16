package pdi;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import alumno.vistaActividad;
import gestor.vistaActividadDetallesActs;
import home.homeView;
import main.MySQLBD;
import modelos.Usuario;
import ong.ongMainView;
import ong.ongSubirActividad;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

public class pdiMainView {

	private JFrame frmAccionsocialmed;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pdiMainView window = new pdiMainView(user);
					window.frmAccionsocialmed.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public pdiMainView(String user) {
		Usuario u = new Usuario(0, user, null, 0, null, null, null);
		initialize(u.getEmail());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String user) {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(ongMainView.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 836, 436);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		Usuario pdi = new Usuario(user);
		
		JButton btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesin.setBackground(Color.LIGHT_GRAY);
		btnCerrarSesin.setBounds(680, 11, 130, 23);
		frmAccionsocialmed.getContentPane().add(btnCerrarSesin);
		
		JLabel lblnombreDeLa = new JLabel(user);
		lblnombreDeLa.setBounds(10, 11, 228, 22);
		frmAccionsocialmed.getContentPane().add(lblnombreDeLa);
		
		JButton btnSolicitudesDeAlumnos = new JButton("Solicitudes de Alumnos");
		btnSolicitudesDeAlumnos.setBackground(Color.LIGHT_GRAY);
		btnSolicitudesDeAlumnos.setBounds(297, 11, 186, 23);
		frmAccionsocialmed.getContentPane().add(btnSolicitudesDeAlumnos);
		
		JButton btnSolicitudesONG = new JButton("Solicitudes de ONG");
		btnSolicitudesONG.setBackground(Color.LIGHT_GRAY);
		btnSolicitudesONG.setBounds(493, 11, 177, 23);
		frmAccionsocialmed.getContentPane().add(btnSolicitudesONG);
		
		JButton btnEditarPerfil = new JButton("Editar perfil");
		btnEditarPerfil.setBackground(Color.LIGHT_GRAY);
		btnEditarPerfil.setBounds(178, 11, 109, 23);
		frmAccionsocialmed.getContentPane().add(btnEditarPerfil);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 800, 305);
		frmAccionsocialmed.getContentPane().add(scrollPane);
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titulo", "Lugar", "Horas", "Organizaci\u00F3n"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(230);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(55);
		table.getColumnModel().getColumn(2).setMinWidth(1);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(226);
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		scrollPane.setViewportView(table);
		
		JButton btnVerActividad = new JButton("Ver actividad");
		btnVerActividad.setBackground(Color.LIGHT_GRAY);
		btnVerActividad.setBounds(10, 364, 116, 23);
		frmAccionsocialmed.getContentPane().add(btnVerActividad);
		
		btnCerrarSesin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homeView.main(null);
				frmAccionsocialmed.dispose();
			}
		});
		
		btnSolicitudesDeAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pdiSolicitudesAlumnosView.main(null);
			}
		});
		
	/*	btnSolicitudesONG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pdiSolicitudesAlumnos.main(null);
				frmAccionsocialmed.dispose();
			}
		});*/
		
	
		
		btnSolicitudesONG.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
					pdiSolicitudesONG.main(user);
							
			}
		});
		
	}
}
