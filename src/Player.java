import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ListIterator;
import image.Assets;

// Clase que define el comportamiento del jugador
public class Player extends Chracter{
	private int pack5=0;
	private Bomb tempBomb;
	private int dir=1;
	protected BufferedImage sprite;
	// Constructor que recibe los atributos de un GameObject
	public Player(double x, double y, int width, int height,  BufferedImage bi, Handler handler) {
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
			if (aux instanceof Block)
			{
				// Si hace contacto con la pared en el eje de las x al sumarle la velocidad
				if (placeMeeting(x+dirX, y+dirY, aux))
				{
					velX=0;
					velY=0;
					return;

				}
				else {
					velX=3;
					velY=3;
				}
			}
			
			if (aux instanceof Rocket)
			{
				// Si hace contacto con el cohete disminuimos la velocidad un instante, y quitamos el PowerUp
				if (placeMeeting(x+dirX, y+dirY, aux))
				{
					velX=1;
					velY=1;
					handler.removeObj(aux);
					//Se asignan 5 balas
					pack5 = 5;
					return;

				}
				else {
					velX=3;
					velY=3;
				}
			}
			
			if (aux instanceof Bomb)
			{
				// Si hace contacto con la Bomba disminuimos la velocidad un instante, y quitamos el PowerUp
				if (placeMeeting(x+dirX, y+dirY, aux))
				{
					velX=1;
					velY=1;
					tempBomb = (Bomb) aux;
					handler.removeObj(aux);
					//Se asignan 5 balas
					return;

				}
				else {
					velX=3;
					velY=3;
				}
			}
		}
	}

	public void paint(Graphics g) 
	{		
		// Los personajes en éste caso son óvalos, así que los dibujamos
		g.drawImage(sprite, getX(), getY(), null);
	}
	
	// Método que lee las teclas que han sido presionadas
	public void keyPressed(int key) {
		// Si es escape, cierra el juego
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);
		// Si es la flecha izquierda, vuelve la velocidad en x -3
		if (key == KeyEvent.VK_LEFT) { 
			collision(-3, 0);
			x += -velX;
			sprite=Assets.tankL;
			dir=2;
			}
		// Si es la flecha derecha, vuelve la velocidad en x +3
		if (key == KeyEvent.VK_RIGHT) { 
			collision(3, 0);
			x += velX;
			sprite=Assets.tankR;
			dir=4;
		}
		// Si es la flecha arriba, vuelve la velocidad en y -3
		if (key == KeyEvent.VK_UP) { 
			collision(0, -3);
			y += -velY;
			sprite=Assets.tankU;
			dir=1;
		}
		// Si es la flecha abajo, vuelve la velocidad en y +3
		if (key == KeyEvent.VK_DOWN) { 
			collision(0, 3);
			y += velY;
			sprite=Assets.tankD;
			dir=3;
		}
		
		if (key == KeyEvent.VK_SPACE) {
			if(pack5>=1) {
				handler.addObj(new RocketBllt(this.getX()+12, this.getY()+12, 8, 8, Assets.rocketB, dir, handler));
				pack5 -= 1;
				return;
			}
			handler.addObj(new Bullet(this.getX()+15, this.getY()+16, 8, 8, Assets.bullet, dir, handler));
		}
		if (key == KeyEvent.VK_B) {
			tempBomb.setX(this.getX()+32);
			tempBomb.setY(this.getY());
			handler.addObj(tempBomb);
			//new Bullet(this.getX()+15, this.getY()+16, 8, 8, Assets.bullet, dir, handler)
		}
	}

	public void keyReleased(int key) {
		
	}

	public void keyTyped(int key) {
		
	}

}
