package StatePatternMapa;

import Main.Mapa;
import Entidades.Personaje;
import Objetos.Objeto;
import java.awt.Graphics2D;

public class JugarConcreteState implements MapaStates{
    private Mapa mapa;
    private Personaje[] bots;
    private Objeto[] objetos;

    public JugarConcreteState(Mapa mapa){
        this.mapa = mapa;
        this.bots = mapa.getBots();
        this.objetos = mapa.getObjetos();
    }

    public void accionUpdate(){
        this.mapa.getJugador().update();
        

        for(int i = 0; i < this.bots.length; i++){
            if(this.bots[i] != null){
                this.bots[i].updateBot();
            }
        }

        if(this.mapa.getNumeroDeBots() == 0){ //En cada update comprobamos si el usuario ha ganado la partida
            // aplicar un setter al estado actual de mapa
            estadoDelJuego = victoria;
        }
    }

    public void accionDraw(Graphics2D g2){
        
        this.mapa.getAdministradorDeCasillas().draw(g2);
        
        for(int i = 0; i < this.objetos.length; i++){

            if(this.objetos[i] != null){
                this.objetos[i].draw(g2, this.mapa);
            }

        }

        for(int i = 0; i < this.bots.length; i++){
            if(this.bots[i] != null){
                this.bots[i].drawBot(g2);

            }
        }
        
        this.mapa.getJugador().draw(g2);
        this.mapa.getUi().draw(g2);

        if(this.mapa.getJugador().getMensajeCofreLooteado() !=  null){

            if(this.mapa.getUi().getContadorFramesMensajePantalla() < 120){
                this.mapa.getUi().drawMensajePorPantalla(this.mapa.getJugador().getMensajeCofreLooteado());
            }
            else{
                this.mapa.getJugador().setMensajeCofreLooteado(null);
                this.mapa.getUi().setContadorFramesMensajePantalla(0);
            }

        }
        
        g2.dispose();
    }
}