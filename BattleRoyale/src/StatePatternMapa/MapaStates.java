package StatePatternMapa;

import java.awt.Graphics2D;

public interface MapaStates {
    public void process();
    public void accionUpdate();
    public void accionDraw(Graphics2D g2);
}
