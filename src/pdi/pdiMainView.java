package pdi;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import login.loginView;
import modelos.Usuario;
import ong.ongMainView;
import ong.ongMisActividades;
import ong.ongSubirActividad;
import pantallasCompartidas.actividadesView;

public class pdiMainView {

	private JFrame frmAccionsocialmed;

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
		frmAccionsocialmed.setBounds(100, 100, 272, 281);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JButton btnActividades = new JButton("Actividades");
		btnActividades.setBounds(66, 44, 126, 23);
		frmAccionsocialmed.getContentPane().add(btnActividades);
		
		JButton btnMisActividades = new JButton("Mis actividades");
		btnMisActividades.setBounds(66, 78, 126, 23);
		frmAccionsocialmed.getContentPane().add(btnMisActividades);
		
		JButton btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesin.setBounds(66, 210, 126, 23);
		frmAccionsocialmed.getContentPane().add(btnCerrarSesin);
		
		JLabel lblnombreDeLa = new JLabel(user);
		lblnombreDeLa.setBounds(72, 11, 133, 22);
		frmAccionsocialmed.getContentPane().add(lblnombreDeLa);
		
		JButton btnSolicitudesDeAlumnos = new JButton("Solicitudes de Alumnos");
		btnSolicitudesDeAlumnos.setBounds(66, 112, 126, 23);
		frmAccionsocialmed.getContentPane().add(btnSolicitudesDeAlumnos);
		
		JButton btnSolicitudesONG = new JButton("Solicitudes de ONG");
		btnSolicitudesONG.setBounds(66, 146, 126, 23);
		frmAccionsocialmed.getContentPane().add(btnSolicitudesONG);
		
		btnActividades.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actividadesView.main(null);
				frmAccionsocialmed.dispose();
			}
		});
		
		btnMisActividades.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pdiMisActividades.main(null);
				frmAccionsocialmed.dispose();
			}
		});
		
		btnCerrarSesin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginView.main(null);
				frmAccionsocialmed.dispose();
			}
		});
		
		btnSolicitudesDeAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pdiSolicitudesAlumnos.main(null);
				frmAccionsocialmed.dispose();
			}
		});
		
		btnSolicitudesONG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pdiSolicitudesAlumnos.main(null);
				frmAccionsocialmed.dispose();
			}
		});
		
		btnSolicitudesDeAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pdiSolicitudesAlumnosView.main(user);
			}
		});
	}

}
