package pdi;

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

import main.MySQLBD;
import modelos.Usuario;

import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;

public class pdiEvaluaGente2 {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 * @param act 
	 */
	public static void main(String correo, int act) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pdiEvaluaGente2 window = new pdiEvaluaGente2(correo, act);
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
	public pdiEvaluaGente2(String correo, int act) {
		initialize(correo, act);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param correo 
	 * @param act 
	 */
	private void initialize(String correo, int act) {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(pdiEvaluaGente2.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 448, 446);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		Usuario us = new Usuario (correo);
		
		JButton button = new JButton("<");
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(10, 11, 41, 23);
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
		
		JLabel labelDni = new JLabel("null");
		labelDni.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelDni.setBounds(69, 70, 170, 14);
		frmAccionsocialmed.getContentPane().add(labelDni);
		
		JLabel lblComentaAlgo = new JLabel("Comenta algo sobre usuario:");
		lblComentaAlgo.setBounds(10, 255, 200, 23);
		frmAccionsocialmed.getContentPane().add(lblComentaAlgo);
		
		JTextPane campoTexto = new JTextPane();
		campoTexto.setBounds(10, 275, 414, 88);
		frmAccionsocialmed.getContentPane().add(campoTexto);
		
		JButton btnEnviarEvaluacion = new JButton("Enviar evaluaci\u00F3n");
		btnEnviarEvaluacion.setBackground(Color.LIGHT_GRAY);
		btnEnviarEvaluacion.setBounds(10, 374, 151, 23);
		frmAccionsocialmed.getContentPane().add(btnEnviarEvaluacion);
		
		JLabel lblNota = new JLabel("Nota:");
		lblNota.setBounds(10, 237, 41, 14);
		frmAccionsocialmed.getContentPane().add(lblNota);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinner.setBounds(51, 234, 33, 20);
		frmAccionsocialmed.getContentPane().add(spinner);
		
		JLabel lblEvaliacinDeLa = new JLabel("Evaliaci\u00F3n de la ONG:");
		lblEvaliacinDeLa.setBounds(10, 95, 140, 14);
		frmAccionsocialmed.getContentPane().add(lblEvaliacinDeLa);
		
		JLabel label_1 = new JLabel("<nota>");
		label_1.setBounds(127, 95, 49, 14);
		frmAccionsocialmed.getContentPane().add(label_1);
		
		JLabel lblOpininDeLa = new JLabel("Opini\u00F3n de la ONG:");
		lblOpininDeLa.setBounds(10, 120, 128, 14);
		frmAccionsocialmed.getContentPane().add(lblOpininDeLa);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(UIManager.getColor("Button.background"));
		textPane.setForeground(Color.BLACK);
		textPane.setEditable(false);
		textPane.setBounds(10, 145, 414, 81);
		frmAccionsocialmed.getContentPane().add(textPane);
		
		
		btnEnviarEvaluacion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					int valoracion = (int) spinner.getValue();
					String opinion = campoTexto.getText();
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
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
		} );
		
	}
}
