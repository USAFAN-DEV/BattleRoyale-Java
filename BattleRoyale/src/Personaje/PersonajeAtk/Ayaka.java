package Personaje.PersonajeAtk;

import java.util.Random;

import Interfaces2.KeyHandler;
import Interfaces2.Mapa;
import Personaje.Jugador;

public class Ayaka extends Jugador{

    //Hereda todos los atributos de la clase Jugador

    //Constructor
    public Ayaka(Mapa mapa, KeyHandler keyHandler){

        super(100,100,25,0,100,0.5,0.25,"Atk","Ayaka","Kamisato Art: Soumetsu");
        this.mapa = mapa;
        this.keyHandler = keyHandler;
        getPlayerImage();

    }

    //METODOS

    //declaracion de la habilidad y que estadisticas va a modificar
    public void usarHabilidad(Jugador equipoEnemigo[],int indiceJugador){
        //necesito mas clases porque tengo que cambiar sus estadisticas 
        Random random=new Random();
        int num=random.nextInt(10)+1;
        int damage;
        //necesito mas clases porque tengo que cambiar sus estadisticas 
        if(super.getCrit()*10>=num){

            damage=(int)((super.getAtk()*2)*super.getEstadisticaHabilidad());

        }

        else{

            damage=(int)(super.getAtk()*super.getEstadisticaHabilidad());

        }

        if(equipoEnemigo[indiceJugador].getEscudo()>0){

            if((equipoEnemigo[indiceJugador].getEscudo()-damage)<0){

                damage=damage-equipoEnemigo[indiceJugador].getEscudo();
                equipoEnemigo[indiceJugador].setEscudo(0);
                equipoEnemigo[indiceJugador].setVida(equipoEnemigo[indiceJugador].getVida()-damage);

                if(equipoEnemigo[indiceJugador].getVida()<0){

                    equipoEnemigo[indiceJugador].setVida(0);

                }

            }

        }

        else{

            equipoEnemigo[indiceJugador].setVida(equipoEnemigo[indiceJugador].getVida()-damage);

            if(equipoEnemigo[indiceJugador].getVida()<0){

                equipoEnemigo[indiceJugador].setVida(0);

            }

        }

        if(num<=5){

            //congelar a un jugador necesitamos le sistema

        }
    }

    //descripcion de la habilidad
    public void descripcionHabilidad(){

        System.out.println();
        
    }
}
