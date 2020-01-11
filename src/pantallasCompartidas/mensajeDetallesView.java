package pantallasCompartidas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import alumno.vistaActividad;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;

public class mensajeDetallesView extends JFrame {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mensajeDetallesView frame = new mensajeDetallesView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mensajeDetallesView() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mensaje de:");
		lblNewLabel.setBounds(10, 11, 80, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("<Correo del q envia");
		label.setBounds(98, 11, 326, 14);
		getContentPane().add(label);
		
		JLabel lblMensaje = new JLabel("Mensaje:");
		lblMensaje.setBounds(10, 36, 53, 14);
		getContentPane().add(lblMensaje);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 56, 414, 125);
		getContentPane().add(textArea);
		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(10, 192, 41, 23);
		getContentPane().add(btnVolver);
		initialize();
	}
	
	private void initialize() {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(vistaActividad.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 406, 504);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		
	}
}
