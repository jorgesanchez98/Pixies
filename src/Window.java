import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window {
	
	//Variables
	private JFrame frame;
	private int width, height;
	private String title;
	public static Canvas canvas;
	
	//Constructor
	public Window(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		createWindow();
	}
	
	//Crear ventana
	public void createWindow() {
		frame = new JFrame(title);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width, screenSize.height);
		frame.setPreferredSize(new Dimension(screenSize.width, screenSize.height));
		frame.setMinimumSize(new Dimension(screenSize.width, screenSize.height));
		frame.setMaximumSize(new Dimension (screenSize.width, screenSize.height));
		frame.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight()));
		canvas.setMinimumSize(new Dimension(frame.getWidth(), frame.getHeight()));
		canvas.setMaximumSize(new Dimension (frame.getWidth(), frame.getHeight()));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
		frame.requestFocus();
	}
	
	public Canvas getCanvas() { 
		return canvas; 
	}
	public JFrame getFrame() { 
		return frame; 
	}
	public void dispose() {
		frame.dispose();
	}
}
