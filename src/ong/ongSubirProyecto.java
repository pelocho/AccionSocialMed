package ong;

import ong.ongMainView;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JRadioButton;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class ongSubirProyecto {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ongSubirProyecto window = new ongSubirProyecto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ongSubirProyecto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 512, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JLabel lblAccionsocialmed = new JLabel("AccionSocialMed");
		menuBar.add(lblAccionsocialmed);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSubirUnNuevo = new JLabel("Subir un nuevo proyecto");
		lblSubirUnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSubirUnNuevo.setBounds(10, 11, 170, 22);
		frame.getContentPane().add(lblSubirUnNuevo);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 44, 42, 14);
		frame.getContentPane().add(lblTipo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Voluntariado", "Aprendizaje-Servicio"}));
		comboBox.setBounds(56, 40, 159, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setBounds(10, 81, 42, 14);
		frame.getContentPane().add(lblTtulo);
		
		textField = new JTextField();
		textField.setBounds(56, 78, 414, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblHoras = new JLabel("Horas:");
		lblHoras.setBounds(10, 122, 42, 14);
		frame.getContentPane().add(lblHoras);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(56, 119, 40, 20);
		frame.getContentPane().add(spinner);
		
		JLabel lblDescripcinDelProyecto = new JLabel("Descripci\u00F3n del proyecto:");
		lblDescripcinDelProyecto.setBounds(10, 155, 194, 22);
		frame.getContentPane().add(lblDescripcinDelProyecto);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 180, 460, 159);
		frame.getContentPane().add(textPane);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 358, 75, 23);
		frame.getContentPane().add(btnVolver);
		
		JButton btnSubir = new JButton("Subir");
		btnSubir.setBounds(205, 358, 89, 23);
		frame.getContentPane().add(btnSubir);
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ongMainView.main(null);
				frame.dispose();
			}
		});
		
		btnSubir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog d = new JDialog(frame, "Proyecto creado y pendiente de revision", true);
				d.setSize(350, 0);
				d.setLocationRelativeTo(frame);
				d.setVisible(true);
				ongMainView.main(null);
				frame.dispose();
			}
		});
	}
}
