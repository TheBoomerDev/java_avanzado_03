package patrones.adaptador.models;

import java.util.Date;

public class PersonaDB {

    protected PersonaDB(){}


    private long id = 0;
    private String name = "";

    private Date birthDay;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
