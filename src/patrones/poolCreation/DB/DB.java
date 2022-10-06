package patrones.poolCreation.DB;

import patrones.cache.dataSource.models.User;

import java.util.ArrayList;
import java.util.List;

public class DB {


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

    public List<User> getAll(){
        return this.usuarios;
    }

    public int sizeUsers(){
        return this.usuarios.size();
    }

}
