package patrones.singleton;

public class Main {

    public static void main(String[] args) {

        PatronSingle sing = PatronSingle.getInstance();
        System.out.println(sing);

        PatronSingle sing2 = PatronSingle.getInstance();
        System.out.println(sing2);

        // =====
        PatronSingle2 sin20 = PatronSingle2.getInstance();
        System.out.println(sin20);
        PatronSingle2 sin21 = PatronSingle2.getInstance();
        System.out.println(sin21);

        // =====
        PatronSingle3 sing30 = PatronSingle3.instance;
        System.out.println(sing30);
        PatronSingle3 sing31 = PatronSingle3.instance;
        System.out.println(sing31);

        // Constructor privado
        // PatronSingle3.instance = new PatronSingle3();
        PatronSingle3.instance = new PatronSingle3();


    }
}
