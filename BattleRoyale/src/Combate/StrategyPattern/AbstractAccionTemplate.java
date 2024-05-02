package Combate.StrategyPattern;

import Entidades.Personaje;

public abstract class AbstractAccionTemplate implements JugadorAccionStrategy{
    private Personaje jugador2;
    public abstract void ataque();
    public abstract void usarHabilidad();
    public abstract void usarPociones();
    public AbstractAccionTemplate(Personaje jugador2){
        this.jugador2=jugador2;
    }
    public Personaje getJugador2(){
        return this.jugador2;
    }
    @Override
    public final void accion(int opcion) {
        if(jugador2.getNombre()=="Qiqi"){
            ataque();
        }
        else{
            if(jugador2.getCooldownHabilidad()!=3 && jugador2.getCooldownHabilidad()>=1){
                jugador2.setCooldownHabilidad(jugador2.getCooldownHabilidad()+1);
                System.out.printf("La habilidad del bot le quedan %d turnos\n",3-jugador2.getCooldownHabilidad());
            }
            else{
                jugador2.setCooldownHabilidad(0);
            }
            if(opcion==1||jugador2.getCooldownHabilidad()>=1){
                ataque();
            }
            else{
                jugador2.setCooldownHabilidad(1);
                System.out.printf("La habilidad del bot le quedan %d turnos\n",3-jugador2.getCooldownHabilidad());
                usarHabilidad();
            }
        }
    }
    

   
    
    
}
