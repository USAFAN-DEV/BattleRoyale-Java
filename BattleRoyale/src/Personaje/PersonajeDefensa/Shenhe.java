package Personaje.PersonajeDefensa;

import Interfaces2.KeyHandler;
import Interfaces2.Mapa;
import Personaje.Jugador;

public class Shenhe extends Jugador{
    
    //Hereda todos los atributos de la clase Jugador

    //Constructor
    public Shenhe(Mapa mapa, KeyHandler keyHandler){

        super(100,100,25,0,200,0.25,0.25,"Defensa","Shenhe","Divine Maiden's Deliverance");
        this.mapa = mapa;
        this.keyHandler = keyHandler;
        getPlayerImage();

    }

    //METODOS

    //declaracion de la habilidad y que estadisticas va a modificar
    public void usarHabilidad(Jugador equipoEnemigo[]){ 
        //Reduce el escudo de los enemigos
        for(int i=0;i<equipoEnemigo.length;i++){

            equipoEnemigo[i].setEscudo((int)(equipoEnemigo[i].getEscudo()-super.getEstadisticaHabilidad()*super.getEscudoMaximo()));

            if(equipoEnemigo[i].getEscudo()<0){

                equipoEnemigo[i].setEscudo(0);

            }

        }

    }

    //descripcion de la habilidad
    public void descripcionHabilidad(){

        System.out.printf("Reduce el escudo de los enemigos en función de su escudo máximo. El escudo de los enemigos no podrá ser menor que 0. Escudo reducido=%f*%d",super.getEstadisticaHabilidad(),super.getEscudoMaximo());
        
    }
}
