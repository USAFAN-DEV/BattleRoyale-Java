package Personaje.PersonajeHealer;

import Personaje.Jugador;

public class Shinobu extends Jugador{
    //rellenamos los datos del perseonaje correspondiendo con su tipo y el nombre
    public Shinobu(){
        super(200,200,25,0,100,0.25,0.25,"Healer","Shinobu","Sanctifying Ring");
    }
    public void usarHabilidad(){
        //necesito mas clases porque tengo que cambiar sus estadisticas 
        //Cura una cierta cantidad los proximos 3 turno al personajes con menos vida, cooldown 5 turnos
    }
}

