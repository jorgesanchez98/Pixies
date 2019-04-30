import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ListIterator;

public class RocketBllt extends GameObject{
	protected BufferedImage sprite;
	private int angle;
	private float dirX, dirY;
	private AnimationSprite bat;
	
	// Constructor que recibe los atributos de un GameObject
	public RocketBllt(int x, int y, int width, int height,  BufferedImage bi, int dirX, int dirY, Handler handler, int angle)
	{
		super (x,y,width,height,handler);
		//this.sprite=bi;
		this.dirX=dirX;
		this.dirY=dirY;
		SpriteBuilder builder = new SpriteBuilder ("./Textures/16cohete.png", 20, 20);
		for (int i=0; i<16 ; i++) {//add all frames
			builder.addImage(i, 0);
		}
		bat=new AnimationSprite(x, y, builder.build());
		bat.setAnimSpd(5);
		this.angle = angle;
		
		
	}
	
	@Override
	public void paint(Graphics g)
	{
		//pintamos la imagen pasada como argumento al contructor
		bat.render(g, x, y, angle);
	}
	
	@Override
	public void tick() {
		x+=dirX;
		y-=dirY;
		collision();
		//Checar la direccion de la bala
		//System.out.println("Dir x = "+dirX+"   Dir Y = "+dirY);
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
					aux.setAlive(false);
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