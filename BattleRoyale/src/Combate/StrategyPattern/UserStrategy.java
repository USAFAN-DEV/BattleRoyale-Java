package Combate.StrategyPattern;

import Combate.Calculadora;
import Entidades.Personaje;

public class UserStrategy implements JugadorAccionStrategy{
    private Calculadora calcularDamage=Calculadora.getInstanceOf();
    private Personaje jugador1;
    private Personaje jugador2;
    public UserStrategy(Personaje jugador1,Personaje jugador2){
        this.jugador1=jugador1;
        this.jugador2=jugador2;
    }
    @Override
    public void usarPociones() {
        if(jugador1.getVida()==jugador1.getVidaMaxima()){
            System.out.println("Tienes la vida al maximo no puedes usar pociones");
        }
        else{
            if(jugador1.getContadorPociones()!=0){
                jugador1.setVida(jugador1.getVida()+50);
                if(jugador1.getVida()>jugador1.getVidaMaxima()){
                    jugador1.setVida(jugador1.getVidaMaxima());
                }
                jugador1.setContadorPociones(jugador1.getContadorPociones()-1);
                if(jugador1.getContadorPociones()<0){
                    jugador1.setContadorPociones(0);
                }
                System.out.printf("Te has curado \n");
                System.out.printf("Tienes %d pocion de vida\n",jugador1.getContadorPociones());
            }
            else{
                System.out.println("No te quedan pociones");
            }
        }
    }
    @Override
    public void accion(int opcion) {
        if(opcion==0){
            ataque();
        }
        else if(opcion==1){
            usarHabilidad();
        }
        else{
            usarPociones();
        }
    }
    @Override
    public void ataque() {
        int damage;
        damage=calcularDamage.damage(jugador1);
        calcularDamage.actualizarVidasDeJugadores(jugador2,damage);
        System.out.println("Daño realizado: " + damage);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(jugador2.getVida() == 0);
    }
    @Override
    public void usarHabilidad() {
        System.out.println("Has usado la habilidad");
        jugador1.usarHabilidad(jugador2);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}