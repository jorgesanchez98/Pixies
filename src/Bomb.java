import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ListIterator;
import image.Assets;

// Clase que define el comportamiento del jugador
public class Bomb extends Chracter{

	protected BufferedImage sprite;
	// Constructor que recibe los atributos de un GameObject
	public Bomb(double x, double y, int width, int height,  BufferedImage bi, Handler handler) {
		super(x, y, width, height, handler);
		this.sprite=bi;
		}
		
	// Método que nos ayuda a actualizar al jugador
	@Override
	public void tick() 
	{	
	}
	
	// Método que se encarga de detectar las colisiones
	
	@Override
	public void collision(double dirX, double dirY) 
	{
		// Se genera un iterador para revisar todos los objetos
		ListIterator <GameObject> iterator = handler.obj.listIterator();
		while (iterator.hasNext())
		{
			// Se crea un objeto auxiliar
			GameObject aux = iterator.next();
			
			// Si el auxiliar es una pared
			if (aux instanceof Player)
			{
				// Si hace contacto con la pared en el eje de las x al sumarle la velocidad
				if (placeMeeting(x+dirX, y+dirY, aux))
				{
					//his.setX(20000);
					System.out.println("Colision");
					//velY=0;
					return;

				}
				else {
					//Nada por ahora
				}
			}
		}
	}

	public void paint(Graphics g) 
	{		
		// Los personajes en éste caso son óvalos, así que los dibujamos
		g.drawImage(sprite, getX(), getY(), null);
	}
	
	
	public void keyReleased(int key) {
		
	}

	public void keyTyped(int key) {
		
	}

}
