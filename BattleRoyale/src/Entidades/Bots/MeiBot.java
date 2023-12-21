package Entidades.Bots;

import java.awt.Rectangle;

import Entidades.PersonajeDefensa.Zhongli;
import Interfaces.Mapa;
import Interfaces.KeyHandler;

public class MeiBot extends Zhongli{
    
    public MeiBot(Mapa mapa, KeyHandler keyHandler, int mapaX, int mapaY){

        super(mapa, keyHandler);
        this.keyHandler = keyHandler;

        this.speed = 2;
        getCharacterImage();
        this.setMapaX(mapaX);
        this.setMapaY(mapaY);
        /*this.areaDeColisionDefaultX = mapa.casillaSizeEscalada;
        this.areaDeColisionDefaultY = mapa.casillaSizeEscalada;
        this.areaDeCollision = new Rectangle(0, 0, mapa.casillaSizeEscalada, mapa.casillaSizeEscalada);*/

    }

}
