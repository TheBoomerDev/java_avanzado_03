package ejercicios.ej01;

public class Main {

    /*

       Hacer un enumerado de Piedra, Papel y Tijera.
       Generar una función qué devuelva un enumerado aleatorio,
       y una función qué diga sí el jugador 1 ganó al jugador 2.

      Y “jugar 10 partdidas”, llevar un conteo de quién es el qué gana.

    //*/

    public static void main(String[] args) {

        Game juego = Game.instance;
        juego.init();

        juego.empezamosPartida();

        juego.resumenPartida();

    }
}
