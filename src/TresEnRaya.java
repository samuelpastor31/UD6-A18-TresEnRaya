import java.util.Scanner;

public class TresEnRaya {

    public static Scanner scanner;
    private Tablero tablero;
    private Jugador[] jugadors;

    public void jugar() {
        // Creamos el tablero del juego
        Tablero tablero = new Tablero();
        // Creamos los 2 jugadores
        Jugador jugador1 = new Jugador(EstadoCasilla.FICHA_X);
        Jugador jugador2 = new Jugador(EstadoCasilla.FICHA_O);

        do {
            // El jugador 1 inserta una ficha en el tablero
            System.out.println("Tira el jugador con ✖️");
            jugador1.ponerFicha(tablero);
            tablero.mostrar();

            // Comprobamos si ha habido victoria o empate
            if (tablero.hayTresEnRaya()) {
                jugador1.cantarVictoria();
                break;
            }
            if (tablero.estaLleno()) {
                System.out.println("La partida ha finalizado en empate");
                break;
            }

            // El jugador 2 inserta una ficha en el tablero
            System.out.println("Tira el jugador con ⭕");
            jugador2.ponerFicha(tablero);
            tablero.mostrar();

            // Comprobamos si ha habido victoria
            if (tablero.hayTresEnRaya()) {
                jugador2.cantarVictoria();
                break;
            }
        } while (!tablero.estaLleno());
    }


    public static void main(String[] args){
        scanner = new Scanner(System.in);
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.jugar();
    }

}
