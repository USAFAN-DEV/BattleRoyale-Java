package Entidades.AbstractFactoryPattern;

import Entidades.Bot;
import Entidades.Personaje;
import Main.KeyHandler;
import Main.Mapa;

public interface EntidadesCreator{
    public Personaje createJugador(Mapa mapa, KeyHandler keyHandler);
    public Bot createBot(Mapa mapa, KeyHandler keyHandler, int mapaX, int mapaY);
}