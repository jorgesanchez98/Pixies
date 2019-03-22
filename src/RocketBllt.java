import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import image.Assets;

public class RocketBllt extends GameObject{
	protected BufferedImage sprite;
	private int dir;
	
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
			break;
		case 2:
			x-=3;
			this.sprite=Assets.rocketBLeft;
			break;
		case 3:
			y+=3;
			this.sprite=Assets.rocketBDown;
			break;
		case 4:
			x+=3;
			this.sprite=Assets.rocketB;
			break;
		}
		
	}
	
	
	// Obtiene los bordes de la bala (nos ayuda con las colisiones)
	@Override
	public Rectangle getBounds()
	{
		return (new Rectangle(getX(), getY(), width, height));
	}
}
