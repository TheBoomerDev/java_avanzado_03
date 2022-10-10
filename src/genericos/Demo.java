package genericos;

import java.util.List;

public class Demo<T> {
    T valor;

    public Demo(T v){
        valor = v;
    }

    T getValor(){
        return valor;
    }

    public String toMyStr(){
        return String.valueOf(valor);
    }

    public int getLongitud(){
        return toMyStr().length();
    }

    public boolean isIn(List<T> listado){
        return listado.contains(valor);
    }
}
