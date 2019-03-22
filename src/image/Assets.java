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
	public static BufferedImage background, level, block, tankU, tankL, tankD, tankR, bullet, rocketPU;
	public static BufferedImage rocketB, rocketBUp, rocketBDown, rocketBLeft,bomb;
	
	// En �ste m�todo se inicializan todas las im�genes que se van a ocupar
	public static void init()
	{
		// Se hace uso de la clase ImageLoader para cargar la im�gen 
		// (la clase debi� ser creada previamente)
		background = ImageLoader.loadImage("/Textures/background.png");
		level = ImageLoader.loadImage("/Textures/level.png");
		block = ImageLoader.loadImage("/Textures/brick.png");
		tankU = ImageLoader.loadImage("/Textures/triTank.png");
		tankL = ImageLoader.loadImage("/Textures/triTankLeft.png");
		tankD = ImageLoader.loadImage("/Textures/triTankDown.png");
		tankR = ImageLoader.loadImage("/Textures/triTankRight.png");
		bullet = ImageLoader.loadImage("/Textures/bullet.png");
		rocketPU = ImageLoader.loadImage("/Textures/rocketPU.png");
		rocketB = ImageLoader.loadImage("/Textures/rocketB.png");
		rocketBUp = ImageLoader.loadImage("/Textures/rocketBUp.png");
		rocketBDown = ImageLoader.loadImage("/Textures/rocketBDown.png");
		rocketBLeft = ImageLoader.loadImage("/Textures/rocketBLeft.png");
		bomb = ImageLoader.loadImage("/Textures/bomb.png");
	}
}
