package ejercicios.ej01_exception;

import ejercicios.ej01.Game;
import logsystem.LogSystem;

public class Main implements  Runnable, Thread.UncaughtExceptionHandler{

    /*
       Hacer un enumerado de Piedra, Papel y Tijera.
       Generar una función qué devuelva un enumerado aleatorio,
       y una función qué diga sí el jugador 1 ganó al jugador 2.

      Y “jugar 10 partdidas”, llevar un conteo de quién es el qué gana.

    //*/

    public static void main(String[] args) {
        ( new Main() ).run();
    }

    @Override
    public void run() {
        Game juego = Game.instance;
        juego.init();

        juego.empezamosPartida();

        juego.resumenPartida();
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        LogSystem logger = LogSystem.getLogger();
        logger.setLevel(LogSystem.Tipo.ERROR);
        logger.error("Main", "ERROR:"+e.getLocalizedMessage());

        e.printStackTrace();
    }
}
