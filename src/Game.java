import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.util.*;

import javax.swing.Timer;

import image.Assets;

public class Game implements Runnable {
	public static int width, height;
	public String title;
	
	public Thread thread;
	private Window window;
	private Handler handler;
	private KeyInput keyInput;
	private BufferStrategy bs;
	private Graphics2D g;
	private LevelCreator level;
	private Player player1;
	private P2 player2;
	private Rocket rocket;
	private HUD HUD;
	private boolean running = false;
	Menu menu = new Menu(720,480);
	
	//Constructor
	public Game(String title, int width, int height) {
		this.title = title;
		Game.width = width;
		Game.height = height;
	}
	
	//Inicializador
	public void init() {
		Assets.init();
	
		window = new Window(title, width, height);
		handler = new Handler();
		level = new LevelCreator (handler);
		player1 = new Player(80,200,32,32,Assets.tankU, handler);
		player2 = new P2(150,200,32,32,Assets.tankU, handler);
		rocket = new Rocket(80,250,32,32,Assets.rocketPU, handler);
		keyInput = new KeyInput(player1,player2);
		window.getFrame().addKeyListener(keyInput);
		handler.addObj(player1);
		handler.addObj(player2);
		handler.addObj(rocket);
		HUD = new HUD(0,452,720,30);
	}

	public synchronized void start() {
		System.out.println("May the game begin");
		if (running) return;
		running = true;
		thread = new Thread(this);

		//Música
		AudioPlayer.get().setMusicVol(0.7f);
		AudioPlayer.get().playMusic("LoungeGame");
		
		thread.start();
	}
	
	//Finalizador del juego
	public synchronized void stop() {
		if (!running) return;
		running = false;
		try {
			thread.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Actualizador del juego 
	public void tick() {
		if (handler.isWin())
			running=false;
		handler.tick();
	}
	
	//Render
	public void render() {
		bs = window.getCanvas().getBufferStrategy();
		if (bs == null) {
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		g = (Graphics2D) bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		//g.drawImage(Assets.background, 0, 0, null);
		
		//Escalado de pantalla
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
		double scrWidth = scrSize.getWidth();
		double scrHeight = scrSize.getHeight();
		g.drawImage(Assets.background, 0, 0, (int)scrWidth, (int)scrHeight, null);
		double wScale = scrWidth/width;
		double aproxH = (height*17)/17;
		double hScale = (scrHeight/aproxH);
		AffineTransform at = new AffineTransform();
		at.scale(wScale, hScale);
		g.setTransform(at);
		
		//Pinta los objetos del Handler
		handler.render(g);
		HUD.render(g);
		g.dispose();
		bs.show();
		
		Font font = new Font("Times New Roman",Font.PLAIN,30);
		g.setFont(font);
		/*
		if(menu.getModo()==1) {
			if(player1.getVidas()<=0 || player2.getVidas()<=0 || HUD.getTiempo()<=0) {
				if(player1.getVidas()>0) {
					g.drawString("¡Gana P1!", 330, 200);
				} else if(player2.getVidas()>0) {
					g.drawString("¡Gana P2!", 330, 200);
				}
			}
		} else if(menu.getModo()==2) {
			if(HUD.getTiempo()<=0) {
				if(player1.getPuntos()>player2.getPuntos()) {
					g.drawString("¡Gana P1!", 330, 200);
				} else if(player2.getVidas()>player1.getPuntos()) {
					g.drawString("¡Gana P2!", 330, 200);
				}
			}
		}
		*/
		
	}
	
	//Runnable
	public void run() {
		init();
		int fps = 60, ticks = 0;
		double timePerTick = 1000000000 / fps, delta = 0;
		long now, lastTime = System.nanoTime(), timer = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now-lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			if (timer>=1000000000) {
				ticks = 0;
				timer = 0;
			}
			//REVISAR
			/*if(player1.getVidas()<=0 || player2.getVidas()<=0 || HUD.getTiempo()<=0) {
				running = false;
			}*/
		}
		stop();
	}	
	
	public int getWidth() { 
		return width; 
	}
	public int getHeight() { 
		return height; 
	}
}
