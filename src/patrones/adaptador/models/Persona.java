package patrones.adaptador.models;

import java.util.Calendar;
import java.util.Date;

public class Persona {

    private Integer id = 0;
    private String name = "";

    private Calendar birthDay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Calendar birthDay) {
        this.birthDay = birthDay;
    }

    public PersonaDB toDB(){
        PersonaDB per = new PersonaDB();

        Date date = this.getBirthDay().getTime();
        per.setBirthDay(date);

        per.setId(this.id);
        per.setName(this.name);

        return per;
    }
}
