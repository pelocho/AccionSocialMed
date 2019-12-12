package ong;

import ong.ongSubirActividad;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import login.loginView;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Toolkit;
import modelos.Usuario;

public class ongMainView {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 */
	public static void main(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ongMainView window = new ongMainView(user);
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
	public ongMainView(String user) {
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
		
		JButton btnSubirProyecto = new JButton("Subir actividad");
		btnSubirProyecto.setBounds(66, 44, 126, 23);
		frmAccionsocialmed.getContentPane().add(btnSubirProyecto);
		
		JButton btnMisProyectos = new JButton("Mis actividades");
		btnMisProyectos.setBounds(66, 78, 126, 23);
		frmAccionsocialmed.getContentPane().add(btnMisProyectos);
		
		JButton btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesin.setBounds(66, 210, 126, 23);
		frmAccionsocialmed.getContentPane().add(btnCerrarSesin);
		
		JLabel lblnombreDeLa = new JLabel(user);
		lblnombreDeLa.setBounds(72, 11, 133, 22);
		frmAccionsocialmed.getContentPane().add(lblnombreDeLa);
		
		JButton btnSolicitudes = new JButton("Solicitudes");
		btnSolicitudes.setBounds(66, 112, 126, 23);
		frmAccionsocialmed.getContentPane().add(btnSolicitudes);
		
		JButton btnActividades = new JButton("Actividades");
		btnActividades.setBounds(66, 146, 126, 23);
		frmAccionsocialmed.getContentPane().add(btnActividades);
		
		btnSubirProyecto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ongSubirActividad.main(user);
			}
		});
		
		btnCerrarSesin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginView.main(null);
				frmAccionsocialmed.dispose();
			}
		});
		
		btnMisProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ongMisActividades.main(user);
			}
		});
	}
}
