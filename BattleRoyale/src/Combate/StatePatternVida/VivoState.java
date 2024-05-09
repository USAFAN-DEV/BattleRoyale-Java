package Combate.StatePatternVida;

import Entidades.Entidad;


public class VivoState implements LifeStateTransition{
    private Entidad jugador;

    public VivoState(Entidad jugador){
        this.jugador = jugador;
    }

    @Override
    public void cambiarVida(){
        if(getJugador().getVida() <= 0){
            morir();
        }else{
            revivir();
        }
    }
    public Entidad getJugador(){
        return this.jugador;
    }
    public void setJugador(Entidad jugador){
        this.jugador=jugador;
    }
    @Override
    public void morir() {
        System.out.println("El jugador acaba de morir");
        jugador.setState(getJugador().getMuertoState());
    }

    @Override
    public void revivir() {
        System.out.println("El personaje ya esta vivo");
    }
    
}
