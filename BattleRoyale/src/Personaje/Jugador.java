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
        setVidaMaxima(vidaMaxima);
        setAtk(atk);
        setCrit(crit);
        setEscudo(escudo);
        setEscudoMaximo(escudoMaximo);
        setNombre(nombre);
        setEstadisticaHabilidad(estadisticaHabilidad);
        setTipo(tipo);
        this.nombreHabilidad=nombreHabilidad;
        arma=null;
        setNivelHabilidad(1);;
    }
    //declaracion de getters y setter de cada uno de los atributos de la clase Jugador
    public int getVida(){
        return this.vida;
    }
    public int getVidaMaxima(){
        return this.vidaMaxima;
    }
    public int getAtk(){
        return this.atk;
    }
    public int getEscudo(){
        return this.escudo;
    }
    public int getEscudoMaximo(){
        return this.escudoMaximo;
    }
    public double getCrit(){
        return this.crit;
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
        return this.nombre;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public String getTipo(){
        return this.tipo;
    }
    public void setNivelHabilidad(int nivelHabilidad){
        this.nivelHabilidad=nivelHabilidad;
    }
    public int getNivelHabilidad(){
        return this.nivelHabilidad;
    }
    public String getNombreHabilidad(){
        return this.nombreHabilidad;
    }
    public void setArma(Armas arma){
        this.arma=arma;
    }
    public Armas getArma(){
        return this.arma;
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
   
}
