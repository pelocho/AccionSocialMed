package gestor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

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
		frmAccionsocialmed.setBounds(100, 100, 282, 295);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JButton btnAadirOng = new JButton("A\u00F1adir ONG");
		btnAadirOng.setBackground(Color.LIGHT_GRAY);
		btnAadirOng.setBounds(48, 149, 160, 23);
		frmAccionsocialmed.getContentPane().add(btnAadirOng);
		
		JButton btnActividades = new JButton("Actividades");
		btnActividades.setBackground(Color.LIGHT_GRAY);
		btnActividades.setBounds(48, 47, 160, 23);
		frmAccionsocialmed.getContentPane().add(btnActividades);
		
		JButton btnSolicitudesOng = new JButton("Solicitudes ONG");
		btnSolicitudesOng.setBackground(Color.LIGHT_GRAY);
		btnSolicitudesOng.setBounds(48, 81, 160, 23);
		frmAccionsocialmed.getContentPane().add(btnSolicitudesOng);
		
		JButton btnSolicitudesAlumnos = new JButton("Solicitudes Alumnos");
		btnSolicitudesAlumnos.setBackground(Color.LIGHT_GRAY);
		btnSolicitudesAlumnos.setBounds(48, 115, 160, 23);
		frmAccionsocialmed.getContentPane().add(btnSolicitudesAlumnos);
		
		JButton btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesin.setBackground(Color.LIGHT_GRAY);
		btnCerrarSesin.setBounds(48, 224, 160, 23);
		frmAccionsocialmed.getContentPane().add(btnCerrarSesin);
		
		JLabel lblcorreoGestor = new JLabel(user);
		lblcorreoGestor.setBounds(70, 11, 131, 25);
		frmAccionsocialmed.getContentPane().add(lblcorreoGestor);
		
		btnAadirOng.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorAnadirONG.main(null);
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
