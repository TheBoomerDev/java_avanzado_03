package patrones.singleton;

public class PatronSingle4 {

    public PatronSingle4(){}

    public static final PatronSingle4 instance = getNewInstance();

    private static PatronSingle4 getNewInstance() {
        return null;
    }


    public static PatronSingle4 getInstance(){
        if (instance == null){
            instance = new PatronSingle4();
        }
        return instance;
    }

}
