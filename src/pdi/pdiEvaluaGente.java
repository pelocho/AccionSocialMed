package pdi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JSlider;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import alumno.funcionesCompartidas;
import main.MySQLBD;
import modelos.Actividad;
import modelos.Participacion;
import modelos.Usuario;

import javax.swing.JButton;
import java.awt.Color;

public class pdiEvaluaGente {

	private JFrame frmAccionsocialmed;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					pdiEvaluaGente window = new pdiEvaluaGente(user);
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
	public pdiEvaluaGente(String user) throws Exception {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize(String user) throws Exception {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(pdiEvaluaGente.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setBounds(100, 100, 557, 366);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		Usuario pdi= new Usuario(user);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 522, 272);
		frmAccionsocialmed.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Correo", "Nombre", "Actividad"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(140);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		scrollPane.setViewportView(table);
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		List<String[]> lista = bd.select("SELECT * FROM eef_primera_iteracion.participacion; " );
		Usuario profesor = new Usuario(user);
		
		for(String[] tupla : lista) {
			Usuario us = new Usuario(tupla[0]);
			Actividad act = new Actividad (Integer.parseInt(tupla[1]) );
			Participacion part = new Participacion(tupla[0],Integer.parseInt(tupla[1]));
			
			if(part.getValoracionONG() != -1 && part.getValoracionPDI() == -1 && funcionesCompartidas.esProfesor(act.getAsignaturaAsociada(),profesor)) {
				Object[] prueba = {us.getEmail(), us.getNombre(), act.getTitulo() } ;
				modelo.addRow(prueba) ;
			}
		}

		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(10, 11, 41, 23);
		frmAccionsocialmed.getContentPane().add(btnVolver);
		
		JButton btnVerAlumno = new JButton("Evaluar usuario\r\n");
		btnVerAlumno.setBackground(Color.LIGHT_GRAY);
		btnVerAlumno.setBounds(373, 11, 159, 23);
		frmAccionsocialmed.getContentPane().add(btnVerAlumno);
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmAccionsocialmed.dispose();
				pdiMainView.main(user);
			}
		});
		
		btnVerAlumno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					MySQLBD bd = new MySQLBD();
					bd.readDataBase();
					
					String usuario  = (String)modelo.getValueAt(table.getSelectedRow(), 0);
					String nombreAct = (String)modelo.getValueAt(table.getSelectedRow(), 2) ;
					
					String act = bd.select("SELECT Codigo FROM eef_primera_iteracion.actividades where Titulo = '" +nombreAct + "'; ").get(0)[0];
					
					frmAccionsocialmed.dispose();
					pdiEvaluaGente2.main(usuario, Integer.parseInt(act),user )  ;
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
		} );
		
		
	}

	private boolean estaEvaluadoOng(Usuario us, Actividad act) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		boolean res = false;
		

		List<String[]> l =  bd.select("select valoracionONG from eef_primera_iteracion.participacion "
				+ "WHERE (`correoUsuario` = '" + us.getEmail() + "') and (`idActividad` = '" + act.getCodigo() + "');; " );

		
			res = l.get(0)[0] != null;
		
		


		return res ;
	}

	private boolean estaEvaluadoPdi(Usuario us, Actividad act) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		boolean res = false;

		List<String[]> l =  bd.select("select valoracionPDI from eef_primera_iteracion.participacion "
				+ "WHERE (`correoUsuario` = '" + us.getEmail() + "') and (`idActividad` = '" + act.getCodigo() + "');; " );

		if(l.size() != 0  && l.get(0).length != 0) {
			res = Integer.parseInt(l.get(0)[0]) != -1;
		}

		return res ;	}
}


