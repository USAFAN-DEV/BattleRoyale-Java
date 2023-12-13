package Personaje.PersonajeHealer;

import Interfaces2.KeyHandler;
import Interfaces2.Mapa;
import Personaje.Jugador;

public class Shinobu extends Jugador{

    //Hereda todos los atributos de la clase Jugador

    //Constructor
    public Shinobu(Mapa mapa, KeyHandler keyHandler){

        super(200,200,25,0,100,0.25,0.25,"Healer","Shinobu","Sanctifying Ring");
        this.mapa = mapa;
        this.keyHandler = keyHandler;
        getPlayerImage();

    }

    //METODOS

    //declaracion de la habilidad y que estadisticas va a modificar
    public void usarHabilidad(){

        //necesito mas clases porque tengo que cambiar sus estadisticas 
        //Cura una cierta cantidad los proximos 3 turno al personajes con menos vida, cooldown 5 turnos
        
    }

    //descripcion de la habilidad
    public void descripcionHabilidad(){


    }
}

