package patrones.singleton;

public class PatronSingle {

    private PatronSingle(){}

    private static PatronSingle instance;

    public static PatronSingle getInstance(){
        if (instance == null){
            instance = new PatronSingle();
        }
        return instance;
    }

}
