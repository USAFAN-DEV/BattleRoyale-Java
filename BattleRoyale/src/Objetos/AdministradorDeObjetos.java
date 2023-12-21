package Objetos;

import Interfaces.Mapa;
import Entidades.Bots.*;

public class AdministradorDeObjetos {
    
    Mapa mapa;

    public AdministradorDeObjetos(Mapa mapa){

        this.mapa = mapa;

    }

    public void colocarObjetos(){

        mapa.objetos[0] = new CofreDorado(mapa, "cofre-oro.png", 30*mapa.casillaSizeEscalada, 29*mapa.casillaSizeEscalada);
        mapa.objetos[1] = new CofrePlateado(mapa,"cofre-plata.png", 13*mapa.casillaSizeEscalada, 14*mapa.casillaSizeEscalada);
        mapa.objetos[2] = new CofreDorado(mapa,"cofre-oro.png", 30*mapa.casillaSizeEscalada, 28*mapa.casillaSizeEscalada);
        mapa.objetos[3] = new CofreDorado(mapa,"cofre-oro.png", 30*mapa.casillaSizeEscalada, 27*mapa.casillaSizeEscalada);
        mapa.objetos[4] = new CofreDorado(mapa,"cofre-oro.png", 30*mapa.casillaSizeEscalada, 26*mapa.casillaSizeEscalada);
        mapa.objetos[5] = new CofreDorado(mapa,"cofre-oro.png", 30*mapa.casillaSizeEscalada, 25*mapa.casillaSizeEscalada);
        mapa.objetos[6] = new CofreDorado(mapa,"cofre-oro.png", 30*mapa.casillaSizeEscalada, 24*mapa.casillaSizeEscalada);
        mapa.objetos[7] = new CofreDorado(mapa,"cofre-oro.png", 30*mapa.casillaSizeEscalada, 23*mapa.casillaSizeEscalada);
        mapa.objetos[8] = new CofreDorado(mapa,"cofre-oro.png", 24*mapa.casillaSizeEscalada,31*mapa.casillaSizeEscalada);
        mapa.objetos[9] = new CofreDorado(mapa,"cofre-oro.png", 26*mapa.casillaSizeEscalada, 31*mapa.casillaSizeEscalada);

    }

    public void colocarBots(){

        int zhongliX = 24 * mapa.casillaSizeEscalada, zhongliY = 10 * mapa.casillaSizeEscalada;
        int qiqiX = 21 * mapa.casillaSizeEscalada, qiqiY = 34 * mapa.casillaSizeEscalada;
        int meiX = 19 * mapa.casillaSizeEscalada, meiY = 50 * mapa.casillaSizeEscalada;

        for(int i = 0; i < mapa.bots.length; i++){

            if(i % 3 == 0){
                mapa.bots[i] = new ZhongliBot(mapa, mapa.keyHandler, zhongliX, zhongliY);
                zhongliX += 25;
            }
            if(i % 3 == 1){
                mapa.bots[i] = new QiqiBot(mapa, mapa.keyHandler, qiqiX, qiqiY);
                qiqiX += 33;
            }
            if(i % 3 == 2){
                mapa.bots[i] = new ZhongliBot(mapa, mapa.keyHandler, meiX, meiY);
                meiX += 32;
            }

        }
        //mapa.bots[0] = new ZhongliBot(mapa, mapa.keyHandler, 25*mapa.casillaSizeEscalada, 31*mapa.casillaSizeEscalada);

    }

}
