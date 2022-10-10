package multithreding.utils;

import logsystem.LogSystem;

import java.util.List;

public class Trabajo {

    private LogSystem logger = LogSystem.getLogger();
    private Avisamos listener;

    private AsyncTask<List<String>, Integer, List<String>> asyncTask = new AsyncTask<List<String>, Integer, List<String>>() {
        @Override
        public Integer doInBackground(List<String>... datos) {
            final List<String>[] datosFinal = datos;
            Secundario hilo = new Secundario(new CosasTrabajo() {
                @Override
                public int trabaja() throws InterruptedException {

                    List<String> datosCurro = datosFinal[0];

                    int contador = 0;
                    for (String cadena : datosCurro) {
                        cadena = cadena.toLowerCase();
                        contador++;
                        Thread.sleep(500);
                        onProgressUpdate(contador);
                    }
                    onPostExecute(datosCurro);
                    return 0;
                }
            });
            hilo.run();
            return null;
        }

        @Override
        synchronized public void onProgressUpdate(Integer... progress) {
            Integer realProgress = progress[0];
            logger.info("PROGESS", ""+realProgress);
            listener.progreso(realProgress);
        }

        @Override
        synchronized public void onPostExecute(List<String> result) {
            logger.info("TERMINADO", result.toString());
            listener.haTerminado(result);
        }
    };

    public void empezamos(List<String> cadenas, Avisamos listener){
        this.listener = listener;
        asyncTask.doInBackground(cadenas);

    }

}
