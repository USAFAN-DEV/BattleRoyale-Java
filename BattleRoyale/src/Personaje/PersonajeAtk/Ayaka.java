package Personaje.PersonajeAtk;

import java.util.Random;

import Personaje.Jugador;

public class Ayaka extends Jugador{
    //rellenamos los datos del perseonaje correspondiendo con su tipo y el nombre
    public Ayaka(){
        super(100,100,25,0,100,0.5,0.25,"Atk","Ayaka","Kamisato Art: Soumetsu");
    }
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
    public void descripcionHabilidad(){
        System.out.println();
    }
}
