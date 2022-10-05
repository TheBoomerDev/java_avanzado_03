package patrones.cache.dataSource.models;

import patrones.cache.tools.Utils;

public class User {

    public int id = 0;
    public String name = "";
    public int edad = 10;


    public static User getRandom(){
        User user = new User();

        Utils tools = new Utils();
        user.name = tools.getRandomName();
        user.edad = tools.getNumber(18);
        user.id = tools.getNumber(100);

        return user;
    }
}
