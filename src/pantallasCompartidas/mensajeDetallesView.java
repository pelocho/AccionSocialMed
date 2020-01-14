package pantallasCompartidas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import alumno.vistaActividad;
import modelos.Mensaje;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;

public class mensajeDetallesView {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 */
	public static void main(String user, Mensaje msg) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mensajeDetallesView window = new mensajeDetallesView(user,msg);
					window.frmAccionsocialmed.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mensajeDetallesView(String user, Mensaje msg) {
		initialize(user,msg);
	}
	
	private void initialize(String user, Mensaje msg) {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(vistaActividad.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 406, 265);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Mensaje de:");
		lblNewLabel.setBounds(10, 11, 80, 14);
		frmAccionsocialmed.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel(msg.getRemitente().getEmail());
		label.setBounds(98, 11, 326, 14);
		frmAccionsocialmed.getContentPane().add(label);
		
		JLabel lblMensaje = new JLabel("Mensaje:");
		lblMensaje.setBounds(10, 36, 53, 14);
		frmAccionsocialmed.getContentPane().add(lblMensaje);
		
		JTextArea textArea = new JTextArea(msg.getCuerpo());
		textArea.setBounds(10, 56, 414, 125);
		frmAccionsocialmed.getContentPane().add(textArea);
		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(10, 192, 41, 23);
		frmAccionsocialmed.getContentPane().add(btnVolver);
		
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensajesView.main(user);
				frmAccionsocialmed.dispose();
			}
		});
	}
}
