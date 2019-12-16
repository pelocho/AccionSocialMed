package ong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ongSolicitudesDeUsuarios {

	private JFrame frmAccionsocialmed;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ongSolicitudesDeUsuarios window = new ongSolicitudesDeUsuarios();
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
	public ongSolicitudesDeUsuarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(ongSolicitudesDeUsuarios.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setBounds(100, 100, 561, 300);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(10, 11, 48, 23);
		frmAccionsocialmed.getContentPane().add(btnVolver);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 526, 206);
		frmAccionsocialmed.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Tipo de usuario", "Asignaturas cursando actualmente"
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
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(324);
		scrollPane.setViewportView(table);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(new Color(50, 205, 50));
		btnAceptar.setBackground(Color.LIGHT_GRAY);
		btnAceptar.setBounds(348, 11, 89, 23);
		frmAccionsocialmed.getContentPane().add(btnAceptar);
		
		JButton btnRechazar = new JButton("Rechazar");
		btnRechazar.setForeground(new Color(220, 20, 60));
		btnRechazar.setBackground(Color.LIGHT_GRAY);
		btnRechazar.setBounds(447, 11, 89, 23);
		frmAccionsocialmed.getContentPane().add(btnRechazar);
	}
}
