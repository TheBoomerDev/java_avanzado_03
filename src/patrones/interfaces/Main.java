package patrones.interfaces;

public class Main {

    public static void main(String[] args) {

        Mayusculas mayus = (txt) -> txt.toUpperCase();

        String texto = "hola";

        System.out.println(mayus.toUpper(texto));

        Utils.instance.clean.toUpper(texto);

    }
}
