package gestor;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import modelos.Noticia;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gestor.gestorMainView;
import pdi.editarPerfilPdi;
import pdi.pdiMainView;

import javax.swing.JButton;
import java.awt.Color;

public class noticiasView {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					noticiasView window = new noticiasView(user);
					window.frame.setVisible(true);
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
	public noticiasView(String user) throws Exception {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize(String user) throws Exception {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(editarPerfilPdi.class.getResource("/imagenes/icono pequeno.png")));
		frame.setTitle("AccionSocialMed");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 414, 206);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Titulo", "Cuerpo"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setResizable(false);
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		List<Noticia> listaNoticias = Noticia.listaNoticias();
		
		for(Noticia n : listaNoticias) {
			Object[] noticia = {n.getTitulo(), n.getCuerpo()};
			modelo.addRow(noticia);
		}
		
		scrollPane.setViewportView(table);
		
		JButton buttonVolver = new JButton("<");
		buttonVolver.setBackground(Color.LIGHT_GRAY);
		buttonVolver.setBounds(10, 10, 41, 23);
		frame.getContentPane().add(buttonVolver);
		
		JButton btnNuevaNoticia = new JButton("Nueva Noticia");
		btnNuevaNoticia.setBackground(Color.LIGHT_GRAY);
		btnNuevaNoticia.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNuevaNoticia.setBounds(204, 10, 105, 23);
		frame.getContentPane().add(btnNuevaNoticia);
		
		JButton btnBorrarNoticia = new JButton("Borrar Noticia");
		btnBorrarNoticia.setBackground(Color.LIGHT_GRAY);
		btnBorrarNoticia.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnBorrarNoticia.setBounds(319, 10, 105, 23);
		frame.getContentPane().add(btnBorrarNoticia);
		
		buttonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		btnNuevaNoticia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearNoticiaView.main(user);
			}
		});
	}
}
