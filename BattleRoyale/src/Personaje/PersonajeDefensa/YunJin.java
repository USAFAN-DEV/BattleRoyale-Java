package Personaje.PersonajeDefensa;

import Personaje.Jugador;

public class YunJin extends Jugador{
    //rellenamos los datos del perseonaje correspondiendo con su tipo y el nombre
    public YunJin(){
        super(100,100,25,0,200,0.25,0.25,"Defensa","Yunjin","Cliffbreaker's Banner");
    }
    public void usarHabilidad(Jugador equipo[]){
        //necesito mas clases porque tengo que cambiar sus estadisticas
        //hace daño extra en base de su escudo durante un turno
        for(int i=0;i<equipo.length;i++){
            
        }
    }
    public void descripcionHabilidad(){
        System.out.printf("",);
    }
}
