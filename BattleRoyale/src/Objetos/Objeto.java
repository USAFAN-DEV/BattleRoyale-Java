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

            int screenX = mapaX - mapa.getJugador().getMapaX() + mapa.getJugador().screenX; //coordenada x del objeto en la pantalla
            int screenY = mapaY - mapa.getJugador().getMapaY() + mapa.getJugador().screenY; //coordenada y del objeto casilla en la pantalla

            
            if((mapaX + mapa.getCasillaSizeEscalada() > mapa.getJugador().getMapaX() - mapa.getJugador().screenX && mapaX - mapa.getCasillaSizeEscalada() < mapa.getJugador().getMapaX() + mapa.getJugador().screenX) && (mapaY + mapa.getCasillaSizeEscalada() > mapa.getJugador().getMapaY() - mapa.getJugador().screenY && mapaY - mapa.getCasillaSizeEscalada() < mapa.getJugador().getMapaY() + mapa.getJugador().screenY)){

                g2.drawImage(image, screenX, screenY, mapa.getCasillaSizeEscalada(), mapa.getCasillaSizeEscalada(), null);

            }

        }

        public abstract String lootCofre(Personaje jugador);
        public abstract Armas recibirArma(String tipoPersonaje, int numEstrellas);

}
