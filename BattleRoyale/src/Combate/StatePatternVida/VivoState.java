package Combate.StatePatternVida;

import Entidades.Personaje;

public class VivoState implements LifeStateTransition{
    private Personaje jugador;

    public VivoState(Personaje jugador){
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
    public Personaje getJugador(){
        return this.jugador;
    }
    public void setJugador(Personaje jugador){
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
