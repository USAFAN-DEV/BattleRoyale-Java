package Combate.StatePatternVida;

import Entidades.Personaje;
import Entidades.PersonajeHealer.Qiqi;

public class MuertoState implements LifeStateTransition{
    private Personaje jugador;

    public MuertoState(Personaje jugador){
        this.jugador = jugador;
    }

    public void cambiarVida(){
        if(jugador instanceof Qiqi && jugador.getVida() <= 0 && jugador.getRevivir() == 0){
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
        jugador.usarHabilidad(jugador);
        jugador.setState(jugador.getVivoState());
    }
}