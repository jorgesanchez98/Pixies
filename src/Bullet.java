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
			if (aux instanceof Block) {
				if (placeMeeting(x, y, aux)) {
					setAlive(false);
					
				}
			}
			if (aux instanceof Target) {
				if (placeMeeting(x, y, aux)) {
					setAlive(false);
					aux.setAlive(false);
					handler.setWin(true);
				}
			}
		}
	}

	// Obtiene los bordes de la bala (nos ayuda con las colisiones)
	@Override
	public Rectangle getBounds()
	{
		return (new Rectangle(getX(), getY(), width, height));
	}
}
