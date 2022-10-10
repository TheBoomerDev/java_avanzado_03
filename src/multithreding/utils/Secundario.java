package multithreding.utils;

public class Secundario implements Runnable{

    private final CosasTrabajo cosas;

    public Secundario(CosasTrabajo cosas){
        this.cosas = cosas;
    }

    @Override
    public void run() {
        try {
            cosas.trabaja();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
