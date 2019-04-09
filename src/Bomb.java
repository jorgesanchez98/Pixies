import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ListIterator;
import image.Assets;

// Clase que define el comportamiento del jugador
public class Bomb extends Chracter{
	protected int dirX, dirY, index;
	private AnimationSprite rocket;
	// Constructor que recibe los atributos de un GameObject
	protected BufferedImage sprite;
	// Constructor que recibe los atributos de un GameObject
	public Bomb(int x, int y, int width, int height, int dirX, int dirY, BufferedImage bi, Handler handler) {
		super(x, y, width, height, handler);
		this.sprite=bi;
		}
		
	// Método que nos ayuda a actualizar al jugador
	@Override
	public void tick() {
		x+=dirX;
		y-=dirY;
		collision(dirX, dirY);
	}
	
	// Método que se encarga de detectar las colisiones
	
	@Override
	public boolean collision(double dirX, double dirY) 
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
					//velY=0;x|
					return true;

				}
				else {
					//Nada por ahora
				}
			}
		}
		return false;
	}

	public void paint(Graphics g) 
	{		
		rocket.render(g, x, y, index);
	}
	
	
	public void keyReleased(int key) {
		
	}

	public void keyTyped(int key) {
		
	}

}