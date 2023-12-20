package Combate;
import java.util.Random;

import Entidades.Personaje;

public class MetodoCombate {
    //declaramos los atributos que son necesarios para calcular el critico, los jugadores y el los turnos del combate
    private Personaje jugador1;
    private Personaje jugador2;
    public MetodoCombate(Personaje jugador1,Personaje jugador2){
        setJugador1(jugador1);
        setJugador2(jugador2);
    }
    public void setJugador1(Personaje jugador1){
        this.jugador1=jugador1;
    }
    public void setJugador2(Personaje jugador2){
        this.jugador2=jugador2;
    }
    public Personaje getJugador1(){
        return jugador1;
    }
    public Personaje getJugador2(){
        return jugador2;
    }
    public int CalcularDamage(Personaje jugador){
        Random random=new Random();
        int randDamage=random.nextInt(10)+1;
        int damage=0;
        if(jugador.getCrit()*10>=randDamage){
            damage=jugador.getAtk()*2;
        }
        else{
            damage=jugador.getAtk();
        }
        return damage;
    }
    public int Dmg(Personaje jugador,int damage){
        //si el escudo es 0
        if(jugador.getEscudo()==0){
            //se actualiza la vida del jugador 2, recibiendo el daño del jugador 1
            jugador.setVida(jugador.getVida()-damage);
            //Si la vida resulta ser negativa entonces se actualiza a 0
            if(jugador.getVida()<0){
                 jugador.setVida(0);
            }
        }
        else{
            //Si tiene escudo
            jugador.setEscudo(jugador.getEscudo()-damage);
            //Si despues de recibir la hostia el escudo se queda negativo
            if(jugador.getEscudo()<0){
                //Entonces Calculamos lo que te tiene que quedar respectivamente en la vida haciendo el resto y quitandoselo a la vida
                jugador.setVida(jugador.getVida()+(jugador.getEscudo()));
                //Ponemos el escudo a 0
                jugador.setEscudo(0);
                //Si resulta que la vida es negativa lo actualizamos a 0
                if(jugador.getVida()<0){
                     jugador.setVida(0);
                }
            }
        }
        return damage;
    }

    //funcion que a base de un random el bot ejecuta una cosa u otra es un 50/50 lo que hace
    public void Botmove(){
        Random random=new Random();
        int randOpcionBot=random.nextInt(2)+1;
        int damage;
        //Cooldown de la habilidad del bot
        damage=CalcularDamage(getJugador2());
        if(getJugador2().getNombre()=="Qiqi"){
            damage=Dmg(getJugador1(),damage);
            System.out.println("Daño recibido "+damage);
        }
        else{
            if(getJugador2().getCooldownHabilidad()!=3 && getJugador2().getCooldownHabilidad()>=1){
            getJugador2().setCooldownHabilidad(getJugador2().getCooldownHabilidad()+1);
            System.out.printf("La habilidad del bot le quedan %d turnos\n",3-getJugador2().getCooldownHabilidad());
            }
            else{
                getJugador2().setCooldownHabilidad(0);
            }
            if(randOpcionBot==1||getJugador2().getCooldownHabilidad()>=1){
                damage=Dmg(getJugador1(),damage);
                System.out.println("Daño recibido "+damage);
            }
            else{
                System.out.printf("La habilidad del bot le quedan %d turnos\n",3-getJugador2().getCooldownHabilidad());
                getJugador2().setCooldownHabilidad(1);
                HabilidadJugador2(getJugador1());
            }
        }       
    }

    public void Ataque(){
        //El primer if es para cuando se produce critico de forma random que va del 1 al 10
        //declaramos el daño que va a recibir el jugador2
        //el jugador 1 es siempre el que ejecuta el daño por tanto habrá que alternar en el ActionListener a los Jugadores
        int damage;
        damage=CalcularDamage(getJugador1());
        damage=Dmg(getJugador2(),damage);
        try{
            System.out.println("Daño realizado de "+damage);
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        Botmove();
    }
    //Este metodo va a utilizar las habilidades del jugador 1 sobre el jugador 2, tambien habrá que hacer lo mismo con el ActionListener
    public void HabilidadJugador1(){
        System.out.println("Has usado la habilidad");
        getJugador1().usarHabilidad(jugador2);
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        Botmove();
    }
    public void HabilidadJugador2(Personaje jugador){
        System.out.println("El bot ha usado la habilidad");
        getJugador2().usarHabilidad(jugador);
    }

    public void usarPociones(){
        //el jugador tiene un atributo que es contadorPociones
        //System.out.println("Te has recuperado 50 puntos de vida");
        if(getJugador1().getVida()==getJugador1().getVidaMaxima()){
            System.out.println("Tienes la vida al maximo no puedes usar pociones");
        }
        else{
            if(getJugador1().getContadorPociones()!=0){
                getJugador1().setVida(getJugador1().getVida()+50);
                if(getJugador1().getVida()>getJugador1().getVidaMaxima()){
                    getJugador1().setVida(getJugador1().getVidaMaxima());
                }
                getJugador1().setContadorPociones(getJugador1().getContadorPociones()-1);
                if(getJugador1().getContadorPociones()<0){
                    getJugador1().setContadorPociones(0);
                }
                System.out.printf("Te has curado \n");
                System.out.printf("Tienes %d pocion de vida\n",getJugador1().getContadorPociones());
            }
            else{
                System.out.println("No te quedan pociones");
            }
        }
    }
}
