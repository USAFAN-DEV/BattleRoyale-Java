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

        if(mapa.estadoDelJuego == 0){

            if(mapa.ui.pantallaDeInicioEstado == mapa.ui.pantallaTitulo){

                if(code == KeyEvent.VK_UP){
                    mapa.ui.menuArrow--;
                    if(mapa.ui.menuArrow < 0){
                        mapa.ui.menuArrow = 1;
                    }
                }
                else if(code == KeyEvent.VK_DOWN){
                    mapa.ui.menuArrow++;
                    if(mapa.ui.menuArrow > 1){
                        mapa.ui.menuArrow = 0;
                    }
                }
                else if(code == KeyEvent.VK_ENTER){
                    
                    if(mapa.ui.menuArrow == 0){
                        mapa.ui.pantallaDeInicioEstado++;
                    }
                    else{
                        System.exit(0);
                    }
                }

            }
            else if(mapa.ui.pantallaDeInicioEstado == mapa.ui.seleccionDePersonaje){

                if(code == KeyEvent.VK_LEFT){
                    mapa.ui.menuArrow--;
                    if(mapa.ui.menuArrow < 0){
                        mapa.ui.menuArrow = 2;
                    }
                }
                else if(code == KeyEvent.VK_RIGHT){
                    mapa.ui.menuArrow++;
                    if(mapa.ui.menuArrow > 2){
                        mapa.ui.menuArrow = 0;
                    }
                }
                else if(code == KeyEvent.VK_ENTER){
                    
                    if(mapa.ui.menuArrow == 0){
                        mapa.player1 = new Zhongli(mapa, this);
                    }
                    else if(mapa.ui.menuArrow == 1){
                        mapa.player1 = new Qiqi(mapa, this);
                    }
                    else{
                        mapa.player1 = new Mei(mapa, this);
                    }

                    mapa.ui.pantallaDeInicioEstado++;
                }

            }
            else if(mapa.ui.pantallaDeInicioEstado == mapa.ui.datosPersonaje){

                if(code == KeyEvent.VK_UP){
                    mapa.ui.menuArrow--;
                    if(mapa.ui.menuArrow < 0){
                        mapa.ui.menuArrow = 1;
                    }
                }
                else if(code == KeyEvent.VK_DOWN){
                    mapa.ui.menuArrow++;
                    if(mapa.ui.menuArrow > 1){
                        mapa.ui.menuArrow = 0;
                    }
                }
                else if(code == KeyEvent.VK_ENTER){
                    
                    if(mapa.ui.menuArrow == 0){
                        mapa.ui.pantallaDeInicioEstado++;
                    }
                    else{
                        mapa.ui.pantallaDeInicioEstado--;
                    }
                }

            }
            else if(mapa.ui.pantallaDeInicioEstado == mapa.ui.elegirCiudad){

                if(code == KeyEvent.VK_UP){
                    mapa.ui.menuArrow--;
                    if(mapa.ui.menuArrow < 0){
                        mapa.ui.menuArrow = 4;
                    }
                }
                else if(code == KeyEvent.VK_DOWN){
                    mapa.ui.menuArrow++;
                    if(mapa.ui.menuArrow > 4){
                        mapa.ui.menuArrow = 0;
                    }
                }
                else if(code == KeyEvent.VK_ENTER){
                    
                    if(mapa.ui.menuArrow == 0){
                        mapa.player1.setMapaX(20*mapa.getCasillaSizeEscalada());
                        mapa.player1.setMapaY(15*mapa.getCasillaSizeEscalada());
                    }
                    else if(mapa.ui.menuArrow == 1){
                        mapa.player1.setMapaX(46*mapa.getCasillaSizeEscalada());
                        mapa.player1.setMapaY(16*mapa.getCasillaSizeEscalada());
                    }
                    else if(mapa.ui.menuArrow == 2){
                        mapa.player1.setMapaX(46*mapa.getCasillaSizeEscalada());
                        mapa.player1.setMapaY(45*mapa.getCasillaSizeEscalada());
                    }
                    else if(mapa.ui.menuArrow == 3){
                        mapa.player1.setMapaX(46*mapa.getCasillaSizeEscalada());
                        mapa.player1.setMapaY(66*mapa.getCasillaSizeEscalada());
                    }
                    else if(mapa.ui.menuArrow == 4){
                        mapa.player1.setMapaX(86*mapa.getCasillaSizeEscalada());
                        mapa.player1.setMapaY(16*mapa.getCasillaSizeEscalada());
                    }

                    mapa.ui.pantallaDeInicioEstado++;

                }

            }
            else if(mapa.ui.pantallaDeInicioEstado == mapa.ui.elegirBots){

                if(code == KeyEvent.VK_UP){
                    mapa.ui.menuArrow--;
                    if(mapa.ui.menuArrow < 0){
                        mapa.ui.menuArrow = 2;
                    }
                }
                else if(code == KeyEvent.VK_DOWN){
                    mapa.ui.menuArrow++;
                    if(mapa.ui.menuArrow > 2){
                        mapa.ui.menuArrow = 0;
                    }
                }
                else if(code == KeyEvent.VK_ENTER){
                    
                    if(mapa.ui.menuArrow == 0){
                        mapa.numeroDeBots = 3;
                    }
                    else if(mapa.ui.menuArrow == 1){
                        mapa.numeroDeBots = 6;
                    }
                    else if(mapa.ui.menuArrow == 2){
                        mapa.numeroDeBots = 9;
                    }

                    mapa.ui.pantallaDeInicioEstado++;

                }
            }
            else if(mapa.ui.pantallaDeInicioEstado == mapa.ui.elegirDificultadBots){

                if(code == KeyEvent.VK_UP){
                    mapa.ui.menuArrow--;
                    if(mapa.ui.menuArrow < 0){
                        mapa.ui.menuArrow = 2;
                    }
                }
                else if(code == KeyEvent.VK_DOWN){
                    mapa.ui.menuArrow++;
                    if(mapa.ui.menuArrow > 2){
                        mapa.ui.menuArrow = 0;
                    }
                }
                else if(code == KeyEvent.VK_ENTER){
                    
                    if(mapa.ui.menuArrow == 0){
                        mapa.dificultadBots = 1;
                    }
                    else if(mapa.ui.menuArrow == 1){
                        mapa.dificultadBots = 2;
                    }
                    else if(mapa.ui.menuArrow == 2){
                        mapa.dificultadBots = 3;
                    }

                    mapa.bots = new Personaje[mapa.numeroDeBots];
                    System.out.println("Dificultad bots: " + mapa.dificultadBots);
                    mapa.AdministradorO.colocarBots();
                    mapa.estadoDelJuego = mapa.jugar;

                }

            }

        }
        else if(mapa.estadoDelJuego == mapa.muerte || mapa.estadoDelJuego == mapa.victoria){

             if(code == KeyEvent.VK_UP){
                mapa.ui.menuArrow--;
                if(mapa.ui.menuArrow < 0){
                    mapa.ui.menuArrow = 1;
                }
            }
            else if(code == KeyEvent.VK_DOWN){
                mapa.ui.menuArrow++;
                if(mapa.ui.menuArrow > 1){
                    mapa.ui.menuArrow = 0;
                }
            }
            else if(code == KeyEvent.VK_ENTER){
                
                if(mapa.ui.menuArrow == 0){
                    mapa.estadoDelJuego = mapa.pantallaInicio;
                    mapa.ui.pantallaDeInicioEstado = mapa.ui.pantallaTitulo;
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

                if(mapa.estadoDelJuego == 1){
                    mapa.estadoDelJuego = 2;
                }
                else{
                    mapa.estadoDelJuego = 1;
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
