package Interfaces;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean PressedUp, PressedDown, PressedLeft, PressedRight;
    Mapa mapa;

    public KeyHandler(Mapa mapa){

        this.mapa = mapa;

    }

    @Override
    public void keyTyped(KeyEvent e) { //No la uso
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
        int code = e.getKeyCode(); //Devuelve un codigo asociado a la tecla presionada

        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){ //Si el usuario presiona la W

            PressedUp = true;

        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){ //Si el usuario presiona la A

            PressedLeft = true;

        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){ //Si el usuario presiona la S

            PressedDown = true;

        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){ //Si el usuario presiona la D

            PressedRight = true;

        }
        if(code == KeyEvent.VK_ESCAPE){

            if(mapa.estadoDelJuego == 1){
                mapa.estadoDelJuego = 2;
            }
            else{
                mapa.estadoDelJuego = 1;
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){ //Si el usuario suelta la W

            PressedUp = false;

        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){ //Si el usuario suelta la A

            PressedLeft = false;

        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){ //Si el usuario suelta la S

            PressedDown = false;

        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){ //Si el usuario suelta la D

            PressedRight = false;

        }

    }
    
}
