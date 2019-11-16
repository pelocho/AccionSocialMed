package Vista;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class InterfazDeRegistro {

	private JFrame frame;
	private ButtonGroup tipoUsuario = new ButtonGroup();
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazDeRegistro window = new InterfazDeRegistro();
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
	public InterfazDeRegistro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 197);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JLabel lblAccionsocialmed = new JLabel("AccionSocialMed");
		menuBar.add(lblAccionsocialmed);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(10, 41, 49, 14);
		frame.getContentPane().add(lblCorreo);
		
		textField = new JTextField();
		textField.setBounds(102, 38, 273, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(10, 72, 82, 14);
		frame.getContentPane().add(lblContrasea);
		
		JLabel lblIniciarSesin = new JLabel("Iniciar sesi\u00F3n");
		lblIniciarSesin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIniciarSesin.setBounds(10, 11, 132, 14);
		frame.getContentPane().add(lblIniciarSesin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(102, 69, 273, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(161, 104, 89, 23);
		frame.getContentPane().add(btnLogin);
	}
}
