package pdi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;

import main.MySQLBD;
import modelos.Actividad;
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
	 * @param profe 
	 */
	public static void main(String correo, int act, String profe) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pdiEvaluaGente2 window = new pdiEvaluaGente2(correo, act, profe);
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
	 * @param profe 
	 */
	public pdiEvaluaGente2(String correo, int act, String profe) {
		try {
			initialize(correo, act, profe);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @param correo 
	 * @param profe 
	 * @param act 
	 * @throws Exception 
	 */
	private void initialize(String correo, int a, String profe) throws Exception {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(pdiEvaluaGente2.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 448, 446);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		Usuario us = new Usuario (correo);
		Actividad act = new Actividad (a);
		
		JButton botonVolver = new JButton("<");
		botonVolver.setBackground(Color.LIGHT_GRAY);
		botonVolver.setBounds(10, 11, 41, 23);
		frmAccionsocialmed.getContentPane().add(botonVolver);
		
		JLabel lblNombreYApellidos = new JLabel("Nombre:");
		lblNombreYApellidos.setBounds(10, 45, 61, 14);
		frmAccionsocialmed.getContentPane().add(lblNombreYApellidos);
		
		JLabel label = new JLabel(us.getNombre() + " " + us.getPrimerApellido() + " " + us.getSegundoApellido());
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(81, 45, 274, 14);
		frmAccionsocialmed.getContentPane().add(label);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 70, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblDni);
		
		JLabel labelDni = new JLabel(us.getDni());
		labelDni.setFont(new Font("Tahoma", Font.PLAIN, 10));
		labelDni.setBounds(69, 70, 170, 14);
		frmAccionsocialmed.getContentPane().add(labelDni);
		
		JLabel lblValoracion = new JLabel("Comenta algo sobre usuario:");
		lblValoracion.setBounds(10, 255, 200, 23);
		frmAccionsocialmed.getContentPane().add(lblValoracion);
		
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
		
		List<String[]> l =  bd.select("select valoracionONG from eef_primera_iteracion.participacion "
				+ "WHERE (`correoUsuario` = '" + us.getEmail() + "') and (`idActividad` = '" + act.getCodigo() + "');; " );

		String notaONG = l.get(0)[0];
		
		JLabel lblNotaOng = new JLabel("  " + notaONG);
		lblNotaOng.setBounds(127, 95, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblNotaOng);
		
		JLabel lblOpininDeLa = new JLabel("Opini\u00F3n de la ONG:");
		lblOpininDeLa.setBounds(10, 120, 128, 14);
		frmAccionsocialmed.getContentPane().add(lblOpininDeLa);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(UIManager.getColor("Button.background"));
		textPane.setForeground(Color.BLACK);
		textPane.setText(act.getDescripcion());
		textPane.setEditable(false);
		textPane.setBounds(10, 145, 414, 81);
		frmAccionsocialmed.getContentPane().add(textPane);
		
		botonVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmAccionsocialmed.dispose();
				pdiEvaluaGente.main(profe);
			}
		});
		
		btnEnviarEvaluacion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					int valoracion = (int) spinner.getValue();
					
					if (valoracion<0 || valoracion >10) {
						JOptionPane.showMessageDialog(frmAccionsocialmed, "Por favor ponga una valoracion entre 0 y 10");
					}else {
						String opinion = campoTexto.getText();
				//	System.out.println("val: " + valoracion  + " "  + horas+ opinion);
					System.out.println(correo + " " + act);

					
					bd.update("UPDATE `eef_primera_iteracion`.`participacion` SET `valoracionPDI` = '" + valoracion + 
							"' WHERE (`correoUsuario` = '" + correo + "') and (`idActividad` = '" + a + " '); " );
					bd.update("UPDATE `eef_primera_iteracion`.`participacion` SET `comentarioPDI` = '" + opinion + 
							"' WHERE (`correoUsuario` = '" + correo + "') and (`idActividad` = '" + a + " '); " );
					
					frmAccionsocialmed.dispose();
					pdiEvaluaGente.main(profe);
					}
					

				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
		} );
		
	}
}
