package pantallasCompartidas;

import java.awt.EventQueue;
import pantallasCompartidas.editarPerfilView;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import alumno.alumnoMainView;
import alumno.funcionesCompartidas;
import gestor.vistaActividadDetallesActs;
import home.homeView;
import main.MySQLBD;
import modelos.Actividad;
import modelos.Usuario;
import ong.ongMainView;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;

public class enviarMensajesView {
	private JFrame frmAccionsocialmed;
	private JTextField textField;
	private JTextField textField_1;
	
	public static void main(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					enviarMensajesView window = new enviarMensajesView(user);
					window.frmAccionsocialmed.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	public enviarMensajesView(String user) throws Exception {
		initialize(user);
	}

	private void initialize(String user) throws Exception {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(alumnoMainView.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 482, 295);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);	
		
		JLabel lblEnviarMensajeNuevo = new JLabel("Enviar mensaje nuevo");
		lblEnviarMensajeNuevo.setBounds(10, 11, 154, 14);
		frmAccionsocialmed.getContentPane().add(lblEnviarMensajeNuevo);
		
		JLabel lblDestinatario = new JLabel("Destinatario:");
		lblDestinatario.setBounds(10, 36, 85, 14);
		frmAccionsocialmed.getContentPane().add(lblDestinatario);
		
		textField = new JTextField();
		textField.setBounds(89, 33, 367, 20);
		frmAccionsocialmed.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblMensaje = new JLabel("Mensaje:");
		lblMensaje.setBounds(10, 61, 63, 14);
		frmAccionsocialmed.getContentPane().add(lblMensaje);
		
		textField_1 = new JTextField();
		textField_1.setBounds(9, 81, 447, 130);
		frmAccionsocialmed.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(10, 222, 41, 23);
		frmAccionsocialmed.getContentPane().add(btnVolver);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBackground(Color.LIGHT_GRAY);
		btnEnviar.setBounds(367, 222, 89, 23);
		frmAccionsocialmed.getContentPane().add(btnEnviar);
		
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String destinatario = textField.getText();
				String cuerpo = textField_1.getText();
				
				if(destinatario.equals("") || cuerpo.equals("")) {
					JOptionPane.showMessageDialog(frmAccionsocialmed, "Faltan campos por rellenar");
				}else {
					try {
						if(funcionesCompartidas.comprobarDestinatario(destinatario)) {
							funcionesCompartidas.enviarMensaje(user,destinatario,cuerpo);
							JOptionPane.showMessageDialog(frmAccionsocialmed, "Mensaje enviado correctamente");
							mensajesView.main(user);
							frmAccionsocialmed.dispose();
						}else {
							JOptionPane.showMessageDialog(frmAccionsocialmed, "El destinatario no se encuentra en la plataforma");
						}						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensajesView.main(user);
				frmAccionsocialmed.dispose();
			}
		});
}
}