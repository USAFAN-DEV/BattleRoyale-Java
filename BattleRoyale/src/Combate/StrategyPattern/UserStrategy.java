package Combate.StrategyPattern;

import Combate.Calculadora;
import Entidades.Entidad;

public class UserStrategy implements JugadorAccionStrategy{
    private Calculadora calcularDamage=Calculadora.getInstanceOf();
    private Entidad jugador1;
    private Entidad jugador2;
    public UserStrategy(Entidad jugador1,Entidad jugador2){
        this.jugador1=jugador1;
        this.jugador2=jugador2;
    }
    public Entidad getJugador1(){
        return this.jugador1;
    }
    public Entidad getJugador2(){
        return this.jugador2;
    }
    @Override
    public void usarPociones() {
        if(getJugador1().getVida()==getJugador1().getVidaMaxima()){
            System.out.println("Tienes la vida al maximo no puedes usar pociones");
        }
        else{
            if(getJugador1().getContadorPociones()!=0){
                getJugador1().setVida(getJugador1().getVida()+50);
                if(getJugador1().getVida()>getJugador1().getVidaMaxima()){
                    getJugador1().setVida(getJugador1().getVidaMaxima());
                }
                getJugador1().setContadorPociones(getJugador1().getContadorPociones()-1);
                if(getJugador1().getContadorPociones()<0){
                    getJugador1().setContadorPociones(0);
                }
                System.out.printf("Te has curado \n");
                System.out.printf("Tienes %d pocion de vida\n",getJugador1().getContadorPociones());
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
        damage=calcularDamage.damage(getJugador1());
        calcularDamage.actualizarVidasDeJugadores(getJugador2(),damage);
        System.out.println("Daño realizado: " + damage);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(getJugador2().getVida() == 0);
    }
    @Override
    public void usarHabilidad() {
        System.out.println("Has usado la habilidad");
        getJugador1().usarHabilidad(getJugador2());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}