package patrones.builder.builder;

public class NPCBuilder {

    private NPC npc;
    public NPCBuilder(){
        this.npc = new NPC();
    }

    public NPCBuilder setName(String name){
        this.npc.setName(name);
        return this;
    }
    public NPCBuilder setId(int id){
        this.npc.setId(id);
        return this;
    }
    public NPCBuilder setDestreza(int valor){
        this.npc.setDestreza(valor);
        return this;
    }

    public NPCBuilder setVida(int valor){
        this.npc.setVida(valor);
        return this;
    }

    public NPCBuilder setFuerza(int valor){
        this.npc.setFuerza(valor);
        return this;
    }

    public NPCBuilder setConstitucion(int valor){
        this.npc.setConstitucion(valor);
        return this;
    }

    public NPCBuilder setNivel(int valor){
        this.npc.setNivel(valor);
        return this;
    }

    public NPCBuilder setExperiencia(int valor){
        this.npc.setExperiencia(valor);
        return this;
    }

    public NPC build() {
        return this.npc;
    }
}
