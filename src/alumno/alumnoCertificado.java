package alumno;

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

import main.MySQLBD;
import modelos.Actividad;
import modelos.Participacion;
import modelos.Usuario;

import java.awt.Label;

public class alumnoCertificado {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 */
	public static void main(String user,int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					alumnoCertificado window = new alumnoCertificado(user,id);
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
	public alumnoCertificado(String user, int id) throws Exception {
		initialize(user,id);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize(String user, int id) throws Exception {	
		Actividad actividad = new Actividad(id);
		Usuario usuario = new Usuario(user);
		Participacion participacion = new Participacion(user,id);
		
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(alumnoCertificado.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 444, 492);
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
		
		JLabel label = new JLabel(actividad.getTitulo());
		label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label.setBounds(91, 54, 327, 14);
		frmAccionsocialmed.getContentPane().add(label);
		
		JLabel lblRealizadaPor = new JLabel("Realizada por:");
		lblRealizadaPor.setBounds(10, 104, 93, 14);
		frmAccionsocialmed.getContentPane().add(lblRealizadaPor);
		
		JLabel label_1 = new JLabel(usuario.getNombre()+" "+usuario.getPrimerApellido()+" "+usuario.getSegundoApellido());
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_1.setBounds(113, 104, 305, 14);
		frmAccionsocialmed.getContentPane().add(label_1);
		
		JLabel lblNmeroDeHoras = new JLabel("N\u00FAmero de horas:");
		lblNmeroDeHoras.setBounds(10, 129, 116, 14);
		frmAccionsocialmed.getContentPane().add(lblNmeroDeHoras);
		
		JLabel label_2 = new JLabel(participacion.getNumeroHoras()+"");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_2.setBounds(123, 129, 295, 14);
		frmAccionsocialmed.getContentPane().add(label_2);
		
		JLabel lblValoracinDeLa = new JLabel("Valoraci\u00F3n de la ONG:");
		lblValoracinDeLa.setBounds(10, 154, 131, 14);
		frmAccionsocialmed.getContentPane().add(lblValoracinDeLa);
		
		JLabel label_3 = new JLabel(participacion.getValoracionONG()+"/5");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_3.setBounds(151, 154, 27, 14);
		frmAccionsocialmed.getContentPane().add(label_3);
		
		JLabel lblValoracinDelPdi = new JLabel("Valoraci\u00F3n del PDI:");
		lblValoracinDelPdi.setBounds(10, 181, 131, 14);
		frmAccionsocialmed.getContentPane().add(lblValoracinDelPdi);
		
		JLabel label_4 = new JLabel(participacion.getValoracionPDI()+"/10");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_4.setBounds(151, 179, 27, 14);
		frmAccionsocialmed.getContentPane().add(label_4);
		
		JLabel lblComentarioDeLa = new JLabel("Comentario de la ONG:");
		lblComentarioDeLa.setBounds(10, 206, 174, 20);
		frmAccionsocialmed.getContentPane().add(lblComentarioDeLa);
		
		JTextArea textArea = new JTextArea(participacion.getComentarioONG());
		textArea.setEditable(false);
		textArea.setBounds(10, 225, 408, 89);
		frmAccionsocialmed.getContentPane().add(textArea);
		
		JLabel lblComentarioDelPdi = new JLabel("Comentario del PDI:");
		lblComentarioDelPdi.setBounds(10, 325, 408, 14);
		frmAccionsocialmed.getContentPane().add(lblComentarioDelPdi);
		
		JTextArea textArea_1 = new JTextArea(participacion.getComentarioPDI());
		textArea_1.setEditable(false);
		textArea_1.setBounds(10, 343, 408, 100);
		frmAccionsocialmed.getContentPane().add(textArea_1);
		
		JLabel lblOrganizadaPor = new JLabel("Organizada por:");
		lblOrganizadaPor.setBounds(10, 72, 93, 28);
		frmAccionsocialmed.getContentPane().add(lblOrganizadaPor);
		
		JLabel label_7 = new JLabel(actividad.getOng());
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_7.setBounds(111, 79, 307, 14);
		frmAccionsocialmed.getContentPane().add(label_7);
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmAccionsocialmed.dispose();
			}
		});
	}
}
