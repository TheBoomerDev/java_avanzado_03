package genericos;

import java.util.Comparator;
import java.util.List;

public class Demo02<T> {

    private final List<T> items;

    public Demo02(List<T> listado){
        this.items = listado;
    }

    public List<T> ordenalo(){

        this.items.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 == null) return -1;
                if (o2 == null) return 1;
                String str01 = String.valueOf(o1);
                String str02 = String.valueOf(o2);
                return str01.compareTo(str02);
            }
        });
        return this.items;

    }

    public T getPrimerValor(){
        T valor = this.items.get(0);
        return valor;
    }

}
