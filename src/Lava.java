
public class Lava {
	
	private int posX, posY, desX, desY;
	private static double inclination=0;
	private static int movX, movY;
	StatesLava justRight;
	StatesLava lilRight;
	StatesLava lilLeft;
	StatesLava state;
	
	public Lava(int posX, int posY, int desX, int desY, int movX, int movY) {
		this.posX=posX;
		this.posY=posY;
		this.desX=desX;
		this.desY=desY;
		this.movX=movX;
		this.movY=movY;
		this.justRight=new JustRight(this, movX, movY);
		this.lilRight=new LittleBitRight (this, movX, movY);
		this.lilLeft=new LittleBitLeft (this, movX, movY);
		state=justRight;
		if (posX-desX==0) {
			movX=0;
		}
		else if (posY-desY==0) {
			movY=0;
		}
		else {
			try {
				inclination=((desX-posX)/(desY-posX));
			} catch (Exception e) {
				System.out.println("Congrats!!! you just discovered an easter egg, definetely not a bug");
			}
		}
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getDesX() {
		return desX;
	}

	public int getDesY() {
		return desY;
	}

	public StatesLava getState() {
		return state;
	}

	public void setState(StatesLava state) {
		this.state = state;
	}
	
	public StatesLava getJustRight() {
		return justRight;
	}

	public StatesLava getLilRight() {
		return lilRight;
	}

	public StatesLava getLilLeft() {
		return lilLeft;
	}

	public static double getInclination() {
		return inclination;
	}

}
