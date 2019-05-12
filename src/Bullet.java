import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ListIterator;

import image.Assets;

public class Bullet extends GameObject{
	
	//Variables
	protected BufferedImage sprite;
	private int dirX, dirY,index;
	
	//Objetos
	Player1 P1 = new Player1(80,200,32,32,Assets.tankU,handler);
	Player2 P2 = new Player2(150,200,32,32,Assets.tankU,handler);
	Menu menu = new Menu(720,480);
	
	//Constructor
	public Bullet (int x, int y, int width, int height, BufferedImage bi, int dirX, int dirY, Handler handler, int index) {
		super (x,y,width,height,handler);
		this.sprite = bi;
		this.dirX = dirX;
		this.dirY = dirY;
		this.index = index;
	}
	
	//Paint 
	public void paint(Graphics g) {
		g.drawImage(sprite,getX(),getY(),null);
	}
	
	//Colisi�n
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
				if (placeMeeting(x,y,aux)) {
					setAlive(false);
				}
			}
			if (aux instanceof Target) {
				if (placeMeeting(x,y,aux)) {
					setAlive(false);
				}
			}
			if (aux instanceof Player2) { 
				//Colisi�n Bala-Player2
				if (placeMeeting(x,y,aux) && index!=2) {
					setAlive(false);
					if(menu.getModo()==1) {
						P2.perderVida();
						handler.removeObj(this);
						if(P2.getVidas()==0) {
							aux.setAlive(false);
						} 
					} else if(menu.getModo()==2) {
						P1.ganarPunto();
						handler.removeObj(this);
					}
				}
			}
			if (aux instanceof Player1) { 
				//Colisi�n Bala-Player1
				if (placeMeeting(x, y, aux) && index!=1) {
					if(menu.getModo()==1) {
						P1.perderVida();
						handler.removeObj(this);
						if(P1.getVidas()==0) {
							aux.setAlive(false);
						} 
					} else if(menu.getModo()==2) {
						P2.ganarPunto();
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
