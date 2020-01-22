package pantallasCompartidas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;

import alumno.alumnoMainView;

import java.awt.Label;

public class usuariosCertificado {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 */
	public static void main(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usuariosCertificado window = new usuariosCertificado(user);
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
	public usuariosCertificado(String user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String user) {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(usuariosCertificado.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 444, 346);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(10, 11, 41, 28);
		frmAccionsocialmed.getContentPane().add(btnVolver);
		
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
		
		JLabel lblComentarioDeLa = new JLabel("Comentario de la ONG:");
		lblComentarioDeLa.setBounds(10, 179, 174, 20);
		frmAccionsocialmed.getContentPane().add(lblComentarioDeLa);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 204, 408, 93);
		frmAccionsocialmed.getContentPane().add(textArea);
		
		JLabel label_5 = new JLabel("/5");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_5.setBounds(177, 154, 33, 14);
		frmAccionsocialmed.getContentPane().add(label_5);
		
		JLabel lblOrganizadaPor = new JLabel("Organizada por:");
		lblOrganizadaPor.setBounds(10, 72, 93, 28);
		frmAccionsocialmed.getContentPane().add(lblOrganizadaPor);
		
		JLabel label_7 = new JLabel("<nombreONG>");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_7.setBounds(111, 79, 307, 14);
		frmAccionsocialmed.getContentPane().add(label_7);
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAccionsocialmed.dispose();
			}
		});
	}
}
