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

public class ongMainView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ongMainView window = new ongMainView();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 272, 266);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JLabel lblAccionsocialmed = new JLabel("AccionSocialMed");
		menuBar.add(lblAccionsocialmed);
		frame.getContentPane().setLayout(null);
		
		JButton btnSubirProyecto = new JButton("Subir proyecto");
		btnSubirProyecto.setBounds(66, 78, 126, 23);
		frame.getContentPane().add(btnSubirProyecto);
		
		JButton btnMisProyectos = new JButton("Mis proyectos");
		btnMisProyectos.setBounds(66, 112, 126, 23);
		frame.getContentPane().add(btnMisProyectos);
		
		JButton btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesin.setBounds(66, 172, 126, 23);
		frame.getContentPane().add(btnCerrarSesin);
		
		JLabel lblnombreDeLa = new JLabel("\"Nombre de la ong\"");
		lblnombreDeLa.setBounds(72, 11, 133, 22);
		frame.getContentPane().add(lblnombreDeLa);
		
		JButton btnSolicitudes = new JButton("Solicitudes");
		btnSolicitudes.setBounds(66, 44, 126, 23);
		frame.getContentPane().add(btnSolicitudes);
		
		btnSubirProyecto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ongSubirProyecto.main(null);
				frame.dispose();
			}
		});
		
		btnCerrarSesin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginView.main(null);
				frame.dispose();
			}
		});
	}
}
