package ong;

import ong.ongSubirProyecto;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import login.loginView;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Toolkit;

public class ongMainView {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ongMainView window = new ongMainView();
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
	public ongMainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/icono pequeno.png"));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 272, 281);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JButton btnSubirProyecto = new JButton("Subir actividad");
		btnSubirProyecto.setBounds(66, 112, 126, 23);
		frmAccionsocialmed.getContentPane().add(btnSubirProyecto);
		
		JButton btnMisProyectos = new JButton("Mis actividades");
		btnMisProyectos.setBounds(66, 146, 126, 23);
		frmAccionsocialmed.getContentPane().add(btnMisProyectos);
		
		JButton btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesin.setBounds(66, 210, 126, 23);
		frmAccionsocialmed.getContentPane().add(btnCerrarSesin);
		
		JLabel lblnombreDeLa = new JLabel("\"Correo de la ong\"");
		lblnombreDeLa.setBounds(72, 11, 133, 22);
		frmAccionsocialmed.getContentPane().add(lblnombreDeLa);
		
		JButton btnSolicitudes = new JButton("Solicitudes");
		btnSolicitudes.setBounds(66, 78, 126, 23);
		frmAccionsocialmed.getContentPane().add(btnSolicitudes);
		
		JButton btnActividades = new JButton("Actividades");
		btnActividades.setBounds(66, 44, 126, 23);
		frmAccionsocialmed.getContentPane().add(btnActividades);
		
		btnSubirProyecto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ongSubirProyecto.main(null);
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
	}
}
