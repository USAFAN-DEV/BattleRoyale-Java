package Objetos;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Entidades.Personaje;
import Herramientas.Armas;
import Main.Mapa;

public abstract class Objeto{
    
        protected final int escala = 3;
        protected BufferedImage image;
        private String name;
        protected boolean colision;
        protected int mapaX, mapaY;
        protected Rectangle areaDeColision;
        protected int areaDeColisionDefaultX, areaDeColisionDefaultY;
        protected Mapa mapa;

        public Objeto(Mapa mapa){

            this.mapa = mapa;

        }

        public void setMapaX(int mapaX){
            this.mapaX = mapaX;
        }
        public int getMapaX(){
            return this.mapaX;
        }
        public void setMapaY(int mapaY){
            this.mapaY = mapaY;
        }
        public int getMapaY(){
            return this.mapaY;
        }
        public int getAreaDeColisionDefaultX(){
            return this.areaDeColisionDefaultX;
        }
        public int getAreaDeColisionDefaultY(){
            return this.areaDeColisionDefaultY;
        }
        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
        public Rectangle getAreaDeColision(){
            return this.areaDeColision;
        }
        public boolean getColision(){
            return this.colision;
        }

        public void draw(Graphics2D g2, Mapa mapa){

            int screenX = mapaX - mapa.getJugador().getMapaX() + mapa.getJugador().getScreenX(); //coordenada x del objeto en la pantalla
            int screenY = mapaY - mapa.getJugador().getMapaY() + mapa.getJugador().getScreenY(); //coordenada y del objeto casilla en la pantalla

            
            if((mapaX + mapa.getCasillaSizeEscalada() > mapa.getJugador().getMapaX() - mapa.getJugador().getScreenX() && mapaX - mapa.getCasillaSizeEscalada() < mapa.getJugador().getMapaX() + mapa.getJugador().getScreenX()) && (mapaY + mapa.getCasillaSizeEscalada() > mapa.getJugador().getMapaY() - mapa.getJugador().getScreenY() && mapaY - mapa.getCasillaSizeEscalada() < mapa.getJugador().getMapaY() + mapa.getJugador().getScreenY())){

                g2.drawImage(image, screenX, screenY, mapa.getCasillaSizeEscalada(), mapa.getCasillaSizeEscalada(), null);

            }

        }
        

        public abstract String lootCofre(Personaje jugador);
        public abstract Armas recibirArma(String tipoPersonaje, int numEstrellas);

}
