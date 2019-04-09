import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

// Clase que designa el comportamiento de los personajes del juego
public abstract class Chracter extends GameObject{
	
	// Es un juego de plataformas, por lo que tiene gravedad, velocidad en x y en y
	protected double dirX;
	protected double dirY;
	protected int angle=12, maxAng=16;
	// Constructor que pide los valores del Game object 
	public Chracter(int x, int y, int width, int height, Handler handler) {
		super(x, y, width, height, handler);
		// Se asigna la velocidad en x y y a que por defecto sea de 3
		dirX = 0;
		dirY= 1;
	}

	// Todo personaje tiene un comportamiento diferente, así que el tick sigue siendo abstracto
	public abstract void tick();
	
	// Todos los personajes en éste juego tienen colisión
	public abstract void collision(double dirX, double dirY);
	
	// Obtenemos los bordes del personaje
	@Override
	public Rectangle getBounds() 
	{
		return (new Rectangle(getX(), getY(), width, height));
	}
	
	public void clockWise() {
		//gira un "grado" en la dirección del relog
		angle= ((((angle+1)%maxAng)+maxAng)%maxAng);
	}
	
	public void counterClockWise() {
		//gira un "grado" en la dirección contraria del relog
		angle= ((((angle-1)%maxAng)+maxAng)%maxAng);
	}
	// Place meeting nos ayuda a revisar si el personaje colisiona con otro objeto

	
	// A partir de aquí son los setters y getters

	public int getAngle() {
		return angle;
	}

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
}
