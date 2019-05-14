import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;

import image.Assets;

public class Game implements Runnable, MouseListener {
	
	public static int width;
	public static int height;
	public String title;
	public Thread thread;
	private Window window;
	private Handler handler;
	private KeyInput keyInput;
	private BufferStrategy BS;
	private LevelCreator level;	
	private Player1 player1;
	private Player2 player2;
	private Rocket rocket;
	private Graphics2D g;
	private HUD HUD;
	private int background;
	private boolean running = false;
	private boolean pausado = false;
	Menu menu = new Menu(720,480);
	Boton pausa = new Boton(345,210,32,32);
	
	//Constructor
	public Game(String title, int width, int height) {
		this.title = title;
		Game.width = width;
		Game.height = height;
	}
	
	//Inicializador
	public void init() {
		Assets.init();
		window = new Window(title,width,height);
		handler = new Handler();
		level = new LevelCreator(handler);	
		pausa = new Boton(345,210,32,32);
		HUD = new HUD(0,452,720,30);
		
		switch(menu.getEscenario()) {
		case 1: player1 = new Player1(60,60,32,32,Assets.tankU, handler,1);
				player2 = new Player2(630,360,32,32,Assets.tankU, handler,1);
				background = 1;
				break;
		case 2: player1 = new Player1(270,210,32,32,Assets.tankU, handler,2);
				player2 = new Player2(420,210,32,32,Assets.tankU, handler,2);
				background = 2;
				break;
		case 3: player1 = new Player1(90,210,32,32,Assets.tankU, handler,1);
				player2 = new Player2(600,210,32,32,Assets.tankU, handler,1);
				background = 3;
				break;
		case 4: player1 = new Player1(60,210,32,32,Assets.tankU, handler,2);
				player2 = new Player2(630,210,32,32,Assets.tankU, handler,2);
				background = 4;
				break;
		}
		
		keyInput = new KeyInput(player1,player2);
		window.getFrame().addKeyListener(keyInput);
		handler.addObj(player1);
		handler.addObj(player2);
		
		HUD.setTiempo(120);
		player1.setEstadisticas(0,5,0);
		player2.setEstadisticas(0,5,0);
	}

	//Inicializador del juego
	public synchronized void start() {
		System.out.println("May the game begin");
		if(running) return;
		running = true;
		thread = new Thread(this);
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
		handler.tick();
	}
	
	//Render
	public void render() {
		BS = window.getCanvas().getBufferStrategy();
		if (BS == null) {
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		g = (Graphics2D) BS.getDrawGraphics();
		g.clearRect(0,0,width,height);
		
		//Escalado de pantalla
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
		double scrWidth = scrSize.getWidth();
		double scrHeight = scrSize.getHeight();
		
		switch(background) {
		case 1: g.drawImage(Assets.background1,0,0,(int)scrWidth,(int)scrHeight,null); break;
		case 2: g.drawImage(Assets.background2,0,0,(int)scrWidth,(int)scrHeight,null); break;
		case 3: g.drawImage(Assets.background3,0,0,(int)scrWidth,(int)scrHeight,null); break;
		case 4: g.drawImage(Assets.background4,0,0,(int)scrWidth,(int)scrHeight,null); break;
		}
		
		double wScale = scrWidth/width;
		double aproxH = (height*17)/17;
		double hScale = (scrHeight/aproxH);
		AffineTransform at = new AffineTransform();
		at.scale(wScale,hScale);
		g.setTransform(at);
	
		handler.render(g);
		HUD.render(g);
		g.dispose();
		BS.show();
	}

	//Runnable
	public void run() {
		init();
		int fps = 60;
		int ticks = 0;
		double timePerTick = 1000000000/fps; 
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;

		while(running == true) {
			if(player1.getPausa() == false) {
				now = System.nanoTime();
				delta += (now-lastTime) / timePerTick;
				timer += now - lastTime;
				lastTime = now;
	
				if(delta>=1) {
					tick();
					render();
					ticks++;
					delta--;
				}
				if(timer>=1000000000) {
					ticks = 0;
					timer = 0;
				}
			} else {
				pausado = true;
			}
			if(player1.getVidas()<=0 || player2.getVidas()<=0 || HUD.getTiempo()<=0) {
				running = false;
				window.dispose();
				menu.setOption(5);
			} 
		}
		stop();
	}	
	
	//Getters
	public int getWidth() { 
		return width; 
	}
	public int getBackground() { 
		return background; 
	}
	public int getHeight() { 
		return height; 
	}
	public boolean getPausado() {
		return pausado;
	}
	
	public void mouseClicked(MouseEvent ME) {
		if(pausa.click(ME.getX(), ME.getY())){
			pausado=!pausado;
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
}
