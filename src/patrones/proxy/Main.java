package patrones.proxy;

import patrones.cache.dataSource.models.User;
import patrones.poolCreation.DB.DB;
import patrones.proxy.dbProxy.Country;
import patrones.proxy.dbProxy.Proxy;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Proxy proxy = Proxy.instance;

        Country[] values = Country.values();
        DB db;
        for (Country country : values) {
            // La más cercana a mi Pais
            db = proxy.getDB(country);

            List<User> users = db.getAll();

            User user = User.getRandom();
            db.addUser(user);

            users = db.getAll();
            String format = "C:%s - NºUsers:%s";
            String msg = String.format(format, country, users.size());
            System.out.println(msg);
        }

        db = proxy.getDB(Country.ESP);
        List<User> users = db.getAll();
        System.out.println("Users:"+users.size());

    }
}
