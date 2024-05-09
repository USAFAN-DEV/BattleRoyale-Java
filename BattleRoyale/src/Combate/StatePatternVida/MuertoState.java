package Combate.StatePatternVida;

import Entidades.Entidad;
import Entidades.AbstractFactoryPattern.Bots.QiqiBot;
import Entidades.AbstractFactoryPattern.Jugadores.QiqiJugador;

public class MuertoState implements LifeStateTransition{
    private Entidad jugador;

    public MuertoState(Entidad jugador){
        this.jugador = jugador;
    }
    public Entidad getJugador(){
        return this.jugador;
    }
    public void setJugador(Entidad jugador){
        this.jugador=jugador;
    }
    public void cambiarVida(){
        if((getJugador() instanceof QiqiJugador || getJugador() instanceof QiqiBot) && getJugador().getVida() <= 0 && getJugador().getRevivir() == 0){
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