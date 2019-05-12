import java.awt.Graphics;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

//Manejador de objetos
public class Handler {
	private boolean win=false;
	
	 // CopyOnWriteArrayList modifica la lista durante varios procesos	
	public CopyOnWriteArrayList <GameObject> obj;

	// Constructor
	public Handler(){
		obj = new CopyOnWriteArrayList <GameObject>();
	}
	
	// Actualizador
	public void tick() {
		ListIterator <GameObject> itr = obj.listIterator();
		while (itr.hasNext()) {
			GameObject GO = itr.next();
			if (!GO.getAlive())
				removeObj(GO);
			GO.tick();
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
