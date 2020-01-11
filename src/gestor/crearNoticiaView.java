package gestor;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

import pdi.editarPerfilPdi;

public class crearNoticiaView {

	private JFrame frame;
	private JTextField textTitulo;
	private JTextField textCuerpo;

	/**
	 * Launch the application.
	 */
	public static void main(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crearNoticiaView window = new crearNoticiaView(user);
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
	public crearNoticiaView(String user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String user) {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(editarPerfilPdi.class.getResource("/imagenes/icono pequeno.png")));
		frame.setTitle("AccionSocialMed");
		frame.setBounds(100, 100, 297, 271);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton buttonVolver = new JButton("<");
		buttonVolver.setBackground(Color.LIGHT_GRAY);
		buttonVolver.setBounds(10, 11, 41, 23);
		frame.getContentPane().add(buttonVolver);
		
		JLabel labelTtulo = new JLabel("Titulo:");
		labelTtulo.setBounds(10, 67, 115, 14);
		frame.getContentPane().add(labelTtulo);
		
		JLabel labelCuerpo = new JLabel("Cuerpo:");
		labelCuerpo.setBounds(10, 110, 115, 14);
		frame.getContentPane().add(labelCuerpo);
		
		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		textTitulo.setBounds(84, 64, 149, 20);
		frame.getContentPane().add(textTitulo);
		
		textCuerpo = new JTextField();
		textCuerpo.setColumns(10);
		textCuerpo.setBounds(84, 107, 149, 20);
		frame.getContentPane().add(textCuerpo);
		
		JLabel labelImagen = new JLabel("Imagen:");
		labelImagen.setBounds(10, 158, 115, 14);
		frame.getContentPane().add(labelImagen);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBackground(Color.LIGHT_GRAY);
		btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnCrear.setBounds(95, 198, 89, 23);
		frame.getContentPane().add(btnCrear);
		
		buttonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}
}
