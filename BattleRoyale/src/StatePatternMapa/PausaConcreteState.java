package StatePatternMapa;

import Main.Mapa;
import java.awt.Graphics2D;

public class PausaConcreteState implements MapaStates{
    private Mapa mapa;

    public PausaConcreteState(Mapa mapa){
        this.mapa = mapa;
    }

    public void accionUpdate(){
        
    }

    public void accionDraw(Graphics2D g2){
        this.mapa.getUi().draw(g2);
    }
}