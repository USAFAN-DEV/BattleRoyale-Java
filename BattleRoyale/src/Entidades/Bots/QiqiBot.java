package Entidades.Bots;

import Entidades.PersonajeHealer.Qiqi;
import Interfaces.Mapa;
import Interfaces.KeyHandler;

public class QiqiBot extends Qiqi{
    
    public QiqiBot(Mapa mapa, KeyHandler keyHandler, int mapaX, int mapaY){

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

