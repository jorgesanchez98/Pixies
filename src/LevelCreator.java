import java.awt.Color;
import java.awt.image.BufferedImage;

import image.Assets;

// Clase encargada de Spawnear enemigos y llevar el control del nivel
public class LevelCreator {
	// Requiere del Handler para añadirle a los enemigos
	private Handler handler;
	private BufferedImage level;
	// Constructor que requiere del Handler
	public LevelCreator (Handler handler)
	{
		this.handler = handler;
		this.level = Assets.level;
		
		int w=level.getWidth();
		int h=level.getHeight();
		for (int yy=0;yy<h;yy++) {
			for (int xx=0;xx<w;xx++) {
				int pixel=level.getRGB(xx, yy);
				int red= (pixel>>16)& 0xff;
				int green= (pixel>>8)& 0xff;
				int blue= (pixel)& 0xff;
				if (red==0&&green==0&&blue==0) {
					handler.addObj(new Block(xx*30, yy*30, 31, 31, Assets.block, handler));
				}		
				if (red==0&&green==0&&blue==255) {
					//handler.addObj(new Target(xx*30, yy*30, 31, 31, Assets.block2, handler));
				}	
			}
		}
	}
}
