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
        
        //Durante este estado no queremos que update() actualice ninguna información

    }

    @Override
    public void accionDraw(Graphics2D g2){

        this.mapa.getUi().draw(g2);

    }


    //TRANSICIONES ENTRE ESTADOS 

    @Override
    public void empezarPartida() {
        
        this.mapa.setEstadoDelJuego(new JugarConcreteState(this.mapa));

    }

    @Override
    public void pausarPartida() {
        
        System.out.println("La partida todavia no ha empezado");

    }

    @Override
    public void empezarCombate() {
        
        System.out.println("La partida todavia no ha empezado");

    }

    @Override
    public void terminarPartida() {
        
        System.out.println("La partida todavia no ha empezado");

    }

    @Override
    public void ganarPartida() {
        
        System.out.println("La partida todavia no ha empezado");

    }

    @Override
    public void volverAJugar() {
        
        System.out.println("Ya estas en la pantalla de inicio");

    }

    @Override
    public void process() {
        
        if(this.mapa.getSolicitudEmpezarPartida() != null){

            this.empezarPartida();
            this.mapa.setSolicitudEmpezarPartida(null);

        }
    }
}