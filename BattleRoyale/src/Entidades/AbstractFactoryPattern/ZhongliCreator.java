package Entidades.AbstractFactoryPattern;

import Entidades.Personaje;
import Entidades.AbstractFactoryPattern.Bots.ZhongliBot;
import Entidades.AbstractFactoryPattern.Jugadores.ZhongliJugador;
import Main.KeyHandler;
import Main.Mapa;

public class ZhongliCreator implements EntidadesCreator{

    @Override
    public Personaje createJugador(Mapa mapa, KeyHandler keyHandler) {
        return new ZhongliJugador(mapa, keyHandler);
    }
    @Override
    public Personaje createBot(Mapa mapa, KeyHandler keyHandler, int mapaX, int mapaY) {
        return new ZhongliBot(mapa, keyHandler, mapaX, mapaY);
    }
    
}
