package streams;

import java.util.ArrayList;
import java.util.List;

public class MainMap {

    public static void printer(Object obj){
        System.out.println(obj);
    }

    public static void main(String[] args) {

        List<String> names = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            names.add("name "+i);
        }

        // Fiter
        List<Integer> aux = new ArrayList<Integer>();
        for (String name : names) {

            String str = name.replace("name","");
            str = str.trim();
            Integer auxI = Integer.valueOf(str);
            aux.add(auxI);
            // SADISMO
            // aux.add(Integer.valueOf(name.replace("name","").trim()));
        }
        System.out.println("Filtrados: "+aux.size());

        Integer[] listaFiltrada = (Integer[]) names.stream().map((name) -> {
            String str = name.replace("name","");
            str = str.trim();
            return Integer.valueOf(str);
        }).toArray();



    }
}
