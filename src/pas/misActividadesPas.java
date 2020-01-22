package pas;

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

import alumno.funcionesCompartidas;
import alumno.vistaActividad;
import gestor.vistaActividadDetallesActs;
import login.loginView;
import main.MySQLBD;
import modelos.Actividad;
import modelos.Solicitud;
import ong.ongDetallesAct;
import pantallasCompartidas.usuariosCertificado;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;

public class misActividadesPas {

	private JPanel contentPane;
	private JTable table;
	private JFrame frmAccionsocialmed;
	private Solicitud prueba;
	private JButton btnCertificado;
	/**
	 * Launch the application.
	 */
	public static void main(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					misActividadesPas window = new misActividadesPas(user);
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
	public misActividadesPas(String user) throws Exception {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(misActividadesPas.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 621, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmAccionsocialmed.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 585, 295);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titulo", "Lugar", "Horas", "Plazas", "Estado"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, Integer.class, String.class
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
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(129);
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		List<Actividad> listaAceptada = funcionesCompartidas.listaActividadesAlumno(user);
		List<Actividad> listaSolicitud = funcionesCompartidas.listaSolicitudesAlumno(user);
			
		for (Actividad a : listaAceptada) {
			
			Object[] prueba = {a.getTitulo(),a.getLugar(), a.getHoras(),a.getPlazasDisponibles(),a.mostrarEstado()}; 	
			modelo.addRow(prueba);
		}
		
		for (Actividad a : listaSolicitud) {
			Object[] prueba = {a.getTitulo(),a.getLugar(), a.getHoras(),a.getPlazasDisponibles(),"Pendiente" }; 	
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
		btnVerDetalles.setBounds(510, 11, 85, 23);
		contentPane.add(btnVerDetalles);
		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnVolver.setBounds(10, 11, 46, 23);
		contentPane.add(btnVolver);
		
		btnCertificado = new JButton("Certificado");
		btnCertificado.setBackground(Color.LIGHT_GRAY);
		btnCertificado.setBounds(397, 11, 103, 23);
		contentPane.add(btnCertificado);
		
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pasMainView.main(user);
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
					pasDetallesActividad.main(id);
				} catch (Exception e1) {
					e1.printStackTrace();
				}				
			}
		});
		
		btnCertificado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int id = 0;
					MySQLBD bd = new MySQLBD();
					bd.readDataBase();
					String[] res = bd.select("SELECT Codigo FROM actividades WHERE Titulo = '"+ modelo.getValueAt(table.getSelectedRow(), 0) +"';").get(0);
					id = Integer.parseInt(res[0]);
					Actividad act = new Actividad(id);
					if(act.getTipo() == 6) {
						usuariosCertificado.main(user,id);
					}else {
						JOptionPane.showMessageDialog(frmAccionsocialmed, "No puedes ver el certificado de una actividad que no ha finalizado");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frmAccionsocialmed, "No puedes ver el certificado de una actividad que no ha finalizado");
				}				
			}
		});
		
	}
}

