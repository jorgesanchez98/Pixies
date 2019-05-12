import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ListIterator;

import image.Assets;

public class Player2 extends Character{
	
	//Variables
	private AnimationSprite AS;	
	private static double PI = 3.1415;
	private int dir = 1;
	private int counter=0;
	private static int vidas = 0;
	private static int cohetes = 0;
	private static int puntos = 0;
	private static boolean ableToShoot = true;
	private static boolean ableToTurn = true;	
	private boolean adelante, atras, clock, anticlock, shootB, shootR; 

	//Constructor
	public Player2(int x, int y, int width, int height, BufferedImage bi, Handler handler) {
		super(x,y,width,height,handler);
		
		SpriteBuilder builder = new SpriteBuilder("/Textures/16dirP2.png",32,32);
		for (int i=0; i<16; i++) {
			builder.addImage(i,0);
		}
		AS=new AnimationSprite(x,y,builder.build());
		AS.setAnimSpd(5);
	}
		
	//Actualizador
	public void tick() {	
		if(counter==0 || counter==1 || counter==2) {
			if(adelante==true) {
				if(!collision(moveX(angle)*2, moveY(angle)*2)) {
					x+=moveX(angle);
					y-=moveY(angle);
					dir=1;
				}
			}
			else if(atras==true) {
				if(!collision(moveX((angle+8)%16)*2, moveY((angle+8)%16)*2)) {
					x+=moveX((angle+8)%16);
					y-=moveY((angle+8)%16);
					dir=3;
				}
			}
		}
		if(clock==true) {
			if(ableToTurn) {
				clockWise();
			}
			ableToTurn=!ableToTurn;
		}
		if(anticlock==true) {
			if(ableToTurn) {
				counterClockWise();
			}
			ableToTurn=!ableToTurn;
		}
		counter=(counter+1)%6;
		AS.update();
	}
	
	//Setters-Getters
	public int getVidas() {
		return vidas;
	}
	public int getCohetes() {
		return cohetes;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setEstadisticas(int puntos, int vidas) {
		this.puntos = puntos;
		this.vidas = vidas;
	}
	
	//Modos de juego
	public void perderVida() {
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
	public void tomarCohete() {
		cohetes = cohetes + 5;
	}
	public void dispararCohete() {
		cohetes = cohetes - 1;
	}
	
	//Deteccion de colisiones
	public boolean collision(double dx, double dy) {
		ListIterator <GameObject> itr = handler.obj.listIterator();
		while(itr.hasNext()) {
			GameObject GO = itr.next();
			if(GO instanceof Block) {
				if(placeMeeting(x+dx, y-dy, GO)) {
					return true;
				}
			}
			if(GO instanceof Target) {
				if(placeMeeting(x+dx, y-dy, GO)) {
					return true;
				}
			}
			if(GO instanceof Player1) {
				if(placeMeeting(x+dx, y-dy, GO)) {
					return true;
				}
			}
			if(GO instanceof Rocket) {
				if(placeMeeting(x+dx, y-dy, GO)) {
					handler.removeObj(GO);
					tomarCohete();
					return true;
				}
			}	
		}
		return false;
	}

	//Metodos de movimiento
	public int moveX(int direction) {
		int movX;
		if (direction >= 0 && direction <=4 || direction >=12 && direction <=15)
			movX=(int)Math.ceil((round(Math.cos(direction*(3.1415/180)*22.5)*2,2)));
		else
			movX=(int)Math.floor((round(Math.cos(direction*(3.1415/180)*22.5)*2,2)));
		return movX;
	}
	public static int moveY(int direction) {
		int movX;
		if (direction >= 0 && direction <=7)
			movX=(int)Math.ceil((round(Math.sin(direction*(3.1415/180)*22.5)*2,2)));
		else
			movX=(int)Math.floor((round(Math.sin(direction*(3.1415/180)*22.5)*2,2)));
		return movX;
	}
	
	//Redondeo de escala
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	//Paint
	public void paint(Graphics g) {		
		AS.render(g,x,y,angle);
	}
	
	//KeyListeners
	public  void keyPressed(int key) {
		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
		if (key == KeyEvent.VK_A) { 
			anticlock=true;
		}
		if (key == KeyEvent.VK_D) { 
			clock=true;
		}
		if (key == KeyEvent.VK_W) { 
			adelante=true;
		}
		if (key == KeyEvent.VK_S) { 
			atras=true;
		}
		if (key == KeyEvent.VK_E) {
			if(ableToShoot) {
				if(getCohetes()>0) {
					handler.addObj(new RocketBllt(this.getX()+15, this.getY()+16, 8, 8, Assets.Rbullet, moveX(angle), moveY(angle), handler, angle,2));
					dispararCohete();
				} else {
					handler.addObj(new Bullet(this.getX()+15, this.getY()+16, 8, 8, Assets.bullet, moveX(angle), moveY(angle), handler,2));
				}
				ableToShoot = false;
			}
		}
	}
	public void keyReleased(int key) {
		if (key == KeyEvent.VK_A) { 
			anticlock=false;
		}
		if (key == KeyEvent.VK_D) { 
			clock=false;
		}
		if (key == KeyEvent.VK_W) { 
			adelante=false;
		}
		if (key == KeyEvent.VK_S) { 
			atras=false;
		}
		if (key == KeyEvent.VK_E) {
			if(!ableToShoot) {
				ableToShoot = true;
			}
		}
	}
	public void keyTyped(int key) {	
	}
}

