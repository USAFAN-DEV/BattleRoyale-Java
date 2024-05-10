package Entidades;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import Combate.InterfazCombateCopia;
import InterfazDeUsuario.UI;
import Main.Mapa;
import ObserverPattern.ModelObservable;
import ObserverPattern.ModelObserver;

public abstract class Personaje extends Entidad implements ModelObservable{

    private List<ModelObserver> observers;
    private String mensajeCofreLooteado;

    public Personaje(int vida,int vidaMaxima,int atk,int escudo,int escudoMaximo,double crit,double estadisticaHabilidad, String tipo,String nombre,String nombreHabilidad, int mapaX, int mapaY, Mapa mapa){

        super(vida, vidaMaxima, atk, escudo, escudoMaximo, crit, estadisticaHabilidad, tipo, nombre, nombreHabilidad, mapaX, mapaY, mapa);
        this.observers = new ArrayList<ModelObserver>();
    }

    //METODOS
    public abstract String descripcionHabilidad();
    public abstract void getCharacterImage();
    public abstract void usarHabilidad(Entidad jugador);

    public void setMensajeCofreLooteado(String mensajeCofreLooteado){

        this.mensajeCofreLooteado = mensajeCofreLooteado;

    }

    public String getMensajeCofreLooteado(){

        return this.mensajeCofreLooteado;

    }

    public void update(){

        teletransportacion();

        if(keyHandler.getPressedUp() == true || keyHandler.getPressedLeft() == true || keyHandler.getPressedDown() == true || keyHandler.getPressedRight() == true){

            if(keyHandler.getPressedUp() == true){

                //direction = "up";
                this.setDirection("up");
                //contFrames++;
                this.setContFrames(this.getContFrames()+1);
            }
            else if(keyHandler.getPressedLeft() == true){

                //direction = "left";
                this.setDirection("left");
                //contFrames++;
                this.setContFrames(this.getContFrames()+1);

            }
            else if(keyHandler.getPressedDown() == true){

                //direction = "down";
                this.setDirection("down");
                //contFrames++;
                this.setContFrames(this.getContFrames()+1);

            }
            else if(keyHandler.getPressedRight() == true){
    
                //direction = "right";
                this.setDirection("right");
                //contFrames++;
                this.setContFrames(this.getContFrames()+1);
            }

            if(this.getContFrames()/*contFrames*/ > 15){

                if(this.getPlayerImageEstado()/*playerImageEstado*/ == 1){
                    //playerImageEstado = 2;
                    this.setPlayerImageEstado(2);
                }
                else{
                    //playerImageEstado = 1;
                    this.setPlayerImageEstado(1);
                }
                
                //contFrames = 0;
                this.setContFrames(0);
            }

            //colisionEstado = false;
            this.setColisionEstado(false);
            mapa.getColisionChecker().checkCasilla(this);
            int objIndex = mapa.getColisionChecker().checkObject(this);

            if(objIndex != -1){

                switch(mapa.getObjetos()[objIndex].getName()){

                    case "cofrePlateado": 
                        //mensajeCofreLooteado = mapa.getObjetos()[objIndex].lootCofre(this);
                        this.setMensajeCofreLooteado(mapa.getObjetos()[objIndex].lootCofre(this));
                        mapa.getObjetos()[objIndex] = null;
                        break;
                    case "cofreDorado":
                        //mensajeCofreLooteado = mapa.getObjetos()[objIndex].lootCofre(this);
                        this.setMensajeCofreLooteado(mapa.getObjetos()[objIndex].lootCofre(this));
                        mapa.getObjetos()[objIndex] = null;
                        break;
                }

                
            }

            int botIndex = mapa.getColisionChecker().checkBot(this, mapa.getBots());

            if(botIndex != -1){
                mapa.setSolicitudCambioEstado("Empezar combate");
                JFrame frameC= new JFrame();
                InterfazCombateCopia interfazC=new InterfazCombateCopia(mapa.getJugador(),mapa.getBots()[botIndex], frameC,mapa);
                mapa.getBots()[botIndex] = null;
                mapa.stopMusic();
                interfazC.playMusic(1);   
            }

            if(this.getColisionEstado() == false/*colisionEstado == false*/){

                switch (this.getDirection()/*direction*/) {
                case "up": //mapaY -= speed; //Restamos porque la esquina izquierda superior es el (0,0) y la derecha inferior es el (maxWidth, maxHeight). Si queremos ir hacia arriba hay que restarle a la coordenada Y
                    this.setMapaY(this.getMapaY()-speed);    
                break;
                case "down": //mapaY += speed;
                    this.setMapaY(this.getMapaY() + speed);
                break;
                case "left": //mapaX -= speed;
                    this.setMapaX(this.getMapaX() - speed);
                break;
                case "right": //mapaX += speed;
                    this.setMapaX(this.getMapaX() + speed);
                break;
                default:
                    break;
                }

            }

        }

    }
    
    public void draw(Graphics2D g2){

        BufferedImage image = null;

        if(this.getDirection().equals("up")){

            if(this.getPlayerImageEstado() == 1){
                image = up1;
            }
            else{
                image = up2;
            }
            
        }
        if(this.getDirection().equals("down")){

            if(this.getPlayerImageEstado() == 1){
                image = down1;
            }
            else{
                image = down2;
            }
            
        }
        if(this.getDirection().equals("left")){

            if(this.getPlayerImageEstado() == 1){
                image = left1;
            }
            else{
                image = left2;
            }
            
        }
        if(this.getDirection().equals("right")){

            if(this.getPlayerImageEstado() == 1){
                image = right1;
            }
            else{
                image = right2;
            }
            
        }

        g2.drawImage(image, this.getScreenX(), this.getScreenY(), mapa.getCasillaSizeEscalada(), mapa.getCasillaSizeEscalada(), null);


    }

    @Override
    public void updateBot() {

        throw new UnsupportedOperationException("Unimplemented method 'updateBot'");

    }

    @Override
    public void drawBot(Graphics2D g2) {

        throw new UnsupportedOperationException("Unimplemented method 'drawBot'");
        
    }

    // Observer Pattern
    @Override
    public void attach(ModelObserver modelObserver){
        this.observers.add(modelObserver);
    }

    @Override
    public void detach(ModelObserver modelObserver){
        this.observers.remove(modelObserver);
    }

    @Override
    public void notifyObservers(){
        for(ModelObserver observer : this.observers){

            if(((UI) observer).getContadorFramesMensajePantalla() < 120){

                observer.drawMensajePorPantalla(null, this.getMensajeCofreLooteado());

            }
            else{

                this.setMensajeCofreLooteado(null);
                ((UI) observer).setContadorFramesMensajePantalla(0);

            }
                
        }
    }
}

