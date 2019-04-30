import java.awt.Color;
import java.awt.Dimension;

import image.Assets;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.nio.FloatBuffer;

import org.lwjgl.glfw.*;

import image.Assets;

// Clase principal para que el juego corra
/*
 * Implementa la clase Runnable, la cual corre al m�todo run() 
 * cuando se inicia el thread princilal 
 */

public class Game implements Runnable{
	// Variables que determinan el ancho, el alto y el t�tulo del juego
	public static int width, height;
	public String title;
	
	// �ste es el thread principal sobre el cu�l va a correr el juego
	public Thread thread;
	
	// Se crean variables de las clases que creamos
	private Window window;
	private Handler handler;
	private KeyInput keyInput;
	
	// �stas 2 variables nos van a ayudar a hacer el renderizado en el juego
	private BufferStrategy bs;
	private Graphics2D g;
	private LevelCreator level;
	private Player player;
	private Rocket rocket;
	
	// Con la variable booleana
	private boolean running = false;
	
	// Se crea el constructor de la clase, recibe el tama�o de la ventana y su t�tulo
	public Game(String title, int width, int height)
	{
		this.title = title;
		Game.width = width;
		Game.height = height;
	}
	
	// M�todo que inicializa los recursos que ser�n utilizados a lo largo del juego
	public void init()
	{
		Assets.init();
		
		// Se crea la ventana, d�ndole su width, height y el t�tulo del juego
		window = new Window(title, width, height);
		// Se crea el Handler 
		/*
		 * Handler nos ayuda a manejar los updates y renderizados de los objetos
		 * contenidos en el juego
		 */
		handler = new Handler();
		//se creal el nivel
		level = new LevelCreator (handler);
		// Se crea al jugador
		player = new Player(80, 200, 32, 32, Assets.tankU, handler);
		rocket = new Rocket(80, 250, 32, 32, Assets.rocketPU, handler);
		// Se crea el KeyInput
		/*
		 * En nuestro caso, qui�n se har� cargo de escuchar los inputs recibidos
		 * por el usuario, es el jugador.
		 */
		keyInput = new KeyInput(player);
		// A�ade el KeyInput a la ventana, para que �sta sea la intermediaria
		window.getFrame().addKeyListener(keyInput);
		
		// Se le a�aden los objetos pared y jugador al Handler
		handler.addObj(player);
		handler.addObj(rocket);
	}
	
	// El m�todo start se encarga de iniciar al juego
	public synchronized void start()
	{
		System.out.println("Hit the special block to win the game\nShoot with space, move with the arrows");
		// Si el juego se est� corriendo, no hace nada
		if (running) return;
		// Hace que running pase al estado de true e inicia el thread principal
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	// El m�todo stop se encarga de detener al juego
	public synchronized void stop()
	{
		// Si el juego no est� corriendo, no hace nada
		if (!running) return;
		// Hace que running pase al estado de false y termina el thread principal
		running = false;
		try
		{
			thread.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	// El m�todo tick() se encarga de realizar el update del juego
	public void tick()
	{
		// Gamepad Functionality
		GLFW.glfwPollEvents();
		boolean gp1_present = GLFW.glfwJoystickPresent(GLFW.GLFW_JOYSTICK_1);
		//boolean gp2_present = GLFW.glfwJoystickPresent(GLFW.GLFW_JOYSTICK_2);
		if (gp1_present) {
			// gamepad 1 present
			FloatBuffer axes = GLFW.glfwGetJoystickAxes(GLFW.GLFW_JOYSTICK_1);
			
			int axisID = 1;
			while (axes.hasRemaining()) {
			    float state = axes.get();
			    if (state < -0.95f || state > 0.95f) {
			        // Full range gamepad 1 action
			    } else if (state < -0.5f || state > 0.5f) {
			        // Mid range gamepad 1 action
			    }
			    axisID++;
			}
		}
		
		if (handler.isWin())
			running=false;
			// Se llama al m�todo tick del Handler y del Spawner
		handler.tick();
	}
	
	// El m�todo render() se encarga de hacer el renderizado del juego
	public void render()
	{
		// Se obtiene el BufferStrategy que tiene el Canvas de Window
		bs = window.getCanvas().getBufferStrategy();
		
		// Si Canvas no tiene un BufferStrategy
		if (bs == null)
		{
			// Se le crea uno de 3 Buffers y retorna
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		// Graphics obtiene lo que est� dibujado en el BufferStrategy
		g = (Graphics2D) bs.getDrawGraphics();
		// Se limpia el Buffer para dibujar en blanco
		g.clearRect(0, 0, width, height);
		
		// Obtiene tama�os de la pantalla
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
		double scrWidth = scrSize.getWidth();
		double scrHeight = scrSize.getHeight();
		
		
		// Dibuja el fondo
		//g.drawImage(Assets.background, 0, 0, null);
		g.drawImage(Assets.background, 0, 0, (int)scrWidth, (int)scrHeight, null);
		
		// Scale the image
		double wScale = scrWidth/width;
		double aproxH = (height*15)/16;
		double hScale = (scrHeight/aproxH);
		AffineTransform at = new AffineTransform();
		at.scale(wScale, hScale);
		g.setTransform(at);
		
		
		// Pinta los objetos contenidos en el handler
		handler.render(g);
		
		// Deja de hacer uso del "pincel" para no consumir los recursos todo el tiempo
		g.dispose();
		// Muestra lo que Graphics dibuj� en los Buffers
		bs.show();
		
	}
	
	
	// �ste es el m�todo primordial para el GameLoop
	public void run()
	{
		// Llama a init() para inicializar lo que es requerido en el juego
		init();
		// Se declara un target de actualizaciones por segundo con fps
		// Con ticks se hace tracking de las actualizaciones que se hacen por segundo
		int fps = 60, ticks = 0;
		// timePerTick nos muestra cu�nto tiempo debe pasar entre cada update
		// timePerTick es 1000000000 porque se manejar� el tiempo en nano segundos
		// delta nos ayuda a saber si el tiempo de timePerTick ya ha pasado
		double timePerTick = 1000000000 / fps, delta = 0;
		// now nos da el tiempo actual y lastTime el tiempo anterior
		// timer da seguimiento al tiempo que ha pasado desde el �ltimo ciclo
		long now, lastTime = System.nanoTime(), timer = 0;
		
		// Mientras el juego se encuentre corriendo...
		while (running)
		{
			// Se obtiene el tiempo actual
			now = System.nanoTime();
			// Se le suma a delta para ver si es momento de hacer un update
			delta += (now-lastTime) / timePerTick;
			// Se le suma a timer el tiempo que se lleva
			timer += now - lastTime;
			// lastTime avanza a ser el actual
			lastTime = now;
			
			// Si el delta es mayor o igual a uno
			if (delta >= 1)
			{
				// Se realiza el update y el pintado
				tick();
				render();
				// Se le suma uno a ticks para dar seguimiento a las actualizaciones que
				// se llevan en �ste segundo
				ticks ++;
				// Se reduce delta en uno para que se pueda volver a realizar el update
				delta --;
			}
			
			// �sto significa que si ha pasado ya un segundo
			if (timer >= 1000000000)
			{
				// Imprime el n�mero de actualizaciones que se hicieron en ese segundo
				//System.out.println("Ticks and frames: " + ticks);
				// Reinicia los contadores
				ticks = 0;
				timer = 0;
			}
		}
		// Cuando el juego ya no est� corriendo, se detiene
		stop();
		System.out.println("yeih");
		System.exit(0);
	}
		
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
}
