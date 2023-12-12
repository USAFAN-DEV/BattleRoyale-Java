package Armas;

public abstract class Armas {
    
    //Atributos
    int statPrincipal; //Stat principal del arma. Sera ATK siempre
    String tipoStatPrincipal; //Tipo de atributo que da la stat principal
    double statSecundaria; //Stat secundaria del arma. Podra ser ATK%, Crit rate, Vida% o Escudo%
    String tipoStatSecundaria; //Tipo de atributo que da la stat secundaria
    int estrellasArma; //3, 4 o 5 estrellas
    
    //Pasiva?

    //Constructor
    public Armas(int statPrincipal, double statSecundaria, String tipoStatSecundaria, int estrellasArma){

        this.tipoStatPrincipal = "Ataque";
        setStatPrincipal(statPrincipal);
        this.tipoStatSecundaria = "Escudo";
        setStatSecundaria(statSecundaria);
        setTipoStatSecundaria(tipoStatSecundaria);
        setEstrellasArma(estrellasArma);

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
    public void setEstrellasArma(int estrellasArma){

        this.estrellasArma = estrellasArma;

    }
   
    

    //Metodos
    public void imprimeInfo(){

       System.out.printf("%s: %.2f\n", tipoStatPrincipal, statPrincipal);

    }
}
