package Personaje;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Herramientas.Armas;
import Interfaces2.Mapa;
import Interfaces2.KeyHandler;

public class Jugador {

    //Declaracion variables stats principales

    //Arma
    private Armas arma;

    //Vida y escudo
    private int vida;
    private int vidaMaxima;
    private int escudo;
    private int escudoMaximo;

    //Ataque y %critico
    private int atk;
    private double crit;

    //Habilidad
    private String nombreHabilidad;
    private double estadisticaHabilidad; //(es un porcentaje)
    private int nivelHabilidad;

    //Info del personaje
    private String nombre;
    private String tipo;

    //Donde esta el jugador en el mapa
    int mapaX, mapaY;
    //Donde dibujamos al jugador en la pantalla
    public final int screenX, screenY;
    int speed;

    //KeyHandler: movimiento personaje y Mapa. Se declaran en los hijos
    protected Mapa mapa;
    protected KeyHandler keyHandler;

    //images
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    int playerFoto, contFrames;
    
    //CooldownHabilidad
    private int cooldownHabilidad;
    
    //Constructor
    public Jugador(int vida,int vidaMaxima,int atk,int escudo,int escudoMaximo,double crit,double estadisticaHabilidad, String tipo,String nombre,String nombreHabilidad, int mapaX, int mapaY){

        //Arma
        arma=null; //Al principio no tiene arma

        //Vida y escudo
        setVida(vida);
        setVidaMaxima(vidaMaxima);
        setEscudo(escudo);
        setEscudoMaximo(escudoMaximo);

        //Ataque y %critico
        setAtk(atk);
        setCrit(crit);
        
        //Habilidad
        this.nombreHabilidad=nombreHabilidad;
        setEstadisticaHabilidad(estadisticaHabilidad);
        setNivelHabilidad(1);

        //Info del personaje
        setNombre(nombre);
        setTipo(tipo);

        //Atributos para el mapa
        //Donde esta el jugador en el mapa
        setMapaX(mapaX);
        setMapaY(mapaY);

        //Donde dibujamos al jugador en la pantalla
        screenX = 480  - 24; //mapaMaxWidth/2 - tamanoCasilla/2. Pequeno ajuste para que este en el centro de la pantalla. Las coordenadas son la esquina izquierda superior por la cual se empieza a dibujar
        screenY = 360 - 24;

        speed = 4;

        direction = "down";
        contFrames = 0;
        playerFoto = 1;

        //cooldown Habilidad
        cooldownHabilidad=0;
    }
    
    //declaracion de getters y setter de cada uno de los atributos de la clase Jugador

    //Arma 
    public void setArma(Armas arma){
        this.arma=arma;
    }
    public Armas getArma(){
        return this.arma;
    }

    //Vida y escudo
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
    public void setCooldownHabilidad(int cooldownHabilidad){
        this.cooldownHabilidad=cooldownHabilidad;
    }
    public int getCooldownHabilidad(){
        return this.cooldownHabilidad;
    }

    //Ataque y %critico
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

    //Habilidad
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
    
    //Info del personaje
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

    //Atributos para el mapa
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
    
    //METODOS

    //sube de nivel la habilidad y cada vez que se aumenta, aumenta la estadistica de la habilidad.
    public int aumentarNivelHabilidad(){

        int resultado=0;

        if(getNivelHabilidad()<3){

            setNivelHabilidad(getNivelHabilidad()+1);
            setEstadisticaHabilidad(getEstadisticaHabilidad()+0.05);

        }

        else{

            resultado=1;

        }

        return resultado;
    }

    public void descripcionHabilidad(){
       
    }

    public void getPlayerImage(){


    }

    public void usarHabilidad(Jugador jugador){
        
    }
    
    //Print de las estadisticas 
    public void imprimeInfo(){

        System.out.printf("%s: Personaje de tipo %s\n", getNombre(), getTipo());
        System.out.printf("Estadísticas:\n\tVida: %d\n\tVida Maxima: %d\n\tAtaque: %d\n\tEscudo: %d\n\tEscudo Maximo: %d\n\tCritRate: %.2f", getVida(), getVidaMaxima(), getAtk(), getEscudo(), getEscudoMaximo(), getCrit());
        System.out.printf("\nHabilidad: %s\n\tNivel: %d\n\t",getNombreHabilidad(), getNivelHabilidad());
        descripcionHabilidad();
        getArma().imprimeInfo();
        System.out.println();

    }
   
    public void update(){

        if(keyHandler.PressedUp == true){

            contFrames++;
            direction = "up";
            mapaY -= speed; //Restamos porque la esquina izquierda superior es el (0,0) y la derecha inferior es el (maxWidth, maxHeight). Si queremos ir hacia arriba hay que restarle a la coordenada Y
        }
        else if(keyHandler.PressedLeft == true){

            contFrames++;
            direction = "left";
            mapaX -= speed;

        }
        else if(keyHandler.PressedDown == true){

            contFrames++;
            direction = "down";
            mapaY += speed;

        }
        else if(keyHandler.PressedRight == true){
 
            contFrames++;
            direction = "right";
            mapaX += speed;

        }

        if(contFrames > 15){

            if(playerFoto == 1){
                playerFoto = 2;
            }
            else {
                playerFoto = 1;
            }
            contFrames = 0;

        }

    }

    public void draw(Graphics2D g2){

        //g2.setColor(Color.white);
        //g2.fillRect(x, y, mapa.CasillaSizeEscalada, mapa.CasillaSizeEscalada);

        
        BufferedImage image = null;
        if(direction.equals("up")){

            if(playerFoto == 1){
                image = up1;
            }
            else{
                image = up2;
            }
            
        }
        else if(direction.equals("down")){

            if(playerFoto == 1){
                image = down1;
            }
            else{
                image = down2;
            }
        }
        else if(direction.equals("left")){

            if(playerFoto == 1){
                image = left1;
            }
            else{
                image = left2;
            }
        }
        else if(direction.equals("right")){

            if(playerFoto == 1){
                image = right1;
            }
            else{
                image = right2;
            }
        }

        g2.drawImage(image, screenX, screenY, mapa.casillaSizeEscalada, mapa.casillaSizeEscalada, null);

    }

}
