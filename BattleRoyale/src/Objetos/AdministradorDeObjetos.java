package Objetos;

import Interfaces2.Mapa;

public class AdministradorDeObjetos {
    
    Mapa mapa;

    public AdministradorDeObjetos(Mapa mapa){

        this.mapa = mapa;

    }

    public void colocarObjetos(){

        mapa.objetos[0] = new Coin("coin.png", 11*mapa.casillaSizeEscalada, 11*mapa.casillaSizeEscalada);
        mapa.objetos[1] = new Coin("coin.png", 26*mapa.casillaSizeEscalada, 9*mapa.casillaSizeEscalada);
        mapa.objetos[2] = new CofreDorado("cofre-oro.png", 23*mapa.casillaSizeEscalada, 70*mapa.casillaSizeEscalada);
        mapa.objetos[3] = new CofrePlateado("cofre-plata.png", 13*mapa.casillaSizeEscalada, 14*mapa.casillaSizeEscalada);

    }

}
