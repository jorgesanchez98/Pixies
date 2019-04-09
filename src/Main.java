
 public class Main {

	public static void main(String[] args) {
		// Se crea el juego, se le da el título y el tamaño de ventana
				Game game = new Game("Tank Test", 720, 480);
				// Se inicia el juego
				game.start();
				System.out.println(((111%360)+360)%360);

	}

}
