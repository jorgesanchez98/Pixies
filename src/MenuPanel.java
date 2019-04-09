import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import image.Assets;

public class MenuPanel extends JPanel implements Runnable {
	
	//Variables
	private static final long serialVersionUID = 1L;
	private static final int PWidth = 720;
	private static final int PHeight = 480;
	
	private Thread animator;
	private volatile boolean running = false;
	private volatile boolean gameOver = false;
	private Graphics DBG;
	private Image DBImage = null;
	private Menu menu;

	//Constructor
	public MenuPanel() {
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(PWidth, PHeight));
		readyForTermination();
		setFocusable(true);     //Recibir KeyEvents
		requestFocus();
		
		menu = new Menu(PWidth, PHeight);
		addMouseListener(menu);
		addKeyListener(menu);
	}
	
	//Métodos de activación
	public void addNotify() {
		super.addNotify();
		startGame();
	}
	public void startGame() {
		if(animator == null || !running) {
			animator = new Thread(this);
			animator.start();
			this.setVisible(true);
		}
	}
	public void StopGame() {
		running = false;
	}
	
	//Método del juego
	public void run() {
		image.Assets.init();
		int fps = 60;
		int ticks = 0;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		
		running = true;
		while (running) {
			now = System.nanoTime();
			delta += (now-lastTime)/timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if (delta >= 1) {
				gameUpdate();
				gameRender();
				paintScreen();
				ticks ++;
				delta --;
			}
			if (timer >= 1000000000) {
				//System.out.println("FPS = " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		StopGame();
	}
	
	//Métodos del Run
	public void gameUpdate() {
		if(!gameOver) {
			menu.update();
		} 
	}
	public void gameRender() {
		if(DBImage == null) {
			DBImage = createImage(PWidth, PHeight);
			if(DBImage == null) {
				System.out.println("DBImage is NULL");
				return;
			}
		} else {
			DBG = DBImage.getGraphics();
			menu.draw((Graphics2D)DBG);
			if(gameOver) {
				gameOverMsg(DBG);
			}
		}
	}
	public void gameOverMsg(Graphics DBG) {
		System.out.println("GAME OVER");
	}
	/*
	public boolean passedMenu() {
		if(menu.getOption() == 3) {
			menu.setOption(-1);
			return true;
		}
		return false;
	}*/
	
	//Paint
	public void paint(Graphics GL) {
		super.paint(GL);
		if(DBImage != null) {
			GL.drawImage(DBImage,0,0,null);
		}
	}
	private void paintScreen() {
		Graphics GL;
		try {
			GL=this.getGraphics();
			if(GL!=null && DBImage!=null) {
				GL.drawImage(DBImage,0,0,null);
				Toolkit.getDefaultToolkit().sync();
				GL.dispose();
			}
		} catch(Exception E) {
			System.out.println("Graphic content error: " + E);
		}
	}
	
	//Métodos adicionales
	public void readyForTermination() {
	}
	public void click(int mx, int my) {
	}
}

