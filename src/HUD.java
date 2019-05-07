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
	private static int tiempo = 120;
	
	Handler handler = new Handler();
	Player player = new Player(80,200,32,32,Assets.tankU,handler);
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
	public void segundoMenos() {
		tiempo = tiempo - 1;
	}
	
	public void render(Graphics2D g) {
		g.setColor(color);
		g.fillRect(x,y,width,height);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString("P1",5,475);
		g.drawString("P2",675,475);
		
		if(menu.getModo()==1) {
			int PVX = 50;
			int PVY = 455;
			for(int i = 0; i < player.getVidas(); i++) {
				System.out.println("i = " + i);
				g.drawImage(Assets.life,PVX,PVY,20,20,null);
				PVX = PVX + 20;
			}
		} else if(menu.getModo()==2) {
			g.drawString("" + tiempo, 350, 475);
			g.drawString("| " + player.getPuntos(),40,475);
		}
	}
}