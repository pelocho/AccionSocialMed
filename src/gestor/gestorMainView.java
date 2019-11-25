package gestor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;

public class gestorMainView {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestorMainView window = new gestorMainView();
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
	public gestorMainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(gestorMainView.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 282, 295);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JButton btnAadirOng = new JButton("A\u00F1adir ONG");
		btnAadirOng.setBounds(48, 149, 160, 23);
		frmAccionsocialmed.getContentPane().add(btnAadirOng);
		
		JButton btnActividades = new JButton("Actividades");
		btnActividades.setBounds(48, 47, 160, 23);
		frmAccionsocialmed.getContentPane().add(btnActividades);
		
		JButton btnSolicitudesOng = new JButton("Solicitudes ONG");
		btnSolicitudesOng.setBounds(48, 81, 160, 23);
		frmAccionsocialmed.getContentPane().add(btnSolicitudesOng);
		
		JButton btnSolicitudesAlumnos = new JButton("Solicitudes Alumnos");
		btnSolicitudesAlumnos.setBounds(48, 115, 160, 23);
		frmAccionsocialmed.getContentPane().add(btnSolicitudesAlumnos);
		
		JButton btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesin.setBounds(48, 224, 160, 23);
		frmAccionsocialmed.getContentPane().add(btnCerrarSesin);
		
		JLabel lblcorreoGestor = new JLabel("\"Correo del gestor\"");
		lblcorreoGestor.setBounds(70, 11, 131, 25);
		frmAccionsocialmed.getContentPane().add(lblcorreoGestor);
	}
}
