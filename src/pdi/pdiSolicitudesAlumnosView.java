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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class pdiSolicitudesAlumnosView extends JFrame {
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pdiSolicitudesAlumnosView frame = new pdiSolicitudesAlumnosView(user);
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
	public pdiSolicitudesAlumnosView(String user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(pdiSolicitudesAlumnosView.class.getResource("/imagenes/icono pequeno.png")));
		setTitle("AccionSocialMed");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 455);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 738, 366);
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
		
		JButton btnVerAlumno = new JButton("Ver perfil");
		btnVerAlumno.setBackground(Color.LIGHT_GRAY);
		btnVerAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVerAlumno.setBounds(637, 11, 111, 23);
		getContentPane().add(btnVerAlumno);
		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(10, 11, 53, 23);
		getContentPane().add(btnVolver);
	}
}
