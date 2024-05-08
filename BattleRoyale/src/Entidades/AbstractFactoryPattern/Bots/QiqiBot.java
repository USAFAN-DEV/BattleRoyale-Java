package Entidades.AbstractFactoryPattern.Bots;

import java.awt.Graphics2D;

import java.awt.image.BufferedImage;

import Entidades.AbstractFactoryPattern.Qiqi;
import Main.KeyHandler;
import Main.Mapa;

public class QiqiBot extends Qiqi{
    
    public QiqiBot(Mapa mapa, KeyHandler keyHandler, int mapaX, int mapaY){

        super(mapa, keyHandler);
        this.keyHandler = keyHandler;

        this.speed = 2;
        getCharacterImage();
        this.setMapaX(mapaX);
        this.setMapaY(mapaY);
        /*this.areaDeColisionDefaultX = mapa.casillaSizeEscalada;
        this.areaDeColisionDefaultY = mapa.casillaSizeEscalada;
        this.areaDeCollision = new Rectangle(0, 0, mapa.casillaSizeEscalada, mapa.casillaSizeEscalada);*/

    }
    
    public void updateBot(){

        setBotDirection();
        if(this.getContBotDirection() % 15 == 0){

            if(this.getPlayerImageEstado() == 1){
                //playerImageEstado = 2;
                this.setPlayerImageEstado(2);
            }
            else{
                //playerImageEstado = 1;
                this.setPlayerImageEstado(1);
            }

        }

        //colisionEstado = false;
        this.setColisionEstado(false);
        mapa.getColisionChecker().checkCasilla(this);
        mapa.getColisionChecker().checkPlayer(this);

        if(mapa.getColisionChecker().checkObject(this) != -1){

            //colisionEstado = true;
            this.setColisionEstado(true);

        }

        if(this.getColisionEstado() == false){

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

    public void drawBot(Graphics2D g2){

        int screenX = this.getMapaX() - mapa.getJugador().getMapaX() + mapa.getJugador().getScreenX(); //coordenada x del objeto en la pantalla
        int screenY = this.getMapaY() - mapa.getJugador().getMapaY() + mapa.getJugador().getScreenY(); //coordenada y del objeto casilla en la pantalla

        if((this.getMapaX() + mapa.getCasillaSizeEscalada() > mapa.getJugador().getMapaX() - mapa.getJugador().getScreenX() && this.getMapaX() - mapa.getCasillaSizeEscalada() < mapa.getJugador().getMapaX() + mapa.getJugador().getScreenX()) && (this.getMapaY() + mapa.getCasillaSizeEscalada() > mapa.getJugador().getMapaY() - mapa.getJugador().getScreenY() && this.getMapaY() - mapa.getCasillaSizeEscalada() < mapa.getJugador().getMapaY() + mapa.getJugador().getScreenY())){

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

            g2.drawImage(image, screenX, screenY, mapa.getCasillaSizeEscalada(), mapa.getCasillaSizeEscalada(), null);

        }
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void draw(Graphics2D g2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }
}

