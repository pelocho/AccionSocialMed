package pdi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.MySQLBD;
import modelos.Usuario;

import java.awt.Font;

public class pdiVePerfilAlumno {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 */
	public static void main(String pdi, String correo, int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pdiVePerfilAlumno window = new pdiVePerfilAlumno(pdi,correo,id);
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
	public pdiVePerfilAlumno(String pdi, String correo, int id) {
		initialize(pdi,correo, id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String pdi, String correo, int id) {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(pdiVePerfilAlumno.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 434, 269);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		Usuario usuario = new Usuario(correo);
		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(10, 11, 46, 23);
		frmAccionsocialmed.getContentPane().add(btnVolver);
		
		JLabel label = new JLabel(usuario.getEmail());
		label.setFont(new Font("Gill Sans MT", Font.PLAIN, 14));
		label.setBounds(66, 15, 342, 14);
		frmAccionsocialmed.getContentPane().add(label);
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido:");
		lblPrimerApellido.setBounds(10, 43, 96, 14);
		frmAccionsocialmed.getContentPane().add(lblPrimerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido:");
		lblSegundoApellido.setBounds(10, 68, 108, 14);
		frmAccionsocialmed.getContentPane().add(lblSegundoApellido);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 93, 66, 14);
		frmAccionsocialmed.getContentPane().add(lblNombre);
		
		JLabel lblAsignaturasCursando = new JLabel("Asignaturas:");
		lblAsignaturasCursando.setBounds(10, 118, 89, 14);
		frmAccionsocialmed.getContentPane().add(lblAsignaturasCursando);
		
		JLabel lblTiposElegidos = new JLabel("Tipos elegidos:");
		lblTiposElegidos.setBounds(10, 143, 108, 14);
		frmAccionsocialmed.getContentPane().add(lblTiposElegidos);
		
		JLabel lblreasElegidas = new JLabel("\u00C1reas elegidas:");
		lblreasElegidas.setBounds(10, 168, 108, 14);
		frmAccionsocialmed.getContentPane().add(lblreasElegidas);
		
		JLabel label_1 = new JLabel(usuario.getPrimerApellido());
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_1.setBounds(109, 43, 299, 14);
		frmAccionsocialmed.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel(usuario.getSegundoApellido());
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_2.setBounds(119, 68, 289, 14);
		frmAccionsocialmed.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel(usuario.getNombre());
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_3.setBounds(66, 93, 342, 14);
		frmAccionsocialmed.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("<asignatura1,asignatura2,asignatura3>");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_4.setBounds(96, 118, 312, 14);
		frmAccionsocialmed.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("<tipo1,tipo2,tipo3>");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_5.setBounds(109, 143, 299, 14);
		frmAccionsocialmed.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("<area1,area2,area3>");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_6.setBounds(109, 168, 299, 14);
		frmAccionsocialmed.getContentPane().add(label_6);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(new Color(60, 179, 113));
		btnAceptar.setBackground(Color.LIGHT_GRAY);
		btnAceptar.setBounds(10, 198, 89, 23);
		frmAccionsocialmed.getContentPane().add(btnAceptar);
		
		JButton btnRechazar = new JButton("Rechazar");
		btnRechazar.setForeground(new Color(220, 20, 60));
		btnRechazar.setBackground(Color.LIGHT_GRAY);
		btnRechazar.setBounds(119, 198, 89, 23);
		frmAccionsocialmed.getContentPane().add(btnRechazar);
		
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//añadir a solicitud, solicitudesAps BORRAR
				try {
					MySQLBD bd = new MySQLBD();
					bd.readDataBase();
					bd.delete("DELETE FROM solicitudesaps WHERE Alumno = '"+correo+"' AND Actividad = '"+id+"';");
					bd.insert("INSERT INTO solicitud (Solicitante,Actividad) VALUES ('"+correo+"', '" + id + "')");
					JOptionPane.showMessageDialog(frmAccionsocialmed, "Alumno aceptado");
					pdiSolicitudesAlumnosView.main(pdi);
					frmAccionsocialmed.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		btnRechazar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					MySQLBD bd = new MySQLBD();
					bd.readDataBase();
					bd.delete("DELETE FROM solicitudesaps WHERE Alumno = '"+correo+"' AND Actividad = '"+id+"';");
					JOptionPane.showMessageDialog(frmAccionsocialmed, "Alumno rechazado");
					pdiSolicitudesAlumnosView.main(pdi);
					frmAccionsocialmed.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
