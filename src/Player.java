import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ListIterator;

import image.Assets;



/*ESTA BRANCH VALE VERGA*/

// Clase que define el comportamiento del jugador
public class Player extends Chracter{
	private int pack5=0;
	private Bomb tempBomb;
	private int dir=1;
	private AnimationSprite bat;
	private int index;
	private static double PI=3.1415;
	// Constructor que recibe los atributos de un GameObject
	public Player(int x, int y, int width, int height,  BufferedImage bi, Handler handler, int index) {
		super(x, y, width, height, handler);
		this.index = index;
		SpriteBuilder builder = new SpriteBuilder ("./Textures/16dir.png", 32, 32);
		for (int i=0; i<16 ; i++) {//add all frames
			builder.addImage(i, 0);
		}
		bat=new AnimationSprite(x, y, builder.build());
		bat.setAnimSpd(5);
		}
		
	// M�todo que nos ayuda a actualizar al jugador
	@Override
	public void tick() 
	{	
		bat.update();
	}
	
	// M�todo que se encarga de detectar las colisiones
	
	@Override
	public boolean collision(double dx, double dy) 
	{
		// Se genera un iterador para revisar todos los objetos
		ListIterator <GameObject> iterator = handler.obj.listIterator();
		while (iterator.hasNext())
		{
			// Se crea un objeto auxiliar
			GameObject aux = iterator.next();
			
			// Si el auxiliar es una pared
			if (aux instanceof Block )
			{
				// Si hace contacto con la pared en el eje de las x al sumarle la velocidad
				if (placeMeeting(x+dx, y-dy, aux))
				{
					return true;
				}
			}
			
			
			if (aux instanceof Rocket)
			{
				// Si hace contacto con el cohete disminuimos la velocidad un instante, y quitamos el PowerUp
				if (placeMeeting(x+dirX, y+dirY, aux))
				{
					/*velX=1;
					velY=1;*/
					handler.removeObj(aux);
					//Se asignan 5 balas
					pack5 = 5;
					//return;

				}
				else {
					/*velX=3;
					velY=3;*/
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
	
	// M�todo que lee las teclas que han sido presionadas
	public void keyPressed(int key) {
		if(this.index ==1) {
		// Si es escape, cierra el juego
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);
		// Si es la flecha izquierda, vuelve la velocidad en x -3
		if (key == KeyEvent.VK_LEFT) { 
			dir=2;
			counterClockWise();
			System.out.println(angle);
			}
		// Si es la flecha derecha, vuelve la velocidad en x +3
		if (key == KeyEvent.VK_RIGHT) { 
			dir=4;
			clockWise();
			System.out.println(angle);
		}
		// Si es la flecha arriba, vuelve la velocidad en y -3
		if (key == KeyEvent.VK_UP) { 
			if (!collision(moveX(angle)*2, moveY(angle)*2)) {
				x+=moveX(angle);
				y-=moveY(angle);
				dir=1;
			}
		}
		// Si es la flecha abajo, vuelve la velocidad en y +3
		if (key == KeyEvent.VK_DOWN) { 
			if (!collision(moveX((angle+8)%16)*2, moveY((angle+8)%16)*2)) {
				x+=moveX((angle+8)%16);
				y-=moveY((angle+8)%16);
				dir=3;
			}
		}
		
		if (key == KeyEvent.VK_SPACE) {
			handler.addObj(new Bullet(this.getX()+15, this.getY()+16, 8, 8, Assets.bullet, moveX(angle), moveY(angle), handler));
		}
		
		if (key == 67) {
			//handler.addObj(new Bomb(this.getX()+15, this.getY()+16, 8, 8,  moveX(angle), moveY(angle), angle, handler));
			if(pack5>=1) {
				handler.addObj(new RocketBllt(this.getX()+35, this.getY()+12, 8, 8, Assets.rocketB, dir, handler));
				pack5 -= 1;
				return;
			}
			//handler.addObj(new Bullet(this.getX()+35, this.getY()+12, 8, 8, Assets.bullet, dir, handler));
		}
		if (key == KeyEvent.VK_B) {
			tempBomb.setX(this.getX()+32);
			tempBomb.setY(this.getY());
			handler.addObj(tempBomb);
			//new Bullet(this.getX()+15, this.getY()+16, 8, 8, Assets.bullet, dir, handler)
		}
		
	}
		if (key == KeyEvent.VK_Q) {
			tempBomb.setX(this.getX()+32);
			tempBomb.setY(this.getY());
			handler.addObj(tempBomb);
			//new Bullet(this.getX()+15, this.getY()+16, 8, 8, Assets.bullet, dir, handler)
		}
	}

	public void keyReleased(int key) {
		
	}

	public void keyTyped(int key) {
		
	}

}
