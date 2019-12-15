package home;

import login.loginONGView;
import login.loginView;
import modelos.Actividad;

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
	 * @throws Exception 
	 */
	public homeView() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.getContentPane().setForeground(Color.GRAY);
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(homeView.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setBounds(100, 100, 709, 370);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JLabel lblbienvenidoAAccinsocialmed = new JLabel("\u00A1Bienvenido a AccionSocialMed!");
		lblbienvenidoAAccinsocialmed.setBounds(255, 272, 197, 14);
		frmAccionsocialmed.getContentPane().add(lblbienvenidoAAccinsocialmed);
		
		JButton btnIniciarSesin = new JButton("iDUMA");
		btnIniciarSesin.setBackground(Color.LIGHT_GRAY);
		btnIniciarSesin.setBounds(179, 297, 144, 23);
		frmAccionsocialmed.getContentPane().add(btnIniciarSesin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(homeView.class.getResource("/imagenes/icono grande.png")));
		lblNewLabel.setBounds(-28, 22, 760, 239);
		frmAccionsocialmed.getContentPane().add(lblNewLabel);
		
		JButton btnIniciarSesinOng = new JButton("Iniciar Sesi\u00F3n ONG");
		btnIniciarSesinOng.setBackground(Color.LIGHT_GRAY);
		btnIniciarSesinOng.setBounds(358, 297, 144, 23);
		frmAccionsocialmed.getContentPane().add(btnIniciarSesinOng);
		
		
		btnIniciarSesin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loginView.main(null);
				frmAccionsocialmed.dispose();
			}
		});
		
		btnIniciarSesinOng.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loginONGView.main(null);
				frmAccionsocialmed.dispose();
			}
		});
	}
}
