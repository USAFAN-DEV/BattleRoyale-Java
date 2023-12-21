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
    
    public final int pantallaTitulo = 0;
    public final int seleccionDePersonaje = 1;
    public final int datosPersonaje = 2;
    public final int elegirCiudad = 3;
    public final int elegirBots = 4;
    public final int elegirDificultadBots = 5;
    final int numeroTiposIconosUI = 6;
    Mapa mapa;
    Font fuenteTexto;
    public Icono[] iconos;
    Graphics2D g2;
    public int contadorFramesMensajePantalla;
    BufferedImage image;
    public int menuArrow;
    public int pantallaDeInicioEstado;

    public UI(Mapa mapa){

        this.mapa = mapa;
        fuenteTexto = new Font("Arial", Font.BOLD, 15); //Font.PLAIN es el style del font
        iconos = new Icono[numeroTiposIconosUI];
        contadorFramesMensajePantalla = 0;
        menuArrow = 0;
        pantallaDeInicioEstado = 0;
        getIconsImages();
    
    }

    public int getXForText(String text){

        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = mapa.maxScreenWidht/2 - length/2;
        return x;

    }

    public void getIconsImages(){

        try {

            String[] tiposIconosUI = {"vida.png", "escudo.png", "ataque.png", "crit.png", "pocion.png", "zhongli-down-1.png"}; //Fotos de cada tipo de decoracion

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

        int x = 0, y = 0;
        String text = "";

        if(pantallaDeInicioEstado == pantallaTitulo){

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
            text = "Genshin Royale";
            x = getXForText(text);
            y = 4 * mapa.casillaSizeEscalada;

            //Background
            g2.setColor(Color.black);
            g2.fillRect(0,0, mapa.maxScreenWidht, mapa.maxScreenHeight);
            /*try {
                image = ImageIO.read(new File("./BattleRoyale-Java/BattleRoyale/images/UI/fondo.jpeg"));
                g2.drawImage(image, 0, 0, mapa.maxScreenWidht, mapa.maxScreenHeight, null);
            } catch (IOException e) { e.printStackTrace();}*/

            //Sombras
            g2.setColor(Color.gray);
            g2.drawString(text, x+5, y+5);

            //Titulo
            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            //Menu
           
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
        else if(pantallaDeInicioEstado == seleccionDePersonaje){

            //Titulo
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));
            text = "Selecciona tu personaje";
            x = getXForText(text);
            y = mapa.casillaSizeEscalada * 2;

            g2.setColor(Color.gray);
            g2.drawString(text, x+5, y+5);
            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            //Zhongli
            x = mapa.casillaSizeEscalada + mapa.casillaSizeEscalada*2;
            y = mapa.casillaSizeEscalada*4;
            try {
                image = ImageIO.read(new File("./BattleRoyale-Java/BattleRoyale/images/player/zhongli.gif"));
                g2.drawImage(image, x, y, mapa.maxScreenWidht/4, mapa.maxScreenHeight/4, null);
            } catch (IOException e) { e.printStackTrace();}

            y += mapa.casillaSizeEscalada*5;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 15F));
            text = "Zhongli, el arconte Geo";
            g2.drawString(text, x + 10, y);

            if(menuArrow == 0){
                g2.drawString("=>", x-mapa.casillaSizeEscalada/2, y);
            }

            //Qiqi
            x += mapa.maxScreenWidht/4;
            y = mapa.casillaSizeEscalada * 4;
            try {
                image = ImageIO.read(new File("./BattleRoyale-Java/BattleRoyale/images/player/qiqi.gif"));
                g2.drawImage(image, x, y, mapa.maxScreenWidht/4, mapa.maxScreenHeight/4, null);
            } catch (IOException e) { e.printStackTrace();}

            y += mapa.casillaSizeEscalada*5;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 15F));
            text = "Qiqi, La arconte de hielo";
            g2.drawString(text, x+ 10, y);

            if(menuArrow == 1){
                g2.drawString("=>", x-mapa.casillaSizeEscalada/2, y);
            }

            //Raiden
            x += mapa.maxScreenWidht/4;
            y = mapa.casillaSizeEscalada*4;
            try {
                image = ImageIO.read(new File("./BattleRoyale-Java/BattleRoyale/images/player/mei.gif"));
                g2.drawImage(image, x, y, mapa.maxScreenWidht/4, mapa.maxScreenHeight/4, null);
            } catch (IOException e) { e.printStackTrace();}

            y += mapa.casillaSizeEscalada*5;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 15F));
            text = "Raiden, La arconte electro";
            g2.drawString(text, x+ 10, y);

            if(menuArrow == 2){
                g2.drawString("=>", x-mapa.casillaSizeEscalada/2, y);
            }

        }
        else if(pantallaDeInicioEstado == datosPersonaje){

            x = 0;
            y = mapa.maxScreenHeight/6;

            try {
                image = ImageIO.read(new File("./BattleRoyale-Java/BattleRoyale/images/player/" + mapa.player1.getNombre().toLowerCase() + ".gif"));
                g2.drawImage(image, x, y, mapa.maxScreenWidht/3, mapa.maxScreenHeight/3, null);
            } catch (IOException e) { e.printStackTrace();}

            x += mapa.maxScreenWidht/3;
            y += mapa.casillaSizeEscalada*2;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 15F));
            g2.setColor(Color.white);

            text = mapa.player1.getNombre();
            g2.drawString(text, x, y);

            y += mapa.casillaSizeEscalada/2;
            text = "Ataque = " + mapa.player1.getAtk();
            g2.drawString(text, x, y);

            y += mapa.casillaSizeEscalada/2;
            text = "%Crit = " + mapa.player1.getCrit();
            g2.drawString(text, x, y);

            y += mapa.casillaSizeEscalada/2;
            text = "Vida Maxima = " + mapa.player1.getVidaMaxima();
            g2.drawString(text, x, y);

            y += mapa.casillaSizeEscalada/2;
            text = "Escudo Maximo = " + mapa.player1.getEscudoMaximo();
            g2.drawString(text, x, y);

            x += mapa.casillaSizeEscalada * 4;
            y = mapa.maxScreenHeight/6 + mapa.casillaSizeEscalada*2;

            text = "Habilidad: " + mapa.player1.getNombreHabilidad();
            g2.drawString(text, x, y);

            y += mapa.casillaSizeEscalada/2;
            String[] textHabilidad = mapa.player1.descripcionHabilidad().split("\n");
            
            for(int i = 0; i < textHabilidad.length; i++){
                g2.drawString(textHabilidad[i], x, y);
                y += mapa.casillaSizeEscalada/2;
            }

            y += mapa.casillaSizeEscalada * 4;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));
            text = "CONFIRMAR";
            x = getXForText(text);
            g2.drawString(text, x, y);

            if(menuArrow == 0){
                g2.drawString("->", x-mapa.casillaSizeEscalada, y);
            }

            y += mapa.casillaSizeEscalada;
            text = "VOLVER";
            x = getXForText(text);
            g2.drawString(text, x, y);

            if(menuArrow == 1){
                g2.drawString("->", x-mapa.casillaSizeEscalada, y);
            }
        }
        else if(pantallaDeInicioEstado == elegirCiudad){

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));

            text = "Elige una ciudad para caer";
            x = getXForText(text);
            y = mapa.casillaSizeEscalada * 2;

            g2.setColor(Color.gray);
            g2.drawString(text, x + 5, y + 5);

            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));

            text = "Espinadragon. Zona nevada";
            x = getXForText(text);
            y = mapa.maxScreenHeight/3;
            g2.drawString(text, x, y);

            if(menuArrow == 0){
                g2.drawString("->", x-mapa.casillaSizeEscalada, y);
            }

            text = "Moonstad. La ciudad de la libertad";
            y += mapa.casillaSizeEscalada;
            x = getXForText(text);
            g2.drawString(text, x, y);

            if(menuArrow == 1){
                g2.drawString("->", x-mapa.casillaSizeEscalada, y);
            }

            text = "Liyue. La ciudad de los contratos";
            y += mapa.casillaSizeEscalada;
            x = getXForText(text);
            g2.drawString(text, x, y);

            if(menuArrow == 2){
                g2.drawString("->", x-mapa.casillaSizeEscalada, y);
            }

            text = "Inazuma. La ciudad de la eternidad";
            y += mapa.casillaSizeEscalada;
            x = getXForText(text);
            g2.drawString(text, x, y);

            if(menuArrow == 3){
                g2.drawString("->", x-mapa.casillaSizeEscalada, y);
            }

            text = "Sumeru. El desierto sin fin";
            y += mapa.casillaSizeEscalada;
            x = getXForText(text);
            g2.drawString(text, x, y);

            if(menuArrow == 4){
                g2.drawString("->", x-mapa.casillaSizeEscalada, y);
            }

        }
        else if(pantallaDeInicioEstado == elegirBots){
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));

            text = "Elige el Numero de Bots";
            x = getXForText(text);
            y = mapa.casillaSizeEscalada * 2;

            g2.setColor(Color.gray);
            g2.drawString(text, x + 5, y + 5);

            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));

            text = "TRES";
            x = getXForText(text);
            y = mapa.maxScreenHeight/3;
            g2.drawString(text, x, y);

            if(menuArrow == 0){
                g2.drawString("->", x-mapa.casillaSizeEscalada, y);
            }

            text = "SEIS";
            y += mapa.casillaSizeEscalada;
            x = getXForText(text);
            g2.drawString(text, x, y);

            if(menuArrow == 1){
                g2.drawString("->", x-mapa.casillaSizeEscalada, y);
            }

            text = "NUEVE";
            y += mapa.casillaSizeEscalada;
            x = getXForText(text);
            g2.drawString(text, x, y);

            if(menuArrow == 2){
                g2.drawString("->", x-mapa.casillaSizeEscalada, y);
            }


        }
        else if(pantallaDeInicioEstado == elegirDificultadBots){

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));

            text = "Elige la dificultad de los Bots";
            x = getXForText(text);
            y = mapa.casillaSizeEscalada * 2;

            g2.setColor(Color.gray);
            g2.drawString(text, x + 5, y + 5);

            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));

            text = "FACIL";
            x = getXForText(text);
            y = mapa.maxScreenHeight/3;
            g2.drawString(text, x, y);

            if(menuArrow == 0){
                g2.drawString("->", x-mapa.casillaSizeEscalada, y);
            }

            text = "MEDIO";
            y += mapa.casillaSizeEscalada;
            x = getXForText(text);
            g2.drawString(text, x, y);

            if(menuArrow == 1){
                g2.drawString("->", x-mapa.casillaSizeEscalada, y);
            }

            text = "DIFICIL";
            y += mapa.casillaSizeEscalada;
            x = getXForText(text);
            g2.drawString(text, x, y);

            if(menuArrow == 2){
                g2.drawString("->", x-mapa.casillaSizeEscalada, y);
            }

        }
    }

    //public void drawEstadisticasPersonaje(int vida, int escudoMaximo, int )

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

            g2.drawImage(iconos[5].image,mapa.casillaSizeEscalada*18 , 10, 25, 25, null);
            g2.drawString( "" + mapa.numeroDeBots, mapa.casillaSizeEscalada*18 + (30), 29);;

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
