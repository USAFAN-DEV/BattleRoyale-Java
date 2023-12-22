package Entidades.Bots;


import Entidades.PersonajeAtk.Mei;
import Main.KeyHandler;
import Main.Mapa;

public class MeiBot extends Mei{
    
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
