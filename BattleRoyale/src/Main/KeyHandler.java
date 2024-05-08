package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Entidades.Personaje;
import Entidades.AbstractFactoryPattern.Mei;
import Entidades.AbstractFactoryPattern.Qiqi;
import Entidades.AbstractFactoryPattern.Zhongli;
import StatePatternMapa.*;
import InterfazDeUsuario.StatePatternUI.*;

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

        if(mapa.getEstadoDelJuego() instanceof PantallaInicioConcreteState){

            if(mapa.getUi().getEstadoUI() instanceof TituloConcreteState){

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

                        mapa.getUi().setSolicitudCambioEstado("Seleccion personaje");

                    }
                    else{

                        System.exit(0);

                    }
                }

            }
            else if(mapa.getUi().getEstadoUI() instanceof SeleccionPersonajeConcreteState){

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
                        //mapa.setJugador(new Zhongli(mapa, this));
                        mapa.setJugador(mapa.getZhongliCreator().createJugador(mapa, this));
                    }
                    else if(mapa.getUi().getMenuArrow() == 1){
                        //mapa.setJugador(new Qiqi(mapa, this));
                        mapa.setJugador(mapa.getQiqiCreator().createJugador(mapa, this));
                    }
                    else{
                        //mapa.setJugador(new Mei(mapa, this));
                        mapa.setJugador(mapa.getMeiCreator().createJugador(mapa, this));
                    }

                    mapa.getUi().setSolicitudCambioEstado("Datos personaje");

                }

            }
            else if(mapa.getUi().getEstadoUI() instanceof DatosPersonajeConcreteState){

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

                        mapa.getUi().setSolicitudCambioEstado("Elegir ciudad");
                        
                    }
                    else{
                        mapa.getUi().setSolicitudCambioEstado("Elegir personaje");;
                    }
                }

            }
            else if(mapa.getUi().getEstadoUI() instanceof ElegirCiudadConcreteState){

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

                    mapa.getUi().setSolicitudCambioEstado("Elegir bots");

                }

            }
            else if(mapa.getUi().getEstadoUI() instanceof BotsConcreteState){

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

                    mapa.getUi().setSolicitudCambioEstado("Elegir dificultad bots");

                }
            }
            else if(mapa.getUi().getEstadoUI() instanceof DificultadBotsConcreteState){

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
                    mapa.getUi().setSolicitudCambioEstado("Nada");
                    mapa.setSolicitudCambioEstado("Empezar partida");

                }

            }

        }
        else if(mapa.getEstadoDelJuego() instanceof MuerteConcreteState|| mapa.getEstadoDelJuego() instanceof VictoriaConcreteState){

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
                    mapa.setSolicitudCambioEstado("Reiniciar partida");
                    mapa.getUi().setSolicitudCambioEstado("Crear partida");
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

                if(mapa.getEstadoDelJuego() instanceof JugarConcreteState){

                    mapa.setSolicitudCambioEstado("Pausar partida");

                }
                else if(mapa.getEstadoDelJuego() instanceof PausaConcreteState){

                    mapa.setSolicitudCambioEstado("Reanudar partida");

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
