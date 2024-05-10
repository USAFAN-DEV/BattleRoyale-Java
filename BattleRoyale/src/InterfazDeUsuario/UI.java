package InterfazDeUsuario;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.Mapa;
import ObserverPattern.ModelObservable;
import ObserverPattern.ModelObserver;
import StatePatternMapa.*;
import InterfazDeUsuario.StatePatternUI.*;

import java.awt.Color;
import java.awt.Font;

public class UI implements ModelObserver{
    
    //ATRIBUTOS

    private UIStates estadoUI;
    private String solicitudCambioEstado;

    private final UIStates tituloConcreteState = new TituloConcreteState(this);
    private final UIStates seleccionPersonajeConcreteState = new SeleccionPersonajeConcreteState(this);
    private final UIStates datosPersonajeConcreteState = new DatosPersonajeConcreteState(this);
    private final UIStates elegirCiudadConcreteState = new ElegirCiudadConcreteState(this);
    private final UIStates botsConcreteState = new BotsConcreteState(this);
    private final UIStates dificultadBotsConcreteState = new DificultadBotsConcreteState(this);

    //Numero fotos de iconos de la UI
    private final int numeroTiposIconosUI = 6;

    //VARIABLES
    private int contadorFramesMensajePantalla;
    private int menuArrow;

    //OBJETOS
    private Mapa mapa;
    private Font fuenteTexto;
    private Icono[] iconos;
    private Graphics2D g2;
    private BufferedImage image;
    

    public UI(Mapa mapa){

        this.mapa = mapa;
        fuenteTexto = new Font("Arial", Font.BOLD, 15); //Font.PLAIN es el style del font
        iconos = new Icono[numeroTiposIconosUI];
        contadorFramesMensajePantalla = 0;
        menuArrow = 0;
        estadoUI = tituloConcreteState;
        solicitudCambioEstado = "Nada";
        getIconsImages();
    
    }

    //GETTERS y SETTERS
    public void setContadorFramesMensajePantalla(int contadorFramesMensajePantalla){

        this.contadorFramesMensajePantalla = contadorFramesMensajePantalla;

    }

    public int getContadorFramesMensajePantalla(){

        return this.contadorFramesMensajePantalla;

    }

    public void setMenuArrow(int menuArrow){

        this.menuArrow = menuArrow;

    }

    public int getMenuArrow(){

        return this.menuArrow;

    }

    //Metodos para procesar el estado de la UI

    public void setSolicitudCambioEstado(String solicitudCambioEstado){

        this.solicitudCambioEstado = solicitudCambioEstado;

    }

    public String getSolicitudCambioEstado(){

        return this.solicitudCambioEstado;

    }

    public UIStates getTituloConcreteState(){

        return this.tituloConcreteState;

    }

    public UIStates getSeleccionPersonajeConcreteState(){

        return this.seleccionPersonajeConcreteState;

    }

    public UIStates getDatosPersonajeConcreteState(){

        return this.datosPersonajeConcreteState;

    }

    public UIStates getElegirCiudadConcreteState(){

        return this.elegirCiudadConcreteState;

    }

    public UIStates getBotsConcreteState(){

        return this.botsConcreteState;

    }

    public UIStates getDificultadBotsConcreteState(){

        return this.dificultadBotsConcreteState;

    }

    public void setEstadoUI(UIStates estadoUI){

        this.estadoUI = estadoUI;

    }

    public UIStates getEstadoUI(){

        return this.estadoUI;

    }

    public void process(){

        this.estadoUI.process();

    }


    public int getXForText(String text){

        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = mapa.getMaxScreenWidth()/2 - length/2;
        return x;

    }

    public void getIconsImages(){

        try {

            String[] tiposIconosUI = {"vida.png", "escudo.png", "ataque.png", "crit.png", "pocion.png", "zhongli-down-1.png"}; //Fotos de cada tipo de decoracion

            for(int i = 0; i < numeroTiposIconosUI; i++){ //Obtenemos las imagenes de cada tipo de casilla

                iconos[i] = new Icono();
                String imagePath = "./BattleRoyale-Java/BattleRoyale/images/UI/" + tiposIconosUI[i];
                iconos[i].image = ImageIO.read(new File(imagePath));
            }

        } catch (IOException e) {e.printStackTrace();}


    }

    public void drawPantallaDePausa(){

        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0, 0, mapa.getMaxScreenWidth(), mapa.getMaxScreenHeight());

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 50F));
        g2.setColor(Color.white);
        String text = "PAUSA";
        int x = getXForText(text);
        int y = mapa.getMaxScreenHeight()/6;

        g2.drawString(text, x, y);

    }

    public void drawPantallaDeCombate(){

        String text = "ESTAS EN COMBATE";
        int x = getXForText(text);
        int y = mapa.getMaxScreenHeight()/2;

        g2.drawString(text, x, y);


    }

    public void drawMensajePorPantalla(ModelObservable modelObservable, Object object/*mensajePorPantalla*/){

        contadorFramesMensajePantalla++;
        System.out.println("ContadorFramesMensajePantalla: "+ contadorFramesMensajePantalla);
        int width = 10*mapa.getCasillaSizeEscalada();
        int height = 2*mapa.getCasillaSizeEscalada();
        int screenX = mapa.getMaxScreenWidth()/4; 
        int screenY = mapa.getMaxScreenHeight() - height;
        
        Color c  = new Color(81, 81, 81, 200);
        g2.setColor(c);
        g2.fillRoundRect(screenX, screenY, width, height, 20, 20);
        g2.setColor(Color.white);
        g2.drawString(object.toString(), getXForText(object.toString()), screenY + mapa.getCasillaSizeEscalada());
        

    }

    public void drawPantallaInicio(){

        int x = 0, y = 0;
        String text = "";

        if(estadoUI instanceof TituloConcreteState){

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
            text = "Genshin Royale";
            x = getXForText(text);
            y = 4 * mapa.getCasillaSizeEscalada();

            //Background
            g2.setColor(Color.black);
            g2.fillRect(0,0, mapa.getMaxScreenWidth(), mapa.getMaxScreenHeight());

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
            y += mapa.getCasillaSizeEscalada() * 4;
            g2.drawString("NEW GAME", x, y);

            if(menuArrow == 0){
                g2.drawString("=>", x-mapa.getCasillaSizeEscalada(), y);
            }

            text = "EXIT";
            x = getXForText(text);
            y += mapa.getCasillaSizeEscalada();
            g2.drawString("EXIT", x, y );

            if(menuArrow == 1){
                g2.drawString("=>", x-mapa.getCasillaSizeEscalada(), y);
            }
           
        }
        else if(estadoUI instanceof SeleccionPersonajeConcreteState){

            //Titulo
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));
            text = "Selecciona tu personaje";
            x = getXForText(text);
            y = mapa.getCasillaSizeEscalada() * 2;

            g2.setColor(Color.gray);
            g2.drawString(text, x+5, y+5);
            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            //Zhongli
            x = mapa.getCasillaSizeEscalada() + mapa.getCasillaSizeEscalada()*2;
            y = mapa.getCasillaSizeEscalada()*4;
            try {
                image = ImageIO.read(new File("./BattleRoyale-Java/BattleRoyale/images/player/zhongli.gif"));
                g2.drawImage(image, x, y, mapa.getMaxScreenWidth()/4, mapa.getMaxScreenHeight()/4, null);
            } catch (IOException e) { e.printStackTrace();}

            y += mapa.getCasillaSizeEscalada()*5;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 15F));
            text = "Zhongli, el arconte Geo";
            g2.drawString(text, x + 10, y);

            if(menuArrow == 0){
                g2.drawString("=>", x-mapa.getCasillaSizeEscalada()/2, y);
            }

            //Qiqi
            x += mapa.getMaxScreenWidth()/4;
            y = mapa.getCasillaSizeEscalada() * 4;
            try {
                image = ImageIO.read(new File("./BattleRoyale-Java/BattleRoyale/images/player/qiqi.gif"));
                g2.drawImage(image, x, y, mapa.getMaxScreenWidth()/4, mapa.getMaxScreenHeight()/4, null);
            } catch (IOException e) { e.printStackTrace();}

            y += mapa.getCasillaSizeEscalada()*5;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 15F));
            text = "Qiqi, La arconte de hielo";
            g2.drawString(text, x+ 10, y);

            if(menuArrow == 1){
                g2.drawString("=>", x-mapa.getCasillaSizeEscalada()/2, y);
            }

            //Raiden
            x += mapa.getMaxScreenWidth()/4;
            y = mapa.getCasillaSizeEscalada()*4;
            try {
                image = ImageIO.read(new File("./BattleRoyale-Java/BattleRoyale/images/player/mei.gif"));
                g2.drawImage(image, x, y, mapa.getMaxScreenWidth()/4, mapa.getMaxScreenHeight()/4, null);
            } catch (IOException e) { e.printStackTrace();}

            y += mapa.getCasillaSizeEscalada()*5;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 15F));
            text = "Raiden, La arconte electro";
            g2.drawString(text, x+ 10, y);

            if(menuArrow == 2){
                g2.drawString("=>", x-mapa.getCasillaSizeEscalada()/2, y);
            }

        }
        else if(estadoUI instanceof DatosPersonajeConcreteState){

            x = 0;
            y = mapa.getMaxScreenHeight()/6;

            try {
                image = ImageIO.read(new File("./BattleRoyale-Java/BattleRoyale/images/player/" + mapa.getJugador().getNombre().toLowerCase() + ".gif"));
                g2.drawImage(image, x, y, mapa.getMaxScreenWidth()/3, mapa.getMaxScreenHeight()/3, null);
            } catch (IOException e) { e.printStackTrace();}

            x += mapa.getMaxScreenWidth()/3;
            y += mapa.getCasillaSizeEscalada()*2;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 15F));
            g2.setColor(Color.white);

            text = mapa.getJugador().getNombre();
            g2.drawString(text, x, y);

            y += mapa.getCasillaSizeEscalada()/2;
            text = "Ataque = " + mapa.getJugador().getAtk();
            g2.drawString(text, x, y);

            y += mapa.getCasillaSizeEscalada()/2;
            text = "%Crit = " + mapa.getJugador().getCrit();
            g2.drawString(text, x, y);

            y += mapa.getCasillaSizeEscalada()/2;
            text = "Vida Maxima = " + mapa.getJugador().getVidaMaxima();
            g2.drawString(text, x, y);

            y += mapa.getCasillaSizeEscalada()/2;
            text = "Escudo Maximo = " + mapa.getJugador().getEscudoMaximo();
            g2.drawString(text, x, y);

            x += mapa.getCasillaSizeEscalada() * 4;
            y = mapa.getMaxScreenHeight()/6 + mapa.getCasillaSizeEscalada()*2;

            text = "Habilidad: " + mapa.getJugador().getNombreHabilidad();
            g2.drawString(text, x, y);

            y += mapa.getCasillaSizeEscalada()/2;
            String[] textHabilidad = mapa.getJugador().descripcionHabilidad().split("\n");
            
            for(int i = 0; i < textHabilidad.length; i++){
                g2.drawString(textHabilidad[i], x, y);
                y += mapa.getCasillaSizeEscalada()/2;
            }

            y += mapa.getCasillaSizeEscalada() * 4;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));
            text = "CONFIRMAR";
            x = getXForText(text);
            g2.drawString(text, x, y);

            if(menuArrow == 0){
                g2.drawString("->", x-mapa.getCasillaSizeEscalada(), y);
            }

            y += mapa.getCasillaSizeEscalada();
            text = "VOLVER";
            x = getXForText(text);
            g2.drawString(text, x, y);

            if(menuArrow == 1){
                g2.drawString("->", x-mapa.getCasillaSizeEscalada(), y);
            }
        }
        else if(estadoUI instanceof ElegirCiudadConcreteState){

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));

            text = "Elige una ciudad para caer";
            x = getXForText(text);
            y = mapa.getCasillaSizeEscalada() * 2;

            g2.setColor(Color.gray);
            g2.drawString(text, x + 5, y + 5);

            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));

            text = "Espinadragon. Zona nevada";
            x = getXForText(text);
            y = mapa.getMaxScreenHeight()/3;
            g2.drawString(text, x, y);

            if(menuArrow == 0){
                g2.drawString("->", x-mapa.getCasillaSizeEscalada(), y);
            }

            text = "Mondstadt. La ciudad de la libertad";
            y += mapa.getCasillaSizeEscalada();
            x = getXForText(text);
            g2.drawString(text, x, y);

            if(menuArrow == 1){
                g2.drawString("->", x-mapa.getCasillaSizeEscalada(), y);
            }

            text = "Liyue. La ciudad de los contratos";
            y += mapa.getCasillaSizeEscalada();
            x = getXForText(text);
            g2.drawString(text, x, y);

            if(menuArrow == 2){
                g2.drawString("->", x-mapa.getCasillaSizeEscalada(), y);
            }

            text = "Inazuma. La ciudad de la eternidad";
            y += mapa.getCasillaSizeEscalada();
            x = getXForText(text);
            g2.drawString(text, x, y);

            if(menuArrow == 3){
                g2.drawString("->", x-mapa.getCasillaSizeEscalada(), y);
            }

            text = "Sumeru. El desierto sin fin";
            y += mapa.getCasillaSizeEscalada();
            x = getXForText(text);
            g2.drawString(text, x, y);

            if(menuArrow == 4){
                g2.drawString("->", x-mapa.getCasillaSizeEscalada(), y);
            }

        }
        else if(estadoUI instanceof BotsConcreteState){
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));

            text = "Elige el Numero de Bots";
            x = getXForText(text);
            y = mapa.getCasillaSizeEscalada() * 2;

            g2.setColor(Color.gray);
            g2.drawString(text, x + 5, y + 5);

            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));

            text = "TRES";
            x = getXForText(text);
            y = mapa.getMaxScreenHeight()/3;
            g2.drawString(text, x, y);

            if(menuArrow == 0){
                g2.drawString("->", x-mapa.getCasillaSizeEscalada(), y);
            }

            text = "SEIS";
            y += mapa.getCasillaSizeEscalada();
            x = getXForText(text);
            g2.drawString(text, x, y);

            if(menuArrow == 1){
                g2.drawString("->", x-mapa.getCasillaSizeEscalada(), y);
            }

            text = "NUEVE";
            y += mapa.getCasillaSizeEscalada();
            x = getXForText(text);
            g2.drawString(text, x, y);

            if(menuArrow == 2){
                g2.drawString("->", x-mapa.getCasillaSizeEscalada(), y);
            }


        }
        else if(estadoUI instanceof DificultadBotsConcreteState){

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));

            text = "Elige la dificultad de los Bots";
            x = getXForText(text);
            y = mapa.getCasillaSizeEscalada() * 2;

            g2.setColor(Color.gray);
            g2.drawString(text, x + 5, y + 5);

            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));

            text = "FACIL";
            x = getXForText(text);
            y = mapa.getMaxScreenHeight()/3;
            g2.drawString(text, x, y);

            if(menuArrow == 0){
                g2.drawString("->", x-mapa.getCasillaSizeEscalada(), y);
            }

            text = "MEDIO";
            y += mapa.getCasillaSizeEscalada();
            x = getXForText(text);
            g2.drawString(text, x, y);

            if(menuArrow == 1){
                g2.drawString("->", x-mapa.getCasillaSizeEscalada(), y);
            }

            text = "DIFICIL";
            y += mapa.getCasillaSizeEscalada();
            x = getXForText(text);
            g2.drawString(text, x, y);

            if(menuArrow == 2){
                g2.drawString("->", x-mapa.getCasillaSizeEscalada(), y);
            }

        }
    }

    public void drawGameOver(){

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
        String text = "GAME OVER";
        int x = getXForText(text);
        int y = 4 * mapa.getCasillaSizeEscalada();

        //Background
        g2.setColor(Color.black);
        g2.fillRect(0,0, mapa.getMaxScreenWidth(), mapa.getMaxScreenHeight());
        try {
            image = ImageIO.read(new File("./BattleRoyale-Java/BattleRoyale/images/UI/calavera.png"));
            g2.drawImage(image, mapa.getMaxScreenWidth()/3 + mapa.getCasillaSizeEscalada()/2, mapa.getMaxScreenHeight()/3, mapa.getMaxScreenWidth()/4, mapa.getMaxScreenHeight()/4, null);
        } catch (IOException e) { e.printStackTrace();}

        //Sombras
        g2.setColor(Color.gray);
        g2.drawString(text, x+5, y+5);

        //Titulo
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        //Menu
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
        text = "PLAY AGAIN";
        x = getXForText(text);
        y += mapa.getCasillaSizeEscalada() * 6;
        g2.drawString(text, x, y);

        if(menuArrow == 0){
            g2.drawString("=>", x-mapa.getCasillaSizeEscalada(), y);
        }

        text = "EXIT";
        x = getXForText(text);
        y += mapa.getCasillaSizeEscalada();
        g2.drawString(text, x, y );

        if(menuArrow == 1){
            g2.drawString("=>", x-mapa.getCasillaSizeEscalada(), y);
        }

    }

    public void drawVictoria(){

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
        String text = "VICTORIA";
        int x = getXForText(text);
        int y = 4 * mapa.getCasillaSizeEscalada();

        //Background
        g2.setColor(Color.black);
        g2.fillRect(0,0, mapa.getMaxScreenWidth(), mapa.getMaxScreenHeight());
        /*try {
            image = ImageIO.read(new File("./BattleRoyale-Java/BattleRoyale/images/UI/calavera.png"));
            g2.drawImage(image, mapa.getMaxScreenWidth()/3, mapa.getMaxScreenHeight()/3, mapa.getMaxScreenWidth()/4, mapa.getMaxScreenHeight()/4, null);
        } catch (IOException e) { e.printStackTrace();}*/

        //Sombras
        g2.setColor(Color.gray);
        g2.drawString(text, x+5, y+5);

        //Titulo
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        //Menu
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
        text = "PLAY AGAIN";
        x = getXForText(text);
        y += mapa.getCasillaSizeEscalada() * 6;
        g2.drawString(text, x, y);

        if(menuArrow == 0){
            g2.drawString("=>", x-mapa.getCasillaSizeEscalada(), y);
        }

        text = "EXIT";
        x = getXForText(text);
        y += mapa.getCasillaSizeEscalada();
        g2.drawString(text, x, y );

        if(menuArrow == 1){
            g2.drawString("=>", x-mapa.getCasillaSizeEscalada(), y);
        }

    }

    public void draw(Graphics2D g2){

        //Esta es la funcion que invocamos en el mapa y a la que le pasamos el g2 del mapa. nos guardamos este g2 en un atributo para poder usarlo en otros metodos

        this.g2 = g2; 
        g2.setFont(fuenteTexto);
        g2.setColor(Color.black);

        if(mapa.getEstadoDelJuego() instanceof JugarConcreteState){ //Estado del juego: jugar

            int screenX = 10;
            int screenY = 10;

            g2.drawImage(iconos[0].image, screenX, screenY, 25, 25, null);
            g2.drawString( "" + mapa.getJugador().getVida() + "/" + mapa.getJugador().getVidaMaxima(), screenX + (30), 29);
            screenY += 40;

            g2.drawImage(iconos[1].image, screenX, screenY, 25, 25, null);
            g2.drawString( "" + mapa.getJugador().getEscudo() + "/" + mapa.getJugador().getEscudoMaximo(), screenX + (30), 69);
            screenY += 40;

            g2.drawImage(iconos[2].image, screenX, screenY, 25, 25, null);
            g2.drawString( "" + mapa.getJugador().getAtk(), screenX + (30), 109);
            screenY += 40;

            g2.drawImage(iconos[3].image, screenX, screenY, 25, 25, null);
            g2.drawString( "" + mapa.getJugador().getCrit(), screenX + (30), 149);
            screenY += 40;

            g2.drawImage(iconos[4].image, screenX, screenY, 25, 25, null);
            g2.drawString( "" + mapa.getJugador().getContadorPociones(), screenX + (30), 189);;

            g2.drawImage(iconos[5].image,mapa.getCasillaSizeEscalada()*18 , 10, 25, 25, null);
            g2.drawString( "" + mapa.getNumeroDeBots(), mapa.getCasillaSizeEscalada()*18 + (30), 29);;

        }
        else if(mapa.getEstadoDelJuego() instanceof PantallaInicioConcreteState){

            drawPantallaInicio();
            
        }
        else if(mapa.getEstadoDelJuego() instanceof PausaConcreteState){ 

            g2.setColor(Color.white);
            drawPantallaDePausa();
            
        }

        else if(mapa.getEstadoDelJuego() instanceof CombateConcreteState){ 

            drawPantallaDeCombate();

        }
        else if(mapa.getEstadoDelJuego() instanceof MuerteConcreteState){ 

           drawGameOver();

        } 
        else if(mapa.getEstadoDelJuego() instanceof VictoriaConcreteState){

            drawVictoria();

        }

    }
}
