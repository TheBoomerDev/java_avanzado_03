package piratasGame.game;

import logsystem.LogSystem;
import multithreding.utils.Utils;
import piratasGame.game.luchadores.TipoPelea;
import piratasGame.game.luchadores.jugadores.Enemigo;
import piratasGame.game.luchadores.jugadores.Jugador;

import java.util.ArrayList;
import java.util.List;

/*

Sistema de Combate entre piratas.

=> Interface -> Pelea ::> peleaCon(obj), setPelea(Enum) [Patron Estrategia]
- Pelea por insultos
	=> "Aprendizaje" -> Un insulto nuevo se aprenderá
	=> % de Fallo
- Pelea por Atributos
	=> Top Tumps
	=> Incremente ese atributo en un %
- Pelea por Objetos
	=> PJ -> El objeto de mayor valor
	=> Valor -> Recoja el otro objeto
	    -> Sube de valor un % al recogerlo

=> Game [Patron Singleton]

=> Lista Objetos -> [Fachada]

=> DTO/DAO -> Generación de los objetos
 */
public class Game {

    private Jugador player;

    private Game(){}
    public static final Game instance = new Game();
    private Utils tools = Utils.instance;
    private LogSystem logger = LogSystem.getLogger();

    public List<Enemigo> enemigos = new ArrayList<Enemigo>();
    private static final int numeroEnemigos = 10;

    public void iniciar(){

        this.player = new Jugador("Arion");

        this.generateEnemies();

        this.empezamosPartida();

    }

    private void generateEnemies(){

        for (int i = 0; i < numeroEnemigos; i++) {
            Enemigo enemy = new Enemigo();
            enemigos.add(enemy);
        }

    }

    private void empezamosPartida (){

        this.enemigos.stream().forEach(this::luchar);

        String format = "Jugador: %s - EstaVivo: %s => Resultado: %s";
        String name = this.player.getName();
        boolean estaVivo = this.player.estaVivo();
        String resultado = (estaVivo) ? "Ha Ganado" : "Game Over";
        String msg = String.format(format, name, estaVivo, resultado);

        logger.info("GAME", msg);
    }

    private void luchar(Enemigo enemigo) {

        if ((!enemigo.estaVivo()) || (!this.player.estaVivo())) return;

        TipoPelea peleaCon = this.getTipoPelea();

        boolean playerGanador = this.player.peleaCon(peleaCon, enemigo);
        if (!playerGanador){
            this.player.quitarVida(10);
        }

    }

    private TipoPelea getTipoPelea(){
        TipoPelea[] values = TipoPelea.values();
        int pos = tools.getNumber(values.length - 1);
        return values[pos];
    }
}
