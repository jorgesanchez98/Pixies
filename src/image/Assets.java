package image;

// Se importan las librerías a ocupar
import java.awt.image.BufferedImage;

public class Assets {
	
	// Aquí se cargan todas las imágenes que se requieran en el juego
	// Es estático y público dado a que requerimos acceder a ellas desde varias clases
	/*
	 * Ejemplo de BufferedImage con varias imágenes:
	 * public static BufferedImage background, player, c	loud, enemy...; 
	*/
	public static BufferedImage background, level, block, block2, tankU, tankL, tankD, tankR, bullet;
	public static BufferedImage relieve, fondo;
	public static BufferedImage jugar, salir, título, tutorial;
	public static BufferedImage corazón, vidas, reloj, tiempo, SModo;
	public static BufferedImage escenario1, escenario2, escenario3, escenario4, SEscenario;
	public static BufferedImage CJugar, imagenTutorial1, imagenTutorial2, imagenTutorial3, imagenTutorial4, imagenTutorial5, imagenTutorial6;
	public static BufferedImage textoTutorial1, textoTutorial2, textoTutorial3, textoTutorial4, textoTutorial5, textoTutorial6;
	public static BufferedImage atrás1, atrás2, atrás3;

	
	// En éste método se inicializan todas las imágenes que se van a ocupar
	public static void init()
	{
		// Se hace uso de la clase ImageLoader para cargar la imágen 
		// (la clase debió ser creada previamente)
		background = ImageLoader.loadImage("/Textures/background.png");
		level = ImageLoader.loadImage("/Textures/level.png");
		block = ImageLoader.loadImage("/Textures/brick.png");
		block2 = ImageLoader.loadImage("/Textures/brick.png");
		tankU = ImageLoader.loadImage("/Textures/triTank.png");
		tankL = ImageLoader.loadImage("/Textures/triTankLeft.png");
		tankD = ImageLoader.loadImage("/Textures/triTankDown.png");
		tankR = ImageLoader.loadImage("/Textures/triTankRight.png");
		bullet = ImageLoader.loadImage("/Textures/bullet.png");
		
		relieve = ImageLoader.loadImage("/Menus/Tanque.png");
		fondo = ImageLoader.loadImage("/Menus/Fondo.jpg");
		
		jugar = ImageLoader.loadImage("/Menus/Jugar.png");
		salir = ImageLoader.loadImage("/Menus/Salir.png");
		título = ImageLoader.loadImage("/Menus/Título.png");
		tutorial = ImageLoader.loadImage("/Menus/Tutorial.png");
		
		corazón = ImageLoader.loadImage("/Menus/Corazón.png");
		vidas = ImageLoader.loadImage("/Menus/Vidas.png");
		reloj = ImageLoader.loadImage("/Menus/Reloj.png");
		tiempo = ImageLoader.loadImage("/Menus/Tiempo.png");
		SModo = ImageLoader.loadImage("/Menus/SModo.png");
		
		escenario1 = ImageLoader.loadImage("/Menus/Scenario1.png");
		escenario2 = ImageLoader.loadImage("/Menus/Scenario2.png");
		escenario3 = ImageLoader.loadImage("/Menus/Scenario3.png");
		escenario4 = ImageLoader.loadImage("/Menus/Scenario4.png");
		SEscenario = ImageLoader.loadImage("/Menus/SEscenario.png");
		
		CJugar = ImageLoader.loadImage("/Menus/CJugar.png");
		imagenTutorial1 = ImageLoader.loadImage("/Menus/Mover.png");
		imagenTutorial2 = ImageLoader.loadImage("/Menus/Proyectil.png");
		imagenTutorial3 = ImageLoader.loadImage("/Menus/Proyectil.png");  //CORREGIR
		imagenTutorial4 = ImageLoader.loadImage("/Menus/TankSprite.png");
		imagenTutorial5 = ImageLoader.loadImage("/Menus/Corazón.png");
		imagenTutorial6 = ImageLoader.loadImage("/Menus/Reloj.png");
		textoTutorial1 = ImageLoader.loadImage("/Menus/Instrucción1.png");
		textoTutorial2 = ImageLoader.loadImage("/Menus/Instrucción2.png");
		textoTutorial3 = ImageLoader.loadImage("/Menus/Instrucción3.png");
		textoTutorial4 = ImageLoader.loadImage("/Menus/Instrucción4.png");
		textoTutorial5 = ImageLoader.loadImage("/Menus/Instrucción5.png");
		textoTutorial6 = ImageLoader.loadImage("/Menus/Instrucción6.png");
		
		atrás1 = ImageLoader.loadImage("/Menus/Atrás.png");
		atrás2 = ImageLoader.loadImage("/Menus/Atrás.png");
		atrás3 = ImageLoader.loadImage("/Menus/Atrás.png");
	}
}
