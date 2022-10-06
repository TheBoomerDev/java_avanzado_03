package patrones.cache;

import patrones.cache.dataSource.DbHandler;
import patrones.cache.dataSource.DbWorker;
import patrones.cache.dataSource.models.User;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Simular una segunda conexión a la db o un segundo trabajador
        DbWorker worker = DbWorker.instance;
        worker.run();

        DbHandler dbHandler = DbHandler.instance;

        // Bucle para simular un trabajo
        while(true){ // Bucle infinito de trabajo

            Thread.sleep(2000); // Simulamos una espera entre ciclos

            System.out.println("Vuelvo a consultar");

            List<User> users = dbHandler.getAll("usuarios");
            if (users == null) {
                System.out.println("No Hay Usuarios");
                continue;
            }
            String format = "Nº Usuarios -> %s";
            String msg = String.format(format, users.size());
            System.out.println(msg);

        }



    }
}
