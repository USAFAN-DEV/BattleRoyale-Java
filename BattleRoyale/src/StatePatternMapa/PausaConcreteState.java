package StatePatternMapa;

import Main.Mapa;
import java.awt.Graphics2D;

public class PausaConcreteState implements MapaStatesTransition{
    
    private Mapa mapa;

    public PausaConcreteState(Mapa mapa){

        this.mapa = mapa;

    }

    @Override
    public void accionUpdate(){
        
         //Durante este estado no queremos que update() actualice ninguna información

    }

    @Override
    public void accionDraw(Graphics2D g2){

        this.mapa.getUi().draw(g2);

    }

    @Override
    public void empezarPartida() {
        
        //Tambien reanudar partida

        this.mapa.setEstadoDelJuego(this.mapa.getJugarConcreteState());

    }

    @Override
    public void pausarPartida() {
        
        throw new IllegalStateException("La partida ya esta pausada");

    }

    @Override
    public void empezarCombate() {
        
        throw new IllegalStateException("La partida esta pausada. No se puede iniciar un combate");

    }

    @Override
    public void terminarPartida() {

        throw new IllegalStateException("La partida esta pausada. No se puede morir");

    }

    @Override
    public void ganarPartida() {

        throw new IllegalStateException("La partid esta pausada. No se puede ganar la partida");

    }

    @Override
    public void volverAJugar() {
        
        throw new IllegalStateException("Termina esta partida para empezar otra");

    }

    @Override
    public void process() {
        
        if(this.mapa.getSolicitudCambioEstado().equals("Reanudar partida")){

            this.empezarPartida();

        }

    }
}