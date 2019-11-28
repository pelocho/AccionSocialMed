package ong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class ongMisActividades {

	private JFrame frmAccionsocialmed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ongMisActividades window = new ongMisActividades();
					window.frmAccionsocialmed.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ongMisActividades() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccionsocialmed = new JFrame();
		frmAccionsocialmed.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 9));
		frmAccionsocialmed.setIconImage(Toolkit.getDefaultToolkit().getImage(ongMisActividades.class.getResource("/imagenes/icono pequeno.png")));
		frmAccionsocialmed.setTitle("AccionSocialMed");
		frmAccionsocialmed.setBounds(100, 100, 632, 317);
		frmAccionsocialmed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccionsocialmed.getContentPane().setLayout(null);
		
		JLabel lblActividades = new JLabel("Mis actividades");
		lblActividades.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblActividades.setBounds(10, 11, 75, 14);
		frmAccionsocialmed.getContentPane().add(lblActividades);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(10, 36, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblTitulo);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(137, 36, 37, 14);
		frmAccionsocialmed.getContentPane().add(lblLugar);
		
		JLabel lblHoras = new JLabel("Horas");
		lblHoras.setBounds(209, 36, 37, 14);
		frmAccionsocialmed.getContentPane().add(lblHoras);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(278, 36, 105, 14);
		frmAccionsocialmed.getContentPane().add(lblDescripcin);
		
		JLabel lblT = new JLabel("t1");
		lblT.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblT.setBounds(10, 61, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblT);
		
		JLabel lblL = new JLabel("l1");
		lblL.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblL.setBounds(137, 61, 30, 14);
		frmAccionsocialmed.getContentPane().add(lblL);
		
		JLabel lblH = new JLabel("h1");
		lblH.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblH.setBounds(209, 61, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblH);
		
		JLabel lblD = new JLabel("d1");
		lblD.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblD.setBounds(278, 61, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblD);
		
		JLabel lblT_1 = new JLabel("t2");
		lblT_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblT_1.setBounds(10, 80, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblT_1);
		
		JLabel lblL_1 = new JLabel("l2");
		lblL_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblL_1.setBounds(137, 80, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblL_1);
		
		JLabel lblH_1 = new JLabel("h2");
		lblH_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblH_1.setBounds(209, 80, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblH_1);
		
		JLabel lblD_1 = new JLabel("d2");
		lblD_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblD_1.setBounds(278, 80, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblD_1);
		
		JLabel lblT_2 = new JLabel("t3");
		lblT_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblT_2.setBounds(10, 105, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblT_2);
		
		JLabel lblL_2 = new JLabel("l3");
		lblL_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblL_2.setBounds(137, 105, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblL_2);
		
		JLabel lblH_2 = new JLabel("h3");
		lblH_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblH_2.setBounds(209, 105, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblH_2);
		
		JLabel lblD_2 = new JLabel("d3");
		lblD_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblD_2.setBounds(278, 105, 49, 14);
		frmAccionsocialmed.getContentPane().add(lblD_2);
	}
}
