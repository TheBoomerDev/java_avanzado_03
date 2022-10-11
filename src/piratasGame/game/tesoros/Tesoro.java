package piratasGame.game.tesoros;

import java.util.Comparator;

public class Tesoro implements Comparator, Comparable{

    private int percent = 10;

    protected Tesoro(String name, int valor){
        this.nombre = name;
        this.valor = valor;
    }

    private int valor = 0;
    private String nombre = "";

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void subeValor() {
        int nValor = (this.valor * this.percent) / 100;
        this.valor = this.valor + nValor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        String format = "T=> %s V:%s";
        String msg = String.format(format, this.nombre, this.valor);
        return msg;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return ((Tesoro)o1).compareTo(o2);
    }

    @Override
    public int compareTo(Object o) {
        int oValor = ((Tesoro)o).valor;
        int tValor = this.valor;
        return (tValor >= oValor) ? 1 : -1;
    }


}
