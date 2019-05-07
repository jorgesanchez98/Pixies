import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ListIterator;

import image.Assets;

public class RocketBllt extends GameObject{
	protected BufferedImage sprite;
	private int angle,index;
	private float dirX, dirY;
	private AnimationSprite bat;
	Player player = new Player(80, 200, 32, 32, Assets.tankU, handler);
	P2 player2 = new P2(150, 200, 32, 32, Assets.tankU, handler);
	Menu menu = new Menu(720,480);
	
	// Constructor 
	public RocketBllt(int x, int y, int width, int height,  BufferedImage bi, int dirX, int dirY, Handler handler, int angle, int index) {
		super (x,y,width,height,handler);
		//this.sprite=bi;
		this.dirX=dirX;
		this.dirY=dirY;
		this.index=index;
		SpriteBuilder builder = new SpriteBuilder ("./Textures/16cohete.png", 20, 20);
		for (int i=0; i<16 ; i++) {
			builder.addImage(i, 0);
		}
		bat=new AnimationSprite(x, y, builder.build());
		bat.setAnimSpd(5);
		this.angle = angle;
	}
	
	public void paint(Graphics g) {
		bat.render(g, x, y, angle);
	}
	
	public void tick() {
		x+=dirX;
		y-=dirY;
		collision();
		//Checar la direccion de la bala
		//System.out.println("Dir x = "+dirX+"   Dir Y = "+dirY);
	}
	
	public void collision() {
		ListIterator <GameObject> iterator = handler.obj.listIterator();
		while (iterator.hasNext()) {
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
			if (aux instanceof P2)
			{
				if (placeMeeting(x, y, aux) && index!=2)
				// Si hace contacto con la pared en el eje de las x al sumarle la velocidad
				{
					if(menu.getModo()==1) {
						player2.perderVidaCohete();
						if(player2.getVidas()<=0) {
							aux.setAlive(false);
						} 
					} else if(menu.getModo()==2) {
						player.ganarPuntoCohete();
					}
				}
			}
			if (aux instanceof Player)
			{
				// Si hace contacto con la pared en el eje de las x al sumarle la velocidad
				if (placeMeeting(x, y, aux) && index!=1)
				{
					if(menu.getModo()==1) {
						player.perderVidaCohete();
						handler.removeObj(this);
						if(player.getVidas()<=0) {
							aux.setAlive(false);
						} 
					} else if(menu.getModo()==2) {
						player2.ganarPuntoCohete();
						handler.removeObj(this);
					}
				}
			}
		}
	}

	//Bordes del cohete
	public Rectangle getBounds() {
		return (new Rectangle(getX(), getY(), width, height));
	}
}