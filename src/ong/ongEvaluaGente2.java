package ong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;

import main.MySQLBD;
import modelos.Usuario;

import javax.swing.JSpinner;
import javax.swing.ImageIcon;

public class ongEvaluaGente2 {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 * @param act 
	 */
	public static void main(String correo, int act) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ongEvaluaGente2 window = new ongEvaluaGente2(correo, act);
					window.frmAccionsocialmed.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param correo 
	 * @param act 
	 */
	public ongEvaluaGente2(String correo, int act) {
		initialize(correo, act);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param correo 
	 * @param act 
	 */
	private void initialize(String correo, int act) {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(ongEvaluaGente2.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 428, 431);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		Usuario us = new Usuario (correo);
		
		JButton button = new JButton("<");
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(10, 11, 54, 23);
		frmAccionsocialmed.getContentPane().add(button);
		
		JLabel lblNombreYApellidos = new JLabel("Nombre:");
		lblNombreYApellidos.setBounds(10, 45, 128, 14);
		frmAccionsocialmed.getContentPane().add(lblNombreYApellidos);
		
		JLabel label = new JLabel(us.getNombre() + " " + us.getPrimerApellido() + " " + us.getSegundoApellido());
		label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label.setBounds(150, 45, 274, 14);
		frmAccionsocialmed.getContentPane().add(label);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 70, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblDni);
		
		JLabel labelDni = new JLabel(us.getDni());
		labelDni.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelDni.setBounds(69, 70, 170, 14);
		frmAccionsocialmed.getContentPane().add(labelDni);
		
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
		
		JTextPane campoTexto = new JTextPane();
		campoTexto.setBounds(10, 208, 392, 141);
		frmAccionsocialmed.getContentPane().add(campoTexto);
		
		JLabel lblHorasEmpleadas = new JLabel("Horas empleadas:");
		lblHorasEmpleadas.setBounds(10, 164, 116, 14);
		frmAccionsocialmed.getContentPane().add(lblHorasEmpleadas);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(120, 164, 41, 20);
		spinner.setModel(new SpinnerNumberModel(0, 0, 1000, 1));

		frmAccionsocialmed.getContentPane().add(spinner);
		
		JButton btnEnviarEvaluacion = new JButton("Enviar evaluaci\u00F3n");
		btnEnviarEvaluacion.setBackground(Color.LIGHT_GRAY);
		btnEnviarEvaluacion.setBounds(10, 360, 151, 23);
		frmAccionsocialmed.getContentPane().add(btnEnviarEvaluacion);
		
		
		btnEnviarEvaluacion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					int valoracion = slider.getValue();
					String opinion = campoTexto.getText();
					int horas = (int) spinner.getValue();
					System.out.println("val: " + valoracion  + " "  + horas+ opinion);
					System.out.println(correo + " " + act);

					MySQLBD bd = new MySQLBD();
					bd.readDataBase();
					bd.update("UPDATE `eef_primera_iteracion`.`participacion` SET `valoracionONG` = '" + valoracion + 
							"' WHERE (`correoUsuario` = '" + correo + "') and (`idActividad` = '" + act + " '); " );
					bd.update("UPDATE `eef_primera_iteracion`.`participacion` SET `comentarioONG` = '" + opinion + 
							"' WHERE (`correoUsuario` = '" + correo + "') and (`idActividad` = '" + act + " '); " );
					bd.update("UPDATE `eef_primera_iteracion`.`participacion` SET `numeroHoras` = '" + horas + 
							"' WHERE (`correoUsuario` = '" + correo + "') and (`idActividad` = '" + act + " '); " );
					



					frmAccionsocialmed.dispose();
					ongEvaluaGente.main(correo, act);
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
		} );
		
	}
	
	
}
