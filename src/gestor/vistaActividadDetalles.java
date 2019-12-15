package gestor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

import home.homeView;
import main.MySQLBD;
import modelos.Actividad;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.AbstractListModel;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.Font;
import java.awt.Color;

public class vistaActividadDetalles {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 */
	public static void main(int id, String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaActividadDetalles window = new vistaActividadDetalles(id,user);
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
	public vistaActividadDetalles(int id,String user) throws Exception {
		initialize(id, user);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize(int id, String user) throws Exception {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(vistaActividadDetalles.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 518, 528);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		Actividad act = new Actividad(id);
		
		JLabel titulo = new JLabel(act.getTitulo());
		titulo.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		titulo.setBounds(100, 9, 316, 23);
		frmAccionsocialmed.getContentPane().add(titulo);
		
		JLabel lblTipo = new JLabel("Tipo(s):");
		lblTipo.setBounds(10, 112, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblTipo);
		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(10, 11, 41, 23);
		frmAccionsocialmed.getContentPane().add(btnVolver);
		
		JLabel lblrea = new JLabel("\u00C1rea(s):");
		lblrea.setBounds(10, 137, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblrea);
		
		JLabel lblHoras = new JLabel("Horas:");
		lblHoras.setBounds(10, 162, 41, 14);
		frmAccionsocialmed.getContentPane().add(lblHoras);
		
		JLabel lblDesde = new JLabel("Desde:");
		lblDesde.setBounds(10, 187, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblDesde);
		
		JLabel lblHasta = new JLabel("Hasta:");
		lblHasta.setBounds(269, 187, 41, 14);
		frmAccionsocialmed.getContentPane().add(lblHasta);
		
		TextArea textArea = new TextArea();
		textArea.setText(act.getDescripcion());
		textArea.setEditable(false);
		textArea.setBounds(10, 238, 459, 142);
		frmAccionsocialmed.getContentPane().add(textArea);
		
		JLabel lblDescripcinDeLa = new JLabel("Descripci\u00F3n de la actividad:");
		lblDescripcinDeLa.setBounds(10, 212, 226, 20);
		frmAccionsocialmed.getContentPane().add(lblDescripcinDeLa);
		
		JLabel lblLugar = new JLabel("Organizaci\u00F3n:");
		lblLugar.setBounds(10, 45, 83, 14);
		frmAccionsocialmed.getContentPane().add(lblLugar);
		
		JLabel label = new JLabel("Lugar:");
		label.setBounds(10, 67, 49, 14);
		frmAccionsocialmed.getContentPane().add(label);
		
		JLabel ong = new JLabel(act.getOng());
		ong.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ong.setBounds(92, 45, 340, 14);
		frmAccionsocialmed.getContentPane().add(ong);
		
		JLabel lugar = new JLabel(act.getLugar());
		lugar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lugar.setBounds(57, 70, 335, 14);
		frmAccionsocialmed.getContentPane().add(lugar);
		
		JLabel tipos = new JLabel(act.getTipoActividadToString());
		tipos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tipos.setBounds(61, 112, 387, 14);
		frmAccionsocialmed.getContentPane().add(tipos);
		
		JLabel areas = new JLabel(act.getAreaActividadToString());
		areas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		areas.setBounds(61, 137, 371, 14);
		frmAccionsocialmed.getContentPane().add(areas);
		
		JLabel horas = new JLabel(act.getHoras()+"");
		horas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		horas.setBounds(61, 162, 83, 14);
		frmAccionsocialmed.getContentPane().add(horas);
		
		JLabel desde = new JLabel(act.getFecha_fin()+"");
		desde.setFont(new Font("Tahoma", Font.PLAIN, 10));
		desde.setBounds(57, 187, 202, 14);
		frmAccionsocialmed.getContentPane().add(desde);
		
		JLabel hasta = new JLabel(act.getFecha_fin()+"");
		hasta.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hasta.setBounds(341, 187, 150, 14);
		frmAccionsocialmed.getContentPane().add(hasta);
		
		JLabel tipo_actividad = new JLabel(act.getTipoToString());
		tipo_actividad.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tipo_actividad.setBounds(362, 424, 107, 14);
		frmAccionsocialmed.getContentPane().add(tipo_actividad);
		
		
		JButton btnRechazar = new JButton("Rechazar");
		btnRechazar.setBackground(Color.LIGHT_GRAY);
		btnRechazar.setForeground(Color.RED);
		btnRechazar.setBounds(237, 420, 89, 23);
		frmAccionsocialmed.getContentPane().add(btnRechazar);
		
		JButton btnAceptar = new JButton("Aceptar como APS"); //1
		btnAceptar.setBackground(Color.LIGHT_GRAY);
		btnAceptar.setBounds(10, 386, 197, 23);
		frmAccionsocialmed.getContentPane().add(btnAceptar);
		
		JButton btnAceptarInv = new JButton("Aceptar como investigacion");//2
		btnAceptarInv.setBackground(Color.LIGHT_GRAY);
		btnAceptarInv.setBounds(10, 420, 197, 23);
		frmAccionsocialmed.getContentPane().add(btnAceptarInv);
		
		JButton btnAceptarVol = new JButton("Aceptar como voluntariado");//0
		btnAceptarVol.setBackground(Color.LIGHT_GRAY);
		btnAceptarVol.setBounds(10, 456, 197, 23);
		frmAccionsocialmed.getContentPane().add(btnAceptarVol);
		
		JLabel lblPlazas = new JLabel("Plazas:");
		lblPlazas.setBounds(10, 87, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblPlazas);
		
		JLabel label_1 = new JLabel(act.getPlazasDisponibles()+"");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_1.setBounds(67, 87, 49, 14);
		frmAccionsocialmed.getContentPane().add(label_1);
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//alumnoMainView.main(user);
				frmAccionsocialmed.dispose();
			}
		});
		
		btnRechazar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MySQLBD bd = new MySQLBD();
				try {
					bd.readDataBase();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				bd.delete("DELETE FROM eef_primera_iteracion.solicitud WHERE Actividad = '"+id+"';");
				bd.delete("DELETE FROM eef_primera_iteracion.inter_act_areaact WHERE idActividad = '"+id+"';");
				bd.delete("DELETE FROM eef_primera_iteracion.inter_act_tipoact WHERE idActividad = '"+id+"';");
				//bd.delete("DELETE FROM eef_primera_iteracion.actividades WHERE Codigo = '"+id+"';");
				bd.update("UPDATE eef_primera_iteracion.solicitud SET RechazadaPorGestor = '1' WHERE (idSolicitud = '"+id+"');");
				bd.update("UPDATE eef_primera_iteracion.actividades SET Tipo = '3' WHERE (Codigo = '"+id+"');");
				
				frmAccionsocialmed.dispose();
				frmAccionsocialmed.dispose();
				gestorSolicitudesActividad.main(user);
			}
		});
		
		btnAceptarInv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MySQLBD bd = new MySQLBD();
				try {
					bd.readDataBase();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				bd.update("UPDATE eef_primera_iteracion.solicitud SET AprobadaPorGestor = '1' WHERE (Actividad = '"+id+"');");
				bd.update("UPDATE eef_primera_iteracion.actividades SET Tipo = '2' WHERE (Codigo = '"+id+"');");
				
				frmAccionsocialmed.dispose();
				frmAccionsocialmed.dispose();
				gestorSolicitudesActividad.main(user);
			}
		});
		
		btnAceptarVol.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MySQLBD bd = new MySQLBD();
				try {
					bd.readDataBase();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				bd.update("UPDATE eef_primera_iteracion.solicitud SET AprobadaPorGestor = '1' WHERE (Actividad = '"+id+"');");
				bd.update("UPDATE eef_primera_iteracion.actividades SET Tipo = '0' WHERE (Codigo = '"+id+"');");
				
				frmAccionsocialmed.dispose();
				frmAccionsocialmed.dispose();
				gestorSolicitudesActividad.main(user);
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//alumnoMainView.main(user);
				relacionarAPSconAsignatura.main(id,user);
				frmAccionsocialmed.dispose();
			}
		});
		
	}
}
