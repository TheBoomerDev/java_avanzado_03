package patrones.callback;

import patrones.callback.interfaces.Click;

public class ClaseClickable  implements Click {

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
}
