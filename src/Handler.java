import java.awt.Graphics;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

//Manejador de objetos
public class Handler {
	
	//Variables
	private boolean win = false;
	
	 //CopyOnWriteArrayList modifica la lista durante varios procesos	
	public CopyOnWriteArrayList <GameObject> obj;

	//Constructor
	public Handler(){
		obj = new CopyOnWriteArrayList <GameObject>();
	}
	
	//Actualizador
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
	
	//Control de objetos
	public void addObj(GameObject obj){
		this.obj.add(obj);
	}
	public void removeObj(GameObject obj) {
		this.obj.remove(obj);
	}	
}
