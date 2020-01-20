package alumno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Label;

public class alumnoCertificado {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					alumnoCertificado window = new alumnoCertificado();
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
	public alumnoCertificado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(alumnoCertificado.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 444, 492);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JButton button = new JButton("<");
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(10, 11, 41, 28);
		frmAccionsocialmed.getContentPane().add(button);
		
		JLabel lblCertificadoDeActividad = new JLabel("CERTIFICADO DE ACTIVIDAD");
		lblCertificadoDeActividad.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		lblCertificadoDeActividad.setBounds(61, -3, 504, 54);
		frmAccionsocialmed.getContentPane().add(lblCertificadoDeActividad);
		
		JLabel lblActividadRealizada = new JLabel("Actividad:");
		lblActividadRealizada.setBounds(10, 54, 79, 14);
		frmAccionsocialmed.getContentPane().add(lblActividadRealizada);
		
		JLabel label = new JLabel("<actividad>");
		label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label.setBounds(91, 54, 327, 14);
		frmAccionsocialmed.getContentPane().add(label);
		
		JLabel lblRealizadaPor = new JLabel("Realizada por:");
		lblRealizadaPor.setBounds(10, 104, 93, 14);
		frmAccionsocialmed.getContentPane().add(lblRealizadaPor);
		
		JLabel label_1 = new JLabel("<NombreCompleto>");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_1.setBounds(113, 104, 305, 14);
		frmAccionsocialmed.getContentPane().add(label_1);
		
		JLabel lblNmeroDeHoras = new JLabel("N\u00FAmero de horas:");
		lblNmeroDeHoras.setBounds(10, 129, 116, 14);
		frmAccionsocialmed.getContentPane().add(lblNmeroDeHoras);
		
		JLabel label_2 = new JLabel("<horas>");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_2.setBounds(123, 129, 295, 14);
		frmAccionsocialmed.getContentPane().add(label_2);
		
		JLabel lblValoracinDeLa = new JLabel("Valoraci\u00F3n de la ONG:");
		lblValoracinDeLa.setBounds(10, 154, 131, 14);
		frmAccionsocialmed.getContentPane().add(lblValoracinDeLa);
		
		JLabel label_3 = new JLabel("<notaONG>");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_3.setBounds(151, 154, 27, 14);
		frmAccionsocialmed.getContentPane().add(label_3);
		
		JLabel lblValoracinDelPdi = new JLabel("Valoraci\u00F3n del PDI:");
		lblValoracinDelPdi.setBounds(10, 181, 131, 14);
		frmAccionsocialmed.getContentPane().add(lblValoracinDelPdi);
		
		JLabel label_4 = new JLabel("<notaPDI>");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_4.setBounds(151, 179, 27, 14);
		frmAccionsocialmed.getContentPane().add(label_4);
		
		JLabel lblComentarioDeLa = new JLabel("Comentario de la ONG:");
		lblComentarioDeLa.setBounds(10, 206, 174, 20);
		frmAccionsocialmed.getContentPane().add(lblComentarioDeLa);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 225, 408, 89);
		frmAccionsocialmed.getContentPane().add(textArea);
		
		JLabel lblComentarioDelPdi = new JLabel("Comentario del PDI:");
		lblComentarioDelPdi.setBounds(10, 325, 408, 14);
		frmAccionsocialmed.getContentPane().add(lblComentarioDelPdi);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(10, 343, 408, 100);
		frmAccionsocialmed.getContentPane().add(textArea_1);
		
		JLabel label_5 = new JLabel("/5");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_5.setBounds(177, 154, 33, 14);
		frmAccionsocialmed.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("/5");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_6.setBounds(177, 179, 33, 14);
		frmAccionsocialmed.getContentPane().add(label_6);
		
		JLabel lblOrganizadaPor = new JLabel("Organizada por:");
		lblOrganizadaPor.setBounds(10, 72, 93, 28);
		frmAccionsocialmed.getContentPane().add(lblOrganizadaPor);
		
		JLabel label_7 = new JLabel("<nombreONG>");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_7.setBounds(111, 79, 307, 14);
		frmAccionsocialmed.getContentPane().add(label_7);
	}
}
