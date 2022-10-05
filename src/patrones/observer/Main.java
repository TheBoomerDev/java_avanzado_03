package patrones.observer;

import java.util.ArrayList;
import java.util.List;

public class Main {

    List<Listener> listadoObservadores = new ArrayList<Listener>();
    Beholder ojoParche = Beholder.instance;


    private void generarObservadores(){
        for (int i = 0; i < 10; i++) {

            final int pos = i;
            Listener listener = new Listener() {
                @Override
                public void newMsg(String msg) {
                    String format = "Ob: %s - %s";
                    String mensaje = String.format(format, pos, msg);
                    System.out.println(mensaje);

                }

                @Override
                public void newUser(Object user) {
                }
            };
            listadoObservadores.add(listener);
        }
    }

    private void start(){

        generarObservadores();

        listadoObservadores.stream().forEach(ojoParche::addListener);

        ojoParche.run();
        System.out.println("Comienza el Juego");

    }

    public static void main(String[] args) {

        Main app = new Main();
        app.start();

    }
}
