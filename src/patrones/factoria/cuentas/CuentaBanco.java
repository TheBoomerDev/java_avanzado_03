package patrones.factoria.cuentas;

public interface CuentaBanco {

    void add(int dinero);

    boolean quitar(int dinero);

    boolean transferir(CuentaBanco cuenta, int dinero);
}
