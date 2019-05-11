import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ListIterator;

import image.Assets;

public class RocketBllt extends GameObject{
	
	//Variables
	protected BufferedImage sprite;
	private int angle,index;
	private float dirX, dirY;
	private AnimationSprite bat;
	
	//Objetos
	Player1 player = new Player1(80, 200, 32, 32, Assets.tankU, handler);
	Player2 player2 = new Player2(150, 200, 32, 32, Assets.tankU, handler);
	Menu menu = new Menu(720,480);
	
	// Constructor 
	public RocketBllt(int x, int y, int width, int height, BufferedImage bi, int dirX, int dirY, Handler handler, int angle, int index) {
		super (x,y,width,height,handler);
		//this.sprite=bi;
		this.dirX=dirX;
		this.dirY=dirY;
		this.index=index;
		this.angle = angle;
		SpriteBuilder builder = new SpriteBuilder ("./Textures/16cohete.png",20,20);
		for (int i=0; i<16 ; i++) {
			builder.addImage(i, 0);
		}
		bat=new AnimationSprite(x, y, builder.build());
		bat.setAnimSpd(5);
	}
	
	//Paint
	public void paint(Graphics g) {
		bat.render(g, x, y, angle);
	}
	
	//Colisión
	public void tick() {
		x+=dirX;
		y-=dirY;
		collision();
	}
	public void collision() {
		ListIterator <GameObject> iterator = handler.obj.listIterator();
		while (iterator.hasNext()) {
			// Se crea un objeto auxiliar
			GameObject aux = iterator.next();
			if (aux instanceof Block) {
				if (placeMeeting(x,y,aux)) {
					setAlive(false);
					aux.setAlive(false);
				}
			}
			if (aux instanceof Target) {
				if (placeMeeting(x,y,aux)) {
					setAlive(false); 
				}
			}
			if (aux instanceof Player2) {
				if (placeMeeting(x, y, aux) && index!=2) {
					if(menu.getModo()==1) {
						player2.perderVidaCohete();
						handler.removeObj(this);
						if(player2.getVidas()<=0) {
							aux.setAlive(false);
						} 
					} else if(menu.getModo()==2) {
						player.ganarPuntoCohete();
						handler.removeObj(this);
					}
				}
			}
			if (aux instanceof Player1) {
				if (placeMeeting(x, y, aux) && index!=1) {
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

	//Rectangle
	public Rectangle getBounds() {
		return (new Rectangle(getX(), getY(), width, height));
	}
}