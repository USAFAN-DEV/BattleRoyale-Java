package Combate.StatePatternVida;

import Entidades.Personaje;

public class VivoState implements LifeStateTransition{
    private Personaje jugador;

    public VivoState(Personaje jugador){
        this.jugador = jugador;
    }

    @Override
    public void cambiarVida(){
        if(jugador.getVida() <= 0){
            morir();
        }else{
            revivir();
        }
    }

    @Override
    public void morir() {
        jugador.setVida(0);
        jugador.setState(jugador.getMuertoState());
    }

    @Override
    public void revivir() {
        System.out.println("El personaje ya esta vivo");
    }
    
}
