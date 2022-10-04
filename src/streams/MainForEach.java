package streams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainForEach {

    public static void printer(Object obj){
        System.out.println(obj);
    }

    public static void main(String[] args) {

        List<String> names = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            names.add("name "+i);
        }
        // names = null;
        // System.gc(); // Proceso interno

        // Recorrerlo

        for (int i=0; i < names.size(); i++){
            String name = names.get(i);
        }

        // ForEach
        for (String name : names) {

        }

        // While -> For => PATRON ITERADOR
        Iterator<String> iterator = names.iterator();
        while(iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        // For Iterator
        for (Iterator i = names.iterator(); i.hasNext(); ){
            String name = (String) i.next();
        }


        // FOREACH -> STREAMS
        names.stream().forEach((name)->{
            System.out.println(name);
        });

        names.stream().forEach(System.out::println);

        names.stream().forEach(MainForEach::printer);



    }
}
