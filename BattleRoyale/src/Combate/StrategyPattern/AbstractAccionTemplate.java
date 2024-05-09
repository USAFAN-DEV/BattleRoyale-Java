package Combate.StrategyPattern;

import Entidades.Entidad;

public abstract class AbstractAccionTemplate implements JugadorAccionStrategy{
    private Entidad jugador2;
    public abstract void ataque();
    public abstract void usarHabilidad();
    public abstract void usarPociones();
    public AbstractAccionTemplate(Entidad jugador2){
        this.jugador2=jugador2;
    }
    public Entidad getJugador2(){
        return this.jugador2;
    }
    @Override
    public final void accion(int opcion) {
        if(getJugador2().getNombre()=="Qiqi"){
            ataque();
        }
        else{
            if(getJugador2().getCooldownHabilidad()!=3 && getJugador2().getCooldownHabilidad()>=1){
                getJugador2().setCooldownHabilidad(getJugador2().getCooldownHabilidad()+1);
                System.out.printf("La habilidad del bot le quedan %d turnos\n",3-getJugador2().getCooldownHabilidad());
            }
            else{
                getJugador2().setCooldownHabilidad(0);
            }
            if(opcion==1||getJugador2().getCooldownHabilidad()>=1){
                ataque();
            }
            else{
                getJugador2().setCooldownHabilidad(1);
                System.out.printf("La habilidad del bot le quedan %d turnos\n",3-getJugador2().getCooldownHabilidad());
                usarHabilidad();
            }
        }
    }
    

   
    
    
}
