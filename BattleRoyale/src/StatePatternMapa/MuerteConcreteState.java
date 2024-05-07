package StatePatternMapa;

import java.awt.Graphics2D;
import Main.Mapa;

public class MuerteConcreteState implements MapaStatesTransition{

    private Mapa mapa;

    public MuerteConcreteState(Mapa mapa){

        this.mapa = mapa;

    }

    @Override
    public void accionUpdate(){

        this.mapa.getUi().process(); //procesamos el estado de la UI

    }
    
    @Override
    public void accionDraw(Graphics2D g2){

        this.mapa.getUi().draw(g2);

    }

    @Override
    public void empezarPartida() {
        
        throw new IllegalStateException("Selecciona personaje, ciudad, numero de bots y dificultad de bots antes");

    }

    @Override
    public void pausarPartida() {
        
        throw new IllegalStateException("La partida ya ha terminado");

    }

    @Override
    public void empezarCombate() {
        
        throw new IllegalStateException("La partida ya ha terminado");

    }

    @Override
    public void terminarPartida() {
        
        throw new IllegalStateException("La partida ya ha terminado");

    }

    @Override
    public void ganarPartida() {
        
        throw new IllegalStateException("La partida ya ha terminado");

    }

    @Override
    public void volverAJugar() {
        
        this.mapa.setEstadoDelJuego(this.mapa.getPantallaInicioConcreteState());

    }

    @Override
    public void process() {

        if(this.mapa.getSolicitudCambioEstado().equals("Reiniciar partida")){

            this.volverAJugar();

        }

    }
}
