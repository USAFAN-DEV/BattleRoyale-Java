package Entidades.AbstractFactoryPattern;

import Entidades.Personaje;
import Entidades.AbstractFactoryPattern.Bots.MeiBot;
import Entidades.AbstractFactoryPattern.Jugadores.MeiJugador;
import Main.KeyHandler;
import Main.Mapa;

public class MeiCreator implements EntidadesCreator{

    @Override
    public Personaje createJugador(Mapa mapa, KeyHandler keyHandler) {
        return new MeiJugador(mapa, keyHandler);
    }

    @Override
    public Personaje createBot(Mapa mapa, KeyHandler keyHandler, int mapaX, int mapaY) {
        return new MeiBot(mapa, keyHandler, mapaX, mapaY);
    }
    
}
