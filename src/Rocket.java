import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ListIterator;

public class Rocket extends Character {

	//Variables
	protected BufferedImage sprite;
	
	//Constructor
	public Rocket(int x, int y, int width, int height, BufferedImage bi, Handler handler) {
		super(x, y, width, height, handler);
		this.sprite=bi;
		}
		
	public void tick() {	
	}
	
	//Deteccion de colision
	public boolean collision(double dirX, double dirY) {
		ListIterator <GameObject> itr = handler.obj.listIterator();
		while (itr.hasNext()){
			GameObject GO = itr.next();
			if (GO instanceof Player1) {
				if (placeMeeting(x+dirX, y+dirY, GO)) {
					return true;
				}
			}
		}
		return false;	
	}

	public void paint(Graphics g) {
		g.drawImage(sprite, getX(), getY(), null);
	}
}
