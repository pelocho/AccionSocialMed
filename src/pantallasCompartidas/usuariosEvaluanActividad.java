package pantallasCompartidas;

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
import modelos.Usuario;
import pas.pasMainView;
import pdi.pdiMainView;
import alumno.alumnoMainView;
import alumno.funcionesCompartidas;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.AbstractListModel;
import javax.swing.JSeparator;
import javax.swing.JSlider;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.Font;
import java.awt.Color;
import java.awt.TextField;

public class usuariosEvaluanActividad {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 */
	public static void main(String user, int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usuariosEvaluanActividad window = new usuariosEvaluanActividad(user,id);
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
	public usuariosEvaluanActividad(String user,int id) throws Exception {
		initialize(user,id);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize(String user, int id) throws Exception {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(usuariosEvaluanActividad.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 406, 573);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		Actividad act = new Actividad(id);
		
		JLabel titulo = new JLabel(act.getTitulo());
		titulo.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		titulo.setBounds(61, 9, 200, 23);
		frmAccionsocialmed.getContentPane().add(titulo);
		
		JLabel lblTipo = new JLabel("Tipo(s):");
		lblTipo.setBounds(10, 113, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblTipo);
		
		JButton btnVolver = new JButton("<");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(10, 11, 41, 23);
		frmAccionsocialmed.getContentPane().add(btnVolver);
		
		JSlider slider = new JSlider();
		slider.setValue(0);
		slider.setMaximum(5);
		slider.setBounds(10, 383, 200, 19);
		frmAccionsocialmed.getContentPane().add(slider);
		
		JLabel label_2 = new JLabel("0");
		label_2.setBounds(10, 369, 26, 14);
		frmAccionsocialmed.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("1");
		label_3.setBounds(46, 369, 18, 14);
		frmAccionsocialmed.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("2");
		label_4.setBounds(84, 369, 26, 14);
		frmAccionsocialmed.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("3");
		label_5.setBounds(120, 369, 20, 14);
		frmAccionsocialmed.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("4");
		label_6.setBounds(161, 369, 18, 14);
		frmAccionsocialmed.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("5");
		label_7.setBounds(200, 369, 26, 14);
		frmAccionsocialmed.getContentPane().add(label_7);
		
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
		
		TextArea textArea = new TextArea();
		textArea.setText(act.getDescripcion());
		textArea.setEditable(false);
		textArea.setBounds(10, 240, 370, 81);
		frmAccionsocialmed.getContentPane().add(textArea);
		
		JLabel lblDescripcinDeLa = new JLabel("Descripci\u00F3n de la actividad:");
		lblDescripcinDeLa.setBounds(10, 213, 226, 20);
		frmAccionsocialmed.getContentPane().add(lblDescripcinDeLa);
		
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
		tipo_actividad.setBounds(10, 327, 107, 14);
		frmAccionsocialmed.getContentPane().add(tipo_actividad);
		
		JLabel lblPlazasDisponibles = new JLabel("Plazas disponibles:");
		lblPlazasDisponibles.setBounds(10, 92, 113, 14);
		frmAccionsocialmed.getContentPane().add(lblPlazasDisponibles);
		
		JLabel lblModificarplazas = new JLabel(act.getPlazasDisponibles()+"");
		lblModificarplazas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblModificarplazas.setBounds(122, 92, 62, 14);
		frmAccionsocialmed.getContentPane().add(lblModificarplazas);
		
		JLabel lblValoraEstaActividad = new JLabel("Valora esta actividad:");
		lblValoraEstaActividad.setBounds(10, 352, 164, 14);
		frmAccionsocialmed.getContentPane().add(lblValoraEstaActividad);
		
		JLabel lblComentaQueTe = new JLabel("Comenta que te ha parecido:");
		lblComentaQueTe.setBounds(10, 405, 200, 14);
		frmAccionsocialmed.getContentPane().add(lblComentaQueTe);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(10, 422, 370, 74);
		frmAccionsocialmed.getContentPane().add(textArea_1);
		
		JButton btnEvaluacin = new JButton("Enviar valoraci\u00F3n");
		btnEvaluacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int valoracion = slider.getValue();
				
				MySQLBD bd = new MySQLBD();
				try {
					bd.readDataBase();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				bd.update("UPDATE `eef_primera_iteracion`.`participacion` SET `valoracionAlumno` = '" + valoracion + 
						"' WHERE (`correoUsuario` = '" + user + "') and (`idActividad` = '" + id + " '); " );
				frmAccionsocialmed.dispose();
				
			}
		});
		btnEvaluacin.setBackground(Color.LIGHT_GRAY);
		btnEvaluacin.setBounds(10, 502, 127, 23);
		frmAccionsocialmed.getContentPane().add(btnEvaluacin);
		
		JLabel lblFinalizada = new JLabel("FINALIZADA");
		lblFinalizada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFinalizada.setForeground(new Color(204, 0, 0));
		lblFinalizada.setBounds(271, 5, 109, 31);
		frmAccionsocialmed.getContentPane().add(lblFinalizada);
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Usuario u = new Usuario(user);
				frmAccionsocialmed.dispose();
				if(u.getCategoryId() == 2) {
					pdiMainView.main(user);
				}else if(u.getCategoryId() == 1) {
					alumnoMainView.main(user);
				}else {
					pasMainView.main(user);
				}
			}
		});
	}
}