package alumno;

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

public class vistaActividad {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 */
	public static void main(int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaActividad window = new vistaActividad(id);
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
	public vistaActividad(int id) throws Exception {
		initialize(id);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize(int id) throws Exception {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(vistaActividad.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 406, 486);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		Actividad actividad = new Actividad(id);
		
		JLabel titulo = new JLabel(actividad.getTitulo());
		titulo.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		titulo.setBounds(61, 7, 249, 26);
		frmAccionsocialmed.getContentPane().add(titulo);
		
		JLabel lblTipo = new JLabel("Tipo(s):");
		lblTipo.setBounds(10, 92, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblTipo);
		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(10, 11, 41, 23);
		frmAccionsocialmed.getContentPane().add(btnVolver);
		
		JLabel lblrea = new JLabel("\u00C1rea(s):");
		lblrea.setBounds(10, 117, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblrea);
		
		JLabel lblHoras = new JLabel("Horas:");
		lblHoras.setBounds(10, 142, 41, 14);
		frmAccionsocialmed.getContentPane().add(lblHoras);
		
		JLabel lblDesde = new JLabel("Desde:");
		lblDesde.setBounds(10, 167, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblDesde);
		
		JLabel lblHasta = new JLabel("Hasta:");
		lblHasta.setBounds(166, 167, 41, 14);
		frmAccionsocialmed.getContentPane().add(lblHasta);
		
		JLabel lblConEstaActividad = new JLabel("Con esta actividad se relaciona:");
		lblConEstaActividad.setBounds(10, 366, 301, 20);
		frmAccionsocialmed.getContentPane().add(lblConEstaActividad);
		
		JLabel actividades = new JLabel(actividad.getAsignaturaAsociadaToString());
		actividades.setFont(new Font("Tahoma", Font.PLAIN, 10));
		actividades.setBounds(10, 386, 556, 14);
		frmAccionsocialmed.getContentPane().add(actividades);
		
		TextArea textArea = new TextArea();
		textArea.setText(actividad.getDescripcion());
		textArea.setEditable(false);
		textArea.setBounds(10, 218, 354, 142);
		frmAccionsocialmed.getContentPane().add(textArea);
		
		JLabel lblDescripcinDeLa = new JLabel("Descripci\u00F3n de la actividad:");
		lblDescripcinDeLa.setBounds(10, 192, 226, 20);
		frmAccionsocialmed.getContentPane().add(lblDescripcinDeLa);
		
		JButton btnSolicitarEstaActividad = new JButton("Solicitar esta actividad");
		btnSolicitarEstaActividad.setBackground(Color.LIGHT_GRAY);
		btnSolicitarEstaActividad.setBounds(10, 411, 165, 23);
		frmAccionsocialmed.getContentPane().add(btnSolicitarEstaActividad);
		
		JLabel lblLugar = new JLabel("Organizaci\u00F3n:");
		lblLugar.setBounds(10, 45, 83, 14);
		frmAccionsocialmed.getContentPane().add(lblLugar);
		
		JLabel label = new JLabel("Lugar:");
		label.setBounds(10, 67, 49, 14);
		frmAccionsocialmed.getContentPane().add(label);
		
		JLabel ong = new JLabel(actividad.getOng());
		ong.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ong.setBounds(92, 45, 288, 14);
		frmAccionsocialmed.getContentPane().add(ong);
		
		JLabel lugar = new JLabel(actividad.getLugar());
		lugar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lugar.setBounds(57, 70, 335, 14);
		frmAccionsocialmed.getContentPane().add(lugar);
		
		JLabel tipos = new JLabel("<tipo1,tipo2>");
		tipos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tipos.setBounds(61, 92, 309, 14);
		frmAccionsocialmed.getContentPane().add(tipos);
		
		JLabel areas = new JLabel("<area1,area2>");
		areas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		areas.setBounds(61, 117, 309, 14);
		frmAccionsocialmed.getContentPane().add(areas);
		
		JLabel horas = new JLabel(actividad.getHoras()+"");
		horas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		horas.setBounds(61, 142, 83, 14);
		frmAccionsocialmed.getContentPane().add(horas);
		
		JLabel desde = new JLabel(actividad.getFecha_fin()+"");
		desde.setFont(new Font("Tahoma", Font.PLAIN, 10));
		desde.setBounds(57, 167, 87, 14);
		frmAccionsocialmed.getContentPane().add(desde);
		
		JLabel hasta = new JLabel(actividad.getFecha_fin()+"");
		hasta.setFont(new Font("Tahoma", Font.PLAIN, 10));
		hasta.setBounds(217, 167, 107, 14);
		frmAccionsocialmed.getContentPane().add(hasta);
		
		JLabel tipo_actividad = new JLabel(actividad.getTipoToString());
		tipo_actividad.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tipo_actividad.setBounds(273, 415, 107, 14);
		frmAccionsocialmed.getContentPane().add(tipo_actividad);
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//alumnoMainView.main(user);
				frmAccionsocialmed.dispose();
			}
		});
		
	/*	btnSolicitarEstaActividad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean ok = enviarSolicitud();
				if(ok) {
					JOptionPane.showMessageDialog(frmAccionsocialmed, "Su solicitud ha sido enviada");
				}else {
					JOptionPane.showMessageDialog(frmAccionsocialmed, "Ha habido un error al enviar su solicitud");
				}
				
				frmAccionsocialmed.dispose();
			}
		});*/
	}
}