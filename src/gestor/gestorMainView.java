package gestor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import home.homeView;
import login.loginView;

import java.awt.Color;

public class gestorMainView {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 */
	public static void main(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestorMainView window = new gestorMainView(user);
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
	public gestorMainView(String user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String user) {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(gestorMainView.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(200, 200, 320, 299);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JButton btnAadirOng = new JButton("A\u00F1adir ONG");
		btnAadirOng.setBackground(Color.LIGHT_GRAY);
		btnAadirOng.setBounds(72, 126, 147, 25);
		frmAccionsocialmed.getContentPane().add(btnAadirOng);
		
		JButton btnActividades = new JButton("Actividades");
		
		btnActividades.setBackground(Color.LIGHT_GRAY);
		btnActividades.setBounds(72, 54, 147, 25);
		frmAccionsocialmed.getContentPane().add(btnActividades);
		
		JButton btnSolicitudesOng = new JButton("Solicitudes ONG");
		btnSolicitudesOng.setBackground(Color.LIGHT_GRAY);
		btnSolicitudesOng.setBounds(72, 90, 147, 25);
		frmAccionsocialmed.getContentPane().add(btnSolicitudesOng);
		
		JButton btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesin.setBackground(Color.LIGHT_GRAY);
		btnCerrarSesin.setBounds(72, 224, 147, 25);
		frmAccionsocialmed.getContentPane().add(btnCerrarSesin);
		
		JLabel lblcorreoGestor = new JLabel(user);
		lblcorreoGestor.setBounds(70, 11, 131, 25);
		frmAccionsocialmed.getContentPane().add(lblcorreoGestor);
		
		JButton btnNoticias = new JButton("Noticias");
		btnNoticias.setBackground(Color.LIGHT_GRAY);
		btnNoticias.setBounds(72, 165, 147, 25);
		frmAccionsocialmed.getContentPane().add(btnNoticias);
		
		btnAadirOng.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorAnadirONG.main(user);
			 	frmAccionsocialmed.dispose();
			}
		});
		
		btnCerrarSesin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homeView.main(null);
				frmAccionsocialmed.dispose();
			}
		});
		
		btnSolicitudesOng.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestorSolicitudesActividad.main(user);
			}
		});

		btnActividades.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestorTodasActividades.main(user);
			}
		});
		
		btnNoticias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noticiasView.main(user);
			}
		});
	}
}
