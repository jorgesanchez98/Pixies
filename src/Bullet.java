import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ListIterator;

public class Bullet extends GameObject{
	protected BufferedImage sprite;
	private int dirX, dirY;
	
	// Constructor que recibe los atributos de un GameObject
	public Bullet (int x, int y, int width, int height,  BufferedImage bi, int dirX, int dirY, Handler handler)
	{
		super (x,y,width,height,handler);
		this.sprite=bi;
		this.dirX=dirX;
		this.dirY=dirY;
	}
	
	@Override
	public void paint(Graphics g)
	{
		//pintamos la imagen pasada como argumento al contructor
		g.drawImage(sprite, getX(), getY(), null);
	}
	
	@Override
	public void tick() {
		x+=dirX;
		y-=dirY;
		collision();
	}
	
	public void collision() {
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
					handler.removeObj(this);

				}
			}
			
			if (aux instanceof Player)
			{
				// Si hace contacto con la pared en el eje de las x al sumarle la velocidad
				if (placeMeeting(x+dirX, y+dirY, aux))
				{
					Player tempPlayer;
					tempPlayer = (Player) aux;
					handler.removeObj(aux);
					handler.removeObj(this);

				}
			}
			
			
		}
	}
	
	public boolean placeMeeting (double x, double y, GameObject obj)
	{
		// revisa si el rect�ngulo del otro objeto intersecta con el rect�ngulo del personaje
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
