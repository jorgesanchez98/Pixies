import java.awt.BorderLayout;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;

// Clase encargada de ejecutar el juego
public class Launcher {

	public static void main(String[] args) {
		MenuPanel menu = new MenuPanel();
		JFrame app = new JFrame("Menu");
		app.setSize(720,480);
		app.getContentPane().add(menu, BorderLayout.CENTER);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		app.pack();
		app.setResizable(false);
		app.setVisible(true);
		app.setLocationRelativeTo(null);
		ExecutorService pool = Executors.newFixedThreadPool(10);
		pool.execute(menu);
		menu.addNotify();
		pool.shutdown();
	}
}
