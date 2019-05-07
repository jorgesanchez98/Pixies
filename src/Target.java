import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Target extends GameObject{
	
	protected BufferedImage sprite;
	
	//Constructor
	public Target (int x, int y, int width, int height,  BufferedImage bi, Handler handler) {
		super (x,y,width,height,handler);
		this.sprite=bi;
	}
	
	//Paint
	public void paint(Graphics g) {
		g.drawImage(sprite, getX(), getY(), null);
	}
	public void tick() {}
	
	//Bordes del rectángulo
	public Rectangle getBounds() {
		return (new Rectangle(getX(), getY(), width, height));
	}
}
