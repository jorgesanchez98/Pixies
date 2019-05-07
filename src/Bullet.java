import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ListIterator;

import image.Assets;

public class Bullet extends GameObject{
	protected BufferedImage sprite;
	private int dirX, dirY,index;
	Player player = new Player(80, 200, 32, 32, Assets.tankU, handler);
	P2 player2 = new P2(150, 200, 32, 32, Assets.tankU, handler);
	
	// Constructor que recibe los atributos de un GameObject
	public Bullet (int x, int y, int width, int height,  BufferedImage bi, int dirX, int dirY, Handler handler,int index)
	{
		super (x,y,width,height,handler);
		this.sprite=bi;
		this.dirX=dirX;
		this.dirY=dirY;
		this.index = index;
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
			if (aux instanceof P2)
			{
				if (placeMeeting(x, y, aux) && index!=2)
				// Si hace contacto con la pared en el eje de las x al sumarle la velocidad
				{
					setAlive(false);
					if(player2.getVidas()>0) {
						player2.perderVida();
					} else if(player2.getVidas()==0) {
						aux.setAlive(false);
					}
				}
			}
			if (aux instanceof Player)
			{
				// Si hace contacto con la pared en el eje de las x al sumarle la velocidad
				if (placeMeeting(x, y, aux) && index!=1)
				{
					setAlive(false);
					if(player.getVidas()>0) {
						player.perderVida();
					} else if(player.getVidas()==0) {
						aux.setAlive(false);
					}
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
