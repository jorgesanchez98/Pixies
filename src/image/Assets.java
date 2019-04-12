package image;

// Se importan las librer�as a ocupar
import java.awt.image.BufferedImage;

public class Assets {
	
	// Aqu� se cargan todas las im�genes que se requieran en el juego
	// Es est�tico y p�blico dado a que requerimos acceder a ellas desde varias clases
	/*
	 * Ejemplo de BufferedImage con varias im�genes:
	 * public static BufferedImage background, player, c	loud, enemy...; 
	*/
	public static BufferedImage background, level, block, block2, tankU, tankL, tankD, tankR, bullet;
	public static BufferedImage relieve, fondo;
	public static BufferedImage jugar, salir, t�tulo, tutorial;
	public static BufferedImage coraz�n, vidas, reloj, tiempo, SModo;
	public static BufferedImage escenario1, escenario2, escenario3, escenario4, SEscenario;
	public static BufferedImage CJugar, imagenTutorial1, imagenTutorial2, imagenTutorial3, imagenTutorial4, imagenTutorial5, imagenTutorial6;
	public static BufferedImage textoTutorial1, textoTutorial2, textoTutorial3, textoTutorial4, textoTutorial5, textoTutorial6;
	public static BufferedImage atr�s1, atr�s2, atr�s3;

	
	// En �ste m�todo se inicializan todas las im�genes que se van a ocupar
	public static void init()
	{
		// Se hace uso de la clase ImageLoader para cargar la im�gen 
		// (la clase debi� ser creada previamente)
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
		t�tulo = ImageLoader.loadImage("/Menus/T�tulo.png");
		tutorial = ImageLoader.loadImage("/Menus/Tutorial.png");
		
		coraz�n = ImageLoader.loadImage("/Menus/Coraz�n.png");
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
		imagenTutorial5 = ImageLoader.loadImage("/Menus/Coraz�n.png");
		imagenTutorial6 = ImageLoader.loadImage("/Menus/Reloj.png");
		textoTutorial1 = ImageLoader.loadImage("/Menus/Instrucci�n1.png");
		textoTutorial2 = ImageLoader.loadImage("/Menus/Instrucci�n2.png");
		textoTutorial3 = ImageLoader.loadImage("/Menus/Instrucci�n3.png");
		textoTutorial4 = ImageLoader.loadImage("/Menus/Instrucci�n4.png");
		textoTutorial5 = ImageLoader.loadImage("/Menus/Instrucci�n5.png");
		textoTutorial6 = ImageLoader.loadImage("/Menus/Instrucci�n6.png");
		
		atr�s1 = ImageLoader.loadImage("/Menus/Atr�s.png");
		atr�s2 = ImageLoader.loadImage("/Menus/Atr�s.png");
		atr�s3 = ImageLoader.loadImage("/Menus/Atr�s.png");
	}
}
