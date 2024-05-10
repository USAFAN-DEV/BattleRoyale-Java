package Entidades;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import Main.Mapa;

public abstract class Bot extends Entidad{
    
    private int contBotDirection;

    public Bot(int vida,int vidaMaxima,int atk,int escudo,int escudoMaximo,double crit,double estadisticaHabilidad, String tipo,String nombre,String nombreHabilidad, int mapaX, int mapaY, Mapa mapa){

        super(vida, vidaMaxima, atk, escudo, escudoMaximo, crit, estadisticaHabilidad, tipo, nombre, nombreHabilidad, mapaX, mapaY, mapa);

    }

    public void setContBotDirection(int contBotDirection){

        this.contBotDirection = contBotDirection;

    }

    public int getContBotDirection(){

        return this.contBotDirection;
        
    }

    public void setBotDirection(){

        contBotDirection++;

        if(contBotDirection == 120){

            Random random = new Random();
            int i = random.nextInt(4) + 1; //1-4

            if(i == 1){this.setDirection("up");}
            else if(i == 2){this.setDirection("down");}
            else if(i == 3){this.setDirection("left");}
            else{this.setDirection("right");}

            contBotDirection = 0;

        }
        
    }

    public void updateBot(){

        setBotDirection();
        if(this.getContBotDirection() % 15 == 0){

            if(this.getPlayerImageEstado() == 1){

                this.setPlayerImageEstado(2);

            }

            else{

                this.setPlayerImageEstado(1);

            }

        }

        this.setColisionEstado(false);
        mapa.getColisionChecker().checkCasilla(this);
        mapa.getColisionChecker().checkPlayer(this);

        if(mapa.getColisionChecker().checkObject(this) != -1){

            this.setColisionEstado(true);

        }

        if(this.getColisionEstado() == false){

            switch (this.getDirection()/*direction*/) {
                case "up": //Restamos porque la esquina izquierda superior es el (0,0) y la derecha inferior es el (maxWidth, maxHeight). Si queremos ir hacia arriba hay que restarle a la coordenada Y
                    this.setMapaY(this.getMapaY()-speed);    
                break;
                case "down": 
                    this.setMapaY(this.getMapaY() + speed);
                break;
                case "left": 
                    this.setMapaX(this.getMapaX() - speed);
                break;
                case "right": 
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

    public abstract String descripcionHabilidad();
    public abstract void getCharacterImage();
    public abstract void usarHabilidad(Entidad jugador);

    @Override
    public void update() {

        throw new UnsupportedOperationException("Unimplemented method 'update'");

    }

    @Override
    public void draw(Graphics2D g2) {

        throw new UnsupportedOperationException("Unimplemented method 'draw'");
        
    }

}
