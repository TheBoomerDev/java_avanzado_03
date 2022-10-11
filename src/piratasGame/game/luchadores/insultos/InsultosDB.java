package piratasGame.game.luchadores.insultos;

import logsystem.LogSystem;
import multithreding.utils.Utils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
DATASOURCE -> DAO
 */
public class InsultosDB {

    private static final String fileName = "insultos.txt";
    private LogSystem logger = LogSystem.getLogger();
    private Utils tools = Utils.instance;
    private InsultosDB(){
        init();
    }
    public static final InsultosDB instance = new InsultosDB();

    private List<Insultos> allInsultos = new ArrayList<Insultos>();

    private void init(){
        FileHandler handler = new FileHandler(fileName);
        try {
            handler.read();
        } catch (FileNotFoundException e) {
            logger.error("InsultosDB", e);
            return;
        }

        List<String> insultosFilas = handler.getLines();
        allInsultos = insultosFilas.stream()
                            .map(Insultos::fromLine)
                            .collect(Collectors.toList());
    }

    public List<Insultos> get(int cuantos){
        return get(cuantos, true);
    }

    public List<Insultos> get(int cuantos, boolean conRespuesta){

        List<Insultos> res = new ArrayList<>();

        while(res.size() < cuantos){
            // Clausulas de Salvaguarda
            int pos = tools.getNumber(allInsultos.size())-1;
            Insultos insulto = allInsultos.get(pos);
            if (res.contains(insulto)){
                continue;
            }

            if (conRespuesta){
                res.add(insulto);
                continue;
            }

            try {
                Insultos clone = (Insultos) insulto.clone();
                res.add(clone);
            } catch (CloneNotSupportedException e) {
                logger.error("InsultosDB", e);
            }

        }

        return res;

        /*

        // PRoblemas =>
        // 1.- No podemos asegurar que en caso que se repita alguno de los insultos,
        // el tamaño del array corresponda con lo que nos piden


        List<Insultos> res = new ArrayList<>();
        for (int i = 0; i < cuantos; i++) {

            int pos = tools.getNumber(allInsultos.size())-1;
            Insultos insulto = allInsultos.get(pos);
            if (!res.contains(insulto)){
                res.add(insulto);
            }

        }

        return res;

         */
    }

}
