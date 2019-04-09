

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class SpriteBuilder {
	private BufferedImage spriteSheet;
	private List<BufferedImage>images;
	private int cellW, cellH;
	
	public SpriteBuilder (String fName, int cellW, int cellH) {
		try {
			spriteSheet= (BufferedImage)ImageIO.read(getClass().getClassLoader().getResource("./"+fName));
		}catch(IOException e) {
			e.printStackTrace();
		}
		images=new ArrayList <>();
		this.cellH=cellH;
		this.cellW=cellW;
	}
	
	public SpriteBuilder addImage(int i, int j) {
		images.add(spriteSheet.getSubimage(i*cellW, j*cellH, cellW, cellH));
		return this;
	}
	
	public CachedSprite build() {
		return new CachedSprite(images);	
	}
}
