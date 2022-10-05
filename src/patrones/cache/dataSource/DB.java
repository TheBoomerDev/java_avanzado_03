package patrones.cache.dataSource;

import patrones.cache.dataSource.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DB {

    private DB(){}
    public static final DB instance = new DB();

    private List<User> usuarios = new ArrayList<User>();

    public void addUser(User user){
        this.usuarios.add(user);
    }

    public User get(int id){

        User usuario = this.usuarios.stream().filter((user) -> {
            return user.id == id;
        }).findAny().get();

        return usuario;
    }

    public int sizeUsers(){
        return this.usuarios.size();
    }

}
