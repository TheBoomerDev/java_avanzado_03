package patrones.cache.dataSource;

import patrones.cache.dataSource.models.User;
import patrones.cache.dataSource.DB;

public class DbWorker {

    private DbWorker(){}
    public static final DbWorker instance = new DbWorker();

    private static final int max = 100;

    public void run(){

        DbWorker ctx = this;

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("Creamos User");

                User user =User.getRandom();

                DB.instance.addUser(user);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ctx.run();
            }
        });
        t1.start();

    }
}
