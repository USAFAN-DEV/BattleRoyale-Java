package Entidades;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import Combate.InterfazCombateCopia;
import InterfazDeUsuario.UI;
import Main.Mapa;
import ObserverPattern.ModelObservable;
import ObserverPattern.ModelObserver;

public abstract class Personaje extends Entidad implements ModelObservable{

    private List<ModelObserver> observers;

    public Personaje(int vida,int vidaMaxima,int atk,int escudo,int escudoMaximo,double crit,double estadisticaHabilidad, String tipo,String nombre,String nombreHabilidad, int mapaX, int mapaY, Mapa mapa){

        super(vida, vidaMaxima, atk, escudo, escudoMaximo, crit, estadisticaHabilidad, tipo, nombre, nombreHabilidad, mapaX, mapaY, mapa);
        this.observers = new ArrayList<ModelObserver>();
    }

    //METODOS
    public abstract String descripcionHabilidad();
    public abstract void getCharacterImage();
    public abstract void usarHabilidad(Entidad jugador);

    public void update(){

        teletransportacion();

        if(keyHandler.getPressedUp() == true || keyHandler.getPressedLeft() == true || keyHandler.getPressedDown() == true || keyHandler.getPressedRight() == true){

            if(keyHandler.getPressedUp() == true){

                //direction = "up";
                this.setDirection("up");
                //contFrames++;
                this.setContFrames(this.getContFrames()+1);
            }
            else if(keyHandler.getPressedLeft() == true){

                //direction = "left";
                this.setDirection("left");
                //contFrames++;
                this.setContFrames(this.getContFrames()+1);

            }
            else if(keyHandler.getPressedDown() == true){

                //direction = "down";
                this.setDirection("down");
                //contFrames++;
                this.setContFrames(this.getContFrames()+1);

            }
            else if(keyHandler.getPressedRight() == true){
    
                //direction = "right";
                this.setDirection("right");
                //contFrames++;
                this.setContFrames(this.getContFrames()+1);
            }

            if(this.getContFrames()/*contFrames*/ > 15){

                if(this.getPlayerImageEstado()/*playerImageEstado*/ == 1){
                    //playerImageEstado = 2;
                    this.setPlayerImageEstado(2);
                }
                else{
                    //playerImageEstado = 1;
                    this.setPlayerImageEstado(1);
                }
                
                //contFrames = 0;
                this.setContFrames(0);
            }

            //colisionEstado = false;
            this.setColisionEstado(false);
            mapa.getColisionChecker().checkCasilla(this);
            int objIndex = mapa.getColisionChecker().checkObject(this);

            if(objIndex != -1){

                switch(mapa.getObjetos()[objIndex].getName()){

                    case "cofrePlateado": 
                        //mensajeCofreLooteado = mapa.getObjetos()[objIndex].lootCofre(this);
                        this.setMensajeCofreLooteado(mapa.getObjetos()[objIndex].lootCofre(this));
                        mapa.getObjetos()[objIndex] = null;
                        break;
                    case "cofreDorado":
                        //mensajeCofreLooteado = mapa.getObjetos()[objIndex].lootCofre(this);
                        this.setMensajeCofreLooteado(mapa.getObjetos()[objIndex].lootCofre(this));
                        mapa.getObjetos()[objIndex] = null;
                        break;
                }

                
            }

            int botIndex = mapa.getColisionChecker().checkBot(this, mapa.getBots());

            if(botIndex != -1){
                mapa.setSolicitudCambioEstado("Empezar combate");
                JFrame frameC= new JFrame();
                InterfazCombateCopia interfazC=new InterfazCombateCopia(mapa.getJugador(),mapa.getBots()[botIndex], frameC,mapa);
                mapa.getBots()[botIndex] = null;
                mapa.stopMusic();
                interfazC.playMusic(1);   
            }

            if(this.getColisionEstado() == false/*colisionEstado == false*/){

                switch (this.getDirection()/*direction*/) {
                case "up": //mapaY -= speed; //Restamos porque la esquina izquierda superior es el (0,0) y la derecha inferior es el (maxWidth, maxHeight). Si queremos ir hacia arriba hay que restarle a la coordenada Y
                    this.setMapaY(this.getMapaY()-speed);    
                break;
                case "down": //mapaY += speed;
                    this.setMapaY(this.getMapaY() + speed);
                break;
                case "left": //mapaX -= speed;
                    this.setMapaX(this.getMapaX() - speed);
                break;
                case "right": //mapaX += speed;
                    this.setMapaX(this.getMapaX() + speed);
                break;
                default:
                    break;
                }

            }

        }

    }
    
    public void draw(Graphics2D g2){

        BufferedImage image = null;

        if(this.getDirection().equals("up")){

            if(this.getPlayerImageEstado() == 1){
                image = up1;
            }
            else{
                image = up2;
            }
            
        }
        if(this.getDirection().equals("down")){

            if(this.getPlayerImageEstado() == 1){
                image = down1;
            }
            else{
                image = down2;
            }
            
        }
        if(this.getDirection().equals("left")){

            if(this.getPlayerImageEstado() == 1){
                image = left1;
            }
            else{
                image = left2;
            }
            
        }
        if(this.getDirection().equals("right")){

            if(this.getPlayerImageEstado() == 1){
                image = right1;
            }
            else{
                image = right2;
            }
            
        }

        g2.drawImage(image, this.getScreenX(), this.getScreenY(), mapa.getCasillaSizeEscalada(), mapa.getCasillaSizeEscalada(), null);


    }

    @Override
    public void updateBot() {

        throw new UnsupportedOperationException("Unimplemented method 'updateBot'");

    }

    @Override
    public void drawBot(Graphics2D g2) {

        throw new UnsupportedOperationException("Unimplemented method 'drawBot'");
        
    }

    // Observer Pattern
    @Override
    public void attach(ModelObserver modelObserver){
        this.observers.add(modelObserver);
    }

    @Override
    public void detach(ModelObserver modelObserver){
        this.observers.remove(modelObserver);
    }

    @Override
    public void notifyObservers(){
        for(ModelObserver observer : this.observers){

            if(((UI) observer).getContadorFramesMensajePantalla() < 120){

                observer.drawMensajePorPantalla(null, this.getMensajeCofreLooteado());

            }
            else{

                this.setMensajeCofreLooteado(null);
                ((UI) observer).setContadorFramesMensajePantalla(0);

            }
                
        }
    }
}
/* 
    //ATRIBUTOS

    //VARIABLES

    //ESTADISTICAS DEL PERSONAJE
    private String nombre;
    private String tipo;
    private int vida;
    private int vidaMaxima;
    private int escudo;
    private int escudoMaximo;
    private int atk;
    private double crit;
    private int contadorPociones;
    private LifeState currentState; //atributo que indica si el personaje esta vivo, herido o muerto
    private MuertoState muertoState;
    private VivoState vivoState;

    //HABILIDAD DEL PERSONAJE
    private String nombreHabilidad;
    private double estadisticaHabilidad; //(es un porcentaje)
    private int nivelHabilidad;
    private int cooldownHabilidad;

    //ATRIBUTOS PARA EL MAPA

    //Posicion en el mapa
    private int mapaX, mapaY;

    //Posicion en la pantalla
    private final int screenX, screenY;

    protected int speed; //Velocidad(numero de coordenadas que recorre cuando apretamos el boton correspondiente)
    protected BufferedImage up1, up2, down1, down2, left1, left2, right1, right2; //Imagenes del personaje. Son 8 para poder animarlo
    private String direction; //Direccion en la que esta caminando el personaje

    //Usado para animar al personaje cuando camina
    private int contFrames;
    private int playerImageEstado; 

    //ATRIBUTOS PARA LA COLISION
    private Rectangle areaDeColision;
    private boolean colisionEstado;
    private int areaDeColisionDefaultX, areaDeColisionDefaultY;

    private int contBotDirection;
    private String mensajeCofreLooteado;

    //OBJETOS 
    protected Mapa mapa;
    protected KeyHandler keyHandler;
    protected Armas arma;

   
    
    //Constructor
    public Personaje(int vida,int vidaMaxima,int atk,int escudo,int escudoMaximo,double crit,double estadisticaHabilidad, String tipo,String nombre,String nombreHabilidad, int mapaX, int mapaY, Mapa mapa){

        //OBJETOS
        this.mapa = mapa;
        arma=null; //Al principio no tiene arma

        //ESTADISTICAS DEL PERSONAJE
        setNombre(nombre);
        setTipo(tipo);
        setVida(vida);
        setVidaMaxima(vidaMaxima);
        setEscudo(escudo);
        setEscudoMaximo(escudoMaximo);
        setAtk(atk);
        setCrit(crit);
        setContadorPociones(0);
        
        //HABILIDAD DEL PERSONAJE
        this.nombreHabilidad=nombreHabilidad;
        setEstadisticaHabilidad(estadisticaHabilidad);
        setNivelHabilidad(1);
        cooldownHabilidad=0;

        //Vida personaje
        this.vivoState = new VivoState(this);
        this.currentState = vivoState;
        this.muertoState = new MuertoState(this);

        //ATRIBUTOS PARA EL MAPA  
        setMapaX(mapaX);
        setMapaY(mapaY);
        screenX = mapa.getMaxScreenWidth()/2 - mapa.getCasillaSizeEscalada()/2; //Pequeno ajuste para que este en el centro de la pantalla. Las coordenadas son la esquina izquierda superior por la cual se empieza a dibujar
        screenY = mapa.getMaxScreenHeight()/2 - mapa.getCasillaSizeEscalada()/2;
        speed = 4;
        direction = "down";
        contFrames = 0;
        playerImageEstado = 1;

        //ATRIBUTOS PARA LA COLISION
        colisionEstado = false;
        areaDeColision = new Rectangle(4 * mapa.getEscala(), 6 * mapa.getEscala(), 8 * mapa.getEscala(), 10 * mapa.getEscala());
        areaDeColisionDefaultX = areaDeColision.x;
        areaDeColisionDefaultY = areaDeColision.y;

        contBotDirection = 0;
        mensajeCofreLooteado = null;

    }
    
    //declaracion de getters y setter de cada uno de los atributos de la clase Jugador

    //ESTADISTICAS
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getTipo(){
        return this.tipo;
    }
    public void setArma(Armas arma){
        this.arma=arma;
    }
    public Armas getArma(){
        return this.arma;
    }
    public void setVida(int vida){
        this.vida=vida;
    }
    public void setVidaMaxima(int vidaMaxima){
        this.vidaMaxima=vidaMaxima;
    }
    public void setEscudo(int escudo){
        this.escudo=escudo;
    }
    public void setEscudoMaximo(int escudoMaximo){
        this.escudoMaximo=escudoMaximo;
    }
    public int getVida(){
        return this.vida;
    }
    public int getVidaMaxima(){
        return this.vidaMaxima;
    }
    public int getEscudo(){
        return this.escudo;
    }
    public int getEscudoMaximo(){
        return this.escudoMaximo;
    }
    public int getAtk(){
        return this.atk;
    }
    public double getCrit(){
        return this.crit;
    }
    public void setAtk(int atk){
        this.atk=atk;
    }
    public void setCrit(double crit){
        this.crit=crit;
    }
    public int getContadorPociones(){
        return contadorPociones;
    }
    public void setContadorPociones(int contadorPociones){
        this.contadorPociones=contadorPociones;
    }
    //Estadisticas vida
    public void setState(LifeState lifeState){
        this.currentState = lifeState;
    }
    public LifeState getCurrentState(){
        return this.currentState;
    }
    public VivoState getVivoState(){
        return this.vivoState;
    }
    public MuertoState getMuertoState(){
        return this.muertoState;
    }
    public void cambiarVida(){
        currentState.cambiarVida();
    }

    //HABILIDAD
    public void setCooldownHabilidad(int cooldownHabilidad){
        this.cooldownHabilidad=cooldownHabilidad;
    }
    public int getCooldownHabilidad(){
        return this.cooldownHabilidad;
    }
    public void setEstadisticaHabilidad(double estadisticaHabilidad){
        this.estadisticaHabilidad=estadisticaHabilidad;
    }
    public void setNivelHabilidad(int nivelHabilidad){
        this.nivelHabilidad=nivelHabilidad;
    }
    public double getEstadisticaHabilidad(){
        return estadisticaHabilidad;
    }
    public int getNivelHabilidad(){
        return this.nivelHabilidad;
    }
    public String getNombreHabilidad(){
        return this.nombreHabilidad;
    }
    public int getRevivir(){
        return 0;
    }

    //ATRIBUTOS PARA EL MAPA
    public void setMapaX(int mapaX){
        this.mapaX = mapaX;
    }
    public void setMapaY(int mapaY){
        this.mapaY = mapaY;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public int getMapaX(){
        return this.mapaX;
    }
    public int getMapaY(){
        return this.mapaY;
    }
    public int getSpeed(){
        return this.speed;
    }
    public int getScreenX(){
        return screenX;
    }
    public int getScreenY(){
        return screenY;
    }
    public void setDirection(String direction){
        this.direction = direction;
    }
    public String getDirection(){
        return this.direction;
    }
    public void setMensajeCofreLooteado(String mensajeCofreLooteado){
        this.mensajeCofreLooteado = mensajeCofreLooteado;
    }
    public String getMensajeCofreLooteado(){
        return this.mensajeCofreLooteado;
    }
    public void setContFrames(int contFrames){
        this.contFrames = contFrames;
    }
    public int getContFrames(){
        return this.contFrames;
    }
    public void setPlayerImageEstado(int playerImageEstado){
        this.playerImageEstado = playerImageEstado;
    }
    public int getPlayerImageEstado(){
        return this.playerImageEstado;
    }
    public void setContBotDirection(int contBotDirection){
        this.contBotDirection = contBotDirection;
    }
    public int getContBotDirection(){
        return this.contBotDirection;
    }

    //COLISION
    public void setAreaDeColision(Rectangle areaDeColision){
        this.areaDeColision = areaDeColision;
    }
    public Rectangle getAreaDeColision(){
        return this.areaDeColision;
    }
    public void setColisionEstado(boolean colisionEstado){
        this.colisionEstado = colisionEstado;
    }
    public boolean getColisionEstado(){
        return this.colisionEstado;
    }
    public int getAreaDeColisionDefaultX(){
        return this.areaDeColisionDefaultX;
    }
    public int getAreaDeColisionDefaultY(){
        return this.areaDeColisionDefaultY;
    }

    public String getPlayerGif(){
        return "text";
    }

    
    //METODOS
    public abstract String descripcionHabilidad();
    public abstract void getCharacterImage();
    public abstract void usarHabilidad(Personaje jugador);
    
    //Print de las estadisticas 
    public void imprimeInfo(){

        System.out.printf("%s: Personaje de tipo %s\n", getNombre(), getTipo());
        System.out.printf("Estadísticas:\n\tVida: %d\n\tVida Maxima: %d\n\tAtaque: %d\n\tEscudo: %d\n\tEscudo Maximo: %d\n\tCritRate: %.2f", getVida(), getVidaMaxima(), getAtk(), getEscudo(), getEscudoMaximo(), getCrit());
        System.out.printf("\nHabilidad: %s\n\tNivel: %d\n\t",getNombreHabilidad(), getNivelHabilidad());
        descripcionHabilidad();
        getArma().imprimeInfo();
        System.out.println();

    }

    public void teletransportacion(){

        int jugadorMapaCol = getMapaX()/mapa.getCasillaSizeEscalada();
        int jugadorMapaRow = getMapaY()/mapa.getCasillaSizeEscalada();

        //tp nieve
        if(jugadorMapaCol == 21 && jugadorMapaRow == 51){
            setMapaX(15 * mapa.getCasillaSizeEscalada());
            setMapaY(70 * mapa.getCasillaSizeEscalada());
        }

        else if(jugadorMapaCol == 13 && jugadorMapaRow == 69){
            setMapaX(21 * mapa.getCasillaSizeEscalada());
            setMapaY(52 * mapa.getCasillaSizeEscalada());
        }

        if(jugadorMapaCol == 89 && jugadorMapaRow == 11){
            setMapaX(81*mapa.getCasillaSizeEscalada());
            setMapaY(57*mapa.getCasillaSizeEscalada());

        }
        else if(jugadorMapaCol == 81 && jugadorMapaRow == 58){
            setMapaX(89*mapa.getCasillaSizeEscalada());
            setMapaY(13*mapa.getCasillaSizeEscalada());

        }

    }

    //Bot metodos

    public void setBotDirection(){

        contBotDirection++;

        if(contBotDirection == 120){

            Random random = new Random();
            int i = random.nextInt(4) + 1; //1-4

            if(i == 1){direction = "up";}
            else if(i == 2){direction = "down";}
            else if(i == 3){direction = "left";}
            else{direction = "right";}

            contBotDirection = 0;

        }
        


    }
    
    public abstract void update();
    public abstract void draw(Graphics2D g2);
    public abstract void updateBot();
    public abstract void drawBot(Graphics2D g2);
}
*/
