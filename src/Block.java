import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

// Clase Pared (En caso de tener varias, ésta puede ser abstracta)
public class Block extends GameObject{
	protected BufferedImage sprite;
	// Constructor que recibe los atributos de un GameObject
	public Block (double x, double y, int width, int height,  BufferedImage bi, Handler handler)
	{
		super (x,y,width,height,handler);
		this.sprite=bi;
	}
	
	// La pared solo requiere ser pintada
	@Override
	public void paint(Graphics g)
	{
		//pintamos la imagen pasada como argumento al contructor
		g.drawImage(sprite, getX(), getY(), null);
	}
	
	// La pared no requiere actualizar nada (posición, color y tamaño se mantienen constantes)
	@Override
	public void tick() {}
	
	// Obtiene los bordes de la pared (nos ayuda con las colisiones)
	@Override
	public Rectangle getBounds()
	{
		return (new Rectangle(getX(), getY(), width, height));
	}
}
