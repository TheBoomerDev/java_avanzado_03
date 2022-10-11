package piratasGame.game.luchadores.insultos;

import java.util.Comparator;

public class Insultos implements Comparable, Comparator, Cloneable {

    private String insulto = "";
    private String respuesta = "";

    public Insultos(String insulto, String respuesta){
        this.insulto = insulto;
        this.respuesta = respuesta;
    }

    public String getInsulto() {
        return insulto;
    }

    public void setInsulto(String insulto) {
        this.insulto = insulto;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int compareTo(String respuesta){
        Insultos temp = new Insultos(null, respuesta);
        return this.compareTo(temp);
    }

    @Override
    public int compareTo(Object o) {
        if (this.respuesta == null) return 1; // Interpretamos que es la respuesta correcta
        if (o == null) return -1; // No supieron responder
        Insultos otro =  (Insultos) o;
        String posibleRespuesta = otro.respuesta;
        return this.respuesta.equals(posibleRespuesta) ? 1 : -1;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return ((Insultos)o1).compareTo(o2);
    }


    public static Insultos fromLine(String line){
        String[] listaTemp = line.split("-");

        String insulto = listaTemp[0];
        String respuesta = listaTemp[1];

        Insultos res = new Insultos(insulto.trim(), respuesta.trim());
        return res;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Insultos nuevo = new Insultos(this.insulto, this.respuesta);
        return nuevo;
    }
}
