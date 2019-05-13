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
	private AnimationSprite AS;
	
	//Objetos
	Player1 player = new Player1(80,200,32,32,Assets.tankU,handler,1);
	Player2 player2 = new Player2(150,200,32,32,Assets.tankU,handler,1);
	Menu menu = new Menu(720,480);
	
	//Constructor 
	public RocketBllt(int x, int y, int width, int height, BufferedImage bi, int dirX, int dirY, Handler handler, int angle, int index) {
		super(x,y,width,height,handler);
		this.dirX = dirX;
		this.dirY = dirY;
		this.index = index;
		this.angle = angle;		
		SpriteBuilder builder = new SpriteBuilder("./Textures/16cohete.png",20,20);
		for (int i=0; i<16 ; i++) {
			builder.addImage(i, 0);
		}
		AS=new AnimationSprite(x, y, builder.build());
		AS.setAnimSpd(5);
	}
	
	//Paint
	public void paint(Graphics g) {
		AS.render(g,x,y,angle);
	}
	
	//Colision
	public void tick() {
		x+=dirX;
		y-=dirY;
		collision();
	}
	public void collision() {
		ListIterator <GameObject> itr = handler.obj.listIterator();
		while(itr.hasNext()) {
			GameObject GO = itr.next();
			if(GO instanceof Block) {
				if(placeMeeting(x,y,GO)) {
					setAlive(false);
					GO.setAlive(false);
				}
			}
			if(GO instanceof Target) {
				if(placeMeeting(x,y,GO)) {
					setAlive(false); 
				}
			}
			if(GO instanceof Player2) {
				if(placeMeeting(x,y,GO) && index!=2) {
					if(menu.getModo()==1) {
						player2.perderVidaCohete();
						handler.removeObj(this);
						if(player2.getVidas()<=0) {
							GO.setAlive(false);
						} 
					} else if(menu.getModo()==2) {
						player.ganarPuntoCohete();
						handler.removeObj(this);
					}
				}
			}
			if(GO instanceof Player1) {
				if(placeMeeting(x, y, GO) && index!=1) {
					if(menu.getModo()==1) {
						player.perderVidaCohete();
						handler.removeObj(this);
						if(player.getVidas()<=0) {
							GO.setAlive(false);
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