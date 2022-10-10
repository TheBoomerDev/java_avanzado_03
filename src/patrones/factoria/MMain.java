package patrones.factoria;

import patrones.factoria.cuentas.CuentaBanco;
import patrones.factoria.cuentas.FactoriaCuentas;
import patrones.factoria.cuentas.TipoCuenta;

public class MMain {

    public static void main(String[] args) {

        FactoriaCuentas factoria = FactoriaCuentas.instance;
        CuentaBanco cuenta01 = factoria.creamosCuenta(TipoCuenta.Credito, 100);
        CuentaBanco cuenta02 = factoria.creamosCuenta(TipoCuenta.Debito, 100);

        for (int i = 0; i < 100; i++) {
            cuenta01.add(i);
            cuenta02.add(i);

            cuenta02.transferir(cuenta01,i+25);
            cuenta01.transferir(cuenta02,i+25);

        }

    }
}
