package pdi;

import java.awt.EventQueue;
import pantallasCompartidas.editarPerfilView;
import pantallasCompartidas.mensajesView;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import alumno.alumnoMainView;
import alumno.funcionesCompartidas;
import gestor.vistaActividadDetallesActs;
import home.homeView;
import main.MySQLBD;
import modelos.Actividad;
import modelos.Usuario;
import ong.ongMainView;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;

public class nuevoProyectoView {
	private JFrame frmAccionsocialmed;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public static void main(int id, String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nuevoProyectoView window = new nuevoProyectoView(id, user);
					window.frmAccionsocialmed.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	public nuevoProyectoView(int id, String user) throws Exception {
		initialize(id, user);
	}

	private void initialize(int id, String user) throws Exception {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(alumnoMainView.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 383, 151);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JLabel lblNuevoProyecto = new JLabel("Nuevo proyecto:");
		lblNuevoProyecto.setBounds(10, 11, 122, 14);
		frmAccionsocialmed.getContentPane().add(lblNuevoProyecto);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 39, 46, 14);
		frmAccionsocialmed.getContentPane().add(lblNombre);
		
		textField_2 = new JTextField();
		textField_2.setBounds(66, 36, 279, 20);
		frmAccionsocialmed.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(Color.LIGHT_GRAY);
		btnAceptar.setBounds(131, 76, 89, 23);
		frmAccionsocialmed.getContentPane().add(btnAceptar);
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textField_2.getText();
				if(nombre.equals("")) {
					JOptionPane.showMessageDialog(frmAccionsocialmed, "Faltan campos por rellenar");
				}else {
					MySQLBD bd = new MySQLBD();
					try {
						bd.readDataBase();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					bd.insert("INSERT INTO eef_primera_iteracion.proyectos (nombre, coordinador) VALUES ('"+nombre+"', '"+user+"');");
					JOptionPane.showMessageDialog(frmAccionsocialmed, "Proyecto creado con éxito");
					pdiAnadirAProyecto.main(id, user);
					
					frmAccionsocialmed.dispose();
				}
			}
		});
		
		
}
}