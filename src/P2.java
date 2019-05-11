import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import image.Assets;

public class P2 extends Chracter{
	private int dir=1, counter=0, pack5;
	private AnimationSprite bat;
	private static double PI=3.1415;
	private boolean adelante, atras, clock, anticlock, shootB, shootR; 
	private static int vidas = 5;
	private static int cohetes = 0;
	private static int puntos = 0;
	private static boolean ableToTurn = true;

	public P2(int x, int y, int width, int height, BufferedImage bi, Handler handler) {
		super(x,y,width,height,handler);
		SpriteBuilder builder = new SpriteBuilder ("/Textures/16dirP2.png", 32, 32);
		for (int i=0; i<16; i++) {
			builder.addImage(i,0);
		}
		bat=new AnimationSprite(x, y, builder.build());
		bat.setAnimSpd(5);
	}
		
	//Actualizador
	public void tick() {	
		if (counter==0 || counter==1 || counter==2) {
			if (adelante==true) {
				if (!collision(moveX(angle)*2, moveY(angle)*2)) {
					x+=moveX(angle);
					y-=moveY(angle);
					dir=1;
				}
			}
			else if (atras==true) {
				if (!collision(moveX((angle+8)%16)*2, moveY((angle+8)%16)*2)) {
					x+=moveX((angle+8)%16);
					y-=moveY((angle+8)%16);
					dir=3;
				}
			}
		}
		if (clock==true) {
			if (ableToTurn) {
				clockWise();
			}
			ableToTurn=!ableToTurn;
		}
		if (anticlock==true) {
			if (ableToTurn) {
				counterClockWise();
			}
			ableToTurn=!ableToTurn;
		}
		counter=(counter+1)%6;
		bat.update();
	}
	
	public int getVidas() {
		return vidas;
	}
	public int getCohetes() {
		return cohetes;
	}
	public int getPuntos() {
		return puntos;
	}
	public void perderVida() {
		System.out.println("Vidas = " + vidas);
		vidas = vidas - 1;
	}
	public void ganarPunto() {
		puntos = puntos + 1;
	}
	public void perderVidaCohete() {
		vidas = vidas - 3;
	}
	public void ganarPuntoCohete() {
		puntos = puntos + 3;
	}
	
	//Detección de colisiones
	public boolean collision(double dx, double dy) {
		ListIterator <GameObject> iterator = handler.obj.listIterator();
		while (iterator.hasNext()) {
			GameObject aux = iterator.next();
			if (aux instanceof Block) {
				if (placeMeeting(x+dx, y-dy, aux)) {
					return true;
				}
			}
			if (aux instanceof Player) {
				
				if (placeMeeting(x+dx, y-dy, aux)) {
					return true;
				}
			}
			if (aux instanceof Rocket) {
				if (placeMeeting(x+dx, y-dy, aux)) {
					handler.removeObj(aux);
					pack5 = 5;
					return true;
				}
			}	
		}
		return false;
	}

	public int moveX (int direction) {
		int movX;
		if (direction >= 0 && direction <=4 || direction >=12 && direction <=15)
			movX=(int)Math.ceil((round(Math.cos(direction*(3.1415/180)*22.5)*2,2)));
		else
			movX=(int)Math.floor((round(Math.cos(direction*(3.1415/180)*22.5)*2,2)));
		return movX;
	}
	
	public static int moveY (int direction) {
			int movX;
			if (direction >= 0 && direction <=7)
				movX=(int)Math.ceil((round(Math.sin(direction*(3.1415/180)*22.5)*2,2)));
			else
				movX=(int)Math.floor((round(Math.sin(direction*(3.1415/180)*22.5)*2,2)));
		return movX;
	}
	
	  public static double round(double value, int places) {
		    if (places < 0) throw new IllegalArgumentException();

		    BigDecimal bd = new BigDecimal(value);
		    bd = bd.setScale(places, RoundingMode.HALF_UP);
		    return bd.doubleValue();
	  }
	
	public void paint(Graphics g) 
	{		
		bat.render(g, x, y, angle);
	}
	
	//KeyListeners
	public  void keyPressed(int key) {
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);
		if (key == KeyEvent.VK_A) { 
			anticlock=true;
		}
		//x+3
		if (key == KeyEvent.VK_D) { 
			clock=true;
		}
		//y-3
		if (key == KeyEvent.VK_W) { 
			adelante=true;
		}
		//y+3
		if (key == KeyEvent.VK_S) { 
			atras=true;
		}
		if (key == KeyEvent.VK_E) {
			if(pack5>0) {
				handler.addObj(new RocketBllt(this.getX()+15, this.getY()+16, 8, 8, Assets.Rbullet, moveX(angle), moveY(angle), handler, angle,2));
				pack5--;
			} else {
				handler.addObj(new Bullet(this.getX()+15, this.getY()+16, 8, 8, Assets.bullet, moveX(angle), moveY(angle), handler,2));
			}
		}
	}
	public void keyReleased(int key) {
		if (key == KeyEvent.VK_A) { 
			anticlock=false;
		}
		//x+3
		if (key == KeyEvent.VK_D) { 
			clock=false;
		}
		//y-3
		if (key == KeyEvent.VK_W) { 
			adelante=false;
		}
		//y+3
		if (key == KeyEvent.VK_S) { 
			atras=false;
		}
		if (key == KeyEvent.VK_E) {
		//	shootR=false;
		}
	}
	public void keyTyped(int key) {	
	}
}

