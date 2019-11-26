package main;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import home.homeView;
import main.MySQLBD;

public class Main {

	public static void main(String[] args) throws Exception{
		MySQLBD dao = new MySQLBD();
		dao.readDataBase();
		final JFrame window = new JFrame("Home Page");
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				homeView.main(args);
			}
		});
	}

}
