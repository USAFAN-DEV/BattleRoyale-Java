package StatePatternMapa;

import Main.KeyHandler;
import Main.Mapa;
import java.awt.Graphics2D;

public class CombateConcreteState implements MapaStates{
    private Mapa mapa;
    private KeyHandler keyHandler;
    
    public CombateConcreteState(Mapa mapa){
        this.mapa = mapa;
        this.keyHandler = mapa.getKeyHandler();
    }

    public void accionUpdate(){
        this.keyHandler.setPressedDown(false);
        this.keyHandler.setPressedLeft(false);
        this.keyHandler.setPressedRight(false);
        this.keyHandler.setPressedUp(false);
    }
    
    public void accionDraw(Graphics2D g2){
        this.mapa.getUi().draw(g2);
    }
}
