package StatePatternMapa;

import Main.Mapa;
import Entidades.Entidad;
import Entidades.Personaje;
import Objetos.Objeto;
import java.awt.Graphics2D;

public class JugarConcreteState implements MapaStatesTransition{

    private Mapa mapa;

    public JugarConcreteState(Mapa mapa){

        this.mapa = mapa;

    }

    @Override
    public void accionUpdate(){

        Entidad[] bots = this.mapa.getBots();
        this.mapa.getJugador().update();
        
        for(int i = 0; i < bots.length; i++){

            if(bots[i] != null){

                bots[i].updateBot();

            }

        }

        if(this.mapa.getNumeroDeBots() == 0){ //En cada update comprobamos si el usuario ha ganado la partida
            //victoria
            this.mapa.setSolicitudCambioEstado("Victoria");

        }
    }

    @Override
    public void accionDraw(Graphics2D g2){

        Entidad[] bots = this.mapa.getBots();
        Objeto[] objetos = this.mapa.getObjetos();
        this.mapa.getAdministradorDeCasillas().draw(g2);
        
        for(int i = 0; i < objetos.length; i++){

            if(objetos[i] != null){

                objetos[i].draw(g2, this.mapa);

            }

        }

        for(int i = 0; i < bots.length; i++){

            if(bots[i] != null){

                bots[i].drawBot(g2);

            }

        }
        
        this.mapa.getJugador().draw(g2);
        this.mapa.getUi().draw(g2);

        if(((Personaje)this.mapa.getJugador()).getMensajeCofreLooteado() != null){ //el jugador cambia de estado. Ha chocado con un cofre

            ((Personaje)this.mapa.getJugador()).notifyObservers(); //notificamos a los observadores

        }
        
        g2.dispose();

    }

    @Override
    public void empezarPartida() {
        
        System.out.println("La partida ya ha empezado");

    }

    @Override
    public void pausarPartida() {
        
        this.mapa.setEstadoDelJuego(new PausaConcreteState(this.mapa));

    }

    @Override
    public void empezarCombate() {

        this.mapa.setEstadoDelJuego(new CombateConcreteState(this.mapa));

    }

    @Override
    public void terminarPartida() {
        
        System.out.println("Solo puedes morir en combate");

    }

    @Override
    public void ganarPartida() {
        
        this.mapa.setEstadoDelJuego(new VictoriaConcreteState(this.mapa));

    }

    @Override
    public void volverAJugar() {
        
        System.out.println("Termina esta partida para empezar otra");

    }

    @Override
    public void process() {
        
        if(this.mapa.getSolicitudCambioEstado().equals("Pausar partida")){

            this.pausarPartida();

        }

        if(this.mapa.getSolicitudCambioEstado().equals("Empezar combate")){

            this.empezarCombate();

        }

        if(this.mapa.getSolicitudCambioEstado().equals("Victoria")){

            this.ganarPartida();

        }

    }
}