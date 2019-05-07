
public class LittleBitLeft implements StatesLava{

	private Lava lava;
	private int movX, movY;
	
	public LittleBitLeft (Lava lava, int movX, int movY) {
		this.lava=lava;
		this.movX=movX;
		this.movY=movY;
	}

	public void advance() {
		lava.setPosY(lava.getPosY()+movY);
		changeState();
	}

	public void changeState() {
		double aux;
		try {
			aux=((double)lava.getDesX()-(double)lava.getPosX()/(double)lava.getDesY()-(double)lava.getPosY());
			if (aux==0) {
				lava.setState(lava.getLilLeft());
			}
			else if (aux<lava.getInclination()){
				lava.setState(lava.getLilLeft());
			}
			else if (aux>lava.getInclination()){
				lava.setState(lava.getJustRight());
			}
			else if (aux==lava.getInclination()) {
				lava.setState(lava.getJustRight());
			}
		} catch (Exception e){
			lava.setState(lava.getLilRight());
		}
	
	}
}
