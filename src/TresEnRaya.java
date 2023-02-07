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
        System.out.println("Vamos a jugar al \"Tres en Raya\"");
        tablero.mostrar();
        System.out.println();

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
        } while (!tablero.estaLleno()||!tablero.estaLleno());
    }

    public static boolean repetir(){
        boolean jugar=false;
        do {
            System.out.println("¿Quieres volver a jugar? [S/N]:");
            switch (scanner.next()) {
                case "S":
                    jugar = true;
                    break;
                case "N":
                    jugar = false;
                    break;
                default:
                    System.out.println("¡Error! Debes introducir S o N");
                    continue;

            }
            return jugar;
        }while (true);
    }


    public static void main(String[] args){
        scanner = new Scanner(System.in);
        TresEnRaya tresEnRaya = new TresEnRaya();
        tresEnRaya.jugar();
        if (repetir()==true){
            tresEnRaya.jugar();
        }

    }

}
