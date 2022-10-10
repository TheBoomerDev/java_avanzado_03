import logsystem.LogSystem;

public class Main implements  Runnable, Thread.UncaughtExceptionHandler{

    public void generaNullPointer(){

        Thread t = new Thread(new Main());
        t.setUncaughtExceptionHandler(this);
        t.start();

    }
    public static void main(String[] args) {
        System.out.println("Hello world!");

        LogSystem logger = LogSystem.getLogger();

        LogSystem.init.setLevel(LogSystem.Tipo.ERROR);

        logger.info("Main", "Hola, Buenos dias");
        logger.error("Main", "WTF... Ya de Mañana");

        Main obj = new Main();
        obj.generaNullPointer();
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        LogSystem logger = LogSystem.getLogger();
        logger.setLevel(LogSystem.Tipo.ERROR);
        logger.error("Main", "ERROR:"+e.getLocalizedMessage());

        e.printStackTrace();
    }

    @Override
    public void run() {
        // NullPointer
        Integer entero = null;
        int entero01 = entero;
    }
}