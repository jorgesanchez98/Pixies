import java.awt.Graphics;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

//Manejador de objetos
public class Handler {
	private boolean win=false;
	
	 // CopyOnWriteArrayList permite modificar la lista aún cuando se corren varios procesos	
	public CopyOnWriteArrayList <GameObject> obj;

	// Constructor
	public Handler(){
		obj = new CopyOnWriteArrayList <GameObject>();
	}
	
	// Actualizador
	public void tick() {
		ListIterator <GameObject> iterator = obj.listIterator();
		while (iterator.hasNext()) {
			GameObject aux = iterator.next();
			if (!aux.getAlive())
				removeObj(aux);
			aux.tick();
		}
	}
	
	//Render
	public void render(Graphics g){
		ListIterator <GameObject> iterator = obj.listIterator();
		while (iterator.hasNext()){
			GameObject aux = iterator.next();
			aux.paint(g);
		}
	}
	
	//Añadir objetos
	public void addObj(GameObject obj){
		this.obj.add(obj);
	}
	//Eliminar objetos
	public void removeObj(GameObject obj) {
		this.obj.remove(obj);
	}
	
	//Setters-Getters
	public boolean isWin() {
		return win;
	}
	public void setWin(boolean win) {
		this.win = win;
	}
	
}
