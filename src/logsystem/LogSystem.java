package logsystem;

public class LogSystem {

    private Tipo level = Tipo.INFO;

    public enum Tipo{
        INFO(0),
        DEBUG(1),
        WARN(2),
        ERROR(3);

        private final int prioridad;
        Tipo(int i) {
            this.prioridad = i;
        }
    }

    private LogSystem(){}
    public static final LogSystem init = new LogSystem();

    public void setLevel(Tipo tipo){
        this.level = tipo;
    }

    public void info(String tag, String msg){
        print(Tipo.INFO, tag, msg);
    }

    public void debug(String tag, String msg){
        print(Tipo.DEBUG, tag, msg);
    }

    public void warn(String tag, String msg){
        print(Tipo.WARN, tag, msg);
    }
    public void error(String tag, String msg){
        print(Tipo.ERROR, tag, msg);
    }

    private void print(Tipo tipo, String tag, String msg){

        int prioridad = tipo.prioridad;
        int limite = level.prioridad;
        if (limite > prioridad) return;

        String format = "%s => %s";
        String txt = String.format(format, tag, msg);
        System.out.println(txt);
    }
}
