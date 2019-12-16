package pas;

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
import modelos.Actividad;
import modelos.Usuario;
import pas.pasMainView;
import pdi.pdiMainView;
import alumno.funcionesCompartidas;

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

public class vistaActividadPas {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 */
	public static void main(String user, int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaActividadPas window = new vistaActividadPas(user,id);
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
	public vistaActividadPas(String user,int id) throws Exception {
		initialize(user,id);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize(String user, int id) throws Exception {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(vistaActividadPas.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 406, 504);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		Actividad act = new Actividad(id);
		
		JLabel titulo = new JLabel(act.getTitulo());
		titulo.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		titulo.setBounds(61, 9, 249, 23);
		frmAccionsocialmed.getContentPane().add(titulo);
		
		JLabel lblTipo = new JLabel("Tipo(s):");
		lblTipo.setBounds(10, 113, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblTipo);
		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(10, 11, 41, 23);
		frmAccionsocialmed.getContentPane().add(btnVolver);
		
		JLabel lblrea = new JLabel("\u00C1rea(s):");
		lblrea.setBounds(10, 138, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblrea);
		
		JLabel lblHoras = new JLabel("Horas:");
		lblHoras.setBounds(10, 163, 41, 14);
		frmAccionsocialmed.getContentPane().add(lblHoras);
		
		JLabel lblDesde = new JLabel("Desde:");
		lblDesde.setBounds(10, 188, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblDesde);
		
		JLabel lblHasta = new JLabel("Hasta:");
		lblHasta.setBounds(166, 188, 41, 14);
		frmAccionsocialmed.getContentPane().add(lblHasta);
		
		JLabel lblConEstaActividad = new JLabel("Con esta actividad se relaciona:");
		lblConEstaActividad.setBounds(10, 387, 301, 20);
		frmAccionsocialmed.getContentPane().add(lblConEstaActividad);
		
		JLabel actividades = new JLabel(act.getAsignaturaAsociadaToString());
		actividades.setFont(new Font("Tahoma", Font.PLAIN, 10));
		actividades.setBounds(10, 407, 556, 14);
		frmAccionsocialmed.getContentPane().add(actividades);
		
		TextArea textArea = new TextArea();
		textArea.setText(act.getDescripcion());
		textArea.setEditable(false);
		textArea.setBounds(10, 239, 354, 142);
		frmAccionsocialmed.getContentPane().add(textArea);
		
		JLabel lblDescripcinDeLa = new JLabel("Descripci\u00F3n de la actividad:");
		lblDescripcinDeLa.setBounds(10, 213, 226, 20);
		frmAccionsocialmed.getContentPane().add(lblDescripcinDeLa);
		
		JButton btnSolicitarEstaActividad = new JButton("Solicitar esta actividad");
		btnSolicitarEstaActividad.setBackground(Color.LIGHT_GRAY);
		btnSolicitarEstaActividad.setBounds(10, 432, 165, 23);
		frmAccionsocialmed.getContentPane().add(btnSolicitarEstaActividad);
		
		JLabel lblLugar = new JLabel("Organizaci\u00F3n:");
		lblLugar.setBounds(10, 45, 83, 14);
		frmAccionsocialmed.getContentPane().add(lblLugar);
		
		JLabel label = new JLabel("Lugar:");
		label.setBounds(10, 67, 49, 14);
		frmAccionsocialmed.getContentPane().add(label);
		
		JLabel ong = new JLabel(act.getOng());
		ong.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ong.setBounds(92, 45, 288, 14);
		frmAccionsocialmed.getContentPane().add(ong);
		
		JLabel lugar = new JLabel(act.getLugar());
		lugar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lugar.setBounds(57, 70, 335, 14);
		frmAccionsocialmed.getContentPane().add(lugar);
		
		JLabel tipos = new JLabel(act.getTipoActividadToString());
		tipos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tipos.setBounds(61, 113, 309, 14);
		frmAccionsocialmed.getContentPane().add(tipos);
		
		JLabel areas = new JLabel(act.getAreaActividadToString());
		areas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		areas.setBounds(61, 138, 309, 14);
		frmAccionsocialmed.getContentPane().add(areas);
		
		JLabel horas = new JLabel(act.getHoras()+"");
		horas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		horas.setBounds(61, 163, 83, 14);
		frmAccionsocialmed.getContentPane().add(horas);
		
		JLabel desde = new JLabel(act.getFecha_fin()+"");
		desde.setFont(new Font("Tahoma", Font.PLAIN, 10));
		desde.setBounds(57, 188, 87, 14);
		frmAccionsocialmed.getContentPane().add(desde);
		
		JLabel hasta = new JLabel(act.getFecha_fin()+"");
		hasta.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hasta.setBounds(217, 188, 107, 14);
		frmAccionsocialmed.getContentPane().add(hasta);
		
		JLabel tipo_actividad = new JLabel(act.getTipoToString());
		tipo_actividad.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tipo_actividad.setBounds(273, 436, 107, 14);
		frmAccionsocialmed.getContentPane().add(tipo_actividad);
		
		JLabel lblPlazasDisponibles = new JLabel("Plazas disponibles:");
		lblPlazasDisponibles.setBounds(10, 92, 113, 14);
		frmAccionsocialmed.getContentPane().add(lblPlazasDisponibles);
		
		JLabel lblModificarplazas = new JLabel(act.getPlazasDisponibles()+"");
		lblModificarplazas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblModificarplazas.setBounds(122, 92, 62, 14);
		frmAccionsocialmed.getContentPane().add(lblModificarplazas);
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmAccionsocialmed.dispose();
			}
		});
		
		btnSolicitarEstaActividad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean ok;
				try {
					Usuario u = new Usuario(user);
					if(u.getCategoryId() == 1 && act.getTipo() == 1) {
						ok = funcionesCompartidas.enviarSolicitudAPDI(u.getEmail(),act.getCodigo());
					}else {
						ok = funcionesCompartidas.enviarSolicitud(u.getEmail(),act.getCodigo());
					}					
					if(ok) {
						JOptionPane.showMessageDialog(frmAccionsocialmed, "Su solicitud ha sido enviada");
						frmAccionsocialmed.dispose();
						if(u.getCategoryId() == 2) {
							pdiMainView.main(user);
						}else if(u.getCategoryId() == 1) {
							pasMainView.main(user);
						}else {
							pasMainView.main(user);
						}
						
					}else {
						JOptionPane.showMessageDialog(frmAccionsocialmed, "Ha habido un error al enviar su solicitud");
						if(u.getCategoryId() == 2) {
							pasMainView.main(user);
						}else if(u.getCategoryId() == 1) {
							pasMainView.main(user);
						}else {
							pasMainView.main(user);
						}
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