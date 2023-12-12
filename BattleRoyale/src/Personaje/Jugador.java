package Personaje;
import Armas.Armas;
//declaramos clase abstracta para heredar sobre otras que van a estar definidas
public class Jugador {
    //stats principales
    private Armas arma;
    private int nivelHabilidad;
    private int vidaMaxima;
    private int escudoMaximo;
    private int vida;
    private int atk;
    private int escudo;
    private double crit;
    private double estadisticaHabilidad;
    private String nombreHabilidad;
    private String nombre;
    private String tipo;
    //declaracion de los getters y setter, y ToString method
    public Jugador(int vida,int vidaMaxima,int atk,int escudo,int escudoMaximo,double crit,double estadisticaHabilidad, String tipo,String nombre,String nombreHabilidad){
        setVida(vida);
        setAtk(atk);
        setCrit(crit);
        setEscudo(escudo);
        setNombre(nombre);
        setEstadisticaHabilidad(estadisticaHabilidad);
        setTipo(tipo);
        setNombre(nombre);
        this.nombreHabilidad=nombreHabilidad;
        arma=null;
        setNivelHabilidad(1);;
    }
    //declaracion de getters y setter de cada uno de los atributos de la clase Jugador
    public int getVida(){
        return vida;
    }
    public int getVidaMaxima(){
        return vidaMaxima;
    }
    public int getAtk(){
        return atk;
    }
    public int getEscudo(){
        return escudo;
    }
    public int getEscudoMaximo(){
        return escudoMaximo;
    }
    public double getCrit(){
        return crit;
    }
    public void setVida(int vida){
        this.vida=vida;
    }
    public void setVidaMaxima(int vidaMaxima){
        this.vidaMaxima=vidaMaxima;
    }
    public void setAtk(int atk){
        this.atk=atk;
    }
    public void setEscudo(int escudo){
        this.escudo=escudo;
    }
    public void setEscudoMaximo(int escudoMaximo){
        this.escudoMaximo=escudoMaximo;
    }
    public void setCrit(double crit){
        this.crit=crit;
    }
    public void setEstadisticaHabilidad(double estadisticaHabilidad){
        this.estadisticaHabilidad=estadisticaHabilidad;
    }
    public double getEstadisticaHabilidad(){
        return estadisticaHabilidad;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public String getTipo(){
        return tipo;
    }
    public void setNivelHabilidad(int nivelHabilidad){
        this.nivelHabilidad=nivelHabilidad;
    }
    public int getNivelHabilidad(){
        return nivelHabilidad;
    }
    public String getNombreHabilidad(){
        return nombreHabilidad;
    }
    public void setArma(Armas arma){
        this.arma=arma;
    }
    public Armas getArma(){
        return arma;
    }
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
    //Print de las estadisticas 
    public void imprimeInfo(){
        System.out.println("Print de los datos");
        System.out.printf("El nombre del jugador es %s y tiene tipo %s y su estadisitica de habilidad es %.2f\n",getNombre(),getTipo(),getEstadisticaHabilidad());
        arma.imprimeInfo();
    }
   
}
