package patrones.adaptador;

import patrones.adaptador.models.Persona;
import patrones.adaptador.models.PersonaDB;

import java.util.Calendar;

public class Main2 {

    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();

        Persona per = new Persona();
        per.setId(120);
        per.setName("Jorge");
        per.setBirthDay(cal);

        PersonaDB perDb = per.toDB();
        // Transformamos en el otro tipo que necesitamos

    }

}
