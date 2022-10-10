package patrones.prototipo;

public class ClaseObj implements Cloneable{
    public int valor = 0;
    public ClaseObj(int v){
            this.valor = v;
        }

    @Override
    public String toString() {
        return String.format("V:%s", this.valor);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new ClaseObj(this.valor);
    }
}