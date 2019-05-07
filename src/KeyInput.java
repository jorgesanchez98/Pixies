import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Clase encargada de leer la entrada de teclado del usuario
public class KeyInput implements KeyListener{
	// Se crea a qui�n va a ser el escuchador de las teclas
	Player player;
	P2 p2;
	// Se hace el constructor, pas�ndole al escuchador
	public KeyInput(Player player, P2 p2) 
	{
		this.player = player;
		this.p2 = p2;
	}
	// Si una tecla es presionada
	@Override
	public void keyPressed(KeyEvent e) {
		// Se obtiene el c�digo entero de la tecla
		int key = e.getKeyCode();
		// Se le pasa el c�digo al m�todo de tecla presionada del escuchador
		player.keyPressed(key);
		p2.keyPressed(key);
	}
	// Si una tecla es liberada
	@Override
	public void keyReleased(KeyEvent e) {
		// Se obtiene el c�digo entero de la tecla
		int key = e.getKeyCode();
		// Se le pasa el c�digo al m�todo de tecla liberada del escuchador
		player.keyReleased(key);
		p2.keyReleased(key);
	}

	@Override
	public void keyTyped(KeyEvent e) {		
	}

}
