package Main;

import javax.swing.JPanel;
import java.awt.*;
import Sound.Musica;
import StatePatternMapa.CombateConcreteState;
import StatePatternMapa.JugarConcreteState;
import StatePatternMapa.MapaStates;
import StatePatternMapa.MuerteConcreteState;
import StatePatternMapa.PantallaInicioConcreteState;
import StatePatternMapa.PausaConcreteState;
import StatePatternMapa.VictoriaConcreteState;
import Entidades.Personaje;
import InterfazDeUsuario.UI;
import Objetos.AdministradorDeObjetos;
import Objetos.Objeto;
import Texturas.AdministradorDeCasillas;

public class Mapa extends JPanel implements Runnable{

    //ATRIBUTOS
    
    //CONSTANTES
    private final int casillaSize = 16; // 16x16. Tamano personajes. Esto se usaba antes cuando las resoluciones eran mas pequenas. Tendremos que hacer escala de esto. 
    private final int escala = 3; 

    private final int casillaSizeEscalada = casillaSize * escala; //Asi los personajes son 48x48
    private final int maxScreenColumnas = 20;
    private final int maxScreenFilas = 15; //Ratio 4x3;
    private final int maxScreenWidth = casillaSizeEscalada * maxScreenColumnas; //48 * 20 = 960pixels
    private final int maxScreenHeight = casillaSizeEscalada * maxScreenFilas; //48 * 15 = 720pixels
    private final int maxMapaColumnas = 103;
    private final int maxMapaFilas = 82;

    private final int FPS = 60; //Frames per second
    private final int numeroDeObjetos = 20;


    //VARIABLES
    private String personajeElegido;
    private int numeroDeBots;
    private int dificultadBots; //1 - facil, 2 - medio, 3 - dificil

    //Estado del juego: 1-jugar, 2-pausar, 3-combate, 4-muerte, 5-victoria
    /*private int estadoDelJuego;
    //Declaro estos atributos en publico. Simplemente son constantes que representan el estado del juego, como un enum.
    public final int pantallaInicio = 0;
    public final int jugar = 1;
    public final int pausar = 2;
    public final int combate = 3;
    public final int muerte = 4;
    public final int victoria = 5;*/
    private MapaStates estadoDelJuego;
    private MapaStates pantallaInicio = new PantallaInicioConcreteState(this);
    private MapaStates jugar = new JugarConcreteState(this);
    private MapaStates pausar = new PausaConcreteState(this);
    private MapaStates combate = new CombateConcreteState(this);
    private MapaStates muerte = new MuerteConcreteState(this);
    private MapaStates victoria = new VictoriaConcreteState(this);
    //OBJETOS
    private AdministradorDeCasillas administradorC;
    private KeyHandler keyHandler;
    private AdministradorDeObjetos administradorO;
    private ColisionCheck colisionChecker;
    private UI ui;
    private Musica musica;
    private Personaje jugador;
    private Objeto[] objetos; 
    private Personaje[] bots;

    private Thread gameThread;

    

    //CONSTRUCTOR
    public Mapa(){

        //instanciamos los objetos
        setObjetos(new Objeto[numeroDeObjetos]);
        this.musica = new Musica();
        keyHandler = new KeyHandler(this);
        administradorC = new AdministradorDeCasillas(this);
        administradorO = new AdministradorDeObjetos(this);
        colisionChecker = new ColisionCheck(this);
        ui = new UI(this);

        this.setPreferredSize(new Dimension(maxScreenWidth, maxScreenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); //Mejora el rendimiento de la renderizacion del juego
        this.addKeyListener(keyHandler); //Anadimos el keyListener
        this.setFocusable(true); // puede ser "focused" para recibir key inputs

        //Colocamos los objetos en el mapa, ponemos la musica e inicializamos el estado del juego
        this.administradorO.colocarObjetos();
        this.playMusic(0);
        estadoDelJuego = pantallaInicio;
    }

    //GETTERS Y SETTERS

    //CONSTANTES
    public int getEscala(){
        return this.escala;
    }
    public int getCasillaSizeEscalada(){
        return this.casillaSizeEscalada;
    }
    public int getMaxScreenWidth(){
        return this.maxScreenWidth;
    }
    public int getMaxScreenHeight(){
        return this.maxScreenHeight;
    }
    public int getMaxMapaColumnas(){
        return this.maxMapaColumnas;
    }
    public int getMaxMapaFilas(){
        return this.maxMapaFilas;
    }

    //VARIABLES
    public void setEstadoDelJuego(int estadoDelJuego){
        this.estadoDelJuego = estadoDelJuego;
    }
    public int getEstadoDelJuego(){
        return this.estadoDelJuego;
    }
    public void setPersonajeElegido(String personajeElegido){
        this.personajeElegido = personajeElegido;
    }
    public String getPersonajeElegido(){
        return this.personajeElegido;
    }
    public void setNumeroDeBots(int numeroDeBots){
        this.numeroDeBots = numeroDeBots;
    }
    public int getNumeroDeBots(){
        return this.numeroDeBots;
    }
    public void setDificultadBots(int dificultadBots){
        this.dificultadBots = dificultadBots;
    }
    public int getDificultadBots(){
        return this.dificultadBots;
    }

    //OBJETOS
    public AdministradorDeCasillas getAdministradorDeCasillas(){
        return this.administradorC;
    }
    public KeyHandler getKeyHandler(){
        return this.keyHandler;
    }
    public AdministradorDeObjetos getAdministradorDeObjetos(){
        return this.administradorO;
    }
    public ColisionCheck getColisionChecker(){
        return this.colisionChecker;
    }
    public UI getUi(){
        return this.ui;
    }


    public Personaje getJugador(){
        return jugador;
    }
    public void setJugador(Personaje jugador){
        this.jugador = jugador;
    }
    public void setObjetos(Objeto[] objetos){
        this.objetos = objetos;
    }
    public Objeto[] getObjetos(){
        return this.objetos;
    }
    public void setBots(Personaje[] bots){
        this.bots = bots;
    }
    public Personaje[] getBots(){
        return this.bots;
    }

    //Funciones para la musica
    public void playMusic(int i){

        musica.setupMusica(i);
        musica.play();
        musica.loop();

    }
    public void stopMusic(){
        musica.stop();
    }

    //Funcion para instanciar y empezar el gameThread
    public void startGameThread(){

        gameThread = new Thread(this); //Instanciamos el Thread
        gameThread.start(); //Llama a run()

    }

    
    @Override
    public void run() {

        // Funcion llamada cuando empieza gameThread. Core del juego
        double drawInterval = 1000000000/FPS; //Intervalo de dibujo. 1 segundo (1000000000 nanosegundos) / FPS (60) = 0.016666 segundos. Cada 0.016666 segundos dibujaremos el siguiente frame
        double delta = 0;
        long lastTime = System.nanoTime(); //En nanosegundos
        long currentTime;
        int timer = 0;
        int contDraw = 0; //Se usa para mostrar los fps por consola

        while(gameThread != null){ //Mientras gameThread exista

            //Delta/Acumulator Method. 
            currentTime = System.nanoTime(); //Chequeamos el current time
            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;

            if(delta >= 1){ //Si la diferencia entre currentTime(Tiempo actual) y lastTime(tiempo antes de que se ejecutara el anterior update() y repaint()), es decir el tiempo que ha pasado desde la ultima vez que actualizamos y dibujamos la informacion, supera o iguala el drawInterval, podemos volvemos a ejecutar update() y repaint()

                //Actualizar: actualizar informacion como la posicion del personaje
                update();
                //Dibujar: dibujar la informacion actualizada
                repaint();
                delta--;
                contDraw++;

            }
            if(timer >= 1000000000){ //Cuando timer llegue a un segundo (1000000000 nanosegundos). Timer es la resta entre current time y last time. Es decir, cuando el tiempo de ejecucion del programa llegue a un segundo

                //System.out.println("FPS:" + contDraw);
                timer = 0;
                contDraw = 0;

            }
           
        }

    }

    public void update(){

        if(estadoDelJuego == jugar){ 

            jugador.update();

            for(int i = 0; i < bots.length; i++){
                if(bots[i] != null){
                    bots[i].updateBot();
                }
            }

            if(numeroDeBots == 0){ //En cada update comprobamos si el usuario ha ganado la partida
             estadoDelJuego = victoria;
            }
        }
        else if(estadoDelJuego == combate){
            //Cuando entras en combate, si al colisionar con el jugador mantienes una tecla presionada, al volver a el estado de jugar, esa tecla sigue teniendo el valor true
            //Por lo que el personaje se mueve aunque no estes presionando nada. Para que no ocurra esto, reseteamos aqui los valores del keyHandler
            keyHandler.setPressedDown(false);
            keyHandler.setPressedLeft(false);
            keyHandler.setPressedRight(false);
            keyHandler.setPressedUp(false);

        }
        else{

            //El estado del juego es pausa, muerte o victoria. No queremos que update() actualice ninguna información

        }

    }
    public void paintComponent(Graphics g){ //metodo built-in java. Uno de los metodos estandares para dibujar cosas en un JPanel

        super.paintComponent(g); //Pintar en el parent class (JPanel)

        Graphics2D g2 = (Graphics2D)g; //cambiamos g de Graphics a Graphics2d. Graphics2D tiene mas metodos y nos da mas control

        if(estadoDelJuego == jugar){

            administradorC.draw(g2);

            for(int i = 0; i < objetos.length; i++){

                if(objetos[i] != null){
                    objetos[i].draw(g2, this);
                }

            }

            for(int i = 0; i < bots.length; i++){
                if(bots[i] != null){
                    bots[i].drawBot(g2);

                }
            }
            
            jugador.draw(g2);
            ui.draw(g2);

            if(getJugador().getMensajeCofreLooteado() !=  null){

                if(ui.getContadorFramesMensajePantalla() < 120){
                    ui.drawMensajePorPantalla(getJugador().getMensajeCofreLooteado());
                }
                else{
                    getJugador().setMensajeCofreLooteado(null);
                    ui.setContadorFramesMensajePantalla(0);
                }

            }
            
            g2.dispose();

        }

        else{

            //En el resto de estados del juego, simplemente dibujamos su pantalla correspondiente de la UI.
            ui.draw(g2);
        }
        
    }

}
