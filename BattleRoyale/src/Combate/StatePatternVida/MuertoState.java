package Combate.StatePatternVida;

import Entidades.Personaje;
import Entidades.AbstractFactoryPattern.Qiqi;

public class MuertoState implements LifeStateTransition{
    private Personaje jugador;

    public MuertoState(Personaje jugador){
        this.jugador = jugador;
    }
    public Personaje getJugador(){
        return this.jugador;
    }
    public void setJugador(Personaje jugador){
        this.jugador=jugador;
    }
    public void cambiarVida(){
        if(getJugador() instanceof Qiqi && getJugador().getVida() <= 0 && getJugador().getRevivir() == 0){
            revivir();
        }else{
            revivir();
        }
    }

    @Override
    public void morir() {
        System.out.println("El jugador ya esta muerto");
    }

    @Override
    public void revivir() {
        
        getJugador().usarHabilidad(getJugador());
        getJugador().setState(getJugador().getVivoState());
    }
}