package ong;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JLabel;

import com.jgoodies.forms.layout.Size;

import java.awt.Font;

public class ongMisActividades extends ongListaActividades{

	private JFrame frmAccionsocialmed;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ongMisActividades window = new ongMisActividades(user);
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
	public ongMisActividades(String user) throws Exception {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize(String user) throws Exception {
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
		lblHoras.setBounds(260, 36, 37, 14);
		frmAccionsocialmed.getContentPane().add(lblHoras);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(330, 36, 105, 14);
		frmAccionsocialmed.getContentPane().add(lblDescripcin);
		
		int numerofilaAcaba=0;
		
		for (int i = 0; i<listaActividades(user).size(); i++) {
			JLabel lblT = new JLabel(name(user,i));
			lblT.setFont(new Font("Tahoma", Font.PLAIN, 9));
			lblT.setBounds(10, 61+i*40, 110, 14);
			frmAccionsocialmed.getContentPane().add(lblT);
			
			
			JLabel lblL = new JLabel(lugar(user,i));
			lblL.setFont(new Font("Tahoma", Font.PLAIN, 9));
			lblL.setBounds(137, 61+i*40, 110, 14);
			frmAccionsocialmed.getContentPane().add(lblL);
			//lblT.setText(lugar(user,i));
			
			JLabel lblH = new JLabel(Integer.toString(horas(user,i)));
			lblH.setFont(new Font("Tahoma", Font.PLAIN, 9));
			lblH.setBounds(260, 61+i*40, 50, 14);
			frmAccionsocialmed.getContentPane().add(lblH);
			//lblT.setText(Integer.toString(horas(user,i)));
			
			JLabel lblD = new JLabel(desc(user,i));
			lblD.setFont(new Font("Tahoma", Font.PLAIN, 9));
			lblD.setBounds(330, 61+i*40, 300, 14);
			frmAccionsocialmed.getContentPane().add(lblD);
			//lblT.setText(desc(user,i));
			
			numerofilaAcaba=i*40;
		}
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, numerofilaAcaba+100, 75, 23);
		frmAccionsocialmed.getContentPane().add(btnVolver);
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmAccionsocialmed.dispose();
			}
		});
	}
}
