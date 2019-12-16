package pdi;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
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

public class pdiSolicitudesAlumnosView {

	private JPanel contentPane;
	private JTable table;
	private JFrame frmAccionsocialmed;
	/**
	 * Launch the application.
	 */
	public static void main(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pdiSolicitudesAlumnosView window = new pdiSolicitudesAlumnosView(user);
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
	public pdiSolicitudesAlumnosView(String user) throws Exception {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(pdiSolicitudesAlumnosView.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 530, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmAccionsocialmed.setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 494, 211);
		contentPane.add(scrollPane);

		table = new JTable();

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Alumno", "Actividad", "Horas", "Plazas"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(207);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(253);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(65);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();

		MySQLBD bd = new MySQLBD();
		bd.readDataBase();

		List<Solicitud> solicitudes= Solicitud.listaSolicitudes();

		for (int i = 0; i<solicitudes.size();i++) {
			Solicitud solicitud = solicitudes.get(i);
			if (solicitud.isAprobadaPorGestor() == false && solicitud.isRechazadaPorGestor()== false) {
				Actividad act = new Actividad(solicitud.getActividad());
				Object[] insert = {act.getTitulo(),act.getLugar(),act.getHoras(),act.getPlazasDisponibles()};
				modelo.addRow(insert);
			}
		}

		scrollPane.setViewportView(table);

		JButton verDetalles = new JButton("Ver detalles actividad");
		verDetalles.setBackground(Color.LIGHT_GRAY);
		verDetalles.setForeground(Color.BLACK);
		verDetalles.setFont(new Font("Tahoma", Font.PLAIN, 9));
		verDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		verDetalles.setBounds(152, 11, 173, 23);
		contentPane.add(verDetalles);

		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnVolver.setBounds(10, 11, 46, 23);
		contentPane.add(btnVolver);

		JButton btnVerDetallesAlumno = new JButton("Ver detalles alumno");
		btnVerDetallesAlumno.setBounds(348, 11, 156, 23);
		contentPane.add(btnVerDetallesAlumno);

		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//ongMainView.main(user);
				frmAccionsocialmed.dispose();
			}
		});
		verDetalles.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int id = 0;
					MySQLBD bd = new MySQLBD();
					bd.readDataBase();

					String[] res = bd.select("SELECT Codigo FROM actividades WHERE Titulo = '"+ modelo.getValueAt(table.getSelectedRow(), 1) +"';").get(0);
					id = Integer.parseInt(res[0]);
					vistaActividadDetallesPdi.main(id);
					frmAccionsocialmed.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});


	}
}
