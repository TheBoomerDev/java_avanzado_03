package main;

public class UsoDeThis {

    public String texto = "";

    public static void main(String[] args) {

        String texto = "";

        UsoDeThis ctx = new UsoDeThis();

        Obj2 obj2 = new Obj2(1, "hola", new Listener(){

            @Override
            public void hagoCosas(String name) {
                ctx.texto = name;
            }
        });


    }
}
