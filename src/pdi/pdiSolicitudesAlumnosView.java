package pdi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class pdiSolicitudesAlumnosView extends JFrame {
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pdiSolicitudesAlumnosView frame = new pdiSolicitudesAlumnosView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public pdiSolicitudesAlumnosView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 455);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(637, 181, 111, 23);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 617, 394);
		getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Alumno", "Correo", "Actividad"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(0).setPreferredWidth(253);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(312);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(315);
		scrollPane.setViewportView(table_1);
		
		JButton btnNewButton_1 = new JButton("Rechazar");
		btnNewButton_1.setBounds(637, 293, 111, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnVerAlumno = new JButton("Ver solicitud");
		btnVerAlumno.setBounds(637, 77, 111, 23);
		getContentPane().add(btnVerAlumno);
	}
}
