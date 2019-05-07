import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ListIterator;
import image.Assets;

public class Rocket extends Chracter{

	protected BufferedImage sprite;
	
	// Constructor
	public Rocket(int x, int y, int width, int height,  BufferedImage bi, Handler handler) {
		super(x, y, width, height, handler);
		this.sprite=bi;
		}
		
	public void tick() {	
	}
	
	//Detección de colisión
	public boolean collision(double dirX, double dirY) {
		ListIterator <GameObject> iterator = handler.obj.listIterator();
		while (iterator.hasNext()){
			GameObject aux = iterator.next();
			if (aux instanceof Player) {
				if (placeMeeting(x+dirX, y+dirY, aux)) {
					//his.setX(20000);
					System.out.println("Colision");
					//velY=0;
					return true;
				}
				else {

				}
			}
		}
		return false;	
	}

	public void paint(Graphics g) {
		g.drawImage(sprite, getX(), getY(), null);
	}
	
	public void keyReleased(int key) {	
	}
	public void keyTyped(int key) {	
	}
}
