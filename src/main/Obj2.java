package main;

public class Obj2 {

    private Obj obj;
    private int id = 0;

    private String texto = "Hola que ta";

    private Listener listener;

    public Obj2(int id, String texto, Listener listener){
        this.id = id;
        this.texto = texto;
        this.listener = listener;
    }

    public void setObj(Obj obj){
        this.obj = obj;
    }

    public void setObj2(Obj cosa){
        obj = cosa;
    }

    public void hagoCosas(){
        this.listener.hagoCosas(texto);
    }

    public void burrada(){
        Obj2 ctx = this;

        new Listener(){
            private String texto = "";
            @Override
            public void hagoCosas(String name) {

                // this -> Es el objeto del new Listener
                this.texto = name;
                // Hace referencia al de Obj2
                texto = name;
                // Usamos el falso this para hacer referencia al de Obj2
                ctx.texto = name;
            }
        };
    }
}
