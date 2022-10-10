package patrones.factoria.cuentas;

public class FactoriaCuentas {

    private FactoriaCuentas(){}
    public static final FactoriaCuentas instance = new FactoriaCuentas();

    public CuentaBanco creamosCuenta(TipoCuenta tipo, int saldoInicial){

        switch (tipo){
            case Debito -> {
                return new CuentaDebito(saldoInicial);
            }
            case Credito -> {
                return new CuentaCredito(saldoInicial);
            }
            default -> {
                return null;
            }
        }
    }
}
