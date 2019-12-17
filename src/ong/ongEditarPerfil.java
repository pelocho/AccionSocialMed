package ong;

import java.awt.EventQueue;
import pantallasCompartidas.funcionesEditarPerfil;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.MySQLBD;
import modelos.ONG;

import javax.swing.JCheckBox;

public class ongEditarPerfil extends funcionesEditarPerfil{

	private JFrame frmAccionsocialmed;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textCorreo;
	private JTextField textWeb;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ongEditarPerfil window = new ongEditarPerfil(user);
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
	public ongEditarPerfil(String user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String user) {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(ongEditarPerfil.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 332, 286);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(10, 11, 41, 23);
		frmAccionsocialmed.getContentPane().add(btnVolver);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 45, 84, 14);
		frmAccionsocialmed.getContentPane().add(lblNombre);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(10, 78, 84, 14);
		frmAccionsocialmed.getContentPane().add(lblTelfono);
		
		JLabel lblCorreoDeContacto = new JLabel("Correo de Contacto:");
		lblCorreoDeContacto.setBounds(10, 106, 151, 14);
		frmAccionsocialmed.getContentPane().add(lblCorreoDeContacto);
		
		JLabel lblWeb = new JLabel("Web:");
		lblWeb.setBounds(10, 141, 74, 14);
		frmAccionsocialmed.getContentPane().add(lblWeb);
		
		textNombre = new JTextField();
		textNombre.setBounds(104, 42, 202, 20);
		frmAccionsocialmed.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(104, 75, 203, 20);
		frmAccionsocialmed.getContentPane().add(textTelefono);
		textTelefono.setColumns(10);
		
		textCorreo = new JTextField();
		textCorreo.setBounds(155, 103, 151, 20);
		frmAccionsocialmed.getContentPane().add(textCorreo);
		textCorreo.setColumns(10);
		
		textWeb = new JTextField();
		textWeb.setBounds(94, 138, 212, 20);
		frmAccionsocialmed.getContentPane().add(textWeb);
		textWeb.setColumns(10);
		
		JButton btnAceptarCambios = new JButton("Aceptar cambios");
		btnAceptarCambios.setBounds(78, 213, 132, 23);
		frmAccionsocialmed.getContentPane().add(btnAceptarCambios);
		
		JLabel lblNewLabel = new JLabel("Nueva contrase\u00F1a");
		lblNewLabel.setBounds(10, 172, 132, 14);
		frmAccionsocialmed.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(160, 169, 146, 20);
		frmAccionsocialmed.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAccionsocialmed.dispose();
			}
		});
		
		btnAceptarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String telf = (textTelefono.getText());
				String Nombre = textNombre.getText();
				String Correo = textCorreo.getText();
				String contraseña = textField_1.getText();
				String Web = textWeb.getText();
				
				if (Nombre.equals("")  || contraseña.equals("")){
					JOptionPane.showMessageDialog(frmAccionsocialmed, "Rellena obligatoriamente nombre y contraseña (la contraseña has de cambiarla)");
					frmAccionsocialmed.dispose();
					ongEditarPerfil.main(user);
				}else {
				try {
					ONG ong = new ONG(user);
					ong.setContrasena(contraseña);
					ong.setNombre(Nombre);
					ong.setCorreo_contacto(Correo);
					ong.setWeb(Web);
					ong.setTlfn(telf);
					
					frmAccionsocialmed.dispose();
					ongMainView.main(user);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				
			
			}
		});
	}
}