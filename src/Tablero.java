public class Tablero {


    public static final int DIMENSION = 3;
    private static int NEUTRAL = 0;
    private EstadoCasilla[][] casillas;
    private final String IMAGEN_O = "\u2B55";
    private final String IMAGEN_X = "\u274C";
    private final String IMAGEN_VACIO = " - ";

    public Tablero() {
        this.casillas = new EstadoCasilla[DIMENSION][DIMENSION];
        vaciar();
    }


    public void mostrar() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j] == EstadoCasilla.FICHA_O) {
                    System.out.print(IMAGEN_O);
                }
                else if (casillas[i][j] == EstadoCasilla.FICHA_X) {
                    System.out.print(IMAGEN_X);
                }
                else if (casillas[i][j] == EstadoCasilla.VACIO) {
                    System.out.print(IMAGEN_VACIO);
                }
            }
            System.out.println("");
        }
    }

    public boolean hayTresEnRaya() {
        if (hayTresEnRaya(EstadoCasilla.FICHA_O) || hayTresEnRaya(EstadoCasilla.FICHA_X)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean hayTresEnRaya(EstadoCasilla color) {
        int contadorFila = 0;
        boolean booleanoFila = false;
        for (int i = 0; i < casillas.length; i++) {
            contadorFila = 0;
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j] != color) {
                    booleanoFila = false;
                    break;
                } else {
                    contadorFila++;
                    if (contadorFila == casillas[i].length) {
                        booleanoFila = true;
                    }
                }
            }
            if (booleanoFila) {
                return true;
            }
        }

        int contadorColumna = 0;
        boolean booleanoColumna = false;
        for (int i = 0; i < casillas[0].length; i++) {
            contadorColumna = 0;
            for (int j = 0; j < casillas.length; j++) {
                if (casillas[j][i] != color) {
                    booleanoColumna = false;
                    break;
                } else {
                    contadorColumna++;
                    if (contadorColumna == casillas.length) {
                        booleanoColumna = true;
                    }
                }
            }
            if (booleanoColumna) {
                return true;
            }
        }

        int contadorSubdiagonal = 0;
        boolean booleanoSubdiagonal = false;
        for (int i = 0; i < casillas.length; i++) {
            if (casillas[i][casillas.length - i - 1] != color) {
                booleanoSubdiagonal = false;
                break;
            } else {
                contadorSubdiagonal++;
                if (contadorSubdiagonal == casillas.length) {
                    booleanoSubdiagonal = true;
                }
            }
        }
        if (booleanoSubdiagonal) {
            return true;
        }

        int contadorDiagonal = 0;
        boolean booleanoDiagonal = false;
        for (int i = 0; i < casillas.length; i++) {
            if (casillas[i][i] != color) {
                booleanoDiagonal = false;
                break;
            } else {
                contadorDiagonal++;
                if (contadorDiagonal == casillas.length) {
                    booleanoDiagonal = true;
                }
            }
        }

        boolean total;
        if (booleanoColumna==true||booleanoFila==true||booleanoSubdiagonal==true||booleanoDiagonal==true){
            return true;
        }else{
            return false;
        }
    }

    public boolean isOcupada(Coordenada casilla){

        if (casillas[casilla.getFila()-1][casilla.getColumna()-1] == EstadoCasilla.VACIO){
            return false;
        } return true;
    }

    public void ponerFicha(Coordenada casilla, EstadoCasilla color) {
        casillas[casilla.getFila()-1][casilla.getColumna()-1] = color;
    }

    public void vaciar() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                casillas[i][j] = EstadoCasilla.VACIO;
            }
        }
    }

    public boolean estaLleno() {
        int contador = 0;
        boolean sacar = false;
        int maximoContador = DIMENSION * DIMENSION;
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                if (casillas[i][j].equals(EstadoCasilla.FICHA_O) || casillas[i][j].equals(EstadoCasilla.FICHA_X)) {
                    ++contador;
                    if (contador == maximoContador) {
                        sacar = true;
                    } else {
                        sacar = false;
                    }
                }
            }
        }
        return sacar;
    }
}
