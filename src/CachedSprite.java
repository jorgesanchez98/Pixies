import java.util.List;
import java.awt.image.BufferedImage;

public class CachedSprite {
	
	//Variables
	private List<BufferedImage>images;
	
	//Constructor
	public CachedSprite(List<BufferedImage>images) {
		this.images = images;
	}
	
	//Getters
	public BufferedImage get(int index) {
		return images.get(index);
	}
	
	//Tamaño
	public int size() {
		return images.size();
	}
}
