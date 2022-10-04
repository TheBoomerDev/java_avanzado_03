package streams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class MainFilter {

    public static void printer(Object obj){
        System.out.println(obj);
    }

    public static void main(String[] args) {

        List<String> names = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            names.add("name "+i);
        }

        // Fiter
        List<String> aux = new ArrayList<String>();
        for (String name : names) {
            // if (name.contains('2'))
            if (name.indexOf('2') > 0){
                aux.add(name);
            }
        }
        System.out.println("Filtrados: "+aux.size());

        String[] listaFiltrada = (String[]) names.stream().filter((name) -> {
            return (name.indexOf('2') > 0);
        }).toArray();



    }
}
