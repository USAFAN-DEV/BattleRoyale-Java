package Objetos;

import Entidades.AbstractFactoryPattern.Bots.*;
import Herramientas.*;
import Herramientas.ArmasAtaque.EngulfingLightning;
import Herramientas.ArmasAtaque.SacrificialFragments;
import Herramientas.ArmasDefensa.StaffOfHoma;
import Herramientas.ArmasDefensa.TheCatch;
import Herramientas.ArmasVida.AquilaFavonia;
import Herramientas.ArmasVida.SacrificialSword;
import Main.Mapa;

public class AdministradorDeObjetos {
    
    private Mapa mapa;

    public AdministradorDeObjetos(Mapa mapa){

        this.mapa = mapa;

    }

    public void colocarObjetos(){

        //Cofres plateados(peor loot)
        mapa.getObjetos()[0] = new CofrePlateado(mapa,"cofre-plata.png", 13*mapa.getCasillaSizeEscalada(), 14*mapa.getCasillaSizeEscalada());
        mapa.getObjetos()[1] = new CofrePlateado(mapa,"cofre-plata.png", 15*mapa.getCasillaSizeEscalada(), 37*mapa.getCasillaSizeEscalada());
        mapa.getObjetos()[2] = new CofrePlateado(mapa,"cofre-plata.png", 21*mapa.getCasillaSizeEscalada(), 19*mapa.getCasillaSizeEscalada());
        mapa.getObjetos()[3] = new CofrePlateado(mapa,"cofre-plata.png", 26*mapa.getCasillaSizeEscalada(), 45*mapa.getCasillaSizeEscalada());
        mapa.getObjetos()[4] = new CofrePlateado(mapa,"cofre-plata.png", 57*mapa.getCasillaSizeEscalada(), 69*mapa.getCasillaSizeEscalada());
        mapa.getObjetos()[5] = new CofrePlateado(mapa,"cofre-plata.png", 43*mapa.getCasillaSizeEscalada(), 70*mapa.getCasillaSizeEscalada());
        mapa.getObjetos()[6] = new CofrePlateado(mapa,"cofre-plata.png", 43*mapa.getCasillaSizeEscalada(), 47*mapa.getCasillaSizeEscalada());
        mapa.getObjetos()[7] = new CofrePlateado(mapa,"cofre-plata.png", 43*mapa.getCasillaSizeEscalada(), 36*mapa.getCasillaSizeEscalada());
        mapa.getObjetos()[8] = new CofrePlateado(mapa,"cofre-plata.png", 50*mapa.getCasillaSizeEscalada(), 9*mapa.getCasillaSizeEscalada());
        mapa.getObjetos()[9] = new CofrePlateado(mapa,"cofre-plata.png", 56*mapa.getCasillaSizeEscalada(), 16*mapa.getCasillaSizeEscalada());
        mapa.getObjetos()[10] = new CofrePlateado(mapa,"cofre-plata.png", 73*mapa.getCasillaSizeEscalada(), 22*mapa.getCasillaSizeEscalada());
        mapa.getObjetos()[11] = new CofrePlateado(mapa,"cofre-plata.png", 78*mapa.getCasillaSizeEscalada(), 34*mapa.getCasillaSizeEscalada());
        mapa.getObjetos()[12] = new CofrePlateado(mapa,"cofre-plata.png", 92*mapa.getCasillaSizeEscalada(), 33*mapa.getCasillaSizeEscalada());
        mapa.getObjetos()[13] = new CofrePlateado(mapa,"cofre-plata.png", 80*mapa.getCasillaSizeEscalada(), 53*mapa.getCasillaSizeEscalada());
        mapa.getObjetos()[14] = new CofrePlateado(mapa,"cofre-plata.png", 81*mapa.getCasillaSizeEscalada(), 52*mapa.getCasillaSizeEscalada());


        //Cofres dorados
        mapa.getObjetos()[15] = new CofreDorado(mapa, "cofre-oro.png", 21*mapa.getCasillaSizeEscalada(), 70*mapa.getCasillaSizeEscalada());
        mapa.getObjetos()[16] = new CofreDorado(mapa, "cofre-oro.png", 51*mapa.getCasillaSizeEscalada(), 41*mapa.getCasillaSizeEscalada());
        mapa.getObjetos()[17] = new CofreDorado(mapa, "cofre-oro.png", 80*mapa.getCasillaSizeEscalada(), 52*mapa.getCasillaSizeEscalada());
        mapa.getObjetos()[18] = new CofreDorado(mapa, "cofre-oro.png", 81*mapa.getCasillaSizeEscalada(), 53*mapa.getCasillaSizeEscalada());

    }

    public void colocarBots(){

        int zhongliX = 24 * mapa.getCasillaSizeEscalada(), zhongliY = 10 * mapa.getCasillaSizeEscalada();
        int qiqiX = 21 * mapa.getCasillaSizeEscalada(), qiqiY = 34 * mapa.getCasillaSizeEscalada();
        int meiX = 83 * mapa.getCasillaSizeEscalada(), meiY = 50 * mapa.getCasillaSizeEscalada();

        for(int i = 0; i < mapa.getNumeroDeBots(); i++){

            if(i % 3 == 0){
                //mapa.getBots()[i] = new ZhongliBot(mapa, mapa.getKeyHandler(), zhongliX, zhongliY);
                mapa.getBots()[i] = mapa.getZhongliCreator().createBot(mapa, mapa.getKeyHandler(), zhongliX, zhongliY);
                zhongliX += 25 * mapa.getCasillaSizeEscalada();
            }
            if(i % 3 == 1){
                //mapa.getBots()[i] = new QiqiBot(mapa, mapa.getKeyHandler(), qiqiX, qiqiY);
                mapa.getBots()[i] = mapa.getQiqiCreator().createBot(mapa, mapa.getKeyHandler(), qiqiX, qiqiY);
                qiqiX += 33 * mapa.getCasillaSizeEscalada();
            }
            if(i % 3 == 2){
                //mapa.getBots()[i] = new MeiBot(mapa, mapa.getKeyHandler(), meiX, meiY);
                mapa.getBots()[i] = mapa.getMeiCreator().createBot(mapa, mapa.getKeyHandler(), meiX, meiY);
                meiX -= 32 * mapa.getCasillaSizeEscalada();
            }

        }
        if(mapa.getDificultadBots() == 2){
            Armas armaAtaque = new SacrificialFragments();
            Armas armaDefensa = new TheCatch();
            Armas armaVida = new SacrificialSword();

            for(int i = 0; i < mapa.getNumeroDeBots(); i++){

                if(i % 3 == 0){
                    mapa.getBots()[i].setArma(armaDefensa);
                    mapa.getBots()[i].getArma().aplicarStatsArma(mapa.getBots()[i]);
                }
                if(i % 3 == 1){
                    mapa.getBots()[i].setArma(armaVida);
                    mapa.getBots()[i].getArma().aplicarStatsArma(mapa.getBots()[i]);
                }
                if(i % 3 == 2){
                    mapa.getBots()[i].setArma(armaAtaque);
                    mapa.getBots()[i].getArma().aplicarStatsArma(mapa.getBots()[i]);
                }

            }

        }
        else if(mapa.getDificultadBots() == 3){
            Armas armaAtaque = new EngulfingLightning();
            Armas armaDefensa = new StaffOfHoma();
            Armas armaVida = new AquilaFavonia();

            for(int i = 0; i < mapa.getNumeroDeBots(); i++){

                if(i % 3 == 0){
                    mapa.getBots()[i].setArma(armaDefensa);
                    mapa.getBots()[i].getArma().aplicarStatsArma(mapa.getBots()[i]);
                }
                if(i % 3 == 1){
                    mapa.getBots()[i].setArma(armaVida);
                    mapa.getBots()[i].getArma().aplicarStatsArma(mapa.getBots()[i]);
                }
                if(i % 3 == 2){
                    mapa.getBots()[i].setArma(armaAtaque);
                    mapa.getBots()[i].getArma().aplicarStatsArma(mapa.getBots()[i]);
                }

            }

        }

    }

}
