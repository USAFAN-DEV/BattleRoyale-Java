package Combate.StrategyPattern;
import Combate.Calculadora;
import Entidades.Personaje;

public class BotStrategy implements JugadorAccionStrategy{
    private Calculadora calcularDamage=Calculadora.getInstanceOf();
    private Personaje jugador1;
    private Personaje jugador2;
    public BotStrategy(Personaje jugador1,Personaje jugador2){
        this.jugador1=jugador1;
        this.jugador2=jugador2;
    }
    @Override
    public void usarPociones() {
        try {
           throw new Exception("Los bots no pueden usar pociones");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void accion(int opcion) {
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
    @Override
    public void ataque() {
        int damage;
        damage=calcularDamage.damage(jugador2);
        calcularDamage.actualizarVidasDeJugadores(jugador1,damage);
        System.out.println("Daño recibido "+damage);
    }
    @Override
    public void usarHabilidad() {
        System.out.println("El bot ha usado la habilidad");
        jugador2.usarHabilidad(jugador1);
    }
    
}
