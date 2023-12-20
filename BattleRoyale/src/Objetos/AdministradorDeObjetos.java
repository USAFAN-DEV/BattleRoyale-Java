package Objetos;

import Interfaces.Mapa;
import Entidades.Bots.*;

public class AdministradorDeObjetos {
    
    Mapa mapa;

    public AdministradorDeObjetos(Mapa mapa){

        this.mapa = mapa;

    }

    public void colocarObjetos(){

        mapa.objetos[0] = new CofreDorado("cofre-oro.png", 30*mapa.casillaSizeEscalada, 29*mapa.casillaSizeEscalada);
        mapa.objetos[1] = new CofrePlateado("cofre-plata.png", 13*mapa.casillaSizeEscalada, 14*mapa.casillaSizeEscalada);
        mapa.objetos[2] = new CofreDorado("cofre-oro.png", 30*mapa.casillaSizeEscalada, 28*mapa.casillaSizeEscalada);
        mapa.objetos[3] = new CofreDorado("cofre-oro.png", 30*mapa.casillaSizeEscalada, 27*mapa.casillaSizeEscalada);
        mapa.objetos[4] = new CofreDorado("cofre-oro.png", 30*mapa.casillaSizeEscalada, 26*mapa.casillaSizeEscalada);
        mapa.objetos[5] = new CofreDorado("cofre-oro.png", 30*mapa.casillaSizeEscalada, 25*mapa.casillaSizeEscalada);
        mapa.objetos[6] = new CofreDorado("cofre-oro.png", 30*mapa.casillaSizeEscalada, 24*mapa.casillaSizeEscalada);
        mapa.objetos[7] = new CofreDorado("cofre-oro.png", 30*mapa.casillaSizeEscalada, 23*mapa.casillaSizeEscalada);
        mapa.objetos[8] = new CofreDorado("cofre-oro.png", 24*mapa.casillaSizeEscalada,31*mapa.casillaSizeEscalada);
        mapa.objetos[9] = new CofreDorado("cofre-oro.png", 26*mapa.casillaSizeEscalada, 31*mapa.casillaSizeEscalada);

    }

    public void colocarBots(){

        mapa.bots[0] = new ZhongliBot(mapa, mapa.keyHandler, 25*mapa.casillaSizeEscalada, 31*mapa.casillaSizeEscalada);

    }

}
