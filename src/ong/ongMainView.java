package ong;

import ong.ongSubirActividad;
import pantallasCompartidas.mensajesView;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import home.homeView;
import login.loginView;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Toolkit;
import modelos.Usuario;
import java.awt.Color;

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
		frmAccionsocialmed.setBounds(100, 100, 272, 315);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JButton btnSubirProyecto = new JButton("Subir actividad");
		btnSubirProyecto.setBackground(Color.LIGHT_GRAY);
		btnSubirProyecto.setBounds(66, 44, 126, 23);
		frmAccionsocialmed.getContentPane().add(btnSubirProyecto);
		
		JButton btnMisProyectos = new JButton("Mis actividades");
		btnMisProyectos.setBackground(Color.LIGHT_GRAY);
		btnMisProyectos.setBounds(66, 78, 126, 23);
		frmAccionsocialmed.getContentPane().add(btnMisProyectos);
		
		JButton btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesin.setBackground(Color.LIGHT_GRAY);
		btnCerrarSesin.setBounds(66, 242, 126, 23);
		frmAccionsocialmed.getContentPane().add(btnCerrarSesin);
		
		JLabel lblnombreDeLa = new JLabel(user);
		lblnombreDeLa.setBounds(72, 11, 133, 22);
		frmAccionsocialmed.getContentPane().add(lblnombreDeLa);
		
		JButton btnSolicitudes = new JButton("Solicitudes");
		btnSolicitudes.setBackground(Color.LIGHT_GRAY);
		btnSolicitudes.setBounds(66, 112, 126, 23);
		frmAccionsocialmed.getContentPane().add(btnSolicitudes);
		
		JButton btnActividades = new JButton("Actividades");
		btnActividades.setBackground(Color.LIGHT_GRAY);
		btnActividades.setBounds(66, 146, 126, 23);
		frmAccionsocialmed.getContentPane().add(btnActividades);
		
		JButton btnMensajes = new JButton("Mensajes");
		btnMensajes.setBackground(Color.LIGHT_GRAY);
		btnMensajes.setBounds(66, 180, 126, 23);
		frmAccionsocialmed.getContentPane().add(btnMensajes);
		
		btnSubirProyecto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ongSubirActividad.main(user);
			}
		});
		
		btnSolicitudes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ongSolicitudesDeUsuarios.main(user);
			}
		});
		
		btnCerrarSesin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homeView.main(null);
				frmAccionsocialmed.dispose();
			}
		});
		
		btnMisProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ongMisActividadesTableView.main(user);
			}
		});
		
		btnActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ongActividadesView.main(user);
			}
		});
		
		btnMensajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensajesView.main(user);
			}
		});
	}
}
