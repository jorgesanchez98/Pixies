import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Lector del teclado
public class KeyInput implements KeyListener {
	Player1 player1;
	Player2 player2;
	
	//Constructor
	public KeyInput(Player1 player1, Player2 player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	//KeyListeners
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		player1.keyPressed(key);
		player2.keyPressed(key);
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		player1.keyReleased(key);
		player2.keyReleased(key);
	}
	public void keyTyped(KeyEvent e) {		
	}
}
