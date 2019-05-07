import java.awt.Font;
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
	private static int option = 0;
	private static int escenario = 0;
	private static int modo = 0;

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
		
		corazon = new Boton(120,130,200,200);
		vidas = new Boton(125,330,190,100);
		reloj = new Boton(400,130,200,200);
		tiempo = new Boton(400,330,200,100);
		SModo = new Boton(85,30,550,97);
		atras1 = new Boton(-15,395,96,100);
		
		escenario1 = new Boton(160,120,150,150);
		escenario2 = new Boton(410,120,150,150);
		escenario3 = new Boton(160,290,150,150);
		escenario4 = new Boton(410,290,150,150);
		SEscenario = new Boton(90,30,550,100);
		atras2 = new Boton(-15,320,96,100);
		
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
		atras3 = new Boton(-15,0,96,100);
	}
	
	public void borrarPrincipal() {
		jugar.setSize(1,1,1,1);
		salir.setSize(1,1,1,1);
		tutorial.setSize(1,1,1,1);
		titulo.setSize(1,1,1,1);
	}

	public void borrarModalidad() {
		corazon.setWidth(1);
		corazon.setHeight(1);
		vidas.setWidth(1);
		vidas.setHeight(1);
		reloj.setWidth(1);
		reloj.setHeight(1);
		tiempo.setWidth(1);
		tiempo.setHeight(1);
		SModo.setWidth(1);
		SModo.setHeight(1);
		atras1.setWidth(1);
		atras1.setHeight(1);
	}
	public void borrarEscenario() {
		escenario1.setWidth(1);
		escenario1.setHeight(1);
		escenario2.setWidth(1);
		escenario2.setHeight(1);
		escenario3.setWidth(1);
		escenario3.setHeight(1);
		escenario4.setWidth(1);
		escenario4.setHeight(1);
		SEscenario.setWidth(1);
		SEscenario.setHeight(1);
		atras2.setWidth(1);
		atras2.setHeight(1);
	}
	public void reestablecerEscenario() {
		escenario1.setWidth(150);
		escenario1.setHeight(150);
		escenario2.setWidth(150);
		escenario2.setHeight(150);
		escenario3.setWidth(150);
		escenario3.setHeight(150);
		escenario4.setWidth(150);
		escenario4.setHeight(150);
		SEscenario.setWidth(550);
		SEscenario.setHeight(100);
		atras2.setWidth(96);
		atras2.setHeight(100);
	}
	public void borrarTutorial() {
		CJugar = null;
		imagenTutorial1.setWidth(0);
		imagenTutorial1.setHeight(0);
		imagenTutorial2.setWidth(0);
		imagenTutorial2.setHeight(0);
		imagenTutorial3.setWidth(0);
		imagenTutorial3.setHeight(0);
		imagenTutorial4.setWidth(0);
		imagenTutorial4.setHeight(0);
		imagenTutorial5.setWidth(0);
		imagenTutorial5.setHeight(0);
		imagenTutorial6.setWidth(0);
		imagenTutorial6.setHeight(0);
		textoTutorial1.setWidth(0);
		textoTutorial1.setHeight(0);
		textoTutorial2.setWidth(0);
		textoTutorial2.setHeight(0);
		textoTutorial3.setWidth(0);
		textoTutorial3.setHeight(0);
		textoTutorial4.setWidth(0);
		textoTutorial4.setHeight(0);
		textoTutorial5.setWidth(0);
		textoTutorial5.setHeight(0);
		textoTutorial6.setWidth(0);
		textoTutorial6.setHeight(0);
		atras3.setWidth(0);
		atras3.setHeight(0);
	}
	
	//Setters-Getters
	public void setOption(int option) {
		this.option = option;
	}
	public int getOption() {
		return option;
	}
	public void setModo(int modo) {
		this.modo = modo;
	}
	public int getModo() {
		return modo;
	}
	public void setEscenario(int escenario) {
		this.escenario = escenario;
	}
	public int getEscenario() {
		return escenario;
	}
	
	//Paint
	public void draw(Graphics2D g) {
	    g.drawImage(Assets.fondo,0,0,720,480,null);
		g.drawImage(Assets.relieve,55,0,610,500,null);
		
		if(option == 0) { 
			//Men� principal
			jugar.paint(g, Assets.jugar); 
			salir.paint(g, Assets.salir);
			tutorial.paint(g, Assets.tutorial);
			titulo.paint(g, Assets.titulo);
			
		} else if(option == 1) { 
			//Men� Modo de Juego
			corazon.paint(g, Assets.corazon);
			vidas.paint(g, Assets.vidas);
			reloj.paint(g, Assets.reloj);
			tiempo.paint(g, Assets.tiempo);
			SModo.paint(g, Assets.SModo);
			atras1.paint(g, Assets.atras1);
			borrarEscenario();
			
		} else if(option == 2) { 
			//Men� escenario
			reestablecerEscenario();
			escenario1.paint(g, Assets.escenario1);
			escenario2.paint(g, Assets.escenario2);
			escenario3.paint(g, Assets.escenario3);
			escenario4.paint(g, Assets.escenario4);
			SEscenario.paint(g, Assets.SEscenario);
			atras2.paint(g, Assets.atras2);
			
		} else if(option == 3) { 
			//Inciar juego
			option = -1;
			Game game = new Game("Tank",720,480);
			game.start();
			
		} else if(option == 4) { 
			//Men� tutorial
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
	/*
	public void drawWin(Graphics2D g, int P1V, int P2V, int P1P, int P2P, int T) {
		Font font = new Font("Times New Roman",Font.PLAIN,40);
		g.setFont(font);
		if(modo == 1) {
			if(P1V>P2V) {
				g.drawString("�Gana P1!", 300, 100);
			} else if(P2V>P1V) {
				g.drawString("�Gana P2!", 300, 100);
			}
		} else if(modo == 2) {
			if(T<=0) {
				if(P1P>P2P) {
					g.drawString("�Gana P1!", 300, 100);
				} else if(P2P>P1P) {
					g.drawString("�Gana P2!", 300, 100);
				}
			}
		}
	}
	*/
	//Actualizar juego
	public void update() {
	}
	
	//MouseListener
	public void mouseClicked(MouseEvent ME) {
		if(jugar.click(ME.getX(),ME.getY())) {
			System.out.println("Funciona");
			option = 1;
			borrarPrincipal();
		} else if(salir.click(ME.getX(),ME.getY())) {
			System.exit(0);
		} else if(tutorial.click(ME.getX(),ME.getY())) {
			option = 4;
		} 
		
		if(corazon.click(ME.getX(), ME.getY())) {
			modo = 1;
			option = 2;
		} else if(reloj.click(ME.getX(),ME.getY())) {
			modo = 2;
			option = 2;
		} else if(atras1.click(ME.getX(),ME.getY())) {
			option = 0;
		} 
		
		if(escenario1.click(ME.getX(),ME.getY())) {
			escenario = 1;
			option = 3;
		} else if(escenario2.click(ME.getX(),ME.getY())) {
			escenario = 2;
			option = 3;
		} else if(escenario3.click(ME.getX(),ME.getY())) {
			escenario = 3;
			option = 3;
		} else if(escenario4.click(ME.getX(),ME.getY())) {
			escenario = 4;
			option = 3;
		} else if(atras2.click(ME.getX(),ME.getY())) {
			option = 1;
		} 
		
		if(atras3.click(ME.getX(),ME.getY())) {
			option = 0;
		} 
		System.out.println("Opci�n " + option);
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