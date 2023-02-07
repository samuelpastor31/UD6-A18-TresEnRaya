import java.util.Scanner;

public class Jugador {
    public static void main(String[] args) {
        Coordenada hola = new Coordenada(3,3);
    }

    private EstadoCasilla ficha;

    public Jugador(EstadoCasilla ficha) {
        this.ficha = ficha;
    }

    public void ponerFicha(Tablero tablero){
       tablero.ponerFicha(recogerCoordenada(),ficha);

    }

    private Coordenada recogerCoordenada() {
        do {
            int fila = pedirNumero("Introduce fila [1-3]:");
            int columna = pedirNumero("Introduce columna [1-3]:");

            // Crear la coordenada
            // Preguntar a la coordenada si es válida
            // Si no es válida, mostrar mensaje de error correspondiente y volver a pedir fila y columna
            // Si es válida, devolverla

            Coordenada coordenada = new Coordenada(fila, columna);
            if (coordenada.isValida(Tablero.DIMENSION)) {
                return coordenada;
            }

            System.out.println("¡Error! Introduce una coordenada válida");
        }while (true);
    }

    private int pedirNumero(String mensaje) {
        do {
            System.out.println(mensaje);
            if (TresEnRaya.scanner.hasNextInt()) {
                return TresEnRaya.scanner.nextInt();
            }

            TresEnRaya.scanner.next();
            System.out.println("¡Error! Debe introducir un número entero");
        } while(true);
    }
}
