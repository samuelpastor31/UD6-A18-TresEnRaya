public class Tablero {

    private final int DIMENSION=3;
    private EstadoCasilla[][] casillas;
    private final String IMAGEN_O="U+2B55";
    private final String IMAGEN_X="U+274C";
    private final String IMAGEN_VACIO="U+1F3FB";

    public Tablero(EstadoCasilla[][] casillas) {
        this.casillas = new EstadoCasilla[DIMENSION][DIMENSION];
    }


    public void mostrar(){
        for (int i = 0; i <casillas.length ; i++) {
            for (int j = 0; j <casillas[0].length ; j++) {
                if (casillas[i][j]==EstadoCasilla.FICHA_O){
                    System.out.println(IMAGEN_O);
                }

                if (casillas[i][j]==EstadoCasilla.FICHA_X){
                    System.out.println(IMAGEN_X);
                }
                if (casillas[i][j]==EstadoCasilla.VACIO){
                    System.out.println(IMAGEN_VACIO);
                }
            }
        }
    }

    public boolean isOcupada(Coordenada casilla){
        if (casilla.equals(EstadoCasilla.FICHA_O)  || casilla.equals(EstadoCasilla.FICHA_X)){
            return true;
            }else{
            return false;
        }
    }

    public void ponerFicha (Coordenada casilla, EstadoCasilla color){
        for (int i = 0; i <casillas.length ; i++) {
            for (int j = 0; j <casillas[0].length ; j++) {
                if (casillas[i][j].equals(casilla)){
                    casillas[i][j] = color;
                }
            }
        }
    }

    public void vaciar(){
        for (int i = 0; i <casillas.length ; i++) {
            for (int j = 0; j < casillas.length ; j++) {
                casillas[i][j]=EstadoCasilla.VACIO;
            }
        }
    }
}
