
public class JustRight implements StatesLava{
	
	private Lava lava;
	private int movX, movY;
	
	public JustRight (Lava lava, int movX, int movY) {
		this.lava=lava;
		this.movX=movX;
		this.movY=movY;
	}
	
	@Override
	public void advance() {
		lava.setPosX(lava.getPosX()+movX);
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
				lava.setState(lava.getLilRight());
			}
		} catch (Exception e){
			lava.setState(lava.getLilRight());
		}
	
	}

		
	
}
