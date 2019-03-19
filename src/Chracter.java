import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

// Clase que designa el comportamiento de los personajes del juego
public abstract class Chracter extends GameObject{
	
	// Es un juego de plataformas, por lo que tiene gravedad, velocidad en x y en y
	protected double gravity = 0.2, velX;
	protected double velY;
	// Constructor que pide los valores del Game object 
	public Chracter(int x, int y, int width, int height, Handler handler) {
		super(x, y, width, height, handler);
		// Se asigna la velocidad en x y y a que por defecto sea de 3
		velX = 3;
		velY=3;
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
	
	// Place meeting nos ayuda a revisar si el personaje colisiona con otro objeto

	
	
	// A partir de aquí son los setters y getters
	public double getVelX()
	{
		return velX;
	}
	public double getVelY()
	{
		return velY;
	}
	public double getGravity()
	{
		return gravity;
	}
	public void setVelX(double velX)
	{
		this.velX = velX;
	}
	public void setVelY(double velY)
	{
		this.velY = velY;
	}
	public void setGravity(double gravity)
	{
		this.gravity = gravity;
	}
}
