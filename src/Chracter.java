import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

// Comportamiento de personajes
public abstract class Chracter extends GameObject{
	
	//Variables
	protected double dirX;
	protected double dirY;
	protected int angle=12, maxAng=16;
	
	// Constructor
	public Chracter(int x, int y, int width, int height, Handler handler) {
		super(x, y, width, height, handler);
		dirX = 0;
		dirY= 1;
	}

	public abstract void tick();
	public abstract boolean collision(double dirX, double dirY);
	
	public Rectangle getBounds() {
		return (new Rectangle(getX(), getY(), width, height));
	}
	
	public void clockWise() {
		angle= ((((angle+1)%maxAng)+maxAng)%maxAng);
	}
	public void counterClockWise() {
		angle= ((((angle-1)%maxAng)+maxAng)%maxAng);
	}
	// Place meeting revisa la colisión entre personaje-objeto

	//Setters-Getters
	public double getDirX() {
		return Math.cos(angle*22.5);
	}
	public void setDirX(double dirX) {
		this.dirX = dirX;
	}
	public double getDirY() {
		return Math.sin(angle*22.5);
	}
	public void setDirY(double dirY) {
		this.dirY = dirY;
	}
	public int getMaxAng() {
		return maxAng;
	}
	public void setMaxAng(int maxAng) {
		this.maxAng = maxAng;
	}
	public void setAngle(int angle) {
		this.angle = angle;
	}
	public int getAngle() {
		return angle;
	}
}
