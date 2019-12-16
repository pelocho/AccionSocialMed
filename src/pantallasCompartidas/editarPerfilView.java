package pantallasCompartidas;

import java.awt.EventQueue;
import pantallasCompartidas.funcionesEditarPerfil;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import alumno.alumnoMainView;
import main.MySQLBD;
import modelos.Usuario;

import javax.swing.JCheckBox;

public class editarPerfilView extends funcionesEditarPerfil{

	private JFrame frmAccionsocialmed;
	private JTextField lugar;
	private JTextField telefono;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editarPerfilView window = new editarPerfilView(user);
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
	public editarPerfilView(String user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String user) {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(editarPerfilView.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 330, 378);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(10, 11, 41, 23);
		frmAccionsocialmed.getContentPane().add(btnVolver);
		
		JLabel lblLugarDePreferencia = new JLabel("Lugar de preferencia:");
		lblLugarDePreferencia.setBounds(10, 108, 161, 23);
		frmAccionsocialmed.getContentPane().add(lblLugarDePreferencia);
		
		JLabel lblTipo = new JLabel("Tipo(s):");
		lblTipo.setBounds(10, 142, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblTipo);
		
		JLabel lblrea = new JLabel("\u00C1rea(s):");
		lblrea.setBounds(153, 142, 65, 14);
		frmAccionsocialmed.getContentPane().add(lblrea);
		
		JLabel lblCambiarTelfono = new JLabel("Cambiar tel\u00E9fono:");
		lblCambiarTelfono.setBounds(10, 83, 115, 14);
		frmAccionsocialmed.getContentPane().add(lblCambiarTelfono);
		
		lugar = new JTextField();
		lugar.setBounds(147, 109, 149, 20);
		frmAccionsocialmed.getContentPane().add(lugar);
		lugar.setColumns(10);
		
		JCheckBox chckbxSalud = new JCheckBox("Salud");
		chckbxSalud.setBounds(10, 163, 60, 23);
		frmAccionsocialmed.getContentPane().add(chckbxSalud);
		
		JCheckBox chckbxEducacin = new JCheckBox("Educaci\u00F3n");
		chckbxEducacin.setBounds(10, 189, 94, 23);
		frmAccionsocialmed.getContentPane().add(chckbxEducacin);
		
		JCheckBox chckbxIntegracin = new JCheckBox("Integraci\u00F3n");
		chckbxIntegracin.setBounds(10, 215, 94, 23);
		frmAccionsocialmed.getContentPane().add(chckbxIntegracin);
		
		JCheckBox chckbxSaludSexual = new JCheckBox("Salud sexual");
		chckbxSaludSexual.setBounds(10, 241, 109, 23);
		frmAccionsocialmed.getContentPane().add(chckbxSaludSexual);
		
		JCheckBox chckbxNuevo = new JCheckBox("Nuevo");
		chckbxNuevo.setBounds(10, 267, 94, 23);
		frmAccionsocialmed.getContentPane().add(chckbxNuevo);
		
		JCheckBox chckbxAncianos = new JCheckBox("Ancianos");
		chckbxAncianos.setBounds(153, 163, 94, 23);
		frmAccionsocialmed.getContentPane().add(chckbxAncianos);
		
		JCheckBox chckbxInmigrantes = new JCheckBox("Inmigrantes");
		chckbxInmigrantes.setBounds(153, 189, 109, 23);
		frmAccionsocialmed.getContentPane().add(chckbxInmigrantes);
		
		JCheckBox chckbxNios = new JCheckBox("Ni\u00F1os");
		chckbxNios.setBounds(153, 215, 94, 23);
		frmAccionsocialmed.getContentPane().add(chckbxNios);
		
		JCheckBox chckbxNecesitados = new JCheckBox("Necesitados");
		chckbxNecesitados.setBounds(153, 241, 109, 23);
		frmAccionsocialmed.getContentPane().add(chckbxNecesitados);
		
		JCheckBox chckbxAdictos = new JCheckBox("Adictos");
		chckbxAdictos.setBounds(153, 267, 94, 23);
		frmAccionsocialmed.getContentPane().add(chckbxAdictos);
		
		JButton btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.setBackground(Color.LIGHT_GRAY);
		btnGuardarCambios.setBounds(10, 304, 149, 23);
		frmAccionsocialmed.getContentPane().add(btnGuardarCambios);
		
		telefono = new JTextField();
		telefono.setColumns(10);
		telefono.setBounds(147, 77, 149, 20);
		frmAccionsocialmed.getContentPane().add(telefono);
		
		JLabel lblCambiarContrasea = new JLabel("Cambiar contrase\u00F1a:");
		lblCambiarContrasea.setBounds(10, 45, 149, 23);
		frmAccionsocialmed.getContentPane().add(lblCambiarContrasea);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(147, 46, 149, 20);
		frmAccionsocialmed.getContentPane().add(textField);
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAccionsocialmed.dispose();
				alumnoMainView.main(user);
			}
		});
		
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int telf = Integer.parseInt(telefono.getText());
				String lugarPref = lugar.getText();
				String contraseña = textField.getText();
				Boolean ok = false;
				try {
					ok = editarAlumno(contraseña, telf, lugarPref, user);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				MySQLBD bd = new MySQLBD();
				try {
					bd.readDataBase();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				Usuario us = new Usuario(user);
				
				//Si el alumno cambia sus preferencias hay que borrar las antiguas
				bd.delete("DELETE FROM eef_primera_iteracion.usuario_tipo_preferencia WHERE Correo='"+user+"';");
				bd.delete("DELETE FROM eef_primera_iteracion.usuario_area_preferencia WHERE Correo='"+user+"';");
				
				
				//Preferencias tipo
				if(chckbxSalud.isSelected()) {
					bd.insert("INSERT INTO eef_primera_iteracion.usuario_tipo_preferencia (Tipo, Correo) VALUES("+1+", '"+user+"');");
					us.añadirTipoIntereses(1);
				}
				if(chckbxEducacin.isSelected()) {
					bd.insert("INSERT INTO eef_primera_iteracion.usuario_tipo_preferencia (Tipo, Correo) VALUES("+2+", '"+user+"');");
					us.añadirTipoIntereses(2);
				}
				if(chckbxIntegracin.isSelected()) {
					bd.insert("INSERT INTO eef_primera_iteracion.usuario_tipo_preferencia (Tipo, Correo) VALUES("+3+", '"+user+"');");
					us.añadirTipoIntereses(3);
				}
				if(chckbxSaludSexual.isSelected()) {
					bd.insert("INSERT INTO eef_primera_iteracion.usuario_tipo_preferencia (Tipo, Correo) VALUES("+4+", '"+user+"');");
					us.añadirTipoIntereses(4);
				}
				if(chckbxNuevo.isSelected()) {
					bd.insert("INSERT INTO eef_primera_iteracion.usuario_tipo_preferencia (Tipo, Correo) VALUES("+5+", '"+user+"');");
					us.añadirTipoIntereses(5);
				}
				
				
				//Preferencias area
				if(chckbxAncianos.isSelected()) {
					bd.insert("INSERT INTO eef_primera_iteracion.usuario_area_preferencia (Area, Correo) VALUES("+1+", '"+user+"');");
					us.añadirAreaInteres(1);
				}
				if(chckbxInmigrantes.isSelected()) {
					bd.insert("INSERT INTO eef_primera_iteracion.usuario_area_preferencia (Area, Correo) VALUES("+2+", '"+user+"');");
					us.añadirAreaInteres(2);
				}
				if(chckbxNios.isSelected()) {
					bd.insert("INSERT INTO eef_primera_iteracion.usuario_area_preferencia (Area, Correo) VALUES("+3+", '"+user+"');");
					us.añadirAreaInteres(3);

				}
				if(chckbxNecesitados.isSelected()) {
					bd.insert("INSERT INTO eef_primera_iteracion.usuario_area_preferencia (Area, Correo) VALUES("+4+", '"+user+"');");
					us.añadirAreaInteres(4);

				}
				if(chckbxAdictos.isSelected()) {
					bd.insert("INSERT INTO eef_primera_iteracion.usuario_area_preferencia (Area, Correo) VALUES("+5+", '"+user+"');");
					us.añadirAreaInteres(5);

				}
				
				
				
				if (ok) {
					frmAccionsocialmed.dispose();
					JOptionPane.showMessageDialog(frmAccionsocialmed, "Perfil editado correctamente");
				} else {
					JOptionPane.showMessageDialog(frmAccionsocialmed, "Error al editar perfil");
				}
				
				alumnoMainView.main(user);
				
				
				
			}
		});
	}
}
