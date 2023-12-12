package Personaje;
//declaramos clase abstracta para heredar sobre otras que van a estar definidas
public abstract class Jugador {
    //stats principales
    int vidaMaxima;
    int escudoMaximo;
    int vida;
    int atk;
    int escudo;
    double crit;
    double estadisticaHabilidad;
    String descripcionHabilidad;
    String nombreHabilidad;
    String nombre;
    String tipo;
    //declaracion de los getters y setter, y ToString method
    public Jugador(int vida,int vidaMaxima,int atk,int escudo,int escudoMaximo,double crit,double estadisticaHabilidad, String tipo,String nombre){
        setVida(vida);
        setatk(atk);
        setcrit(crit);
        setescudo(escudo);
        setNombre(nombre);
        setEstadisticaHabilidad(estadisticaHabilidad);
        setTipo(tipo);
        setNombre(nombre);
    }
    //declaracion de getters y setter de cada uno de los atributos de la clase Jugador
    public int getVida(){
        return vida;
    }
    public int getatk(){
        return atk;
    }
    public int getescudo(){
        return escudo;
    }
    public double getcrit(){
        return crit;
    }
    public void setVida(int vida){
        this.vida=vida;
    }
    public void setatk(int atk){
        this.atk=atk;
    }
    public void setescudo(int escudo){
        this.escudo=escudo;
    }
    public void setcrit(double crit){
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
    //Print de las estadisticas 
    public void imprimeInfo(){
        System.out.println("Print de los datos");
        System.out.printf("El nombre del jugador es %s y tiene tipo %s y su estadisitica de habilidad es %.2f",getNombre(),getTipo(),getEstadisticaHabilidad());
    }
   

    
}
