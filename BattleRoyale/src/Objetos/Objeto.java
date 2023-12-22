package Objetos;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Entidades.Personaje;
import Herramientas.Armas;
import Interfaces.Mapa;

public abstract class Objeto{
    
        public final int escala = 3;
        public BufferedImage image;
        public String name;
        public boolean collision;
        public int mapaX, mapaY;
        public Rectangle areaDeColision;
        public int areaDeColisionDefaultX, areaDeColisionDefaultY;
        public Mapa mapa;

        public Objeto(Mapa mapa){

            this.mapa = mapa;

        }

        public void draw(Graphics2D g2, Mapa mapa){

            int screenX = mapaX - mapa.player1.getMapaX() + mapa.player1.screenX; //coordenada x del objeto en la pantalla
            int screenY = mapaY - mapa.player1.getMapaY() + mapa.player1.screenY; //coordenada y del objeto casilla en la pantalla

            
            if((mapaX + mapa.getCasillaSizeEscalada() > mapa.player1.getMapaX() - mapa.player1.screenX && mapaX - mapa.getCasillaSizeEscalada() < mapa.player1.getMapaX() + mapa.player1.screenX) && (mapaY + mapa.getCasillaSizeEscalada() > mapa.player1.getMapaY() - mapa.player1.screenY && mapaY - mapa.getCasillaSizeEscalada() < mapa.player1.getMapaY() + mapa.player1.screenY)){

                g2.drawImage(image, screenX, screenY, mapa.getCasillaSizeEscalada(), mapa.getCasillaSizeEscalada(), null);

            }

        }

        public abstract String lootCofre(Personaje jugador);
        public abstract Armas recibirArma(String tipoPersonaje, int numEstrellas);

}
