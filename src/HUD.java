import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.Timer;
import image.Assets;

public class HUD {
	
	//Variables
	private int x;
	private int y;
	private int width;
	private int height;
	private static int tiempo = 180;
	
	//Objetos
	Handler handler = new Handler();
	Player1 player1 = new Player1(80,200,32,32,Assets.tankU,handler);
	Player2 player2 = new Player2(150,200,32,32,Assets.tankU,handler);
	Game game = new Game("Tank",720,480);
	Menu menu = new Menu(720,480);
	
	//Texto
	Color color = new Color(120,120,120);
	Font font = new Font("Times New Roman",Font.PLAIN,30);
	
	//Timer
	Timer timer = new Timer(1000, AE->segundoMenos());
	
	//Constructor
	public HUD(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		if(menu.getModo()==2) {
			timer.start();
		}
	}
	
	//Setters-Getters
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return y;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getWidth() {
		return width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getHeight() {
		return height;
	}
	public static int getTiempo() {
		return tiempo;
	}
	
	//Reducción de tiempo
	public void segundoMenos() {
		if(game.getPausado() == true) {
			tiempo = tiempo - 1;
		}
	}
	
	//Render
	public void render(Graphics2D g) {
		g.setColor(color);
		g.fillRect(x,y,width,height);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString("P1",5,475);
		g.drawString("P2",680,475);
		
		if(menu.getModo()==1) { 
			//Pintar vidas
			int PVY1 = 455;
			int PVX1 = 45;
			for(int i = 0; i < player1.getVidas(); i++) {
				g.drawImage(Assets.life,PVX1,PVY1,20,20,null);
				PVX1 = PVX1 + 20;
			}
			int PVY2 = 455;
			int PVX2 = 565;
			for(int i = 0; i < player2.getVidas(); i++) {
				g.drawImage(Assets.life,PVX2,PVY2,20,20,null);
				PVX2 = PVX2 + 20;
			}
			g.drawImage(Assets.rocketPU,150,455,20,20,null);
			g.drawString("" + player1.getCohetes(),175,475);
			g.drawImage(Assets.rocketPU,538,455,20,20,null);
			g.drawString("" + player2.getCohetes(),520,475);
			
		} else if(menu.getModo()==2) { 
			//Pintar puntuación
			g.drawString("" + tiempo, 350, 475);
			g.drawString("| " + player1.getPuntos(),40,475);
			g.drawString("" + player2.getPuntos() + " |",645,475);
			g.drawImage(Assets.rocketPU,100,455,20,20,null);
			g.drawString("" + player1.getCohetes(),127,475);
			g.drawImage(Assets.rocketPU,590,455,20,20,null);
			g.drawString("" + player2.getCohetes(),570,475);
		}
	}
}