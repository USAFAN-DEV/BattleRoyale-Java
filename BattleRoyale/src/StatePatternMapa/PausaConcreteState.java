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

        this.mapa.setEstadoDelJuego(new JugarConcreteState(this.mapa));

    }

    @Override
    public void pausarPartida() {
        
        System.out.println("La partida ya esta pausada");

    }

    @Override
    public void empezarCombate() {
        
        System.out.println("La partida esta pausada. No se puede iniciar un combate");

    }

    @Override
    public void terminarPartida() {

        System.out.println("La partida esta pausada. No se puede morir");

    }

    @Override
    public void ganarPartida() {

        System.out.println("La partid esta pausada. No se puede ganar la partida");

    }

    @Override
    public void volverAJugar() {
        
        System.out.println("Termina esta partida para empezar otra");

    }

    @Override
    public void process() {
        
        if(this.mapa.getSolicitudReanudarPartida() != null){

            this.empezarPartida();
            this.mapa.setSolicitudReanudarPartida(null);

        }

    }
}