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
import gestor.vistaActividadDetallesActs;
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

public class ongMisActividadesTableView extends ongListaActividades {

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
					ongMisActividadesTableView window = new ongMisActividadesTableView(user);
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
	public ongMisActividadesTableView(String user) throws Exception {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(ongMisActividadesTableView.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 621, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmAccionsocialmed.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 585, 263);
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
		
		List<Actividad> listaact = Actividad.listaActividadesOng(user);
		
		
		String estado = ""; 
		for (Actividad a : listaact) {
			if (a.getTipo() == 4) {
				estado = "Pendiente de Gestor";
			}else if (a.getTipo()==3) {
				estado = "Rechazada";
			}else if( a.getTipo()==5){
				estado = "Aps Pendiente de aceptación";
			}else if(a.getTipo() == 6){ 
				estado = "Finalizada";
			}else {
				estado = "Aceptada";
			}
			
			
			Object[] prueba = {a.getTitulo(),a.getLugar(), a.getHoras(),a.getPlazasDisponibles(),estado }; 	
			modelo.addRow(prueba);
		}
		

		scrollPane.setViewportView(table);
		
		JButton btnVerDetalles = new JButton("Ver detalles");
		btnVerDetalles.setBackground(Color.LIGHT_GRAY);
		btnVerDetalles.setForeground(Color.BLACK);
		btnVerDetalles.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		
		btnVerDetalles.setBounds(482, 11, 114, 23);
		contentPane.add(btnVerDetalles);
		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnVolver.setBounds(10, 11, 46, 23);
		contentPane.add(btnVolver);
		
		JButton btnEliminarRechazadas = new JButton("Eliminar rechazadas");
		btnEliminarRechazadas.setBackground(Color.LIGHT_GRAY);
		btnEliminarRechazadas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEliminarRechazadas.setBounds(10, 314, 158, 23);
		contentPane.add(btnEliminarRechazadas);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnFinalizar.setBackground(Color.LIGHT_GRAY);
		btnFinalizar.setBounds(506, 314, 89, 23);
		contentPane.add(btnFinalizar);
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//ongMainView.main(user);
				frmAccionsocialmed.dispose();
			}
		});
		
		btnEliminarRechazadas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MySQLBD bd = new MySQLBD();
				try {
					bd.readDataBase();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				bd.delete("DELETE FROM eef_primera_iteracion.actividades WHERE Tipo = '3' AND ONG = '"+user+"';");
				JOptionPane.showMessageDialog(frmAccionsocialmed, "Eliminadas actividades rechazadas");
				frmAccionsocialmed.dispose();
				ongMisActividadesTableView.main(user);
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
		
		
		
		btnFinalizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					int id = 0;
					MySQLBD bd = new MySQLBD();
					bd.readDataBase();
					String[] res = bd.select("SELECT Codigo FROM actividades WHERE Titulo = '"+ modelo.getValueAt(table.getSelectedRow(), 0) +"';").get(0);
					id = Integer.parseInt(res[0] );
					
					Actividad aux = new Actividad(id);
					
					if (aux.getTipo() == 1 || aux.getTipo() == 2 || aux.getTipo() == 0) {  // Actividad en curso valida
						aux.setTipo(6);
						frmAccionsocialmed.dispose();
						ongEvaluaGente.main(user,id);


						
					}else {
						JOptionPane.showMessageDialog(frmAccionsocialmed, "Esta actividad no se puede finalizar");
					}
			
					
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
		} );
	
	}
}