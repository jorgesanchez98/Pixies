import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DefCanvas extends Canvas implements MouseListener {
	
	//Instance variables
	private int option = 0;
	
	public DefCanvas() {
		super();
		option = 0;
		try {
			block = ImageIO.read(getClass().getResource("/Tanque.png"));
		} catch (IOException IOE){ 
			IOE.printStackTrace();
		}
		addMouseListener(this);
	}
	
	//Setters-Getters
	public void setOption(int option) {
		this.option = option;
	}
	public int getOption() {
		return option;
	}

	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}
