package StatePatternMapa;

import java.awt.Graphics2D;
import Main.Mapa;

public class VictoriaConcreteState implements MapaStates{
    private Mapa mapa;

    public VictoriaConcreteState(Mapa mapa){
        this.mapa = mapa;
    }

    public void accionUpdate(){

    }
    public void accionDraw(Graphics2D g2){
        this.mapa.getUi().draw(g2);
    }
}
