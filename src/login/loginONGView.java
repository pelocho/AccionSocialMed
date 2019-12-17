package login;

import ong.ongEditarPerfil;
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
import modelos.ONG;

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

public class loginONGView extends funcionesLogin{

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
					loginONGView window = new loginONGView();
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
	public loginONGView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(loginONGView.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setBounds(100, 100, 412, 174);
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
		
		JLabel lblIniciarSesin = new JLabel("Iniciar sesi\u00F3n ONG");
		lblIniciarSesin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIniciarSesin.setBounds(10, 11, 132, 14);
		frmAccionsocialmed.getContentPane().add(lblIniciarSesin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(102, 69, 273, 20);
		frmAccionsocialmed.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.setBackground(Color.LIGHT_GRAY);
		btnLogin.setBounds(102, 100, 89, 23);
		frmAccionsocialmed.getContentPane().add(btnLogin);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(219, 100, 89, 23);
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
				Boolean acceso = false, primeravez = false;
				ONG ong = null;
				try {
					acceso = comprobarUsuarioONG(user, passwd);
				} catch (Exception e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
					try {
						if(acceso) ong = new ONG(user);
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				
				if (acceso && ong.getNombre() == null){
					primeravez = true;
				}
				
				try {
					int tipoUsur = 0;
					acceso = comprobarUsuarioONG(user, passwd);
					if(acceso) {
						if (!primeravez) {
							ongMainView.main(user);
							frmAccionsocialmed.dispose();
						}else {
							ongEditarPerfil.main(user);
							frmAccionsocialmed.dispose();
						}
						
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
