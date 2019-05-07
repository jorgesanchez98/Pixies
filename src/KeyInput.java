import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Lector del teclado
public class KeyInput implements KeyListener{
	Player player;
	P2 p2;
	
	//Constructor
	public KeyInput(Player player, P2 p2) {
		this.player = player;
		this.p2 = p2;
	}
	
	//KeyListeners
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		player.keyPressed(key);
		p2.keyPressed(key);
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		player.keyReleased(key);
		p2.keyReleased(key);
	}
	public void keyTyped(KeyEvent e) {		
	}
}
