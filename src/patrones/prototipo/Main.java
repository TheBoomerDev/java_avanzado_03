package patrones.prototipo;

import logsystem.LogSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static List<ClaseObj> listado = new ArrayList<ClaseObj>();

    public static void init(){
        for (int i = 0; i < 10; i++) {

            listado.add( new ClaseObj(i) );
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Main.init();

        ClaseObj obj01 = (ClaseObj) listado.get(0).clone();
        obj01.valor = 666;

        for (ClaseObj texto: listado) {
            String format = "Mensaje: %s";
            String msg = String.format(format, texto);
            LogSystem.getLogger().info("Main", msg);
        }

    }
}
