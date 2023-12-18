package Objetos;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Interfaces2.Mapa;

public class Objeto{
    
        public BufferedImage image;
        public String name;
        public boolean collision = false;
        public int mapaX, mapaY;

        public void draw(Graphics2D g2, Mapa mapa){

            int screenX = mapaX - mapa.player1.getMapaX() + mapa.player1.screenX; //coordenada x del objeto en la pantalla
            int screenY = mapaY - mapa.player1.getMapaY() + mapa.player1.screenY; //coordenada y del objeto casilla en la pantalla

            
            if((mapaX + mapa.casillaSizeEscalada > mapa.player1.getMapaX() - mapa.player1.screenX && mapaX - mapa.casillaSizeEscalada < mapa.player1.getMapaX() + mapa.player1.screenX) && (mapaY + mapa.casillaSizeEscalada > mapa.player1.getMapaY() - mapa.player1.screenY && mapaY - mapa.casillaSizeEscalada < mapa.player1.getMapaY() + mapa.player1.screenY)){

                g2.drawImage(image, screenX, screenY, mapa.casillaSizeEscalada, mapa.casillaSizeEscalada, null);

            }

        }

}
