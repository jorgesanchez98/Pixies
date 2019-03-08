import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	//Instance variables
	private BufferedImage image;
	JButton play, exit, help;
	JPanel panel;
	JLabel label;
	
	//Constructors for decorating elements
	Color color = new Color(90,90,90);
	Color title = new Color(255,222,0);
	Font font = new Font("Times New Roman",Font.PLAIN,60);
	
	//Constructor
	public Menu() {
		super();
		
		//Set layout and background color
		setLayout(null);
		getContentPane().setBackground(color);
		
		//Create JFrame elements
		play = new JButton();
		exit = new JButton();
		help = new JButton();
		panel = new JPanel();
		label = new JLabel();
		
		//Upload images for buttons
		try {
			image = ImageIO.read(getClass().getResource("/Play.png"));
			play.setIcon(new ImageIcon(image));
		} catch (IOException IOE){ 
			IOE.printStackTrace();
		}
		try {
			image = ImageIO.read(getClass().getResource("/Exit.png"));
			exit.setIcon(new ImageIcon(image));
		} catch (IOException IOE){ 
			IOE.printStackTrace();
		}
		
		//Add ActionListeners to buttons
		play.addActionListener(this);
		exit.addActionListener(this);
		help.addActionListener(this);
		
		//Set buttons dimensions
		play.setBounds(170,185,250,90);
		exit.setBounds(170,305,250,90);
		help.setBounds(520,570,60,80);

		
		//Set label attributes
		label.setBounds(140,40,400,100);
		label.setFont(font);
		label.setForeground(title);
		label.setText("Tank");
		
		//Add JFrame elements to the window
		add(play);
		add(exit);
		add(help);
		add(label);
	}
	
	//Set an action for every button when pressed
	public void actionPerformed(ActionEvent AE) {
		if(AE.getSource() == play) {
			
		} 
	}
}