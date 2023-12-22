package Objetos;

import Interfaces.Mapa;
import Herramientas.*;
import Herramientas.ArmasAtaque.EngulfingLightning;
import Herramientas.ArmasAtaque.SacrificialFragments;
import Herramientas.ArmasDefensa.StaffOfHoma;
import Herramientas.ArmasDefensa.TheCatch;
import Herramientas.ArmasVida.AquilaFavonia;
import Herramientas.ArmasVida.SacrificialSword;
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

        for(int i = 0; i < mapa.numeroDeBots; i++){

            if(i % 3 == 0){
                mapa.bots[i] = new ZhongliBot(mapa, mapa.keyHandler, zhongliX, zhongliY);
                zhongliX += 25 * mapa.casillaSizeEscalada;
            }
            if(i % 3 == 1){
                mapa.bots[i] = new QiqiBot(mapa, mapa.keyHandler, qiqiX, qiqiY);
                qiqiX += 33 * mapa.casillaSizeEscalada;
            }
            if(i % 3 == 2){
                mapa.bots[i] = new MeiBot(mapa, mapa.keyHandler, meiX, meiY);
                meiX += 32 * mapa.casillaSizeEscalada;
            }

        }
        if(mapa.dificultadBots == 2){
            Armas armaAtaque = new SacrificialFragments();
            Armas armaDefensa = new TheCatch();
            Armas armaVida = new SacrificialSword();

            for(int i = 0; i < mapa.numeroDeBots; i++){

                if(i % 3 == 0){
                    mapa.bots[i].arma = armaDefensa;
                    mapa.bots[i].arma.aplicarStatsArma(mapa.bots[i]);
                }
                if(i % 3 == 1){
                    mapa.bots[i].arma = armaVida;
                    mapa.bots[i].arma.aplicarStatsArma(mapa.bots[i]);
                }
                if(i % 3 == 2){
                    mapa.bots[i].arma = armaAtaque;
                    mapa.bots[i].arma.aplicarStatsArma(mapa.bots[i]);
                }

            }

        }
        else if(mapa.dificultadBots == 3){
            Armas armaAtaque = new EngulfingLightning();
            Armas armaDefensa = new StaffOfHoma();
            Armas armaVida = new AquilaFavonia();

            for(int i = 0; i < mapa.numeroDeBots; i++){

                if(i % 3 == 0){
                    mapa.bots[i].arma = armaDefensa;
                    mapa.bots[i].arma.aplicarStatsArma(mapa.bots[i]);
                    mapa.bots[i].setEscudo(50);
                }
                if(i % 3 == 1){
                    mapa.bots[i].arma = armaVida;
                    mapa.bots[i].arma.aplicarStatsArma(mapa.bots[i]);
                    mapa.bots[i].setEscudo(50);
                }
                if(i % 3 == 2){
                    mapa.bots[i].arma = armaAtaque;
                    mapa.bots[i].arma.aplicarStatsArma(mapa.bots[i]);
                    mapa.bots[i].setEscudo(50);
                }

            }

        }
        //mapa.bots[0] = new ZhongliBot(mapa, mapa.keyHandler, 25*mapa.casillaSizeEscalada, 31*mapa.casillaSizeEscalada);

    }

}
