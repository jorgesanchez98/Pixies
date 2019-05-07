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
	public int tiempo = 120;
	
	public Thread thread;
	private Window window;
	private Handler handler;
	private KeyInput keyInput;
	private BufferStrategy bs;
	private Graphics2D g;
	private LevelCreator level;
	private Player player;
	private P2 player2;
	private Rocket rocket;
	private HUD HUD;
	private boolean running = false;
	
	Menu menu = new Menu(720,480);
	Color color = new Color(150,150,150);
	Font font = new Font("Times New Roman",Font.PLAIN,36);
	//Timer timer = new Timer(1000,AE->segundoMenos());
	
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
		//se creal el nivel
		level = new LevelCreator (handler);
		// Se crea al jugador
		player = new Player(80, 200, 32, 32, Assets.tankU, handler);
		player2 = new P2(150, 200, 32, 32, Assets.tankU, handler);
		rocket = new Rocket(80, 250, 32, 32, Assets.rocketPU, handler);
		// Se crea el KeyInput
		/*
		 * En nuestro caso, qui�n se har� cargo de escuchar los inputs recibidos
		 * por el usuario, es el jugador.
		 */
		keyInput = new KeyInput(player,player2);
		//keyInput = new KeyInput(player2);
		// A�ade el KeyInput a la ventana, para que �sta sea la intermediaria
		window.getFrame().addKeyListener(keyInput);
		handler.addObj(player);
		handler.addObj(player2);
		handler.addObj(rocket);
		HUD = new HUD(0,452,720,30);
	}
	
	// El m�todo start se encarga de iniciar al juego
	public synchronized void start()
	{
		System.out.println("Hit the special block to win the game\nShoot with space, move with the arrows");
		if (running) return;
		running = true;
		thread = new Thread(this);
		
		// MUSIC
		AudioPlayer.get().setMusicVol(0.7f);
		AudioPlayer.get().playMusic("LoungeGame");
		
		thread.start();
		/*
		if(menu.getModo()==2) {
			timer.start();
		}
		*/
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
		// Se obtiene el BufferStrategy que tiene el Canvas de Window
		bs = window.getCanvas().getBufferStrategy();
		
		//Creador del BufferStrategy
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
	}
	/*
	public void segundoMenos() {
		tiempo = tiempo - 1;
	}
	*/
	
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
		}
		System.out.println("" + tiempo);
		stop();
		System.exit(0);
	}	
	
	public int getWidth() { 
		return width; 
	}
	public int getHeight() { 
		return height; 
	}
}
