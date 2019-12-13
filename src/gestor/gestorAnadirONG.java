package gestor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import login.loginView;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;

public class gestorAnadirONG {

	private JFrame frmAccionsocialmed;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestorAnadirONG window = new gestorAnadirONG();
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
	public gestorAnadirONG() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(gestorAnadirONG.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 450, 237);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JLabel lblAadirUnaNueva = new JLabel("A\u00F1adir una nueva ONG");
		lblAadirUnaNueva.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAadirUnaNueva.setBounds(10, 11, 188, 23);
		frmAccionsocialmed.getContentPane().add(lblAadirUnaNueva);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(10, 45, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblCorreo);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(10, 104, 72, 14);
		frmAccionsocialmed.getContentPane().add(lblContrasea);
		
		JLabel lblRepitaLaContrasea = new JLabel("Repita la contrase\u00F1a:");
		lblRepitaLaContrasea.setBounds(10, 129, 126, 23);
		frmAccionsocialmed.getContentPane().add(lblRepitaLaContrasea);
		
		JLabel lblRepitaElCorreo = new JLabel("Repita el correo:");
		lblRepitaElCorreo.setBounds(10, 70, 106, 23);
		frmAccionsocialmed.getContentPane().add(lblRepitaElCorreo);
		
		textField = new JTextField();
		textField.setBounds(146, 45, 278, 20);
		frmAccionsocialmed.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 71, 278, 20);
		frmAccionsocialmed.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(146, 101, 278, 20);
		frmAccionsocialmed.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(146, 130, 278, 20);
		frmAccionsocialmed.getContentPane().add(passwordField_1);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBounds(167, 166, 89, 23);
		frmAccionsocialmed.getContentPane().add(btnAadir);
		
		btnAadir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						boolean ok = false;
						if (textField.getText().equals(textField_1.getText())  && new String(passwordField.getPassword()).equals(new String(passwordField_1.getPassword()))) {
						funcionesGestor.insertarONG(textField.getText(),new String(passwordField.getPassword()));
						ok = true;
							if(ok ==true) {
								frmAccionsocialmed.dispose();
								JOptionPane.showMessageDialog(frmAccionsocialmed, "ONG introducida correctamente");
							}
							
						}else {
							JOptionPane.showMessageDialog(frmAccionsocialmed, "Datos incorrectos");
						}
						
						
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		
	}
}
