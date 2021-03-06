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

import home.homeView;
import login.loginView;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Color;

public class gestorAnadirONG {

	private JFrame frmAccionsocialmed;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestorAnadirONG window = new gestorAnadirONG(user);
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
	public gestorAnadirONG(String user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String user) {
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
		btnAadir.setBackground(Color.LIGHT_GRAY);
		btnAadir.setBounds(109, 164, 89, 23);
		frmAccionsocialmed.getContentPane().add(btnAadir);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(258, 164, 89, 23);
		frmAccionsocialmed.getContentPane().add(btnVolver);

		btnAadir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						boolean ok = false;
						if (textField.getText().equals(textField_1.getText()) && new String(passwordField.getPassword()).equals(new String(passwordField_1.getPassword()))) {
							ok = funcionesGestor.insertarONG(textField.getText(),new String(passwordField.getPassword()));
							if(ok == true) {
								JOptionPane.showMessageDialog (frmAccionsocialmed, " ONG introducida correctamente " );
								gestorMainView.main(user);
								frmAccionsocialmed.dispose();
							}else{
								JOptionPane.showMessageDialog (frmAccionsocialmed, " Ya existe ese correo " );
							}

						}else {
							JOptionPane.showMessageDialog (frmAccionsocialmed, " Datos incorrectos " );
						}




					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

			}
		});
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestorMainView.main(null);
				frmAccionsocialmed.dispose();
			}
		});

	}
}
