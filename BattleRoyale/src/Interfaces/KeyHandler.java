package Interfaces;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Entidades.Personaje;
import Entidades.PersonajeAtk.Mei;
import Entidades.PersonajeDefensa.Zhongli;
import Entidades.PersonajeHealer.Qiqi;

public class KeyHandler implements KeyListener {

    public boolean PressedUp, PressedDown, PressedLeft, PressedRight;
    Mapa mapa;

    public KeyHandler(Mapa mapa){

        this.mapa = mapa;

    }

    public boolean getPressedLeft(){
        return PressedLeft;
    }

    @Override
    public void keyTyped(KeyEvent e) { //No la uso
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
        int code = e.getKeyCode(); //Devuelve un codigo asociado a la tecla presionada

        if(mapa.getEstadoDelJuego() == 0){

            if(mapa.getUi().pantallaDeInicioEstado == mapa.getUi().pantallaTitulo){

                if(code == KeyEvent.VK_UP){
                    mapa.getUi().menuArrow--;
                    if(mapa.getUi().menuArrow < 0){
                        mapa.getUi().menuArrow = 1;
                    }
                }
                else if(code == KeyEvent.VK_DOWN){
                    mapa.getUi().menuArrow++;
                    if(mapa.getUi().menuArrow > 1){
                        mapa.getUi().menuArrow = 0;
                    }
                }
                else if(code == KeyEvent.VK_ENTER){
                    
                    if(mapa.getUi().menuArrow == 0){
                        mapa.getUi().pantallaDeInicioEstado++;
                    }
                    else{
                        System.exit(0);
                    }
                }

            }
            else if(mapa.getUi().pantallaDeInicioEstado == mapa.getUi().seleccionDePersonaje){

                if(code == KeyEvent.VK_LEFT){
                    mapa.getUi().menuArrow--;
                    if(mapa.getUi().menuArrow < 0){
                        mapa.getUi().menuArrow = 2;
                    }
                }
                else if(code == KeyEvent.VK_RIGHT){
                    mapa.getUi().menuArrow++;
                    if(mapa.getUi().menuArrow > 2){
                        mapa.getUi().menuArrow = 0;
                    }
                }
                else if(code == KeyEvent.VK_ENTER){
                    
                    if(mapa.getUi().menuArrow == 0){
                        mapa.setJugador(new Zhongli(mapa, this));
                    }
                    else if(mapa.getUi().menuArrow == 1){
                        mapa.setJugador(new Qiqi(mapa, this));
                    }
                    else{
                        mapa.setJugador(new Mei(mapa, this));
                    }

                    mapa.getUi().pantallaDeInicioEstado++;
                }

            }
            else if(mapa.getUi().pantallaDeInicioEstado == mapa.getUi().datosPersonaje){

                if(code == KeyEvent.VK_UP){
                    mapa.getUi().menuArrow--;
                    if(mapa.getUi().menuArrow < 0){
                        mapa.getUi().menuArrow = 1;
                    }
                }
                else if(code == KeyEvent.VK_DOWN){
                    mapa.getUi().menuArrow++;
                    if(mapa.getUi().menuArrow > 1){
                        mapa.getUi().menuArrow = 0;
                    }
                }
                else if(code == KeyEvent.VK_ENTER){
                    
                    if(mapa.getUi().menuArrow == 0){
                        mapa.getUi().pantallaDeInicioEstado++;
                    }
                    else{
                        mapa.getUi().pantallaDeInicioEstado--;
                    }
                }

            }
            else if(mapa.getUi().pantallaDeInicioEstado == mapa.getUi().elegirCiudad){

                if(code == KeyEvent.VK_UP){
                    mapa.getUi().menuArrow--;
                    if(mapa.getUi().menuArrow < 0){
                        mapa.getUi().menuArrow = 4;
                    }
                }
                else if(code == KeyEvent.VK_DOWN){
                    mapa.getUi().menuArrow++;
                    if(mapa.getUi().menuArrow > 4){
                        mapa.getUi().menuArrow = 0;
                    }
                }
                else if(code == KeyEvent.VK_ENTER){
                    
                    if(mapa.getUi().menuArrow == 0){
                        mapa.getJugador().setMapaX(20*mapa.getCasillaSizeEscalada());
                        mapa.getJugador().setMapaY(15*mapa.getCasillaSizeEscalada());
                    }
                    else if(mapa.getUi().menuArrow == 1){
                        mapa.getJugador().setMapaX(46*mapa.getCasillaSizeEscalada());
                        mapa.getJugador().setMapaY(16*mapa.getCasillaSizeEscalada());
                    }
                    else if(mapa.getUi().menuArrow == 2){
                        mapa.getJugador().setMapaX(46*mapa.getCasillaSizeEscalada());
                        mapa.getJugador().setMapaY(45*mapa.getCasillaSizeEscalada());
                    }
                    else if(mapa.getUi().menuArrow == 3){
                        mapa.getJugador().setMapaX(46*mapa.getCasillaSizeEscalada());
                        mapa.getJugador().setMapaY(66*mapa.getCasillaSizeEscalada());
                    }
                    else if(mapa.getUi().menuArrow == 4){
                        mapa.getJugador().setMapaX(86*mapa.getCasillaSizeEscalada());
                        mapa.getJugador().setMapaY(16*mapa.getCasillaSizeEscalada());
                    }

                    mapa.getUi().pantallaDeInicioEstado++;

                }

            }
            else if(mapa.getUi().pantallaDeInicioEstado == mapa.getUi().elegirBots){

                if(code == KeyEvent.VK_UP){
                    mapa.getUi().menuArrow--;
                    if(mapa.getUi().menuArrow < 0){
                        mapa.getUi().menuArrow = 2;
                    }
                }
                else if(code == KeyEvent.VK_DOWN){
                    mapa.getUi().menuArrow++;
                    if(mapa.getUi().menuArrow > 2){
                        mapa.getUi().menuArrow = 0;
                    }
                }
                else if(code == KeyEvent.VK_ENTER){
                    
                    if(mapa.getUi().menuArrow == 0){
                        mapa.setNumeroDeBots(3);
                    }
                    else if(mapa.getUi().menuArrow == 1){
                        mapa.setNumeroDeBots(6);
                    }
                    else if(mapa.getUi().menuArrow == 2){
                        mapa.setNumeroDeBots(9);
                    }

                    mapa.getUi().pantallaDeInicioEstado++;

                }
            }
            else if(mapa.getUi().pantallaDeInicioEstado == mapa.getUi().elegirDificultadBots){

                if(code == KeyEvent.VK_UP){
                    mapa.getUi().menuArrow--;
                    if(mapa.getUi().menuArrow < 0){
                        mapa.getUi().menuArrow = 2;
                    }
                }
                else if(code == KeyEvent.VK_DOWN){
                    mapa.getUi().menuArrow++;
                    if(mapa.getUi().menuArrow > 2){
                        mapa.getUi().menuArrow = 0;
                    }
                }
                else if(code == KeyEvent.VK_ENTER){
                    
                    if(mapa.getUi().menuArrow == 0){
                        mapa.setDificultadBots(1);
                    }
                    else if(mapa.getUi().menuArrow == 1){
                        mapa.setDificultadBots(2);
                    }
                    else if(mapa.getUi().menuArrow == 2){
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
                mapa.getUi().menuArrow--;
                if(mapa.getUi().menuArrow < 0){
                    mapa.getUi().menuArrow = 1;
                }
            }
            else if(code == KeyEvent.VK_DOWN){
                mapa.getUi().menuArrow++;
                if(mapa.getUi().menuArrow > 1){
                    mapa.getUi().menuArrow = 0;
                }
            }
            else if(code == KeyEvent.VK_ENTER){
                
                if(mapa.getUi().menuArrow == 0){
                    mapa.setEstadoDelJuego(mapa.pantallaInicio);
                    mapa.getUi().pantallaDeInicioEstado = mapa.getUi().pantallaTitulo;
                }
                else{
                    System.exit(0);
                }
            }


        }
        else{

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
