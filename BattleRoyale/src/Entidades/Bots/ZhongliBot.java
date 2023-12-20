package Entidades.Bots;

import Entidades.PersonajeDefensa.Zhongli;
import Interfaces.Mapa;
import Interfaces.KeyHandler;

public class ZhongliBot extends Zhongli{
    
    public ZhongliBot(Mapa mapa, KeyHandler keyHandler, int mapaX, int mapaY){

        super(mapa, keyHandler);
        this.keyHandler = keyHandler;

        this.speed = 2;
        getCharacterImage();
        this.setMapaX(mapaX);
        this.setMapaY(mapaY);

    }

}
