package image;
import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage background, block, block2, tankU, tankL,Rbullet, tankD, tankR, bullet, rocketPU;
	public static BufferedImage level1, level2, level3, level4;
	public static BufferedImage relieve, fondo;
	public static BufferedImage jugar, salir, titulo, tutorial;
	public static BufferedImage corazon, vidas, reloj, tiempo, SModo;
	public static BufferedImage escenario1, escenario2, escenario3, escenario4, SEscenario;
	public static BufferedImage CJugar, imagenTutorial1, imagenTutorial2, imagenTutorial3, imagenTutorial4, imagenTutorial5, imagenTutorial6;
	public static BufferedImage textoTutorial1, textoTutorial2, textoTutorial3, textoTutorial4, textoTutorial5, textoTutorial6;
	public static BufferedImage atras1, atras2, atras3;
	public static BufferedImage life;

	
	public static void init() {
		background = ImageLoader.loadImage("/Textures/background.png");
		level1 = ImageLoader.loadImage("/Textures/level1.png");
		level2 = ImageLoader.loadImage("/Textures/level2.png");
		level3 = ImageLoader.loadImage("/Textures/level3.png");
		level4 = ImageLoader.loadImage("/Textures/level4.png");
		rocketPU = ImageLoader.loadImage("/Textures/rocketPU.png");
		block = ImageLoader.loadImage("/Textures/brick.png");
		block2 = ImageLoader.loadImage("/Textures/brick2.png");
		tankU = ImageLoader.loadImage("/Textures/triTank.png");
		tankL = ImageLoader.loadImage("/Textures/triTankLeft.png");
		tankD = ImageLoader.loadImage("/Textures/triTankDown.png");
		tankR = ImageLoader.loadImage("/Textures/triTankRight.png");
		bullet = ImageLoader.loadImage("/Textures/bullet.png");
		Rbullet = ImageLoader.loadImage("/Textures/Rbullet.png");
		relieve = ImageLoader.loadImage("/Menus/Tanque.png");
		fondo = ImageLoader.loadImage("/Menus/Fondo.jpg");
		life = ImageLoader.loadImage("/Textures/Life.png");
		
		jugar = ImageLoader.loadImage("/Menus/Jugar.png");
		salir = ImageLoader.loadImage("/Menus/Salir.png");
		titulo = ImageLoader.loadImage("/Menus/Titulo.png");
		tutorial = ImageLoader.loadImage("/Menus/Tutorial.png");
		
		corazon = ImageLoader.loadImage("/Menus/Corazon.png");
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
		imagenTutorial3 = ImageLoader.loadImage("/Menus/RocketPU.png");  
		imagenTutorial4 = ImageLoader.loadImage("/Menus/TankSprite.png");
		imagenTutorial5 = ImageLoader.loadImage("/Menus/Corazon.png");
		imagenTutorial6 = ImageLoader.loadImage("/Menus/Reloj.png");
		textoTutorial1 = ImageLoader.loadImage("/Menus/Instruccion1.png");
		textoTutorial2 = ImageLoader.loadImage("/Menus/Instruccion2.png");
		textoTutorial3 = ImageLoader.loadImage("/Menus/Instruccion3.png");
		textoTutorial4 = ImageLoader.loadImage("/Menus/Instruccion4.png");
		textoTutorial5 = ImageLoader.loadImage("/Menus/Instruccion5.png");
		textoTutorial6 = ImageLoader.loadImage("/Menus/Instruccion6.png");
		
		atras1 = ImageLoader.loadImage("/Menus/Atras.png");
		atras2 = ImageLoader.loadImage("/Menus/Atras.png");
		atras3 = ImageLoader.loadImage("/Menus/Atras.png");
	}
}
