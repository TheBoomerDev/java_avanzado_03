package patrones.adaptador;

import java.nio.DoubleBuffer;

public class Main {

    public static void funcion (){
        String cell = "30";
        Double dob = new Double(cell);
        int ent = dob.intValue();
        Integer ent2 = new Integer(ent);
        String str = ent2.toString();
        String str2 = new String(str);
    }

    public static void main(String[] args) {

        Integer entero = 0;

        String texto = entero.toString(); // "0"
        entero = Integer.valueOf(texto);

        int entero2 = entero;

        // Cosas a tener en cuenta

        Boolean bul = null;
        boolean bul2 = false; // true - false
        // bul2 = bul; // null => false

        // OJO=> BURRADA
        // entero2 = (Integer) null;


        // Traducion
        String cell = "30";
        new String(new Integer(new Double(cell).intValue()).toString());

        Double dob = new Double(cell);
        int ent = dob.intValue();
        Integer ent2 = new Integer(ent);
        String str = ent2.toString();
        String str2 = new String(str);

        // Hacen lo mismo
        String cel2 = cell.toString();
        cel2 = ""+cell;

        // Todo pasa a ser string
        cel2 = ""+12;
        cel2 = ""+true;
        cel2 = ""+10.12f;
        cel2 = ""+"Hola";


        long tiempoBegin = System.nanoTime();

        for (int i=0; i < 100000; i++){
            Main.funcion();
        }

        long tiempoEnd = System.nanoTime();

        String format = "Tiempo Ejecución %s";
        String msg = String.format(format, (tiempoEnd-tiempoBegin)/ 1000);
        System.out.println(msg);

        tiempoBegin = System.nanoTime();

        for (int i=0; i < 100000; i++){
            String cel3 = cell.toString();
        }

        tiempoEnd = System.nanoTime();

        msg = String.format(format, (tiempoEnd-tiempoBegin)/ 1000);
        System.out.println(msg);





    }
}
