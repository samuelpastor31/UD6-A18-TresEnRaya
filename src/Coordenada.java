public class Coordenada {

    private int fila;
    private int columna;

    public Coordenada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean isValida(int dimension){
        if ((this.fila>=1&&this.fila<=dimension)&&(this.columna>=1&&this.columna<=dimension)){
            return true;
        }else{
            return false;
        }

    }
}
