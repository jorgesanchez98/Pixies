
public class LittleBitRight implements StatesLava{

	private Lava lava;
	private int movX, movY;
	
	public LittleBitRight (Lava lava, int movX, int movY) {
		this.lava=lava;
		this.movX=movX;
		this.movY=movY;
	}

	@Override
	public void advance() {
		lava.setPosX(lava.getPosX()+movX);
		changeState();
	}

	public void changeState() {
		double aux;
		try {
			aux=(lava.getDesX()-lava.getPosX()/lava.getDesY()-lava.getPosY());
			if (aux==0) {
				lava.setState(lava.getLilLeft());
			}
			else if (aux<lava.getInclination()){
				lava.setState(lava.getJustRight());
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
