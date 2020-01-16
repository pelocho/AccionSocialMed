package home;

import login.loginONGView;
import login.loginView;
import modelos.Actividad;
import modelos.Noticia;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.CardLayout;
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
		lblNewLabel.setBounds(282, 25, 453, 239);
		frmAccionsocialmed.getContentPane().add(lblNewLabel);
		
		JButton btnIniciarSesinOng = new JButton("Iniciar Sesi\u00F3n ONG");
		btnIniciarSesinOng.setBackground(Color.LIGHT_GRAY);
		btnIniciarSesinOng.setBounds(358, 297, 144, 23);
		frmAccionsocialmed.getContentPane().add(btnIniciarSesinOng);
		
		CardLayout card = new CardLayout(0,0);
		
		JPanel noticiasPanel = new JPanel();
		noticiasPanel.setBounds(10, 74, 249, 187);
		frmAccionsocialmed.getContentPane().add(noticiasPanel);
		noticiasPanel.setLayout(card);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.setBackground(Color.LIGHT_GRAY);
		btnAnterior.setBounds(10, 44, 89, 23);
		frmAccionsocialmed.getContentPane().add(btnAnterior);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBackground(Color.LIGHT_GRAY);
		btnSiguiente.setBounds(170, 44, 89, 23);
		frmAccionsocialmed.getContentPane().add(btnSiguiente);
		
		JLabel lblNoticias = new JLabel("Noticias");
		lblNoticias.setBounds(111, 25, 46, 14);
		frmAccionsocialmed.getContentPane().add(lblNoticias);
		
		List<Noticia> listaNoticias = Noticia.listaNoticias();
		
		for (int i = 0; i < listaNoticias.size() ; i++) {
			String numero = String.valueOf(i);
			String title = listaNoticias.get(i).getTitulo();
			String body = listaNoticias.get(i).getCuerpo();
			String imagen = listaNoticias.get(i).getImagen();
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.add(new JLabel(title));
			panel.add(new JLabel(body));
			byte[] image = imagen.getBytes();
			Image img = Toolkit.getDefaultToolkit().createImage(image);
			ImageIcon icon = new ImageIcon(img);
			JLabel lPhoto = new JLabel();
			lPhoto.setIcon(icon);
			panel.add(lPhoto);
			noticiasPanel.add(panel);
			panel.setName(numero);
		} 
		
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(noticiasPanel);
			}
		});
		
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(noticiasPanel);
			}
		});
		
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
