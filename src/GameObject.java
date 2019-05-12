import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

//Comportamiento de objetos
public abstract class GameObject {
	
	//Variables
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected Handler handler;
	public boolean alive;
	
	// Constructor
	public GameObject(int x, int y, int width, int height, Handler handler) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.handler = handler;
		alive=true;
	}
	
	//Metodos abstractos
	public abstract void paint(Graphics g);
	public abstract void tick();
	public abstract Rectangle getBounds();
	
	//Colision entre rectangulos
	public boolean placeMeeting (double x, double y, GameObject obj) {
		if ((new Rectangle((int)x, (int)y, width, height)).intersects(obj.getBounds())) {
			return true;
		}
		return false;
	}
	
	//Setters-Getters
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return (int)x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return (int)y;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getWidth() {
		return width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getHeight() {
		return height;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public boolean getAlive() {
		return alive;
	}
}
