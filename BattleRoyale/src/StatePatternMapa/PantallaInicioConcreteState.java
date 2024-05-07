package StatePatternMapa;

import Main.Mapa;
import java.awt.Graphics2D;

public class PantallaInicioConcreteState implements MapaStatesTransition{

    private Mapa mapa;

    public PantallaInicioConcreteState(Mapa mapa){

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


    //TRANSICIONES ENTRE ESTADOS 

    @Override
    public void empezarPartida() {
        
        this.mapa.setEstadoDelJuego(this.mapa.getJugarConcreteState());

    }

    @Override
    public void pausarPartida() {

        throw new IllegalStateException("La partida todavia no ha empezado");

    }

    @Override
    public void empezarCombate() {
        
        throw new IllegalStateException("La partida todavia no ha empezado");

    }

    @Override
    public void terminarPartida() {
        
        throw new IllegalStateException("La partida todavia no ha empezado");

    }

    @Override
    public void ganarPartida() {
        
        throw new IllegalStateException("La partida todavia no ha empezado");

    }

    @Override
    public void volverAJugar() {
        
        throw new IllegalStateException("Ya estas en la pantalla de inicio");

    }

    @Override
    public void process() {
        
        if(this.mapa.getSolicitudCambioEstado().equals("Empezar partida")){

            this.empezarPartida();
            
        }
    }
}