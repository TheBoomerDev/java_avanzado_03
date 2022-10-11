package piratasGame.game.luchadores.insultos;

import piratasGame.game.luchadores.jugadores.PJ;

public interface PeleaDeInsultos {

    public String recogerInsulto();

    /**
     *
     * @param pj - A quien insultamos
     * @param insulto - El insulto que insultamos
     * @return - <strong>Null</strong> => No respondió correctamente
     * <strong>String</strong> => Comprobamos si es el correcto o si no lo tenemos.
     * -> En caso que sea el correcto, perdemos vida
     */
    public String insultar(PJ pj, String insulto);
}
