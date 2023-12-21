package InterfazDeUsuario;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Interfaces.Mapa;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;

import Texturas.Casilla;

public class UI {
    
    final int numeroTiposIconosUI = 5;
    Mapa mapa;
    Font fuenteTexto;
    public Icono[] iconos;
    Graphics2D g2;
    public int contadorFramesMensajePantalla;
    BufferedImage image;
    public int menuArrow;
    public int pantallaDeInicioLevel;

    public UI(Mapa mapa){

        this.mapa = mapa;
        fuenteTexto = new Font("Arial", Font.BOLD, 15); //Font.PLAIN es el style del font
        iconos = new Icono[numeroTiposIconosUI];
        contadorFramesMensajePantalla = 0;
        menuArrow = 0;
        pantallaDeInicioLevel = 0;
        getIconsImages();
    
    }

    public int getXForText(String text){

        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = mapa.maxScreenWidht/2 - length/2;
        return x;

    }

    public void getIconsImages(){

        try {

            String[] tiposIconosUI = {"vida.png", "escudo.png", "ataque.png", "crit.png", "pocion.png"}; //Fotos de cada tipo de decoracion

            for(int i = 0; i < numeroTiposIconosUI; i++){ //Obtenemos las imagenes de cada tipo de casilla

                iconos[i] = new Icono();
                String imagePath = "./BattleRoyale-Java/BattleRoyale/images/UI/" + tiposIconosUI[i];
                //System.out.println(imagePath);
                iconos[i].image = ImageIO.read(new File(imagePath));
            }

        } catch (IOException e) {e.printStackTrace();}


    }

    public void drawPantallaDePausa(){

        //g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 50));
        String text = "Mermaid";
        int x = getXForText(text);
        int y = mapa.maxScreenHeight/2;

        g2.drawString(text, x, y);

    }

    public void drawPantallaDeCombate(){

        String text = "ESTAS EN COMBATE";
        int x = getXForText(text);
        int y = mapa.maxScreenHeight/2;

        g2.drawString(text, x, y);


    }

    public void drawMensajePorPantalla(String mensajePorPantalla){

        contadorFramesMensajePantalla++;

        int width = 10*mapa.casillaSizeEscalada;
        int height = 2*mapa.casillaSizeEscalada;
        int screenX = mapa.maxScreenWidht/4; 
        int screenY = mapa.maxScreenHeight - height;
        


        Color c  = new Color(81, 81, 81, 200);
        g2.setColor(c);
        g2.fillRoundRect(screenX, screenY, width, height, 20, 20);
        g2.setColor(Color.white);
        g2.drawString(mensajePorPantalla, getXForText(mensajePorPantalla), screenY + mapa.casillaSizeEscalada);

    }

    public void drawPantallaInicio(){

        if(pantallaDeInicioLevel == 0){

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
            String text = "Genshin Royale";
            int x = getXForText(text);
            int y = 4 * mapa.casillaSizeEscalada;

            //Background
            g2.setColor(Color.black);
            g2.fillRect(0,0, mapa.maxScreenWidht, mapa.maxScreenHeight);
            try {
                image = ImageIO.read(new File("./BattleRoyale-Java/BattleRoyale/images/UI/fondo.jpeg"));
                g2.drawImage(image, 0, 0, mapa.maxScreenWidht, mapa.maxScreenHeight, null);
            } catch (IOException e) { e.printStackTrace();}

            //Sombras
            g2.setColor(Color.gray);
            g2.drawString(text, x+5, y+5);

            //Titulo
            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            //Menu
            if(menuArrow > 1){
                menuArrow = 0;
            }
            else if(menuArrow < 0){
                menuArrow = 1;
            }

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
            text = "NEW GAME";
            x = getXForText(text);
            y += mapa.casillaSizeEscalada * 4;
            g2.drawString("NEW GAME", x, y);

            if(menuArrow == 0){
                g2.drawString("=>", x-mapa.casillaSizeEscalada, y);
            }

            text = "EXIT";
            x = getXForText(text);
            y += mapa.casillaSizeEscalada;
            g2.drawString("EXIT", x, y );

            if(menuArrow == 1){
                g2.drawString("=>", x-mapa.casillaSizeEscalada, y);
            }
           
        }

        if(menuArrow == 0 && pantallaDeInicioLevel == 1){



            }
        else if(menuArrow == 1 && pantallaDeInicioLevel == 1){
            System.exit(0);
            
        }
    }

    public void draw(Graphics2D g2){

        this.g2 = g2; //Esta es la funcion que invocamos en el mapa y a la que le pasamos el g2 del mapa. nos guardamos este g2 en un atributo para poder usarlo en otros metodos
        g2.setFont(fuenteTexto);
        //g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 15F));
        g2.setColor(Color.black);

        if(mapa.estadoDelJuego == mapa.jugar){ //Estado del juego: jugar

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

            g2.drawImage(iconos[4].image, screenX, screenY, 25, 25, null);
            g2.drawString( "" + mapa.player1.getContadorPociones(), screenX + (30), 189);;

        }
        else if(mapa.estadoDelJuego == mapa.pantallaInicio){
            drawPantallaInicio();
        }
        else if(mapa.estadoDelJuego == mapa.pausar){ //Estado del juego: pausado

            g2.setColor(Color.white);
            drawPantallaDePausa();
            
        }

        else if(mapa.estadoDelJuego == mapa.combate){ //Estado del juego: combate

            drawPantallaDeCombate();

        }
        else if(mapa.estadoDelJuego == 4){ //Estado del juego: mensaje por pantalla

           //muerte

        } 

        

    }
}
