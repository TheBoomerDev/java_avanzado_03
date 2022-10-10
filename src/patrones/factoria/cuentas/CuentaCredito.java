package patrones.factoria.cuentas;

public class CuentaCredito implements CuentaBanco{

    protected CuentaCredito(int saldoInicial){
        this.saldo = saldoInicial;
    }

    private int saldo = 0;
    private int limite = 1000;

    @Override
    public void add(int dinero) {
        this.saldo = this.saldo + dinero;
    }

    @Override
    public boolean quitar(int dinero) {
        if (dinero > (this.saldo+this.limite)) return false;
        this.saldo = this.saldo - dinero;
        return true;
    }

    @Override
    public boolean transferir(CuentaBanco cuenta, int dinero) {
        if (!quitar(dinero)) return false;
        cuenta.add(dinero);
        return true;
    }
}
