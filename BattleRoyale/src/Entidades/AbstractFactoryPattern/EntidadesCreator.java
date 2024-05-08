package Entidades.AbstractFactoryPattern;

import Entidades.Personaje;
import Main.KeyHandler;
import Main.Mapa;

public interface EntidadesCreator{
    public Personaje createJugador(Mapa mapa, KeyHandler keyHandler);
    public Personaje createBot(Mapa mapa, KeyHandler keyHandler, int mapaX, int mapaY);
}