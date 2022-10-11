package piratasGame.game.tesoros;

import java.util.ArrayList;
import java.util.List;

import logsystem.LogSystem;
import multithreding.utils.Utils;
public class GeneradorTesoro {

    // TODO: Mejorar con un fichero de configuracion
    private final int numeroTesoros = 100;
    private List<Tesoro> tesoros = new ArrayList<Tesoro>();
    private Utils tools = Utils.instance;
    private LogSystem logger = LogSystem.getLogger();

    private GeneradorTesoro(){
        this.generaTesoros();
    }
    public static final GeneradorTesoro instance = new GeneradorTesoro();

    private void generaTesoros(){

        for (int i = 0; i < numeroTesoros; i++) {

            int valor = tools.getNumber(1000)+1;

            String format = "Tesoro %s";
            String name = String.format(format, i);
            Tesoro tesoro = new Tesoro(name, valor);

            tesoros.add(tesoro);

        }

    }

    public Tesoro getTesoro(){
        int pos = tools.getNumber(tesoros.size())-1;
        Tesoro tesoro = this.tesoros.get(pos);
        logger.debug("GeneradorTesoro", tesoro.toString());
        return tesoro;
    }

}
