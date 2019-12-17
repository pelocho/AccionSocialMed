package ong;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import alumno.vistaActividad;
import login.loginView;
import main.MySQLBD;
import modelos.Actividad;
import modelos.Solicitud;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;

public class ongActividadesView extends ongListaActividades {

	private JPanel contentPane;
	private JTable table;
	private JFrame frmAccionsocialmed;
	private Solicitud prueba;
	/**
	 * Launch the application.
	 */
	public static void main(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ongActividadesView window = new ongActividadesView(user);
					window.frmAccionsocialmed.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public ongActividadesView(String user) throws Exception {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(ongActividadesView.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 530, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmAccionsocialmed.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 494, 210);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"T\u00EDtulo", "ONG", "Lugar", "Horas", "Plazas"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(207);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(215);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(132);
		table.getColumnModel().getColumn(3).setResizable(false);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		List<Actividad> listaact = Actividad.listaActividadesAceptadas();
		
		
		for (Actividad a : listaact) {
			Object[] prueba = {a.getTitulo(),a.getOng(), a.getLugar(),a.getHoras(),a.getPlazasDisponibles() }; 	
			modelo.addRow(prueba);
		}
		

		scrollPane.setViewportView(table);
		
		JButton btnVerDetalles = new JButton("Ver detalles");
		btnVerDetalles.setBackground(Color.LIGHT_GRAY);
		btnVerDetalles.setForeground(Color.BLACK);
		btnVerDetalles.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnVerDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnVerDetalles.setBounds(419, 11, 85, 23);
		contentPane.add(btnVerDetalles);
		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnVolver.setBounds(10, 11, 45, 23);
		contentPane.add(btnVolver);
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//ongMainView.main(user);
				frmAccionsocialmed.dispose();
			}
		});
		
		
		btnVerDetalles.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int id = 0;
					MySQLBD bd = new MySQLBD();
					bd.readDataBase();
					String[] res = bd.select("SELECT Codigo FROM actividades WHERE Titulo = '"+ modelo.getValueAt(table.getSelectedRow(), 0) +"';").get(0);
					id = Integer.parseInt(res[0]);
					ongDetallesAct.main(id);
				} catch (Exception e1) {
					e1.printStackTrace();
				}				
			}
		});
		
	}
}