package patrones.observer;

import java.util.ArrayList;
import java.util.List;

public class Beholder{

    private Beholder(){}
    public static Beholder instance = new Beholder();

    private List<Listener> observadores= new ArrayList<Listener>();

    public void addListener(Listener listener){
        this.observadores.add(listener);
    }

    public void delListener(Listener listener){
        this.observadores.remove(listener);
    }


    public void run(){

        String msg = "Hola, Usuario";
        System.out.println("Comienzo de Run - Beholder");
        WorkListener listener = new WorkListener() {
            @Override
            public void heTerminado() {
                observadores.stream().forEach((observador)->{
                    observador.newMsg(msg);
                });
            }
        };
        WorkThread worker = new WorkThread(listener);
        worker.run();

        System.out.println("Fin de Run - Beholder");


    }


}
