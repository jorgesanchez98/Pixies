import java.awt.image.BufferedImage;

import image.Assets;

//Layout del nivel
public class LevelCreator {
	
	//Variables
	private Handler handler;
	private BufferedImage level;
	Menu menu = new Menu(720,480);
	
	// Constructor
	public LevelCreator(Handler handler){
		this.handler = handler;
		
		switch(menu.getEscenario()) {
		case 1: this.level = Assets.level1; break;
		case 2: this.level = Assets.level2; break;
		case 3: this.level = Assets.level3; break;
		case 4: this.level = Assets.level4; break;
		}
		
		int w = level.getWidth();
		int h = level.getHeight();
		
		for(int yy=0;yy<h;yy++) {
			for(int xx=0;xx<w;xx++) {
				int pixel=level.getRGB(xx, yy);
				int red= (pixel>>16)& 0xff;
				int green= (pixel>>8)& 0xff;
				int blue= (pixel)& 0xff;
				if(red==0 && green==0 && blue==0) {
					switch(menu.getEscenario()) {
					case 1: handler.addObj(new Block(xx*30, yy*30, 31, 31, Assets.block, handler)); break;
					case 2: handler.addObj(new Block(xx*30, yy*30, 31, 31, Assets.woodlog, handler)); break;
					case 3: handler.addObj(new Block(xx*30, yy*30, 31, 31, Assets.block, handler)); break;
					case 4:	handler.addObj(new Block(xx*30, yy*30, 31, 31, Assets.woodlog, handler)); break;
					}
				}		
				if(red==0 && green==0 && blue==255) {
					handler.addObj(new Target(xx*30, yy*30, 31, 31, Assets.block2, handler));
				}
				if(red==0 && green==255 && blue==0) {
					switch(menu.getEscenario()) {
					case 1: handler.addObj(new Rocket(xx*30, yy*30, 31, 31, Assets.rocketPU, handler)); break;
					case 2: handler.addObj(new Rocket(xx*30, yy*30, 31, 31, Assets.torpedo, handler)); break;
					case 3: handler.addObj(new Rocket(xx*30, yy*30, 31, 31, Assets.rocketPU, handler)); break;
					case 4: handler.addObj(new Rocket(xx*30, yy*30, 31, 31, Assets.torpedo, handler)); break;
					}
					
				}
			}
		}
	}
}

