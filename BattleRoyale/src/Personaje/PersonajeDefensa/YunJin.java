package Personaje.PersonajeDefensa;

import Personaje.Jugador;

public class YunJin extends Jugador{
    //rellenamos los datos del perseonaje correspondiendo con su tipo y el nombre
    public YunJin(){
        super(100,100,25,0,200,25.0,0.25,"Defensa","Yunjin");
    }
    public void usarHabilidad(){
        //necesito mas clases porque tengo que cambiar sus estadisticas
        //hace daño extra en base de su escudo durante un turno
    }
}
