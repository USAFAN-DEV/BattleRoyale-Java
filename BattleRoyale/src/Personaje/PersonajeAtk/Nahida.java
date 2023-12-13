package Personaje.PersonajeAtk;

import java.util.Random;

import Interfaces2.KeyHandler;
import Interfaces2.Mapa;
import Personaje.Jugador;

public class Nahida extends Jugador{

    //Hereda todos los atributos de la clase Jugador

    //Constructor
    public Nahida(Mapa mapa, KeyHandler keyHandler){

        //Ajustar estadistica habilidad
        super(100,100,25,0,100,0.5,0.25,"Atk","Nahida","All Schemes to Know");
        this.mapa = mapa;
        this.keyHandler = keyHandler;
        getPlayerImage();

    }

    //METODOS

    //declaracion de la habilidad y que estadisticas va a modificar
    public void usarHabilidad(Jugador equipoEnemigo[]){

        Random random=new Random();
        int num=random.nextInt(10)+1;
        int damage=0;
        //necesito mas clases porque tengo que cambiar sus estadisticas 
        if(super.getCrit()*10>=num){

            damage=(int)((super.getAtk()*2)*super.getEstadisticaHabilidad());

        }

        else{

            damage=(int)(super.getAtk()*super.getEstadisticaHabilidad());
            
        }

        for(int indiceJugador=0;indiceJugador<equipoEnemigo.length;indiceJugador++){

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

        }

    }

    //descripcion de la habilidad
    public void descripcionHabilidad(){

        System.out.printf("Nahida realiza daño en area en función a su ataque y su porcentaje de crítico. Daño realizado(crítico)= %d*2*%f,Daño realizado(Sin crítico)=%d*%f",super.getAtk(),super.getEstadisticaHabilidad(),super.getAtk(),super.getEstadisticaHabilidad());

    }
}
