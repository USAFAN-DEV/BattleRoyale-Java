package StatePatternMapa;

import Main.Mapa;
import java.awt.Graphics2D;

public class CombateConcreteState implements MapaStatesTransition{

    private Mapa mapa;
    
    public CombateConcreteState(Mapa mapa){

        this.mapa = mapa;

    }

    @Override
    public void accionUpdate(){

        //Mientras esta en combate, no se puede mover en el mapa

        this.mapa.getKeyHandler().setPressedDown(false);
        this.mapa.getKeyHandler().setPressedLeft(false);
        this.mapa.getKeyHandler().setPressedRight(false);
        this.mapa.getKeyHandler().setPressedUp(false);

    }
    
    @Override
    public void accionDraw(Graphics2D g2){

        this.mapa.getUi().draw(g2);

    }

    @Override
    public void empezarPartida() {
        
        this.mapa.setEstadoDelJuego(this.mapa.getJugarConcreteState());

    }

    @Override
    public void pausarPartida() {
        
        System.out.println("No se puede pausar la partida durante un combate");

    }

    @Override
    public void empezarCombate() {
        
        System.out.println("Ya se ha iniciado un combate");

    }

    @Override
    public void terminarPartida() {
        
        this.mapa.setEstadoDelJuego(this.mapa.getMuerteConcreteState());

    }

    @Override
    public void ganarPartida() {
        
        System.out.println("No puede ganar mientras estas en combate");

    }

    @Override
    public void volverAJugar() {
        
        System.out.println("Termina esta partida para empezar otra");

    }

    @Override
    public void process() {
        
        if(this.mapa.getSolicitudCambioEstado().equals("Combate ganado")){

            this.empezarPartida();//reanudar partida

        }
        if(this.mapa.getSolicitudCambioEstado().equals("Combate perdido")){

            this.terminarPartida();

        }

    }
}
