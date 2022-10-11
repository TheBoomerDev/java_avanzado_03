package piratasGame.game.luchadores.jugadores;

import multithreding.utils.Utils;
import piratasGame.game.luchadores.Pelea;
import piratasGame.game.luchadores.TipoPelea;
import piratasGame.game.tesoros.Tesoro;

public abstract class PJ implements Pelea {

    private Utils tools = Utils.instance;
    private int percent = 5;

    // fuerza, destreza, constitución, sabiduria
    private int fuerza = 10;
    private int destreza = 10;
    private int constitución = 10;
    private int sabiduria = 10;

    protected int vida = 100;

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getConstitución() {
        return constitución;
    }

    public void setConstitución(int constitución) {
        this.constitución = constitución;
    }

    public int getSabiduria() {
        return sabiduria;
    }

    public void setSabiduria(int sabiduria) {
        this.sabiduria = sabiduria;
    }

    public int getVida() {
        return vida;
    }

    public void addVida(int vida){
        this.vida = this.vida + vida;
    }

    public boolean estaVivo(){
        return this.vida > 0;
    }

    @Override
    public boolean peleaCon(TipoPelea tipoPelea, PJ pj) {

        boolean check = false;

        switch (tipoPelea){
            case ATRIBUTOS -> {
                check = peleaConAtributos(pj);
            }
            case OBJETOS -> {
                check = peleaConObjetos(pj);
            }
            case INSULTOS -> {
                check = peleaConInsultos(pj);
            }
        }

        return check;
    }

    private int subeExperiencia(int valor){
        int aSubir = (valor * percent) / 100;
        valor = valor + aSubir;
        return valor;
    }

    private boolean peleaConAtributos(PJ pj) {
        // TODO: Generar una función generica para DRY KISS
        int rnd = tools.getNumber(3);
        switch (rnd){
            case 0->{
                // fuerza
                int pjAt = pj.getFuerza();
                int curAt = this.getFuerza();
                boolean ganador = (curAt >= pjAt);
                if (ganador){
                    curAt = this.subeExperiencia(curAt);
                    this.setFuerza(curAt);
                }
                return ganador;
            }
            case 1 ->{
                // destreza
                int pjAt = pj.getDestreza();
                int curAt = this.getDestreza();
                boolean ganador = (curAt >= pjAt);
                if (ganador){
                    curAt = this.subeExperiencia(curAt);
                    this.setDestreza(curAt);
                }
                return ganador;
            }
            case 2 ->{
                // constitucion
                int pjAt = pj.getConstitución();
                int curAt = this.getConstitución();
                boolean ganador = (curAt >= pjAt);
                if (ganador){
                    curAt = this.subeExperiencia(curAt);
                    this.setConstitución(curAt);
                }
                return ganador;
            }
            case 3 ->{
                // sabiduria
                int pjAt = pj.getSabiduria();
                int curAt = this.getSabiduria();
                boolean ganador = (curAt >= pjAt);
                if (ganador){
                    curAt = this.subeExperiencia(curAt);
                    this.setSabiduria(curAt);
                }
                return ganador;
            }
        }
        return false;
    }

    abstract boolean peleaConObjetos(PJ pj);

    protected boolean quienEsMasValioso(Tesoro tJugador, Tesoro tEnemigo){
        if (tJugador == null || tEnemigo == null) return true;

        int check = tJugador.compareTo(tEnemigo);
        return (check >= 0);
    }

    abstract Tesoro getTesoro();

    private boolean peleaConInsultos(PJ pj) {
        return false;
    }
}
