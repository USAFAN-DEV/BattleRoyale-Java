package Combate;

import java.util.Random;

import Entidades.Personaje;

public class Calculadora {
    private static Calculadora calcularDamage=new Calculadora();
    private Calculadora(){}
    public static Calculadora getInstanceOf(){
        return calcularDamage;
    }
    public int damage(Personaje jugador){
        Random random=new Random();
        int randDamage=random.nextInt(10)+1;
        int damage=0;
        if(jugador.getCrit()*10>=randDamage){
            damage=jugador.getAtk()*2;
        }
        else{
            damage=jugador.getAtk();
        }
        return damage;
    }
    public void actualizarVidasDeJugadores(Personaje jugador,int damage){
        //si el escudo es 0
        if(jugador.getEscudo()==0){
            //se actualiza la vida del jugador 2, recibiendo el daño del jugador 1
            jugador.setVida(jugador.getVida()-damage);
            //Si la vida resulta ser negativa entonces se actualiza a 0
            if(jugador.getVida()<0){
                 jugador.setVida(0);
            }
        }
        else{
            //Si tiene escudo
            jugador.setEscudo(jugador.getEscudo()-damage);
            //Si despues de recibir la hostia el escudo se queda negativo
            if(jugador.getEscudo()<0){
                //Entonces Calculamos lo que te tiene que quedar respectivamente en la vida haciendo el resto y quitandoselo a la vida
                jugador.setVida(jugador.getVida()+(jugador.getEscudo()));
                //Ponemos el escudo a 0
                jugador.setEscudo(0);
                //Si resulta que la vida es negativa lo actualizamos a 0
                if(jugador.getVida()<0){
                     jugador.setVida(0);
                }
            }
        }
    }
}
