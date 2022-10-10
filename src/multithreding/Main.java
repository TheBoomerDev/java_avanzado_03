package multithreding;

import logsystem.LogSystem;
import multithreding.utils.Avisamos;
import multithreding.utils.Trabajo;
import multithreding.utils.Utils;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        LogSystem logger = LogSystem.getLogger();


        List<String> cadenasTexto = new ArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            String rndName = Utils.instance.getRandomName();
            cadenasTexto.add(rndName+"-"+i);
        }

        Trabajo trabajador = new Trabajo();
        trabajador.empezamos(cadenasTexto, new Avisamos() {
            @Override
            public void progreso(Integer percent) {
                logger.info("Main", "Progeso Actual "+percent);
            }

            @Override
            public void haTerminado(List<String> resultado) {
                logger.info("Main", resultado.toString());
            }
        });



    }
}
