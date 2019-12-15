package gestor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import main.MySQLBD;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class relacionarAPSconAsignatura {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 */
	public static void main(int id, String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					relacionarAPSconAsignatura window = new relacionarAPSconAsignatura( id, user);
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
	public relacionarAPSconAsignatura(int id, String user) {
		initialize( id, user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int id, String user) {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(relacionarAPSconAsignatura.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 490, 160);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(10, 11, 47, 14);
		frmAccionsocialmed.getContentPane().add(btnVolver);
		
		JLabel lblParaRelacionarEsta = new JLabel("Para aceptar esta asignatura como Aprendizaje-Servicio debes de");
		lblParaRelacionarEsta.setBounds(67, 11, 397, 14);
		frmAccionsocialmed.getContentPane().add(lblParaRelacionarEsta);
		
		JLabel lblSeleccionarLaAsignatura = new JLabel("seleccionar la asignatura con  la que se relaciona:");
		lblSeleccionarLaAsignatura.setBounds(10, 28, 373, 23);
		frmAccionsocialmed.getContentPane().add(lblSeleccionarLaAsignatura);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Anatom\u00EDa Topogr\u00E1fica y Aplicativa", "Bases Neurofisiol\u00F3gicas de la Conducta Humana", "Aplicaciones de T\u00E9cnicas Moleculares en Patolog\u00EDa", "Biomec\u00E1nica Aplicada en Medicina y Pr\u00E1ctica Deportiva", "Farmacolog\u00EDa Social", "Salud Ambiental y Ecolog\u00EDa", "Arteriosclerosis y Factores de Riesgo Vascular", "Avances en Neurofisiolog\u00EDa del Sistema Nervioso Aut\u00F3nomo", "Habilidades B\u00E1sicas en Cirug\u00EDa Laparosc\u00F3pica", "Medicina Transfusional Perioperatoria", "Avances en Ciencias Forenses", "Los Medicamentos en los Ni\u00F1os", "Patolog\u00EDa Quir\u00FArgica Oral y Maxilofacial", "Urgencias en Patolog\u00EDa del Aparato Locomotor en el Ni\u00F1o", "Bases Microbiol\u00F3gicas para Tratamiento Antimicrobiano y Vacunolog\u00EDa", "Farmacolog\u00EDa de las Drogas de Abuso: Toxicoman\u00EDas", "Rehabilitaci\u00F3n y Medicina F\u00EDsica", "Farmacoterap\u00E9utica en Entornos Desfavorecidos", "T\u00E9cnicas de Evaluaci\u00F3n de la Composici\u00F3n Corporal", "Medicina del Deporte", "Fundamentos de la Investigaci\u00F3n en Medicina", "Gesti\u00F3n Sanitaria"}));
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
				int ID =Integer.parseInt((bd.select("SELECT id FROM dumamockup.courses WHERE name = '"+comboBox.getSelectedItem()+"';")).get(0)[0]);
				bd.update("UPDATE eef_primera_iteracion.actividades SET AsignaturaAsociada = '"+ID+"' WHERE (Codigo = '"+id+"');");
				bd.update("UPDATE eef_primera_iteracion.solicitud SET AprobadaPorGestor = '1' WHERE (Actividad = '"+id+"');");
				bd.update("UPDATE eef_primera_iteracion.actividades SET Tipo = '1' WHERE (Codigo = '"+id+"');");
				JOptionPane.showMessageDialog(frmAccionsocialmed, "La actividad ha sido añadida como ApS");
				gestorSolicitudesActividad.main(user);
				frmAccionsocialmed.dispose();
				
				
				
				
			}
		});
		
		
		
	}
}
