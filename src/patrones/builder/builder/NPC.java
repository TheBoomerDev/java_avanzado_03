package patrones.builder.builder;

import java.util.Comparator;

public class NPC implements Comparable, Comparator {

    private int id = 0;
    private String name = "";
    private int vida =100;
    private int destreza = 100;
    private int fuerza = 100;

    private int constitucion = 100;

    private int nivel = 10;

    private int experiencia = 1000;


    protected NPC(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getConstitucion() {
        return constitucion;
    }

    public void setConstitucion(int constitucion) {
        this.constitucion = constitucion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public int compareTo(Object o) {
        int id = ((NPC)o).id;
        return (this.id > id) ? -1 : 1;
    }

    @Override
    public int compare(Object o1, Object o2) {
        int id1 = ((NPC)o1).id;
        int id2 = ((NPC)o2).id;
        return (id1 > id2) ? -1 : 1;
    }
}
