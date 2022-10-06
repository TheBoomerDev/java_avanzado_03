package patrones.interfaces;

public class Utils {

    private Utils(){}
    public static final Utils instance = new Utils();

    public Mayusculas mayus = (txt) -> txt.toUpperCase();

    public Mayusculas minus = (txt) -> txt.toLowerCase();

    public Mayusculas replace = (txt) -> txt.replace("H", "J");

    public Mayusculas clean = (txt) -> {return "";};

    public Mayusculas other = (txt) -> { return "_"+txt; };

}
