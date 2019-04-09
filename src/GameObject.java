import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

// Clase que define el comportamiento general de un objeto en el juego
public abstract class GameObject {
	// Tienen una posición x y y en el plano
	protected int x, y;
	// tienen una altura y una anchura (es un juego 2d)
	protected int width, height;
	// Pertenecen a un Handler
	protected Handler handler;
	//Si debe de seguir siendo dibujada o no
	public boolean alive;
	
	// Constructor en el que se piden todos los atributos requeridos
	public GameObject (int x, int y, int width, int height, Handler handler)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.handler = handler;
		alive=true;
	}
	
	// Todo objeto requiere ser pintado
	public abstract void paint(Graphics g);
	// Todo objeto requiere ser actualizado
	public abstract void tick();
	// Para obtener los bordes del objeto (nos ayuda con las colisiones)
	public abstract Rectangle getBounds();
	
	public boolean placeMeeting (double x, double y, GameObject obj)
	{
		// revisa si el rectángulo del otro objeto intersecta con el rectángulo del personaje
		if ((new Rectangle((int)x, (int)y, width, height)).intersects(obj.getBounds())) 
			return true;
		return false;
	}
	
	// A partir de aquí son los getters y setters
	public int getX()
	{
		return (int)x;
	}
	public int getY()
	{
		return (int)y;
	}
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public void setWidth(int width)
	{
		this.width = width;
	}
	public void setHeight(int height)
	{
		this.height = height;
	}

	public boolean getAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
}
