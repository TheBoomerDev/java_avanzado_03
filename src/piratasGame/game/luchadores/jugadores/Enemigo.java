package piratasGame.game.luchadores.jugadores;

import piratasGame.game.luchadores.insultos.Insultos;
import piratasGame.game.luchadores.insultos.InsultosDB;
import piratasGame.game.tesoros.GeneradorTesoro;
import piratasGame.game.tesoros.Tesoro;

import java.util.List;

public class Enemigo extends PJ{

    private static final int numeroInsultos = 5;
    private final List<Insultos> insultos;
    private final Tesoro tesoro;

    public Enemigo(){
        // TODO: Añadir los nombres a los enemigos
        this.tesoro = GeneradorTesoro.instance.getTesoro();
        this.insultos = InsultosDB.instance.get(numeroInsultos);
    }

    @Override
    public Tesoro getTesoro() {
        return tesoro;
    }

    @Override
    boolean peleaConObjetos(PJ pj) {

        Tesoro tJugador = pj.getTesoro();
        Tesoro tEnemigo = this.tesoro;

        return quienEsMasValioso(tJugador, tEnemigo);
    }
}
