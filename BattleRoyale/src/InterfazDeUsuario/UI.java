package InterfazDeUsuario;

import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Interfaces.Mapa;

import java.awt.Color;
import java.awt.Font;

import Texturas.Casilla;

public class UI {
    
    final int numeroTiposIconosUI = 4;
    Mapa mapa;
    Font fuenteTexto;
    public Icono[] iconos;
    Graphics2D g2;

    public UI(Mapa mapa){

        this.mapa = mapa;
        fuenteTexto = new Font("Arial", Font.PLAIN, 15); //Font.PLAIN es el style del font
        iconos = new Icono[numeroTiposIconosUI];
        getIconsImages();

    }

    public void getIconsImages(){

        try {

            String[] tiposIconosUI = {"vida.png", "escudo.png", "ataque.png", "crit.png"}; //Fotos de cada tipo de decoracion

            for(int i = 0; i < numeroTiposIconosUI; i++){ //Obtenemos las imagenes de cada tipo de casilla

                iconos[i] = new Icono();
                String imagePath = "./BattleRoyale-Java/BattleRoyale/images/UI/" + tiposIconosUI[i];
                //System.out.println(imagePath);
                iconos[i].image = ImageIO.read(new File(imagePath));
            }

        } catch (IOException e) {e.printStackTrace();}


    }

    public void drawPantallaDePausa(){

        String text = "PAUSED";
        int x = mapa.maxScreenWidht/2;
        int y = mapa.maxScreenHeight/2;

        g2.drawString(text, x, y);

    }

    public void drawPantallaDeCombate(){

        String text = "ESTAS EN COMBATE";
        int x = mapa.maxScreenWidht/2;
        int y = mapa.maxScreenHeight/2;

        g2.drawString(text, x, y);


    }

    public void draw(Graphics2D g2){

        this.g2 = g2; //Esta es la funcion que invocamos en el mapa y a la que le pasamos el g2 del mapa. nos guardamos este g2 en un atributo para poder usarlo en otros metodos
        g2.setFont(fuenteTexto);
        g2.setColor(Color.black);

        if(mapa.estadoDelJuego == 1){

            int screenX = 10;
            int screenY = 10;

            g2.drawImage(iconos[0].image, screenX, screenY, 25, 25, null);
            g2.drawString( "" + mapa.player1.getVida() + "/" + mapa.player1.getVidaMaxima(), screenX + (30), 29);
            screenY += 40;

            g2.drawImage(iconos[1].image, screenX, screenY, 25, 25, null);
            g2.drawString( "" + mapa.player1.getEscudo() + "/" + mapa.player1.getEscudoMaximo(), screenX + (30), 69);
            screenY += 40;

            g2.drawImage(iconos[2].image, screenX, screenY, 25, 25, null);
            g2.drawString( "" + mapa.player1.getAtk(), screenX + (30), 109);
            screenY += 40;

            g2.drawImage(iconos[3].image, screenX, screenY, 25, 25, null);
            g2.drawString( "" + mapa.player1.getCrit(), screenX + (30), 149);
            screenY += 40;

        }
        else if(mapa.estadoDelJuego == 2){

            drawPantallaDePausa();

        }

        else if(mapa.estadoDelJuego == 3){

            drawPantallaDeCombate();

        }

        

    }
}
