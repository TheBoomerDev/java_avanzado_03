import logsystem.LogSystem;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        LogSystem logger = LogSystem.getLogger();

        LogSystem.init.setLevel(LogSystem.Tipo.ERROR);


        logger.info("Main", "Hola, Buenos dias");
        logger.error("Main", "WTF... Ya de Mañana");
    }
}