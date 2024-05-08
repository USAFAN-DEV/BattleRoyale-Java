package Entidades.AbstractFactoryPattern;

import Entidades.Personaje;
import Entidades.AbstractFactoryPattern.Bots.QiqiBot;
import Entidades.AbstractFactoryPattern.Jugadores.QiqiJugador;
import Main.KeyHandler;
import Main.Mapa;

public class QiqiCreator implements EntidadesCreator{

    @Override
    public Personaje createJugador(Mapa mapa, KeyHandler keyHandler) {
        return new QiqiJugador(mapa, keyHandler);
    }

    @Override
    public Personaje createBot(Mapa mapa, KeyHandler keyHandler, int mapaX, int mapaY) {
        return new QiqiBot(mapa, keyHandler, mapaX, mapaY);
    }
    
}
