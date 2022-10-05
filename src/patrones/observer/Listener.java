package patrones.observer;

public interface Listener {

    void newMsg(String msg);
    void newUser(Object user);
}
