
public interface StatesLava {
	
	//mueve la lava seg�n los movimientos especificados
	public void advance();
	
	//Compara la pendiente de la lava con su objetivo, en base a su posici�n actual y al destino,
	//con respecto a la pendiente original, y dependiendo si esta es mayor o menor, o igual, cambia
	//de estado para hacer las correcciones necesarias
	public void changeState();
}
