import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	
	Boton victoria1;
	Boton victoria2;
	Boton empate;
	Boton volver;
	Boton salir2;
	
	Handler handler = new Handler();
	Player1 P1 = new Player1(80,200,32,32,Assets.tankU,handler,1);
	Player2 P2 = new Player2(150,200,32,32,Assets.tankU,handler,1);
	
	//Constructor
	public Menu(int PWidth, int PHeight) {
		this.PWidth = PWidth;
		this.PHeight = PHeight;
		
		jugar = new Boton(270,180,180,100);
		salir = new Boton(270,300,180,100);
		tutorial = new Boton(647,397,78,100);
		titulo = new Boton(239,20,242,160);
		
		corazon = new Boton(130,130,200,200);
		vidas = new Boton(135,330,190,100);
		reloj = new Boton(390,130,200,200);
		tiempo = new Boton(390,330,200,100);
		SModo = new Boton(85,30,550,97);
		atras1 = new Boton(-15,395,96,100);
		
		escenario1 = new Boton(125,120,225,150);
		escenario2 = new Boton(375,120,225,150);
		escenario3 = new Boton(125,290,225,150);
		escenario4 = new Boton(375,290,225,150);
		SEscenario = new Boton(90,30,550,100);
		atras2 = new Boton(-15,395,96,100);
		
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
		atras3 = new Boton(-15,395,96,100);
		
		victoria1 = new Boton(60,20,600,135);
		victoria2 = new Boton(60,20,600,135);
		empate = new Boton(200,20,320,135);
		volver = new Boton(270,180,180,100);
		salir2 = new Boton(270,300,180,100);
		
	}
	
	//Controladores de botones 
	public void borrarPrincipal() {
		jugar.setSize(1,1,1,1);
		salir.setSize(1,1,1,1);
		tutorial.setSize(1,1,1,1);
		titulo.setSize(1,1,1,1);
	}
	public void reestablecerPrincipal() {
		jugar.setSize(270,180,180,100);
		salir.setSize(270,300,180,100);
		tutorial.setSize(647,397,78,100);
		titulo.setSize(239,20,242,160);
	}
	public void borrarModalidad() {
		corazon.setSize(1,1,1,1);
		vidas.setSize(1,1,1,1);
		reloj.setSize(1,1,1,1);
		tiempo.setSize(1,1,1,1);
		SModo.setSize(1,1,1,1);
		atras1.setSize(1,1,1,1);
	}
	public void reestablecerModalidad() {
		corazon.setSize(130,130,200,200);
		vidas.setSize(135,330,190,100);
		reloj.setSize(390,130,200,200);
		tiempo.setSize(390,330,200,100);
		SModo.setSize(85,30,550,97);
		atras1.setSize(-15,395,96,100);
	}
	public void borrarEscenario() {
		escenario1.setSize(1,1,1,1);
		escenario2.setSize(1,1,1,1);
		escenario3.setSize(1,1,1,1);
		escenario4.setSize(1,1,1,1);
		SEscenario.setSize(1,1,1,1);
		atras2.setSize(1,1,1,1);
	}
	public void reestablecerEscenario() {
		escenario1.setSize(125,120,225,150);
		escenario2.setSize(375,120,225,150);
		escenario3.setSize(125,290,225,150);
		escenario4.setSize(375,290,225,150);
		SEscenario.setSize(90,30,550,100);
		atras2.setSize(-15,395,96,100);
	}
	public void borrarTutorial() {
		CJugar.setSize(1,1,1,1);
		imagenTutorial1.setSize(1,1,1,1);
		imagenTutorial2.setSize(1,1,1,1);
		imagenTutorial3.setSize(1,1,1,1);
		imagenTutorial4.setSize(1,1,1,1);
		imagenTutorial5.setSize(1,1,1,1);
		imagenTutorial6.setSize(1,1,1,1);
		textoTutorial1.setSize(1,1,1,1);
		textoTutorial2.setSize(1,1,1,1);
		textoTutorial3.setSize(1,1,1,1);
		textoTutorial4.setSize(1,1,1,1);
		textoTutorial5.setSize(1,1,1,1);
		textoTutorial6.setSize(1,1,1,1);
		atras3.setSize(1,1,1,1);
	}
	public void reestablecerTutorial() {
		CJugar.setSize(175,10,366,130);
		imagenTutorial1.setSize(130,120,50,50);
		imagenTutorial2.setSize(130,170,50,50);
		imagenTutorial3.setSize(130,220,50,50);
		imagenTutorial4.setSize(130,270,50,50);
		imagenTutorial5.setSize(130,320,50,50);
		imagenTutorial6.setSize(130,370,50,50);
		textoTutorial1.setSize(190,120,420,50);
		textoTutorial2.setSize(190,170,420,50);
		textoTutorial3.setSize(190,220,420,50);
		textoTutorial4.setSize(190,270,420,50);
		textoTutorial5.setSize(190,320,420,50);
		textoTutorial6.setSize(190,360,420,76);
		atras3.setSize(-15,395,96,100);
	}
	public void borrarVictoria() {
		victoria1.setSize(1,1,1,1);
		victoria2.setSize(1,1,1,1);
		empate.setSize(1,1,1,1);
		volver.setSize(1,1,1,1);
		salir2.setSize(1,1,1,1);
	}
	public void reestablecerVictoria() {
		victoria1.setSize(60,20,600,135);
		victoria2.setSize(60,20,600,135);
		empate.setSize(200,20,320,135);
		volver.setSize(270,180,180,100);
		salir2.setSize(270,300,180,100);
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
			//Menú principal
			borrarEscenario();
			borrarModalidad();
			borrarTutorial();
			borrarVictoria();
			reestablecerPrincipal();
			jugar.paint(g, Assets.jugar); 
			salir.paint(g, Assets.salir);
			tutorial.paint(g, Assets.tutorial);
			titulo.paint(g, Assets.titulo);
			
		} else if(option == 1) { 
			//Menú Modo de Juego
			borrarEscenario();
			borrarPrincipal();
			borrarTutorial();
			borrarVictoria();
			reestablecerModalidad();
			corazon.paint(g, Assets.corazon);
			vidas.paint(g, Assets.vidas);
			reloj.paint(g, Assets.reloj);
			tiempo.paint(g, Assets.tiempo);
			SModo.paint(g, Assets.SModo);
			atras1.paint(g, Assets.atras1);
			borrarEscenario();
			
		} else if(option == 2) { 
			//Menú escenario
			borrarPrincipal();
			borrarModalidad();
			borrarTutorial();
			borrarVictoria();
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
			//Menú tutorial
			borrarPrincipal();
			borrarModalidad();
			borrarEscenario();
			borrarVictoria();
			reestablecerTutorial();
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
			
		} else if(option == 5) {
			//Menú Ganador
			borrarPrincipal();
			borrarModalidad();
			borrarEscenario();
			borrarTutorial();
			reestablecerVictoria();
			if(P1.getPuntos()>P2.getPuntos() || P2.getVidas()<=0) {
				victoria1.paint(g, Assets.victoria1);
			} else if(P1.getPuntos()<P2.getPuntos() || P1.getVidas()<=0) {
				victoria2.paint(g, Assets.victoria2);
			} else if(P1.getPuntos()==P2.getPuntos()) {
				empate.paint(g, Assets.empate);
			}
			volver.paint(g, Assets.volver);
			salir2.paint(g, Assets.salir);
		}
	}

	//Actualizar juego
	public void update() {
	}
	
	//MouseListener
	public void mouseClicked(MouseEvent ME) {
		//Menú principal
		if(jugar.click(ME.getX(),ME.getY())) {
			option = 1;
		} else if(salir.click(ME.getX(),ME.getY())) {
			System.exit(0);
		} else if(tutorial.click(ME.getX(),ME.getY())) {
			option = 4;
		} 
		
		//Menú Modo de Juego
		if(corazon.click(ME.getX(), ME.getY())) {
			modo = 1;
			option = 2;
		} else if(reloj.click(ME.getX(),ME.getY())) {
			modo = 2;
			option = 2;
		} else if(atras1.click(ME.getX(),ME.getY())) {
			option = 0;
		} 
		
		//Menú Escenario
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
		
		//Menú Tutorial
		if(atras3.click(ME.getX(),ME.getY())) {
			option = 0;
		} 
		
		//Menu Victoria
		if(volver.click(ME.getX(),ME.getY())) {
			option = 0;
		} else if(salir2.click(ME.getX(),ME.getY())) {
			System.exit(0);
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