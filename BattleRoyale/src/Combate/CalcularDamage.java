package Combate;

import java.util.Random;

import Entidades.Personaje;

public class CalcularDamage {
    private static CalcularDamage calcularDamage=new CalcularDamage();
    private CalcularDamage(){}
    public static CalcularDamage getInstanceOf(){
        return calcularDamage;
    }
    public int Damage(Personaje jugador){
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
}
