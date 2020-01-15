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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

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
	 * @throws Exception 
	 */
	public pdiVePerfilAlumno(String pdi, String correo, int id) throws Exception {
		initialize(pdi,correo, id);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize(String pdi, String correo, int id) throws Exception {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(pdiVePerfilAlumno.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 436, 323);
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
		lblAsignaturasCursando.setBounds(10, 123, 89, 14);
		frmAccionsocialmed.getContentPane().add(lblAsignaturasCursando);
		
		JLabel lblTiposElegidos = new JLabel("Tipos elegidos:");
		lblTiposElegidos.setBounds(10, 168, 108, 14);
		frmAccionsocialmed.getContentPane().add(lblTiposElegidos);
		
		JLabel lblreasElegidas = new JLabel("\u00C1reas elegidas:");
		lblreasElegidas.setBounds(10, 198, 108, 14);
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
		
		JLabel label_5 = new JLabel(usuario.getTipoInteresesToString());
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_5.setBounds(109, 170, 299, 14);
		frmAccionsocialmed.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel(usuario.getAreaInteresesToString());
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_6.setBounds(109, 200, 299, 14);
		frmAccionsocialmed.getContentPane().add(label_6);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(new Color(60, 179, 113));
		btnAceptar.setBackground(Color.LIGHT_GRAY);
		btnAceptar.setBounds(10, 228, 89, 23);
		frmAccionsocialmed.getContentPane().add(btnAceptar);
		
		JButton btnRechazar = new JButton("Rechazar");
		btnRechazar.setForeground(new Color(220, 20, 60));
		btnRechazar.setBackground(Color.LIGHT_GRAY);
		btnRechazar.setBounds(119, 228, 89, 23);
		frmAccionsocialmed.getContentPane().add(btnRechazar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(109, 118, 290, 34);
		frmAccionsocialmed.getContentPane().add(scrollPane);
		
		JLabel lblAsignaturas = new JLabel(usuario.getAsignaturasCursadasToString());
		lblAsignaturas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAsignaturas.setBounds(109, 200, 299, 14);
		lblAsignaturas.setBackground(new Color(240, 240, 240));
		scrollPane.setViewportView(lblAsignaturas);
		
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
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
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
