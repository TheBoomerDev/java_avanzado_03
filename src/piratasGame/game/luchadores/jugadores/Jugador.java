package piratasGame.game.luchadores.jugadores;

import piratasGame.game.luchadores.insultos.Insultos;
import piratasGame.game.luchadores.insultos.InsultosDB;
import piratasGame.game.tesoros.GeneradorTesoro;
import piratasGame.game.tesoros.Tesoro;

import java.util.ArrayList;
import java.util.List;

public class Jugador extends PJ{

    private static final int numeroInsultos = 3;
    private final List<Insultos> insultos;

    private String name = "";

    public Jugador(String name){
        this.name = name;
        this.insultos = InsultosDB.instance.get(numeroInsultos, false);
        this.inventario = new ArrayList<Tesoro>();

        Tesoro objInicial = GeneradorTesoro.instance.getTesoro();
        this.inventario.add(objInicial);
    }

    private List<Tesoro> inventario = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tesoro> getInventario() {
        return inventario;
    }

    public void setInventario(List<Tesoro> inventario) {
        this.inventario = inventario;
    }

    @Override
    Tesoro getTesoro() {
        if (this.inventario.isEmpty()) return null;
        Tesoro miTesoro = this.inventario.stream().max(Tesoro::compareTo).get();
        return miTesoro;
    }

    @Override
    boolean peleaConObjetos(PJ pj) {

        Tesoro tJugador = this.getTesoro();
        Tesoro tEnemigo = pj.getTesoro();

        boolean check = quienEsMasValioso(tJugador, tEnemigo);
        if (check){
            tEnemigo.subeValor();
            this.inventario.add(tEnemigo);
        }
        return check;
    }


    public void quitarVida(int valor) {
        this.vida = this.vida - valor;
    }
}
