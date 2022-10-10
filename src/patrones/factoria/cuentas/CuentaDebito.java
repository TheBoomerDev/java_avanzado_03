package patrones.factoria.cuentas;

public class CuentaDebito implements CuentaBanco{
    protected CuentaDebito(int saldoInicial){
        this.saldo = saldoInicial;
    }

    private int saldo = 0;

    @Override
    public void add(int dinero) {
        this.saldo = this.saldo + dinero;
    }

    @Override
    public boolean quitar(int dinero) {
        if (dinero > this.saldo) return false;

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
