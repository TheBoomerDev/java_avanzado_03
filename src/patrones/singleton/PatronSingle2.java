package patrones.singleton;

public class PatronSingle2 {

    private PatronSingle2(){}

    private static PatronSingle2 instance  = new PatronSingle2();

    public static PatronSingle2 getInstance(){
        return instance;
    }

}
