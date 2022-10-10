package genericos;

public class ClaseT<T> implements ComparaT<T> {

    private final T valor;

    public ClaseT(T valor){
        this.valor = valor;
    }

    @Override
    public int compare(Object o1, Object o2) {
        Comparable valor01 = ((Comparable) o1);
        Comparable valor02 = ((Comparable) o2);
        return valor01.compareTo(valor02);
    }
}
