import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Target extends GameObject {
	
	//Variables
	protected BufferedImage sprite;
	
	//Constructor
	public Target(int x, int y, int width, int height, BufferedImage BI, Handler handler) {
		super(x,y,width,height,handler);
		this.sprite = BI;
	}
	
	//Paint
	public void paint(Graphics g) {
		g.drawImage(sprite,getX(),getY(),null);
	}
	
	//Actualizador
	public void tick() {
	}
	
	//Rectangle
	public Rectangle getBounds() {
		return (new Rectangle(getX(),getY(),width,height));
	}
}
