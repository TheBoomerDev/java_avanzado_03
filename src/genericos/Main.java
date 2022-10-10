package genericos;

public class Main {
    public static void main(String[] args) {

        Demo<Integer> demo01 = new Demo<Integer>(11);
        Integer entero = demo01.getValor();

        Demo<String> demo02 = new Demo<String>("WTF");
        String cadena = demo02.getValor();

    }
}
