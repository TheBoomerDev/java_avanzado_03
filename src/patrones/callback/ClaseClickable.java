package patrones.callback;

import patrones.callback.interfaces.CLickConError;
import patrones.callback.interfaces.Click;

import java.util.Comparator;

public class ClaseClickable  implements CLickConError, Comparable, Comparator {

    int limite = 100;
    @Override
    public void doClick(float calculo) {

        String formato = "Limite: %s => %s";
        String msg = String.format(formato, this.limite, calculo);

        String msgFormat = "%s -> Bien";

        if (limite >= calculo){
            msgFormat = "%s -> Mal";
        }

        String res = String.format(msgFormat, msg);
        System.out.println(res);

    }

    @Override
    public void error(String error) {

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
