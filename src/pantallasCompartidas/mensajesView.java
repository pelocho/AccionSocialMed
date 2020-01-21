package pantallasCompartidas;

import java.awt.EventQueue;
import pantallasCompartidas.editarPerfilView;
import pas.pasMainView;
import pdi.pdiMainView;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import alumno.alumnoMainView;
import alumno.funcionesCompartidas;
import gestor.gestorMainView;
import gestor.vistaActividadDetallesActs;
import home.homeView;
import main.MySQLBD;
import modelos.Actividad;
import modelos.Mensaje;
import modelos.ONG;
import modelos.Usuario;
import ong.ongMainView;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ListSelectionModel;

public class mensajesView {

	private JFrame frmAccionsocialmed;
	private JTable table_1;

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mensajesView window = new mensajesView(user);
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
	 * @wbp.parser.entryPoint
	 */
	public mensajesView(String user) throws Exception {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */
	private void initialize(String user) throws Exception {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(alumnoMainView.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 482, 295);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 479, 178);
		frmAccionsocialmed.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Enviado por:", "Estado", "id"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(330);
		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(135);
		table_1.getColumnModel().getColumn(2).setResizable(false);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(15);
		scrollPane.setViewportView(table_1);
		
		DefaultTableModel modelo = (DefaultTableModel) table_1.getModel();
		
		List<Mensaje> mensajes = Mensaje.listaMensajesUsuario(user);
			
		for(Mensaje m : mensajes) {
			Object[] prueba = {m.getRemitente(),m.getEstadotoString(),m.getId()}; 		// Inserta todos los mensajes
			modelo.addRow(prueba);
		}
		
		JButton btnNuevoMensaje = new JButton("Nuevo mensaje");
		btnNuevoMensaje.setBackground(Color.LIGHT_GRAY);
		btnNuevoMensaje.setBounds(75, 11, 114, 23);
		frmAccionsocialmed.getContentPane().add(btnNuevoMensaje);
		
		JButton btnVerMensaje = new JButton("Ver mensaje");
		btnVerMensaje.setBackground(Color.LIGHT_GRAY);
		btnVerMensaje.setBounds(341, 11, 121, 23);
		frmAccionsocialmed.getContentPane().add(btnVerMensaje);
		
		JButton btnEliminarMensaje = new JButton("Eliminar mensaje");
		btnEliminarMensaje.setBackground(Color.LIGHT_GRAY);
		btnEliminarMensaje.setBounds(199, 11, 132, 23);
		frmAccionsocialmed.getContentPane().add(btnEliminarMensaje);
		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(10, 11, 55, 23);
		frmAccionsocialmed.getContentPane().add(btnVolver);
		
		btnNuevoMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviarMensajesView.main(user);
				frmAccionsocialmed.dispose();
			}
		});
		
		btnVerMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Mensaje msg = new Mensaje((int) modelo.getValueAt(table_1.getSelectedRow(), 2));
					mensajeDetallesView.main(user,msg);
					funcionesCompartidas.mensajeLeido(msg.getId());
					frmAccionsocialmed.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnEliminarMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mensaje msg;
				try {
					msg = new Mensaje((int)modelo.getValueAt(table_1.getSelectedRow(), 2));
					funcionesCompartidas.eliminarMensaje(msg.getId());
					JOptionPane.showMessageDialog(frmAccionsocialmed, "Mensaje eliminado");
					mensajesView.main(user);
					frmAccionsocialmed.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(funcionesCompartidas.esUsuario(user)) {
						Usuario usuario = new Usuario(user);
						if(usuario.getCategoryId() == 1) {
							alumnoMainView.main(user);
						}else if(usuario.getCategoryId() == 2) {
							pdiMainView.main(user);
						}else if(usuario.getCategoryId() == 3) {
							pasMainView.main(user);
						}else {
							gestorMainView.main(user);
						}
					}else {
						ongMainView.main(user);
					}
					frmAccionsocialmed.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		});
	}
}

