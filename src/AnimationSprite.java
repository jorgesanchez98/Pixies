import java.awt.Graphics;

public class AnimationSprite {
	private int imageIndex;
	private CachedSprite sprite;
	private boolean reachedEnd;
	private int animSpd;
	private int animCount;
	private int topCount;	
	private int topCount;
	private int width, height;
	
	public AnimationSprite (int x, int y, CachedSprite sprite) {
		imageIndex=0;
		this.sprite=sprite;
		System.out.println("Sprites Amount: "+sprite.size());
	}
	public AnimationSprite (int x, int y, CachedSprite sprite, int width, int height) {
		imageIndex=0;
		this.sprite=sprite;
		System.out.println("Sprites Amount: "+sprite.size());
	}
	public void update() {
		if (animSpd>0) {
			if (animCount < topCount) {
				animCount++;
				reachedEnd=false;
			}
			else {
				animCount=0;
				imageIndex=(imageIndex+1)%sprite.size();
				reachedEnd=true;
			}
		}
	}
	public void render(Graphics g, int x, int y, int index) {
		if (width!=0)
			g.drawImage(sprite.get(index), x, y, width, height, null);
		else 
			g.drawImage(sprite.get(index), x, y, null);
	}
	
	public boolean hasReachedEnd() {
		return reachedEnd;
	}
	public void reset() {
		imageIndex=0;
		animCount=0;
	}
	
	public int getImageIndex() {
		return imageIndex;
	}
	public void setImageIndex(int imageIndex) {
		this.imageIndex = imageIndex;
	}
	public CachedSprite getSprite() {
		return sprite;
	}
	public void setSprite(CachedSprite sprite) {
		this.sprite = sprite;
	}
	public boolean isReachedEnd() {
		return reachedEnd;
	}
	public void setReachedEnd(boolean reachedEnd) {
		this.reachedEnd = reachedEnd;
	}
	public int getAnimSpd() {
		return animSpd;
	}
	public void setAnimSpd(int animSpd) {
		this.animSpd = animSpd;
		if (animSpd!=0) {
			topCount=60/animSpd;
			animCount=0;
		}
		reachedEnd=false;
	}
	public int getAnimCount() {
		return animCount;
	}
	public void setAnimCount(int animCount) {
		this.animCount = animCount;
	}
	public int getTopCount() {
		return topCount;
	}
	public void setTopCount(int topCount) {
		this.topCount = topCount;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
