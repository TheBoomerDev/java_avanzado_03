package ejercicios.ej01;

import java.util.Random;

public class Jugador {

    public Jugador(String name){
        this.name = "PJ-"+name;
    }
    Random random = new Random();

    private String name = "";

    private int partidasGanadas = 0;

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public void gano(){
        this.partidasGanadas++;
    }

    public int getNumber(int max){
        return random.nextInt(max + 1 - 1) + 1;
    }

    public Valores dameJugada() {
        Valores[] valores = Valores.values();
        int rnd = getNumber(valores.length) - 1;
        return valores[rnd];
    }

    @Override
    public String toString() {
        return this.name;
    }
}
