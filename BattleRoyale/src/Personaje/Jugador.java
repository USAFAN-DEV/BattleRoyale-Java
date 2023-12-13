package Personaje;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


import Armas.Armas;
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

    //Declaracion atributos para el mapa
    int x, y, speed;

    //KeyHandler: movimiento personaje
    protected Mapa mapa;
    protected KeyHandler keyHandler;

    //images
    //public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    //public String direction;
    public BufferedImage characterImage;
    
    
    //Constructor
    public Jugador(int vida,int vidaMaxima,int atk,int escudo,int escudoMaximo,double crit,double estadisticaHabilidad, String tipo,String nombre,String nombreHabilidad){

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
        x = 100;
        y = 100;
        speed = 4;

        //direction = "down";

    }
    
    //declaracion de getters y setter de cada uno de los atributos de la clase Jugador

    public void setX(int x){

        this.x = x;

    }
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

            //direction = "up";
            y -= speed; //Restamos porque la esquina izquierda superior es el (0,0) y la derecha inferior es el (maxWidth, maxHeight). Si queremos ir hacia arriba hay que restarle a la coordenada Y
        }
        else if(keyHandler.PressedLeft == true){

            //direction = "left";
            x -= speed;

        }
        else if(keyHandler.PressedDown == true){

            //direction = "down";
            y += speed;

        }
        else if(keyHandler.PressedRight == true){
 
            //direction = "right";
            x += speed;

        }

    }

    public void draw(Graphics2D g2){

        //g2.setColor(Color.white);
        //g2.fillRect(x, y, mapa.CuadriculaSizeEscalada, mapa.CuadriculaSizeEscalada);

        //BufferedImage image = null;

        /*switch (direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
            default:
                break;
        }*/

        g2.drawImage(characterImage, x, y, mapa.CuadriculaSizeEscalada, mapa.CuadriculaSizeEscalada, null);

    }

}
