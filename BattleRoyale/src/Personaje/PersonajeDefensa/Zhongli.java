package Personaje.PersonajeDefensa;

import Personaje.Jugador;

public class Zhongli extends Jugador{
    //rellenamos los datos del perseonaje correspondiendo con su tipo y el nombre
    public Zhongli(){
        super(100,100,25,0,200,0.25,0.25,"Defensa","Zhongli","Dominus Lapidis");
    }
    //declaracion de la habilidad y que estadisticas va a modificar
    public void usarHabilidad(Jugador equipo[]){
        //da escudo la habilidad al resto de equipo
        for(int i=0;i<equipo.length;i++){
            equipo[i].setEscudo((int)(equipo[i].getEscudo()+super.getEstadisticaHabilidad()*super.getEscudoMaximo()));
            if(equipo[i].getEscudo()>equipo[i].getEscudoMaximo()){
                equipo[i].setEscudo(equipo[i].getEscudoMaximo());
            }
        }
    } 
    public void descripcionHabilidad(){
        System.out.printf("Da escudo escudo al resto del equipo en función de su escudo máximo. El escudo recibido por un personaje no puede superar su escudo máximo. Escudo recibido= %f*%d",super.getEstadisticaHabilidad(),super.getEscudoMaximo());
    } 
}
