package pdi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import main.MySQLBD;
import modelos.Actividad;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class pdiAnadirAProyecto {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 * @param user 
	 */
	public static void main(int id, String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pdiAnadirAProyecto window = new pdiAnadirAProyecto(id, user);
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
	public pdiAnadirAProyecto(int id, String user) throws Exception {
		initialize( id, user);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param user 
	 * @throws Exception 
	 */
	private void initialize(int id, String user) throws Exception {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(pdiAnadirAProyecto.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 490, 160);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(10, 11, 47, 14);
		frmAccionsocialmed.getContentPane().add(btnVolver);
		
		JLabel lblParaRelacionarEsta = new JLabel("Añade esta actividad con un proyecto");
		lblParaRelacionarEsta.setBounds(67, 11, 397, 14);
		frmAccionsocialmed.getContentPane().add(lblParaRelacionarEsta);
		
		JLabel lblSeleccionarLaAsignatura = new JLabel("si es un proyecto nuevo, selecciona nuevo:");
		lblSeleccionarLaAsignatura.setBounds(10, 28, 373, 23);
		frmAccionsocialmed.getContentPane().add(lblSeleccionarLaAsignatura);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		List<String[]> proyectos = listaProyectos();
		
		comboBox.setModel(new DefaultComboBoxModel());
		for(int i = 0 ; i<proyectos.size();i++) {
			comboBox.addItem(proyectos.get(i)[0]);
		}
		comboBox.addItem("Nuevo proyecto:");
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setBounds(10, 54, 454, 23);
		frmAccionsocialmed.getContentPane().add(comboBox);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(Color.LIGHT_GRAY);
		btnAceptar.setBounds(375, 88, 89, 23);
		frmAccionsocialmed.getContentPane().add(btnAceptar);
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySQLBD bd = new MySQLBD();
				try {
					bd.readDataBase();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if (comboBox.getSelectedItem().equals("Nuevo proyecto:")) {
					nuevoProyectoView.main(id, user);
					frmAccionsocialmed.dispose();
				}else {
					
						List<String[]> idProyecto = null;
						try {
							idProyecto = idProyecto((String) comboBox.getSelectedItem());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
					String statement = "UPDATE eef_primera_iteracion.actividades SET proyecto = '"+idProyecto.get(0)[0]+"' WHERE Codigo = '"+id+"'";
					bd.update(statement);
					Actividad act = null;
					try {
						act = new Actividad(id);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						act.setTipo(1);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(frmAccionsocialmed, "Actividad añadida con exito al proyecto");

					frmAccionsocialmed.dispose();
					
				}
	
			}
		});
		
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//alumnoMainView.main(user);
				frmAccionsocialmed.dispose();
			}
		});
		
		
		
	}
	
	public static List<String[]> listaProyectos() throws Exception{
		List<String[]> res = new ArrayList<>();
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();

		res = bd.select("SELECT nombre FROM eef_primera_iteracion.proyectos;");
	
		return res;
	}
	
	public static List<String[]> idProyecto(String nombre) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();

		List<String[]> res = bd.select("SELECT id FROM eef_primera_iteracion.proyectos WHERE nombre = '"+nombre+"';");
	
		return res;
	}
}