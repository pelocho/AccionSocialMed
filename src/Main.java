import home.homeView;
import javax.swing.*;

public class Main {

	public static void main(String[] args) throws Exception{
		MySQLAccess dao = new MySQLAccess();
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
