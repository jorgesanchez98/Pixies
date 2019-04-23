import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
//import image.Assets;
import java.io.IOException;

import javax.imageio.ImageIO;

import image.Assets;

public class Menu implements MouseListener, KeyListener {
	
	//Variables
	protected final int PWidth;
	protected final int PHeight;
	private int option = 0;
	
	Boton jugar;
	Boton salir;
	Boton tutorial;
	Boton titulo;
	
	Boton corazon;
	Boton vidas;
	Boton reloj;
	Boton tiempo;
	Boton SModo;
	
	Boton atras1;
	Boton atras2;
	Boton atras3;
	
	Boton escenario1;
	Boton escenario2;
	Boton escenario3;
	Boton escenario4;
	Boton SEscenario;
	
	Boton CJugar;
	Boton imagenTutorial1;
	Boton imagenTutorial2;
	Boton imagenTutorial3;
	Boton imagenTutorial4;
	Boton imagenTutorial5;
	Boton imagenTutorial6;
	Boton textoTutorial1;
	Boton textoTutorial2;
	Boton textoTutorial3;
	Boton textoTutorial4;
	Boton textoTutorial5;
	Boton textoTutorial6;
	
	//Constructor
	public Menu(int PWidth, int PHeight) {
		this.PWidth = PWidth;
		this.PHeight = PHeight;
		
		jugar = new Boton(270,180,180,100);
		salir = new Boton(270,300,180,100);
		tutorial = new Boton(647,397,78,100);
		titulo = new Boton(239,20,242,160);
		
		corazon = new Boton(140,130,200,200);
		vidas = new Boton(140,330,200,100);
		reloj = new Boton(380,130,200,200);
		tiempo = new Boton(380,330,200,100);
		SModo = new Boton(85,30,550,97);
		
		atras1 = new Boton(-15,395,96,100);
		atras2 = new Boton(-15,395,96,100);
		atras3 = new Boton(-15,395,96,100);
		
		escenario1 = new Boton(200,120,150,150);
		escenario2 = new Boton(370,120,150,150);
		escenario3 = new Boton(200,290,150,150);
		escenario4 = new Boton(370,290,150,150);
		SEscenario = new Boton(90,30,550,100);
		
		CJugar = new Boton(175,10,366,130);
		imagenTutorial1 = new Boton(130,120,50,50);
		imagenTutorial2 = new Boton(130,170,50,50);
		imagenTutorial3 = new Boton(130,220,50,50);
		imagenTutorial4 = new Boton(130,270,50,50);
		imagenTutorial5 = new Boton(130,320,50,50);
		imagenTutorial6 = new Boton(130,370,50,50);
		textoTutorial1 = new Boton(190,120,420,50);
		textoTutorial2 = new Boton(190,170,420,50);
		textoTutorial3 = new Boton(190,220,420,50);
		textoTutorial4 = new Boton(190,270,420,50);
		textoTutorial5 = new Boton(190,320,420,50);
		textoTutorial6 = new Boton(190,360,420,76);
	}
	
	//Setters-Getters
	public void setOption(int option) {
		this.option = option;
	}
	public int getOption() {
		return option;
	}
	
	//Paint
	public void draw(Graphics2D g) {
	    g.drawImage(Assets.fondo,0,0,720,480,null);
		g.drawImage(Assets.relieve,55,0,610,500,null);
		
		if(option == 0) { 
			//Menú principal
			jugar.paint(g, Assets.jugar); 
			salir.paint(g, Assets.salir);
			tutorial.paint(g, Assets.tutorial);
			titulo.paint(g, Assets.titulo);
		} else if(option == 1) { 
			//Menú Modo de Juego
			corazon.paint(g, Assets.corazon);
			vidas.paint(g, Assets.vidas);
			reloj.paint(g, Assets.reloj);
			tiempo.paint(g, Assets.tiempo);
			atras1.paint(g, Assets.atras1);
			SModo.paint(g, Assets.SModo);
		} else if(option == 2) { 
			//Menú escenario
			escenario1.paint(g, Assets.escenario1);
			escenario2.paint(g, Assets.escenario2);
			escenario3.paint(g, Assets.escenario3);
			escenario4.paint(g, Assets.escenario4);
			atras2.paint(g, Assets.atras2);
			SEscenario.paint(g, Assets.SEscenario);
		} else if(option == 3) { 
			//Inciar juego
			option = -1;
			Game game = new Game("Tank",720,480);
			game.start();
		} else if(option == 4) { 
			//Menú tutorial
			CJugar.paint(g, Assets.CJugar);
			imagenTutorial1.paint(g, Assets.imagenTutorial1);
			imagenTutorial2.paint(g, Assets.imagenTutorial2);
			imagenTutorial3.paint(g, Assets.imagenTutorial3);
			imagenTutorial4.paint(g, Assets.imagenTutorial4);
			imagenTutorial5.paint(g, Assets.imagenTutorial5);
			imagenTutorial6.paint(g, Assets.imagenTutorial6);
			textoTutorial1.paint(g, Assets.textoTutorial1);
			textoTutorial2.paint(g, Assets.textoTutorial2);
			textoTutorial3.paint(g, Assets.textoTutorial3);
			textoTutorial4.paint(g, Assets.textoTutorial4);
			textoTutorial5.paint(g, Assets.textoTutorial5);
			textoTutorial6.paint(g, Assets.textoTutorial6);
			atras3.paint(g, Assets.atras3);
		}
	}
	
	//Actualizar juego
	public void update() {
	}
	
	//MouseListener
	public void mouseClicked(MouseEvent ME) {
		System.out.println("Hello There");
		if(jugar.click(ME.getX(),ME.getY())) {
			System.out.println("Funciona");
			option = 1;
		} else if(salir.click(ME.getX(),ME.getY())) {
			System.exit(0);
		} else if(tutorial.click(ME.getX(),ME.getY())) {
			option = 4;
		} else if(corazon.click(ME.getX(),ME.getY()) || vidas.click(ME.getX(),ME.getY()) || reloj.click(ME.getX(),ME.getY()) || tiempo.click(ME.getX(),ME.getY())) {
			option = 2;
		} else if(atras1.click(ME.getX(),ME.getY())) {
			option = 0;
		} else if(atras2.click(ME.getX(),ME.getY())) {
			option = 1;
		} else if(escenario1.click(ME.getX(),ME.getY()) || escenario2.click(ME.getX(),ME.getY()) || escenario3.click(ME.getX(),ME.getY()) || escenario4.click(ME.getX(),ME.getY())) {
			option = 3;
		} else if(atras3.click(ME.getX(),ME.getY())) {
			option = 0;
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
	
	//KeyListener
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
	}
}