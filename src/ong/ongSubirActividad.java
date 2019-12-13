package ong;

import ong.ongMainView;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

import main.MySQLBD;

import javax.swing.JRadioButton;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Toolkit;

public class ongSubirActividad extends funcionesONG{

	private JFrame frmAccionsocialmed;
	private JTextField titulo;
	private JTextField lugar;

	/**
	 * Launch the application.
	 */
	public static void main(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ongSubirActividad window = new ongSubirActividad(user);
					window.frmAccionsocialmed.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param user 
	 */
	public ongSubirActividad(String user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param user 
	 */
	private void initialize(String user) {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(ongSubirActividad.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 512, 639);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JLabel lblSubirUnNuevo = new JLabel("Subir una nueva actividad");
		lblSubirUnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSubirUnNuevo.setBounds(10, 11, 170, 22);
		frmAccionsocialmed.getContentPane().add(lblSubirUnNuevo);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setBounds(10, 47, 42, 14);
		frmAccionsocialmed.getContentPane().add(lblTtulo);
		
		titulo = new JTextField();
		titulo.setBounds(95, 44, 391, 20);
		frmAccionsocialmed.getContentPane().add(titulo);
		titulo.setColumns(10);
		
		JLabel lblHoras = new JLabel("Total horas:");
		lblHoras.setBounds(10, 236, 75, 14);
		frmAccionsocialmed.getContentPane().add(lblHoras);
		
		JSpinner horas = new JSpinner();
		horas.setBounds(95, 233, 48, 20);
		frmAccionsocialmed.getContentPane().add(horas);
		
		JLabel lblDescripcinDelProyecto = new JLabel("Descripci\u00F3n de la actividad:");
		lblDescripcinDelProyecto.setBounds(10, 356, 194, 22);
		frmAccionsocialmed.getContentPane().add(lblDescripcinDelProyecto);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 570, 75, 23);
		frmAccionsocialmed.getContentPane().add(btnVolver);
		
		JButton btnSubir = new JButton("Subir");
		btnSubir.setBounds(192, 570, 89, 23);
		frmAccionsocialmed.getContentPane().add(btnSubir);
		
		JLabel lblrea = new JLabel("\u00C1rea:");
		lblrea.setBounds(10, 170, 32, 14);
		frmAccionsocialmed.getContentPane().add(lblrea);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 107, 40, 19);
		frmAccionsocialmed.getContentPane().add(lblTipo);
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio:");
		lblFechaInicio.setBounds(10, 277, 75, 14);
		frmAccionsocialmed.getContentPane().add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha fin:");
		lblFechaFin.setBounds(10, 318, 61, 14);
		frmAccionsocialmed.getContentPane().add(lblFechaFin);
		
		JSpinner fecha_inicio = new JSpinner();
		fecha_inicio.setModel(new SpinnerDateModel(new Date(1577833200000L), null, null, Calendar.DAY_OF_YEAR));
		fecha_inicio.setBounds(95, 274, 104, 20);
		frmAccionsocialmed.getContentPane().add(fecha_inicio);
		
		JSpinner fecha_fin = new JSpinner();
		fecha_fin.setModel(new SpinnerDateModel(new Date(1609369200000L), null, null, Calendar.DAY_OF_YEAR));
		fecha_fin.setBounds(95, 315, 104, 20);
		frmAccionsocialmed.getContentPane().add(fecha_fin);
		
		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setBounds(10, 78, 49, 18);
		frmAccionsocialmed.getContentPane().add(lblLugar);
		
		lugar = new JTextField();
		lugar.setBounds(95, 75, 391, 20);
		frmAccionsocialmed.getContentPane().add(lugar);
		lugar.setColumns(10);
		
		JRadioButton rdbtnSalud = new JRadioButton("Salud");
		rdbtnSalud.setBounds(95, 103, 71, 23);
		frmAccionsocialmed.getContentPane().add(rdbtnSalud);
		
		JRadioButton rdbtnEducacin = new JRadioButton("Educaci\u00F3n");
		rdbtnEducacin.setBounds(168, 103, 89, 23);
		frmAccionsocialmed.getContentPane().add(rdbtnEducacin);
		
		JRadioButton rdbtnIntegracin = new JRadioButton("Integraci\u00F3n");
		rdbtnIntegracin.setBounds(259, 103, 96, 23);
		frmAccionsocialmed.getContentPane().add(rdbtnIntegracin);
		
		JRadioButton rdbtnSaludSexual = new JRadioButton("Salud sexual");
		rdbtnSaludSexual.setBounds(357, 103, 111, 23);
		frmAccionsocialmed.getContentPane().add(rdbtnSaludSexual);
		
		JRadioButton rdbtnNuevo = new JRadioButton("Nuevo");
		rdbtnNuevo.setBounds(95, 128, 111, 23);
		frmAccionsocialmed.getContentPane().add(rdbtnNuevo);
		
		JRadioButton rdbtnAncianos = new JRadioButton("Ancianos");
		rdbtnAncianos.setBounds(95, 166, 88, 23);
		frmAccionsocialmed.getContentPane().add(rdbtnAncianos);
		
		JRadioButton rdbtnInmigrantes = new JRadioButton("Inmigrantes");
		rdbtnInmigrantes.setBounds(185, 166, 96, 23);
		frmAccionsocialmed.getContentPane().add(rdbtnInmigrantes);
		
		JRadioButton rdbtnNios = new JRadioButton("Ni\u00F1os");
		rdbtnNios.setBounds(283, 166, 61, 23);
		frmAccionsocialmed.getContentPane().add(rdbtnNios);
		
		JRadioButton rdbtnNecesitados = new JRadioButton("Necesitados");
		rdbtnNecesitados.setBounds(357, 166, 104, 23);
		frmAccionsocialmed.getContentPane().add(rdbtnNecesitados);
		
		JRadioButton rdbtnAdictos = new JRadioButton("Adictos");
		rdbtnAdictos.setBounds(95, 192, 75, 23);
		frmAccionsocialmed.getContentPane().add(rdbtnAdictos);
		
		JTextArea descripcion = new JTextArea();
		descripcion.setBounds(10, 384, 476, 175);
		frmAccionsocialmed.getContentPane().add(descripcion);
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmAccionsocialmed.dispose();
			}
		});
		
		btnSubir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = titulo.getText();
				String sitio = lugar.getText();
				String descripc = descripcion.getText();
				SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
				String init_date = formater.format(fecha_inicio.getValue());
				String end_date = formater.format(fecha_fin.getValue());
				int total_horas = (int) horas.getValue();

				String ong = user;
				try {
					boolean ok = false;
					ok = subirActividad(name, sitio, descripc, init_date, end_date, total_horas, ong);
					if(ok) {
						JOptionPane.showMessageDialog (frmAccionsocialmed, " Proyecto creado y pendiente de revisi�n " );
						frmAccionsocialmed.dispose();
					} else {
						JOptionPane.showMessageDialog (frmAccionsocialmed, " Hay alg�n fallo en el formulario " );
					}
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
				MySQLBD bd = new MySQLBD();
				try {
					bd.readDataBase();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				int id = Integer.parseInt(bd.select("SELECT Codigo FROM actividades WHERE titulo = '" + name + "';").get(0)[0]);
				
				if(rdbtnSalud.isSelected()) {
					bd.insert("INSERT INTO eef_primera_iteracion.inter_act_tipoact(idActividad, idTipoActividad) VALUES("+id+", " +1+ ");");
				}
				if(rdbtnSaludSexual.isSelected()) {
					bd.insert("INSERT INTO eef_primera_iteracion.inter_act_tipoact(idActividad, idTipoActividad) VALUES("+id+", " +2+ ");");
				}
				if(rdbtnEducacin.isSelected()) {
					bd.insert("INSERT INTO eef_primera_iteracion.inter_act_tipoact(idActividad, idTipoActividad) VALUES("+id+", " +3+ ");");
				}
				if(rdbtnIntegracin.isSelected()) {
					bd.insert("INSERT INTO eef_primera_iteracion.inter_act_tipoact(idActividad, idTipoActividad) VALUES("+id+", " +4+ ");");
				}
				if(rdbtnNuevo.isSelected()) {
					bd.insert("INSERT INTO eef_primera_iteracion.inter_act_tipoact(idActividad, idTipoActividad) VALUES("+id+", " +5+ ");");
				}
				
				
				if(rdbtnAncianos.isSelected()) {
					bd.insert("INSERT INTO eef_primera_iteracion.inter_act_areaact(idActividad, idAreaActividad) VALUES("+id+", " +1+ ");");
				}
				if(rdbtnInmigrantes.isSelected()) {
					bd.insert("INSERT INTO eef_primera_iteracion.inter_act_areaact(idActividad, idAreaActividad) VALUES("+id+", " +2+ ");");
				}
				if(rdbtnNios.isSelected()) {
					bd.insert("INSERT INTO eef_primera_iteracion.inter_act_areaact(idActividad, idAreaActividad) VALUES("+id+", " +3+ ");");
				}
				if(rdbtnNecesitados.isSelected()) {
					bd.insert("INSERT INTO eef_primera_iteracion.inter_act_areaact(idActividad, idAreaActividad) VALUES("+id+", " +4+ ");");
				}
				if(rdbtnAdictos.isSelected()) {
					bd.insert("INSERT INTO eef_primera_iteracion.inter_act_areaact(idActividad, idAreaActividad) VALUES("+id+", " +5+ ");");
				}
				
				
			}
		});
	}
}
