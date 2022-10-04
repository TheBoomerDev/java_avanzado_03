package patrones.comparator;

import patrones.builder.builder.NPC;
import patrones.builder.builder.NPCBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        NPCBuilder npcBuilder = new NPCBuilder();
        NPC orco = npcBuilder.setId(1).setName("Orco").setVida(100).build();

        NPC dragon = npcBuilder
                .clean()
                .setVida(120)
                .setId(2)
                .setName("Dragon")
                .build();

        List<NPC> npcs = new ArrayList<NPC>();
        npcs.add(dragon);
        npcs.add(orco);

        npcs.stream().sorted(NPC::compareTo);

        NPC npcMin = npcs.stream().min(NPC::compareTo).get();




    }
}
