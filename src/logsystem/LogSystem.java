package logsystem;

public class LogSystem {

    private Tipo level = Tipo.INFO;

    public enum Tipo{
        INFO(0, 'I'),
        DEBUG(1, 'D'),
        WARN(2, 'W'),
        ERROR(3, 'E'),
        WTF(4, 'T');

        private final int prioridad;
        private final char letter;
        Tipo(int i, char letter) {
            this.letter = letter;
            this.prioridad = i;
        }
    }

    private LogSystem(){}
    public static final LogSystem init = new LogSystem();

    public static LogSystem getLogger(){
        return init;
    }

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

    public void error(String tag, Exception e){

        String message = e.getLocalizedMessage();
        String cause = e.getCause().getLocalizedMessage();
        String format = "ERROR: %s \r\n -> %s";
        String msg = String.format(format, cause, message);
        error(tag, msg);

        e.printStackTrace();
    }

    private void print(Tipo tipo, String tag, String msg){

        int prioridad = tipo.prioridad;
        int limite = level.prioridad;
        if (limite > prioridad) return;

        String format = "%s: (T:%s) => \r\n %s";
        char letter = tipo.letter;

        String txt = String.format(format, letter, tag, msg);
        System.out.println(txt);
    }
}
