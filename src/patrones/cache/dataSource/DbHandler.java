package patrones.cache.dataSource;

import patrones.cache.dataSource.models.User;

import java.util.List;

public class DbHandler {

    private DbHandler(){}
    public static final DbHandler instance = new DbHandler();

    private DB db = DB.instance;
    private DbCache cache = DbCache.instance;

    public void addUser(User user){
        this.db.addUser(user);
        /*
            Si queremos que el Usuario no se de cuenta cuando se recoje la nueva info
            o queremos que se modifique en local, mientras no responde la red; actualizamos el cache.
         */
        List<User> users = this.db.getAll();
        this.cache.setInfo("usuarios", users);
    }

    public List<User> getAll(String label){
        boolean exists = this.cache.exists(label);
        boolean caducado = this.cache.caducado(label);
        if (exists && !caducado) {
            // Si tenemos info y no está caducada la devolvemos
            System.out.println("DbHandler -> Cache");
            return this.cache.getInfo(label);
        };

        // Tenemos info, y está caducada
        List<User> newInfo = this.db.getAll();
        this.cache.setInfo(label, newInfo);

        System.out.println("DbHandler -> DB");
        return newInfo;
    }


}
