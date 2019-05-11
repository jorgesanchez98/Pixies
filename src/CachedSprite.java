import java.util.List;
import java.awt.image.BufferedImage;

public class CachedSprite {
	
	//Variables
	private List<BufferedImage>images;
	
	//Constructor
	public CachedSprite(List<BufferedImage>images) {
		this.images=images;
	}
	
	//Métodos
	public BufferedImage get (int index) {
		return images.get(index);
	}
	public int size() {
		return images.size();
	}
}
