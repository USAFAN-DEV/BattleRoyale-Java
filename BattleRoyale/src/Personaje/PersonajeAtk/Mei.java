package Personaje.PersonajeAtk;

import Personaje.Jugador;
import java.util.Random;

public class Mei extends Jugador{
    //rellenamos los datos del perseonaje correspondiendo con su tipo y el nombre
    public Mei(){
        super(100,100,25,0,100,0.5,0.25,"Atk","Mei","Musou Shinsetsu");
    }
    public void usarHabilidad(Jugador equipoEnemigo[],int indiceJugador){
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
    }

    public void descripcionHabilidad(){
        System.out.printf("Mei realiza daño en función a su ataque y su porcentaje de crítico a un enemigo. Daño realizado(crítico)= %d*2*%f,Daño realizado(Sin crítico)=%d*%f",super.getAtk(),super.getEstadisticaHabilidad(),super.getAtk(),super.getEstadisticaHabilidad());
    }
}
