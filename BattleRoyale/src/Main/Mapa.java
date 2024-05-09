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
import Entidades.Entidad;
import Entidades.AbstractFactoryPattern.EntidadesCreator;
import Entidades.AbstractFactoryPattern.MeiCreator;
import Entidades.AbstractFactoryPattern.QiqiCreator;
import Entidades.AbstractFactoryPattern.ZhongliCreator;
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

    private MapaStates estadoDelJuego;

    private final MapaStates pantallaInicio = new PantallaInicioConcreteState(this);
    private final MapaStates jugar = new JugarConcreteState(this);
    private final MapaStates pausar = new PausaConcreteState(this);
    private final MapaStates combate = new CombateConcreteState(this);
    private final MapaStates muerte = new MuerteConcreteState(this);
    private final MapaStates victoria = new VictoriaConcreteState(this);

    private String solicitudCambioEstado; //Mensaje de una clase al mapa porque ha sucedido algo que requiere un cambio de estado


    //OBJETOS
    private AdministradorDeCasillas administradorC;
    private KeyHandler keyHandler;
    private AdministradorDeObjetos administradorO;
    private ColisionCheck colisionChecker;
    private UI ui;
    private Musica musica;
    private Entidad jugador;
    private Objeto[] objetos; 
    private Entidad[] bots;

    private Thread gameThread;

    //ABSTRACT FACTORY PATTERN
    private EntidadesCreator meiCreator = new MeiCreator();
    private EntidadesCreator zhongliCreator = new ZhongliCreator();
    private EntidadesCreator qiqiCreator = new QiqiCreator();

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

        this.solicitudCambioEstado = "";
        estadoDelJuego = pantallaInicio;
    }

    //GETTERS Y SETTERS

    //ABSTRACT FACTORY PATTERN
    public EntidadesCreator getQiqiCreator(){

        return this.qiqiCreator;

    }

    public EntidadesCreator getMeiCreator(){

        return this.meiCreator;

    }

    public EntidadesCreator getZhongliCreator(){

        return this.zhongliCreator;
        
    }

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

    public Entidad getJugador(){
        return jugador;
    }
    public void setJugador(Entidad jugador){
        this.jugador = jugador;
    }
    public void setObjetos(Objeto[] objetos){
        this.objetos = objetos;
    }
    public Objeto[] getObjetos(){
        return this.objetos;
    }
    public void setBots(Entidad[] bots){
        this.bots = bots;
    }
    public Entidad[] getBots(){
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

    //Funciones para procesar el estado del juego

    public void setEstadoDelJuego(MapaStates estadoDelJuego){

        this.estadoDelJuego = estadoDelJuego;

    }
    public MapaStates getEstadoDelJuego(){
        
        return this.estadoDelJuego;
        
    }

    public void setSolicitudCambioEstado(String solicitudCambioEstado){

        this.solicitudCambioEstado = solicitudCambioEstado;

    }

    public String getSolicitudCambioEstado(){

        return this.solicitudCambioEstado;

    }

    public MapaStates getPantallaInicioConcreteState(){

        return this.pantallaInicio;

    }

    public MapaStates getJugarConcreteState(){

        return this.jugar;

    }

    public MapaStates getPausaConcreteState(){

        return this.pausar;

    }

    public MapaStates getCombateConcreteState(){

        return this.combate;

    }

    public MapaStates getMuerteConcreteState(){

        return this.muerte;

    }

    public MapaStates getVictoriaConcreteState(){

        return this.victoria;

    }

    public void process(){

        this.estadoDelJuego.process(); //delegacion por composicion dura

    }

    public void updateDependingOfState(){

        this.estadoDelJuego.accionUpdate(); //delegacion por composicion dura

    }

    public void drawDependingOfState(Graphics2D g2){

        this.estadoDelJuego.accionDraw(g2); //delegacion por composicion dura

    }

    //Funcion para instanciar y empezar el gameThread
    public void startGameThread(){

        gameThread = new Thread(this); //Instanciamos el Thread
        gameThread.start(); //Llama a run()

    }

    
    @Override
    public void run() {

        // Funcion llamada cuando empieza gameThread. Core del juego
        //TemplateMethod:
        //  Crear clase GameCore que haga todo esto. Clase abstracta que tiene todos los metodos que se usan en el algoritmo mas el template method. 
        //  Todo lo de los fps lo hace y luego el update y draw los delega

        
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

        this.updateDependingOfState();
        this.process();

    }
    public void paintComponent(Graphics g){ //metodo built-in java. Uno de los metodos estandares para dibujar cosas en un JPanel

        super.paintComponent(g); //Pintar en el parent class (JPanel)
        Graphics2D g2 = (Graphics2D)g; //cambiamos g de Graphics a Graphics2d. Graphics2D tiene mas metodos y nos da mas control

        this.drawDependingOfState(g2);

    }

}
