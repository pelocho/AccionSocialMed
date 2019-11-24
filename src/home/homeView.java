package home;

import login.loginView;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class homeView {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homeView window = new homeView();
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
	public homeView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.getContentPane().setForeground(Color.GRAY);
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rafa Rueda\\eclipse-workspace\\prAccionSocialMed\\imagenes\\icono pequeno.png"));
		frmAccionsocialmed.setBounds(100, 100, 709, 370);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JLabel lblbienvenidoAAccinsocialmed = new JLabel("\u00A1Bienvenido a AccionSocialMed!");
		lblbienvenidoAAccinsocialmed.setBounds(255, 272, 197, 14);
		frmAccionsocialmed.getContentPane().add(lblbienvenidoAAccinsocialmed);
		
		JButton btnIniciarSesin = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesin.setBounds(281, 298, 123, 23);
		frmAccionsocialmed.getContentPane().add(btnIniciarSesin);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Rafa Rueda\\eclipse-workspace\\prAccionSocialMed\\imagenes\\icono grande.png"));
		lblNewLabel.setBounds(-28, 22, 760, 239);
		frmAccionsocialmed.getContentPane().add(lblNewLabel);
		
		btnIniciarSesin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loginView.main(null);
				frmAccionsocialmed.dispose();
			}
		});
	}

}
