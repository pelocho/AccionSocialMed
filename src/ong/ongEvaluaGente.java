package ong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JSlider;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;

public class ongEvaluaGente {

	private JFrame frmAccionsocialmed;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ongEvaluaGente window = new ongEvaluaGente();
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
	public ongEvaluaGente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(ongEvaluaGente.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setBounds(100, 100, 557, 366);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 522, 272);
		frmAccionsocialmed.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "DNI"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(160);
		table.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("<");
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(10, 11, 41, 23);
		frmAccionsocialmed.getContentPane().add(button);
		
		JButton btnVerAlumno = new JButton("Ver alumno");
		btnVerAlumno.setBackground(Color.LIGHT_GRAY);
		btnVerAlumno.setBounds(420, 11, 112, 23);
		frmAccionsocialmed.getContentPane().add(btnVerAlumno);
	}
}
