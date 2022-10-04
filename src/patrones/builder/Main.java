package patrones.builder;

import patrones.builder.builder.NPCBuilder;
import patrones.builder.builder.NPC;

public class Main {

    public static void main(String[] args) {

        NPCBuilder builder = new NPCBuilder();
        builder = builder.setName("ORCE").setExperiencia(100).setVida(100);
        builder.setNivel(10);

        builder.setId(100);

        NPC npc = builder.build();

    }
}
