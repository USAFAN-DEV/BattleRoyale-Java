package Combate.StrategyPattern;
import Combate.Calculadora;
import Entidades.Entidad;

public class BotStrategy extends AbstractAccionTemplate{
    private Calculadora calcularDamage=Calculadora.getInstanceOf();
    private Entidad jugador1;
    public BotStrategy(Entidad jugador1,Entidad jugador2){
        super(jugador2);
        this.jugador1=jugador1;
    }
    public Entidad getJugador1(){
        return this.jugador1;
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
    public void ataque() {
        int damage;
        damage=calcularDamage.damage(super.getJugador2());
        calcularDamage.actualizarVidasDeJugadores(getJugador1(),damage);
        System.out.println("Daño recibido "+damage);
    }
    @Override
    public void usarHabilidad() {
        System.out.println("El bot ha usado la habilidad");
        super.getJugador2().usarHabilidad(getJugador1());
    }
    
}