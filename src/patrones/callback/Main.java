package patrones.callback;

import patrones.callback.interfaces.Click;

public class Main {

    public static void main(String[] args) {

        Cosa cosa = new Cosa(10000);

        cosa.setListener(new Click() {
            @Override
            public void doClick(float calculo) {
                System.out.println("Salimos");
            }
        });

        Click clicker = new Click() {
            @Override
            public void doClick(float calculo) {
                System.out.println("Salimos");
            }
        };
        cosa.setListener(clicker);

        ClaseClickable objClase = new ClaseClickable();
        cosa.setListener(objClase);

        cosa.ATrabajar();


    }

}
