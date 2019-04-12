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
	public static BufferedImage background, rocketPU, level, block, block2, tankU, tankL, tankD, tankR,bullet,Rbullet;

	
	// En éste método se inicializan todas las imágenes que se van a ocupar
	public static void init()
	{
		// Se hace uso de la clase ImageLoader para cargar la imágen 
		// (la clase debió ser creada previamente)
		background = ImageLoader.loadImage("/Textures/background.png");
		level = ImageLoader.loadImage("/Textures/level.png");
		block = ImageLoader.loadImage("/Textures/brick.png");
		block2 = ImageLoader.loadImage("/Textures/brick2.png");
		tankU = ImageLoader.loadImage("/Textures/triTank.png");
		tankL = ImageLoader.loadImage("/Textures/triTankLeft.png");
		tankD = ImageLoader.loadImage("/Textures/triTankDown.png");
		tankR = ImageLoader.loadImage("/Textures/triTankRight.png");
		bullet = ImageLoader.loadImage("/Textures/bullet.png");
		Rbullet = ImageLoader.loadImage("/Textures/Rbullet.png");
		rocketPU = ImageLoader.loadImage("/Textures/rocketPU.png");
	}
}
