import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ListIterator;

import image.Assets;

public class RocketBllt extends GameObject{
	protected BufferedImage sprite;
	private int dir;
	private Block tempBlock;
	private Player tempPlayer;
	
	// Constructor que recibe los atributos de un GameObject
	public RocketBllt (double x, double y, int width, int height,  BufferedImage bi, int dir, Handler handler)
	{
		super (x,y,width,height,handler);
		this.sprite=bi;
		this.dir=dir;
	}
	
	@Override
	public void paint(Graphics g)
	{
		//pintamos la imagen pasada como argumento al contructor
		g.drawImage(sprite, getX(), getY(), null);
	}
	
	@Override
	public void tick() {
		switch(dir) {
		case 1:
			y-=3;
			this.sprite=Assets.rocketBUp;
			collision(-3, 0);
			break;
		case 2:
			x-=3;
			collision(3, 0);
			this.sprite=Assets.rocketBLeft;
			break;
		case 3:
			y+=3;
			collision(0, -3);
			this.sprite=Assets.rocketBDown;
			break;
		case 4:
			x+=3;
			collision(0, 3);
			this.sprite=Assets.rocketB;
			break;
		}
		
	}
	
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
					tempBlock = (Block) aux;
					handler.removeObj(aux);
					handler.removeObj(this);

				}
			}
			
			if (aux instanceof Player)
			{
				// Si hace contacto con la pared en el eje de las x al sumarle la velocidad
				if (placeMeeting(x+dirX, y+dirY, aux))
				{
					tempPlayer = (Player) aux;
					handler.removeObj(aux);
					handler.removeObj(this);

				}
			}
			
			
		}
	}
	
	public boolean placeMeeting (double x, double y, GameObject obj)
	{
		// revisa si el rectángulo del otro objeto intersecta con el rectángulo del personaje
		if ((new Rectangle((int)x, (int)y, width, height)).intersects(obj.getBounds())) 
			return true;
		return false;
	}
	
	
	
	
	// Obtiene los bordes de la bala (nos ayuda con las colisiones)
	@Override
	public Rectangle getBounds()
	{
		return (new Rectangle(getX(), getY(), width, height));
	}
}
