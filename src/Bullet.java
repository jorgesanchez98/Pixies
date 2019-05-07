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
	Menu menu = new Menu(720,480);
	
	// Constructor
	public Bullet (int x, int y, int width, int height,  BufferedImage bi, int dirX, int dirY, Handler handler,int index) {
		super (x,y,width,height,handler);
		this.sprite=bi;
		this.dirX=dirX;
		this.dirY=dirY;
		this.index = index;
	}
	
	//Paint 
	public void paint(Graphics g) {
		g.drawImage(sprite, getX(), getY(), null);
	}
	
	public void tick() {
		x+=dirX;
		y-=dirY;
		collision();
	}
	
	public void collision() {
		ListIterator <GameObject> iterator = handler.obj.listIterator();
		while (iterator.hasNext()) {
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
			if (aux instanceof P2) { //Colisión Bala-Player2
				if (placeMeeting(x, y, aux) && index!=2) {
					setAlive(false);
					if(menu.getModo()==1) {
						player2.perderVida();
						handler.removeObj(this);
						if(player2.getVidas()==0) {
							aux.setAlive(false);
						} 
					} else if(menu.getModo()==2) {
						player.ganarPunto();
						handler.removeObj(this);
					}
				}
			}
			if (aux instanceof Player) { //Colisión Bala-Player1
				if (placeMeeting(x, y, aux) && index!=1) {
					if(menu.getModo()==1) {
						player.perderVida();
						handler.removeObj(this);
						if(player.getVidas()==0) {
							aux.setAlive(false);
						} 
					} else if(menu.getModo()==2) {
						player2.ganarPunto();
						handler.removeObj(this);
					}
				}
			}
		}
	}

	//Bordes del rectángulo
	public Rectangle getBounds() {
		return (new Rectangle(getX(), getY(), width, height));
	}
}
