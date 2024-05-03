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

         //Durante este estado no queremos que update() actualice ninguna información

    }
    
    @Override
    public void accionDraw(Graphics2D g2){

        this.mapa.getUi().draw(g2);

    }

    @Override
    public void empezarPartida() {
        
        System.out.println("Selecciona personaje, ciudad, numero de bots y dificultad de bots antes");

    }

    @Override
    public void pausarPartida() {
        
        System.out.println("La partida ya ha terminado");

    }

    @Override
    public void empezarCombate() {
        
        System.out.println("La partida ya ha terminado");

    }

    @Override
    public void terminarPartida() {
        
        System.out.println("La partida ya ha terminado");

    }

    @Override
    public void ganarPartida() {
        
        System.out.println("La partida ya ha terminado");

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
