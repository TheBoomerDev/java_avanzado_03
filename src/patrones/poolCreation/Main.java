package patrones.poolCreation;

import patrones.cache.dataSource.models.User;
import patrones.poolCreation.DB.DB;
import patrones.poolCreation.DB.DbPool;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        DbPool pool = DbPool.instance;

        for (int i = 0; i < 50; i++) {

            DB con = pool.getConnection();

            List<User> users = con.getAll();

            System.out.println("Listado: "+users.size());

            User user = User.getRandom();
            con.addUser(user);
            users = con.getAll();

            //pool.liberate(con);

        }

        pool.listAll();

    }
}
