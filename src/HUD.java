import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.Timer;
import image.Assets;

public class HUD {
	
	private int x;
	private int y;
	private int width;
	private int height;
	private static int tiempo = 10;
	
	Handler handler = new Handler();
	Player player1 = new Player(80,200,32,32,Assets.tankU,handler);
	P2 player2 = new P2(150, 200, 32, 32, Assets.tankU, handler);
	Game game = new Game("Tank",720,480);
	Menu menu = new Menu(720,480);
	
	Color color = new Color(120,120,120);
	Timer timer = new Timer(1000, AE->segundoMenos());
	Font font = new Font("Times New Roman",Font.PLAIN,30);
	
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
	public int getTiempo() {
		return tiempo;
	}
	public void segundoMenos() {
		tiempo = tiempo - 1;
	}
	
	public void render(Graphics2D g) {
		g.setColor(color);
		g.fillRect(x,y,width,height);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString("P1",5,475);
		g.drawString("P2",680,475);
		
		if(menu.getModo()==1) {
			int PVY1 = 455;
			int PVX1 = 50;
			for(int i = 0; i < player1.getVidas(); i++) {
				System.out.println("i = " + i);
				g.drawImage(Assets.life,PVX1,PVY1,20,20,null);
				PVX1 = PVX1 + 20;
			}
			int PVY2 = 455;
			int PVX2 = 555;
			for(int i = 0; i < player2.getVidas(); i++) {
				System.out.println("i = " + i);
				g.drawImage(Assets.life,PVX2,PVY2,20,20,null);
				PVX2 = PVX2 + 20;
			}
			
		} else if(menu.getModo()==2) {
			g.drawString("" + tiempo, 350, 475);
			g.drawString("| " + player1.getPuntos(),40,475);
			g.drawString("" + player2.getPuntos() + " |",645,475);
		}
	}
}