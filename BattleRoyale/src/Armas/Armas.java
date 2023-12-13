package Armas;

import Personaje.Jugador;

public abstract class Armas {
    
    //Atributos
    int statPrincipal; //Stat principal del arma. Sera ATK siempre
    String tipoStatPrincipal; //Tipo de atributo que da la stat principal
    double statSecundaria; //Stat secundaria del arma. Podra ser ATK%, Crit rate, Vida% o Escudo%
    String tipoStatSecundaria; //Tipo de atributo que da la stat secundaria
    int estrellasArma; //3, 4 o 5 estrellas
    String nombreArma; //Nombre del arma
    
    //Pasiva?

    //Constructor
    public Armas(int statPrincipal, double statSecundaria, String tipoStatSecundaria, int estrellasArma, String nombreArma){

        this.tipoStatPrincipal = "Ataque";
        setStatPrincipal(statPrincipal);
        this.tipoStatSecundaria = "Escudo";
        setStatSecundaria(statSecundaria);
        setTipoStatSecundaria(tipoStatSecundaria);
        setEstrellasArma(estrellasArma);
        setNombreArma(nombreArma);

    }

    //Setters y getters
    public void setStatPrincipal(int statPrincipal){
        this.statPrincipal = statPrincipal;
    }
    public int getStatPrincipal(){
        return this.statPrincipal;
    }
    public String getTipoStatPrincipal(){
        return this.tipoStatPrincipal;
    }
    public void setStatSecundaria(double statSecundaria){
        this.statSecundaria = statSecundaria;
    }
    public double getStatSecundaria(){
        return this.statSecundaria;
    }
    public void setTipoStatSecundaria(String tipoStatSecundaria){
        this.tipoStatSecundaria = tipoStatSecundaria;
    }
    public String getTipoStatSecundaria(){
        return this.tipoStatSecundaria;
    }
    public int getEstrellasArma(){
        return this.estrellasArma;
    }
    public void setEstrellasArma(int estrellasArma){
        this.estrellasArma = estrellasArma;
    }
    public void setNombreArma(String nombreArma){
        this.nombreArma = nombreArma;
    }
    public String getNombreArma(){
        return this.nombreArma;
    }
   
    //Metodos
    public void imprimeInfo(){

        System.out.printf("\n%s: Arma de %d estrellas.\n\t%s: %d\n\t%s: %.2f", getNombreArma(), getEstrellasArma(), getTipoStatPrincipal(), getStatPrincipal(), getTipoStatSecundaria(), getStatSecundaria());
        System.out.println();

    }

    public void aplicarStatsArma(Jugador jugador1){

        jugador1.setAtk(jugador1.getAtk() + this.getStatPrincipal());

        if(this.getTipoStatSecundaria().equals("CritRate")){

            jugador1.setCrit(jugador1.getCrit() + this.getStatSecundaria());

        }
        else if(this.getTipoStatSecundaria().equals("EscudoPorcentual")){

            jugador1.setEscudoMaximo(jugador1.getEscudoMaximo() + (int)(this.getStatSecundaria()*jugador1.getEscudoMaximo()));

        }
        else{

            jugador1.setVidaMaxima(jugador1.getVidaMaxima() + (int)(this.getStatSecundaria() * jugador1.getVidaMaxima()));

        }

    }
}
