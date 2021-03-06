package gestor;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelos.Noticia;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

import javafx.stage.FileChooser;
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
		labelCuerpo.setBounds(10, 98, 115, 14);
		frame.getContentPane().add(labelCuerpo);
		
		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		textTitulo.setBounds(84, 64, 149, 20);
		frame.getContentPane().add(textTitulo);
		
		textCuerpo = new JTextField();
		textCuerpo.setColumns(10);
		textCuerpo.setBounds(84, 92, 149, 20);
		frame.getContentPane().add(textCuerpo);
		
		JLabel labelImagen = new JLabel("Imagen:");
		labelImagen.setBounds(10, 132, 115, 14);
		frame.getContentPane().add(labelImagen);
		
		
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBackground(Color.LIGHT_GRAY);
		btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnCrear.setBounds(95, 198, 89, 23);
		frame.getContentPane().add(btnCrear);
		
		JButton btnEscoger = new JButton("Escoger...");
		btnEscoger.setBackground(Color.LIGHT_GRAY);
		btnEscoger.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnEscoger.setBounds(94, 128, 89, 23);
		frame.getContentPane().add(btnEscoger);
		
		JLabel lblRuta = new JLabel("Ruta...");
		lblRuta.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblRuta.setBounds(117, 155, 46, 14);
		frame.getContentPane().add(lblRuta);
		
		btnEscoger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileChooser file = new FileChooser();
				JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int r = j.showOpenDialog(null); 
				if (r == JFileChooser.APPROVE_OPTION) {
					lblRuta.setText(j.getSelectedFile().getAbsolutePath());
				}
			}
		});
		
		buttonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				noticiasView.main(user);
			}
		});
		
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textTitulo.getText().equals("") && !textCuerpo.getText().equals("")) {
					String titulo = textTitulo.getText();
					String cuerpo = textCuerpo.getText();
					String ruta = lblRuta.getText();
					try {
						Boolean ok = Noticia.guardarNoticia(titulo, cuerpo, ruta);
						if (ok) {
							JOptionPane.showMessageDialog(frame, "Noticia creada correctamente.");
							frame.dispose();
							noticiasView.main(user);
						} else {
							JOptionPane.showMessageDialog(frame, "Fallo al crear la noticia.");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	}
}
