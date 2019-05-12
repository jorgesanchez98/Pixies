import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import image.Assets;
public class Boton {

	//Variables
	private int x;
	private int y;
	private int height;
	private int width;
	
	//Constructor
	public Boton(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width  = width;
	}
	
	//Setters-Getters
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return y;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getWidth() {
		return width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getHeight() {
		return height;
	}
	public void setSize(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	//Paint
	public void paint(Graphics2D g, BufferedImage BI) {
		g.drawImage(BI,x,y,width,height,null);
	}
	
	//Detección de click
	public boolean click(int mx, int my) {
		boolean detection = false;
		if(x<mx && x+width>mx && y<my && y+height>my) {
			detection = true;
		}
		return detection;	
	}
}
