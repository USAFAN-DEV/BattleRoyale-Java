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

        //Cofres plateados(peor loot)
        mapa.objetos[0] = new CofrePlateado(mapa,"cofre-plata.png", 13*mapa.getCasillaSizeEscalada(), 14*mapa.getCasillaSizeEscalada());
        mapa.objetos[1] = new CofrePlateado(mapa,"cofre-plata.png", 15*mapa.getCasillaSizeEscalada(), 37*mapa.getCasillaSizeEscalada());
        mapa.objetos[2] = new CofrePlateado(mapa,"cofre-plata.png", 21*mapa.getCasillaSizeEscalada(), 19*mapa.getCasillaSizeEscalada());
        mapa.objetos[3] = new CofrePlateado(mapa,"cofre-plata.png", 26*mapa.getCasillaSizeEscalada(), 45*mapa.getCasillaSizeEscalada());
        mapa.objetos[4] = new CofrePlateado(mapa,"cofre-plata.png", 57*mapa.getCasillaSizeEscalada(), 69*mapa.getCasillaSizeEscalada());
        mapa.objetos[5] = new CofrePlateado(mapa,"cofre-plata.png", 43*mapa.getCasillaSizeEscalada(), 70*mapa.getCasillaSizeEscalada());
        mapa.objetos[6] = new CofrePlateado(mapa,"cofre-plata.png", 43*mapa.getCasillaSizeEscalada(), 47*mapa.getCasillaSizeEscalada());
        mapa.objetos[7] = new CofrePlateado(mapa,"cofre-plata.png", 43*mapa.getCasillaSizeEscalada(), 36*mapa.getCasillaSizeEscalada());
        mapa.objetos[8] = new CofrePlateado(mapa,"cofre-plata.png", 50*mapa.getCasillaSizeEscalada(), 9*mapa.getCasillaSizeEscalada());
        mapa.objetos[9] = new CofrePlateado(mapa,"cofre-plata.png", 56*mapa.getCasillaSizeEscalada(), 16*mapa.getCasillaSizeEscalada());
        mapa.objetos[10] = new CofrePlateado(mapa,"cofre-plata.png", 73*mapa.getCasillaSizeEscalada(), 22*mapa.getCasillaSizeEscalada());
        mapa.objetos[11] = new CofrePlateado(mapa,"cofre-plata.png", 78*mapa.getCasillaSizeEscalada(), 34*mapa.getCasillaSizeEscalada());
        mapa.objetos[12] = new CofrePlateado(mapa,"cofre-plata.png", 92*mapa.getCasillaSizeEscalada(), 33*mapa.getCasillaSizeEscalada());
        mapa.objetos[13] = new CofrePlateado(mapa,"cofre-plata.png", 80*mapa.getCasillaSizeEscalada(), 53*mapa.getCasillaSizeEscalada());
        mapa.objetos[14] = new CofrePlateado(mapa,"cofre-plata.png", 81*mapa.getCasillaSizeEscalada(), 52*mapa.getCasillaSizeEscalada());


        //Cofres dorados
        mapa.objetos[15] = new CofreDorado(mapa, "cofre-oro.png", 21*mapa.getCasillaSizeEscalada(), 70*mapa.getCasillaSizeEscalada());
        mapa.objetos[16] = new CofreDorado(mapa, "cofre-oro.png", 51*mapa.getCasillaSizeEscalada(), 41*mapa.getCasillaSizeEscalada());
        mapa.objetos[17] = new CofreDorado(mapa, "cofre-oro.png", 80*mapa.getCasillaSizeEscalada(), 52*mapa.getCasillaSizeEscalada());
        mapa.objetos[18] = new CofreDorado(mapa, "cofre-oro.png", 81*mapa.getCasillaSizeEscalada(), 53*mapa.getCasillaSizeEscalada());

        /* 
        mapa.objetos[0] = new CofreDorado(mapa, "cofre-oro.png", 30*mapa.getCasillaSizeEscalada(), 29*mapa.getCasillaSizeEscalada());
        mapa.objetos[2] = new CofreDorado(mapa,"cofre-oro.png", 30*mapa.getCasillaSizeEscalada(), 28*mapa.getCasillaSizeEscalada());
        mapa.objetos[3] = new CofreDorado(mapa,"cofre-oro.png", 30*mapa.getCasillaSizeEscalada(), 27*mapa.getCasillaSizeEscalada());
        mapa.objetos[4] = new CofreDorado(mapa,"cofre-oro.png", 30*mapa.getCasillaSizeEscalada(), 26*mapa.getCasillaSizeEscalada());
        mapa.objetos[5] = new CofreDorado(mapa,"cofre-oro.png", 30*mapa.getCasillaSizeEscalada(), 25*mapa.getCasillaSizeEscalada());
        mapa.objetos[6] = new CofreDorado(mapa,"cofre-oro.png", 30*mapa.getCasillaSizeEscalada(), 24*mapa.getCasillaSizeEscalada());
        mapa.objetos[7] = new CofreDorado(mapa,"cofre-oro.png", 30*mapa.getCasillaSizeEscalada(), 23*mapa.getCasillaSizeEscalada());
        mapa.objetos[8] = new CofreDorado(mapa,"cofre-oro.png", 24*mapa.getCasillaSizeEscalada(),31*mapa.getCasillaSizeEscalada());
        mapa.objetos[9] = new CofreDorado(mapa,"cofre-oro.png", 26*mapa.getCasillaSizeEscalada(), 31*mapa.getCasillaSizeEscalada());
        */

    }

    public void colocarBots(){

        int zhongliX = 24 * mapa.getCasillaSizeEscalada(), zhongliY = 10 * mapa.getCasillaSizeEscalada();
        int qiqiX = 21 * mapa.getCasillaSizeEscalada(), qiqiY = 34 * mapa.getCasillaSizeEscalada();
        int meiX = 83 * mapa.getCasillaSizeEscalada(), meiY = 50 * mapa.getCasillaSizeEscalada();

        for(int i = 0; i < mapa.numeroDeBots; i++){

            if(i % 3 == 0){
                mapa.bots[i] = new ZhongliBot(mapa, mapa.keyHandler, zhongliX, zhongliY);
                zhongliX += 25 * mapa.getCasillaSizeEscalada();
            }
            if(i % 3 == 1){
                mapa.bots[i] = new QiqiBot(mapa, mapa.keyHandler, qiqiX, qiqiY);
                qiqiX += 33 * mapa.getCasillaSizeEscalada();
            }
            if(i % 3 == 2){
                mapa.bots[i] = new MeiBot(mapa, mapa.keyHandler, meiX, meiY);
                meiX -= 32 * mapa.getCasillaSizeEscalada();
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
        //mapa.bots[0] = new ZhongliBot(mapa, mapa.keyHandler, 25*mapa.getCasillaSizeEscalada(), 31*mapa.getCasillaSizeEscalada());

    }

}
