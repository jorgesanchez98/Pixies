import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		//Constructor
		Menu menu = new Menu();
		
		//Set Main Menu attributes
		menu.setTitle("Tank");
		menu.setSize(600,700);
		menu.setVisible(true);
		menu.setLocationRelativeTo(null);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
