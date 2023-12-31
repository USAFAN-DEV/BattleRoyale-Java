package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Entidades.Personaje;
import Entidades.PersonajeAtk.Mei;
import Entidades.PersonajeDefensa.Zhongli;
import Entidades.PersonajeHealer.Qiqi;

public class KeyHandler implements KeyListener {

    private boolean pressedUp, pressedDown, pressedLeft, pressedRight;
    private Mapa mapa;

    public KeyHandler(Mapa mapa){

        this.mapa = mapa;

    }
    public void setPressedUp(boolean pressedUp){
        this.pressedUp = pressedUp;
    }
    public boolean getPressedUp(){
        return this.pressedUp;
    }
    public void setPressedDown(boolean pressedDown){
        this.pressedDown = pressedDown;
    }
    public boolean getPressedDown(){
        return this.pressedDown;
    }
    public void setPressedLeft(boolean pressedLeft){
        this.pressedLeft = pressedLeft;
    }
    public boolean getPressedLeft(){
        return this.pressedLeft;
    }
    public void setPressedRight(boolean pressedRight){
        this.pressedRight = pressedRight;
    }
    public boolean getPressedRight(){
        return this.pressedRight;
    }


    @Override
    public void keyTyped(KeyEvent e) { //No la uso
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
        int code = e.getKeyCode(); //Devuelve un codigo asociado a la tecla presionada

        if(mapa.getEstadoDelJuego() == 0){

            if(mapa.getUi().getPantallaDeInicioEstado() == mapa.getUi().pantallaTitulo){

                if(code == KeyEvent.VK_UP){
                    mapa.getUi().setMenuArrow(mapa.getUi().getMenuArrow() - 1);
                    if(mapa.getUi().getMenuArrow() < 0){
                        mapa.getUi().setMenuArrow(1);
                    }
                }
                else if(code == KeyEvent.VK_DOWN){
                    mapa.getUi().setMenuArrow(mapa.getUi().getMenuArrow() + 1);
                    if(mapa.getUi().getMenuArrow() > 1){
                        mapa.getUi().setMenuArrow(0);
                    }
                }
                else if(code == KeyEvent.VK_ENTER){
                    
                    if(mapa.getUi().getMenuArrow() == 0){
                        mapa.getUi().setPantallaDeInicioEstado(mapa.getUi().getPantallaDeInicioEstado() + 1);
                    }
                    else{
                        System.exit(0);
                    }
                }

            }
            else if(mapa.getUi().getPantallaDeInicioEstado() == mapa.getUi().seleccionDePersonaje){

                if(code == KeyEvent.VK_LEFT){
                    mapa.getUi().setMenuArrow(mapa.getUi().getMenuArrow() - 1);
                    if(mapa.getUi().getMenuArrow() < 0){
                        mapa.getUi().setMenuArrow(2);
                    }
                }
                else if(code == KeyEvent.VK_RIGHT){
                    mapa.getUi().setMenuArrow(mapa.getUi().getMenuArrow() + 1);
                    if(mapa.getUi().getMenuArrow() > 2){
                        mapa.getUi().setMenuArrow(0);
                    }
                }
                else if(code == KeyEvent.VK_ENTER){
                    
                    if(mapa.getUi().getMenuArrow() == 0){
                        mapa.setJugador(new Zhongli(mapa, this));
                    }
                    else if(mapa.getUi().getMenuArrow() == 1){
                        mapa.setJugador(new Qiqi(mapa, this));
                    }
                    else{
                        mapa.setJugador(new Mei(mapa, this));
                    }

                    mapa.getUi().setPantallaDeInicioEstado(mapa.getUi().getPantallaDeInicioEstado() + 1);
                }

            }
            else if(mapa.getUi().getPantallaDeInicioEstado() == mapa.getUi().datosPersonaje){

                if(code == KeyEvent.VK_UP){
                    mapa.getUi().setMenuArrow(mapa.getUi().getMenuArrow() - 1);
                    if(mapa.getUi().getMenuArrow() < 0){
                        mapa.getUi().setMenuArrow(1);
                    }
                }
                else if(code == KeyEvent.VK_DOWN){
                    mapa.getUi().setMenuArrow(mapa.getUi().getMenuArrow() + 1);
                    if(mapa.getUi().getMenuArrow() > 1){
                        mapa.getUi().setMenuArrow(0);
                    }
                }
                else if(code == KeyEvent.VK_ENTER){
                    
                    if(mapa.getUi().getMenuArrow() == 0){
                        mapa.getUi().setPantallaDeInicioEstado(mapa.getUi().getPantallaDeInicioEstado() + 1);
                    }
                    else{
                        mapa.getUi().setPantallaDeInicioEstado(mapa.getUi().getPantallaDeInicioEstado() - 1);
                    }
                }

            }
            else if(mapa.getUi().getPantallaDeInicioEstado() == mapa.getUi().elegirCiudad){

                if(code == KeyEvent.VK_UP){
                    mapa.getUi().setMenuArrow(mapa.getUi().getMenuArrow() - 1);
                    if(mapa.getUi().getMenuArrow() < 0){
                        mapa.getUi().setMenuArrow(4);
                    }
                }
                else if(code == KeyEvent.VK_DOWN){
                    mapa.getUi().setMenuArrow(mapa.getUi().getMenuArrow() + 1);
                    if(mapa.getUi().getMenuArrow() > 4){
                        mapa.getUi().setMenuArrow(0);
                    }
                }
                else if(code == KeyEvent.VK_ENTER){
                    
                    if(mapa.getUi().getMenuArrow() == 0){
                        mapa.getJugador().setMapaX(20*mapa.getCasillaSizeEscalada());
                        mapa.getJugador().setMapaY(15*mapa.getCasillaSizeEscalada());
                    }
                    else if(mapa.getUi().getMenuArrow() == 1){
                        mapa.getJugador().setMapaX(46*mapa.getCasillaSizeEscalada());
                        mapa.getJugador().setMapaY(16*mapa.getCasillaSizeEscalada());
                    }
                    else if(mapa.getUi().getMenuArrow() == 2){
                        mapa.getJugador().setMapaX(46*mapa.getCasillaSizeEscalada());
                        mapa.getJugador().setMapaY(45*mapa.getCasillaSizeEscalada());
                    }
                    else if(mapa.getUi().getMenuArrow() == 3){
                        mapa.getJugador().setMapaX(46*mapa.getCasillaSizeEscalada());
                        mapa.getJugador().setMapaY(66*mapa.getCasillaSizeEscalada());
                    }
                    else if(mapa.getUi().getMenuArrow() == 4){
                        mapa.getJugador().setMapaX(86*mapa.getCasillaSizeEscalada());
                        mapa.getJugador().setMapaY(16*mapa.getCasillaSizeEscalada());
                    }

                    mapa.getUi().setPantallaDeInicioEstado(mapa.getUi().getPantallaDeInicioEstado() + 1);

                }

            }
            else if(mapa.getUi().getPantallaDeInicioEstado() == mapa.getUi().elegirBots){

                if(code == KeyEvent.VK_UP){
                    mapa.getUi().setMenuArrow(mapa.getUi().getMenuArrow() - 1);
                    if(mapa.getUi().getMenuArrow() < 0){
                        mapa.getUi().setMenuArrow(2);
                    }
                }
                else if(code == KeyEvent.VK_DOWN){
                    mapa.getUi().setMenuArrow(mapa.getUi().getMenuArrow() + 1);
                    if(mapa.getUi().getMenuArrow() > 2){
                        mapa.getUi().setMenuArrow(0);
                    }
                }
                else if(code == KeyEvent.VK_ENTER){
                    
                    if(mapa.getUi().getMenuArrow() == 0){
                        mapa.setNumeroDeBots(3);
                    }
                    else if(mapa.getUi().getMenuArrow() == 1){
                        mapa.setNumeroDeBots(6);
                    }
                    else if(mapa.getUi().getMenuArrow() == 2){
                        mapa.setNumeroDeBots(9);
                    }

                    mapa.getUi().setPantallaDeInicioEstado(mapa.getUi().getPantallaDeInicioEstado() + 1);

                }
            }
            else if(mapa.getUi().getPantallaDeInicioEstado() == mapa.getUi().elegirDificultadBots){

                if(code == KeyEvent.VK_UP){
                    mapa.getUi().setMenuArrow(mapa.getUi().getMenuArrow() - 1);
                    if(mapa.getUi().getMenuArrow() < 0){
                        mapa.getUi().setMenuArrow(2);
                    }
                }
                else if(code == KeyEvent.VK_DOWN){
                    mapa.getUi().setMenuArrow(mapa.getUi().getMenuArrow() + 1);
                    if(mapa.getUi().getMenuArrow() > 2){
                        mapa.getUi().setMenuArrow(0);
                    }
                }
                else if(code == KeyEvent.VK_ENTER){
                    
                    if(mapa.getUi().getMenuArrow() == 0){
                        mapa.setDificultadBots(1);
                    }
                    else if(mapa.getUi().getMenuArrow() == 1){
                        mapa.setDificultadBots(2);
                    }
                    else if(mapa.getUi().getMenuArrow() == 2){
                        mapa.setDificultadBots(3);
                    }

                    mapa.setBots(new Personaje[mapa.getNumeroDeBots()]);
                    System.out.println("Dificultad bots: " + mapa.getDificultadBots());
                    mapa.getAdministradorDeObjetos().colocarBots();
                    mapa.setEstadoDelJuego(mapa.jugar);

                }

            }

        }
        else if(mapa.getEstadoDelJuego() == mapa.muerte || mapa.getEstadoDelJuego() == mapa.victoria){

             if(code == KeyEvent.VK_UP){
                mapa.getUi().setMenuArrow(mapa.getUi().getMenuArrow() - 1);
                if(mapa.getUi().getMenuArrow() < 0){
                    mapa.getUi().setMenuArrow(1);
                }
            }
            else if(code == KeyEvent.VK_DOWN){
                mapa.getUi().setMenuArrow(mapa.getUi().getMenuArrow() + 1);
                if(mapa.getUi().getMenuArrow() > 1){
                    mapa.getUi().setMenuArrow(0);
                }
            }
            else if(code == KeyEvent.VK_ENTER){
                
                if(mapa.getUi().getMenuArrow() == 0){
                    mapa.setEstadoDelJuego(mapa.pantallaInicio);
                    mapa.getUi().setPantallaDeInicioEstado(mapa.getUi().pantallaTitulo);
                }
                else{
                    System.exit(0);
                }
            }


        }
        else{

            if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){ //Si el usuario presiona la W

                pressedUp = true;

            }
            if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){ //Si el usuario presiona la A

                pressedLeft = true;

            }
            if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){ //Si el usuario presiona la S

                pressedDown = true;

            }
            if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){ //Si el usuario presiona la D

                pressedRight = true;

            }
            if(code == KeyEvent.VK_ESCAPE){

                if(mapa.getEstadoDelJuego() == 1){
                    mapa.setEstadoDelJuego(2);
                }
                else{
                    mapa.setEstadoDelJuego(1);
                }

            }
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode();

 
        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){ //Si el usuario suelta la W
            pressedUp = false;
        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){ //Si el usuario suelta la A
            pressedLeft = false;
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){ //Si el usuario suelta la S
            pressedDown = false;
        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){ //Si el usuario suelta la D
            pressedRight = false;
        }


    }
    
}
