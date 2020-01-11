package ong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;

public class ongEvaluaGente2 {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ongEvaluaGente2 window = new ongEvaluaGente2();
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
	public ongEvaluaGente2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(ongEvaluaGente2.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 428, 431);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JButton button = new JButton("<");
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(10, 11, 54, 23);
		frmAccionsocialmed.getContentPane().add(button);
		
		JLabel lblNombreYApellidos = new JLabel("Nombre y apellidos:");
		lblNombreYApellidos.setBounds(10, 45, 128, 14);
		frmAccionsocialmed.getContentPane().add(lblNombreYApellidos);
		
		JLabel label = new JLabel("<nombre>");
		label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label.setBounds(150, 45, 274, 14);
		frmAccionsocialmed.getContentPane().add(label);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 70, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblDni);
		
		JLabel label_1 = new JLabel("<dni>");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_1.setBounds(69, 70, 170, 14);
		frmAccionsocialmed.getContentPane().add(label_1);
		
		JLabel lblEvalaAlUsuario = new JLabel("Eval\u00FAa al usuario:");
		lblEvalaAlUsuario.setBounds(10, 95, 138, 14);
		frmAccionsocialmed.getContentPane().add(lblEvalaAlUsuario);
		
		JSlider slider = new JSlider();
		slider.setValue(0);
		slider.setMaximum(5);
		slider.setBounds(10, 134, 200, 19);
		frmAccionsocialmed.getContentPane().add(slider);
		
		JLabel label_2 = new JLabel("0");
		label_2.setBounds(10, 120, 26, 14);
		frmAccionsocialmed.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("1");
		label_3.setBounds(46, 120, 18, 14);
		frmAccionsocialmed.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("2");
		label_4.setBounds(84, 120, 26, 14);
		frmAccionsocialmed.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("3");
		label_5.setBounds(120, 120, 20, 14);
		frmAccionsocialmed.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("4");
		label_6.setBounds(161, 120, 18, 14);
		frmAccionsocialmed.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("5");
		label_7.setBounds(200, 120, 26, 14);
		frmAccionsocialmed.getContentPane().add(label_7);
		
		JLabel lblComentaAlgo = new JLabel("Comenta algo sobre usuario:");
		lblComentaAlgo.setBounds(10, 187, 200, 23);
		frmAccionsocialmed.getContentPane().add(lblComentaAlgo);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 208, 392, 141);
		frmAccionsocialmed.getContentPane().add(textPane);
		
		JLabel lblHorasEmpleadas = new JLabel("Horas empleadas:");
		lblHorasEmpleadas.setBounds(10, 164, 116, 14);
		frmAccionsocialmed.getContentPane().add(lblHorasEmpleadas);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(120, 164, 41, 20);
		frmAccionsocialmed.getContentPane().add(spinner);
		
		JButton btnEnviarEvaluacin = new JButton("Enviar evaluaci\u00F3n");
		btnEnviarEvaluacin.setBackground(Color.LIGHT_GRAY);
		btnEnviarEvaluacin.setBounds(10, 360, 151, 23);
		frmAccionsocialmed.getContentPane().add(btnEnviarEvaluacin);
	}
}
