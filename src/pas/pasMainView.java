package pas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;

public class pasMainView {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pasMainView window = new pasMainView();
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
	public pasMainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(pasMainView.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setBounds(100, 100, 450, 300);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JLabel lblEstaEsLa = new JLabel("ESTA ES LA VISTA DE PAS");
		lblEstaEsLa.setBounds(130, 62, 231, 118);
		frmAccionsocialmed.getContentPane().add(lblEstaEsLa);
	}

}
