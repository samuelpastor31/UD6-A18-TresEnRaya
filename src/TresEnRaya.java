import java.util.Scanner;

public class TresEnRaya {

    public static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador(EstadoCasilla.FICHA_X);


        tablero.mostrar();
        jugador.ponerFicha(tablero);
        tablero.mostrar();
    }
}
