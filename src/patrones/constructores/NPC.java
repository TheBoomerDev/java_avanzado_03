package patrones.constructores;

public class NPC {

    private int id = 0;
    private String name = "";
    private int vida =100;
    private int destreza = 100;
    private int fuerza = 100;

    private int constitucion = 100;

    private int nivel = 10;

    private int experiencia;

    public NPC (int id, String name, int vida, int destreza, int fuerza, int constitucion, int nivel, int experiencia){
        this.id = id;
        this.name = name;
        // ETC
    }

    public NPC (String name, int destreza, int fuerza, int consitucion){
        return new NPC(1, name, 100, destreza, fuerza, consitucion, 1, 100);
    }

    public NPC (String name){
        return new NPC(name, 100, 100, 100);
    }

    public NPC (){
        return new NPC("ORCO");
    }



}
