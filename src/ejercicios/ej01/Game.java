package ejercicios.ej01;

import logsystem.LogSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Game {

    private Game(){}
    public static final Game instance = new Game();

    private Comparator juez = (o1, o2) ->{
        Valores val01 = (Valores) o1;
        Valores val02 = (Valores) o2;
        if (val01 == Valores.Papel){
            if (val02 == Valores.Piedra) return -1;
            if (val02 == Valores.Tijera) return 1;
        }
        if (val01 == Valores.Piedra){
            if (val02 == Valores.Papel) return 1;
            if (val02 == Valores.Tijera) return -1;
        }

        if (val01 == Valores.Tijera){
            if (val02 == Valores.Piedra) return 1;
            if (val02 == Valores.Tijera) return -1;
        }

        return 0;
    };

    private final int partidas = 100;
    private final int numJugadores = 2;


    private List<Jugador> jugadores = new ArrayList<Jugador>();

    public void init(){

        for (int i = 0; i < numJugadores; i++) {
            this.jugadores.add(new Jugador("PJ"+i));
        }
    }

    public void empezamosPartida(){

        Jugador pj01 = this.jugadores.get(0);
        Jugador pj02 = this.jugadores.get(1);

        for (int i = 0; i < partidas; i++) {

            Valores val01 = pj01.dameJugada();
            Valores val02 = pj02.dameJugada();

            int ganador = juez.compare(val01, val02);
            if (ganador > 0){
                pj01.gano();
            }else{
                pj02.gano();
            }
        }

    }

    public void resumenPartida(){

        Jugador pj01 = this.jugadores.get(0);
        Jugador pj02 = this.jugadores.get(1);

        String format = "Pj01:%s - Pj02:%s => %s";
        int ganadas01 = pj01.getPartidasGanadas();
        int ganadas02 = pj02.getPartidasGanadas();
        Jugador ganador = (ganadas01 > ganadas02) ? pj01 : pj02;
        String msg = String.format(format, ganadas01, ganadas02, ganador);
        LogSystem.getLogger().info("PARTIDAS", msg);

        Integer entero = null;
        int entero01 = entero;

    }
}
