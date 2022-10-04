package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MainMinMax {

    public static void printer(Object obj){
        System.out.println(obj);
    }

    public static void main(String[] args) {

        List<Integer> values = new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++) {
            values.add(i*i);
        }

        // Clasico
        Integer min = Integer.MAX_VALUE; // Valor más alto del sistema
        Integer max = Integer.MIN_VALUE; // Valor más bajo del sistema
        for (Integer valor : values) {
            if (valor < min) min = valor;
            if (valor > max) max = valor;
        }

        min = values.stream().min(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }).get();

        max = values.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        }).get();


    }
}
