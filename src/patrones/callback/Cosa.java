package patrones.callback;

import patrones.callback.interfaces.Click;

public class Cosa{

    private int interacciones = 0;
    private Click listener;

    Cosa(int interacciones){
        this.interacciones = interacciones;
    }

    public  void setListener(Click clickListener){
        this.listener = clickListener;
    }

    public void ATrabajar(){

        int calculo = 1;

        for (int i=1; i <= this.interacciones; i++){
            calculo = calculo * i;
            calculo = ((calculo) / i) * i;
            System.out.println("Estoy Dentro");
        }

        if (this.listener != null){
            this.listener.doClick(calculo);
        }
    }

}