package login;

import ong.ongMainView;
import pas.pasMainView;
import pdi.pdiMainView;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import alumno.alumnoMainView;
import gestor.gestorMainView;
import home.homeView;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Toolkit;
import java.awt.Color;

public class loginView extends funcionesLogin{

	private JFrame frmAccionsocialmed;
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
					loginView window = new loginView();
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
	public loginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(loginView.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setBounds(100, 100, 412, 200);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);

		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(10, 41, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblCorreo);

		textField = new JTextField();
		textField.setBounds(102, 38, 273, 20);
		frmAccionsocialmed.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(10, 72, 82, 14);
		frmAccionsocialmed.getContentPane().add(lblContrasea);
		
		JLabel lblIniciarSesin = new JLabel("Iniciar sesi\u00F3n iDUMA");
		lblIniciarSesin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIniciarSesin.setBounds(10, 11, 132, 14);
		frmAccionsocialmed.getContentPane().add(lblIniciarSesin);

		passwordField = new JPasswordField();
		passwordField.setBounds(102, 69, 273, 20);
		frmAccionsocialmed.getContentPane().add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(102, 127, 89, 23);
		frmAccionsocialmed.getContentPane().add(btnLogin);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(219, 127, 89, 23);
		frmAccionsocialmed.getContentPane().add(btnVolver);
		
		/*JLabel lblRecordarContrasea = new JLabel("\u00BFHas olvidado tu contrase\u00F1a?");
		lblRecordarContrasea.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblRecordarContrasea.setForeground(Color.BLUE);
		lblRecordarContrasea.setBounds(10, 97, 147, 28);
		frmAccionsocialmed.getContentPane().add(lblRecordarContrasea);*/
		
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String user = textField.getText();
				String passwd = String.valueOf(passwordField.getPassword());
				Boolean acceso;
				try {
					int tipoUsur = 0;
					acceso = comprobarUsuario(user, passwd);
					if(acceso) {
						tipoUsur = tipoDeUsuario(user,passwd);
						cargarBD(user, passwd);
						if(tipoUsur == 1) {
							alumnoMainView.main(null);
						}else if(tipoUsur == 2) {
							pdiMainView.main(user);
						}else if(tipoUsur == 3) {
							pasMainView.main(null);
						}/*else if(tipoUsur == 4) {
							ongMainView.main(user);
						}*/else /*if(user.equals("admin") && passwd.equals("admin"))*/{
							gestorMainView.main(user);
						}
						frmAccionsocialmed.dispose();
					} else {
						JOptionPane.showMessageDialog(frmAccionsocialmed, "Datos incorrectos");
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
				homeView.main(null);
				frmAccionsocialmed.dispose();
			}
		});
	}
}
