package Personaje.PersonajeHealer;

import Personaje.Jugador;

public class Qiqi extends Jugador{
    private int revivir;
    //rellenamos los datos del perseonaje correspondiendo con su tipo y el nombre
    public Qiqi(){
        super(200,200,25,0,100,0.25,0.25,"Healer","Qiqi","Preserver of Fortune");
        setRevivir(0);
    }
    public int getRevivir(){
        return revivir;
    }
    public void setRevivir(int revivir){
        this.revivir=revivir;
    }
    public void usarHabilidad(Jugador equipo[]){
        //necesito mas clases porque tengo que cambiar sus estadisticas 
        //revive a una persona
        if(getRevivir()==0){
            for(int i=0;i<equipo.length;i++){
                if(equipo[i].getVida()==0){
                    equipo[i].setVida(100);
                }
            } 
            setRevivir(1);
        }
        else{
            System.out.println("Error. La habilidad revivir ya se ha utilizado");
        }    
    }
    public void descripcionHabilidad(){
        System.out.println("Qiqi revive a los alidos que han muerto en combate. Solo se puede usar una vez por partida");
    }
}
