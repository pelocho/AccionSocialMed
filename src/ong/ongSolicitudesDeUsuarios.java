package ong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import alumno.funcionesCompartidas;
import alumno.vistaActividad;
import main.MySQLBD;
import modelos.Actividad;
import modelos.Solicitud;
import modelos.Usuario;

public class ongSolicitudesDeUsuarios {

	private JFrame frmAccionsocialmed;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String ong) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ongSolicitudesDeUsuarios window = new ongSolicitudesDeUsuarios(ong);
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
	public ongSolicitudesDeUsuarios(String ong) throws Exception {
		initialize(ong);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize(String ong) throws Exception {
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
			},
			new String[] {
				"Tipo de usuario", "Asignaturas cursando actualmente", "Correo"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
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
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		List<Solicitud> solicitudes = Solicitud.listaSolicitudesNoAceptadas(ong);
		for(Solicitud i : solicitudes) {
			System.out.println(i.getSolicitante() + ", " + i.getActividad());
		}
		for(Solicitud solicitud : solicitudes) {
			Usuario usuario = new Usuario(solicitud.getSolicitante());
			Object[] insert = {funcionesCompartidas.getTipoUsuario(usuario.getCategoryId()),usuario.getAsignaturasCursadasToString(),usuario.getEmail()};
			modelo.addRow(insert);	
		}
		
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
		
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String usuario = (String) modelo.getValueAt(table.getSelectedRow(), 2);
					System.out.println(usuario);
					MySQLBD bd = new MySQLBD();
					bd.readDataBase();
					String[] res = bd.select("SELECT Actividad FROM solicitud WHERE Solicitante = '"+ usuario +"';").get(0);
					int id = Integer.parseInt(res[0]);
					bd.delete("DELETE FROM solicitud WHERE Solicitante = '"+usuario+"' AND Actividad ='"+id+"';");
					Actividad act = new Actividad(id);
					act.plazaMenos();
					bd.insert("INSERT INTO `eef_primera_iteracion`.`participacion` (`correoUsuario`, `idActividad`) VALUES ('"+usuario+"', '"+id+"');");
					JOptionPane.showMessageDialog(frmAccionsocialmed, "Usuario Aceptado");
					frmAccionsocialmed.dispose();
					ongMainView.main(ong);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnRechazar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String usuario = (String) modelo.getValueAt(table.getSelectedRow(), 2);
					System.out.println(usuario);
					MySQLBD bd = new MySQLBD();
					bd.readDataBase();
					String[] res = bd.select("SELECT Actividad FROM solicitud WHERE Solicitante = '"+ usuario +"';").get(0);
					int id = Integer.parseInt(res[0]);
					bd.delete("DELETE FROM solicitud WHERE Solicitante = '"+usuario+"' AND Actividad ='"+id+"';");
					JOptionPane.showMessageDialog(frmAccionsocialmed, "Usuario Rechazado");
					frmAccionsocialmed.dispose();
					ongMainView.main(ong);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//ongMainView.main(ong);
				frmAccionsocialmed.dispose();
			}
		});
	}
}
