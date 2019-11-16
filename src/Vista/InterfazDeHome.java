package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JButton;

public class InterfazDeHome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazDeHome window = new InterfazDeHome();
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
	public InterfazDeHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 281, 154);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JLabel lblAccionsocialmed = new JLabel("AccionSocialMed");
		menuBar.add(lblAccionsocialmed);
		frame.getContentPane().setLayout(null);
		
		JLabel lblbienvenidoAAccinsocialmed = new JLabel("\u00A1Bienvenido a AccionSocialMed!");
		lblbienvenidoAAccinsocialmed.setBounds(44, 21, 197, 14);
		frame.getContentPane().add(lblbienvenidoAAccinsocialmed);
		
		JButton btnIniciarSesin = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesin.setBounds(70, 48, 123, 23);
		frame.getContentPane().add(btnIniciarSesin);
	}

}
