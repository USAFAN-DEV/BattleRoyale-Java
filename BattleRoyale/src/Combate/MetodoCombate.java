package Combate;
import Personaje.Jugador;
import java.util.Random;

public class MetodoCombate {
    //declaramos los atributos que son necesarios para calcular el critico, los jugadores y el los turnos del combate
    private Jugador jugador1;
    private Jugador jugador2;
    public MetodoCombate(Jugador jugador1,Jugador jugador2){
        this.jugador1=jugador1;
        this.jugador2=jugador2;
    }
    public void setJugador1(Jugador jugador1){
        this.jugador1=jugador1;
    }
    public void setJugador2(Jugador jugador2){
        this.jugador2=jugador2;
    }
    public Jugador getJugador1(){
        return jugador1;
    }
    public Jugador getJugador2(){
        return jugador2;
    }
    public void Ataque(){
        Random random=new Random();
        int randDamage=random.nextInt(10)+1;
        int randOpcionBot=random.nextInt(2)+1;
        //El primer if es para cuando se produce critico de forma random que va del 1 al 10
        //declaramos el daño que va a recibir el jugador2
        //el jugador 1 es siempre el que ejecuta el daño por tanto habrá que alternar en el ActionListener a los Jugadores
        int damage=0;
        if(jugador1.getCrit()*10>=randDamage){
            damage=getJugador1().getAtk()*2;
            //si el escudo es 0
            if(getJugador2().getEscudo()==0){
                //se actualiza la vida del jugador 2, recibiendo el daño del jugador 1
                getJugador2().setVida(getJugador2().getVida()-damage);
                //Si la vida resulta ser negativa entonces se actualiza a 0
                if(getJugador2().getVida()<0){
                    getJugador2().setVida(0);
                }
            }
            else{
                //Si tiene escudo
                getJugador2().setEscudo(getJugador2().getEscudo()-damage);
                //Si despues de recibir la hostia el escudo se queda negativo
                if(getJugador2().getEscudo()<0){
                    //Entonces Calculamos lo que te tiene que quedar respectivamente en la vida haciendo el resto y quitandoselo a la vida
                    getJugador2().setVida(getJugador2().getVida()-(damage+getJugador2().getEscudo()));
                    //Ponemos el escudo a 0
                    getJugador2().setEscudo(0);
                    //Si resulta que la vida es negativa lo actualizamos a 0
                    if(getJugador2().getVida()<0){
                        getJugador2().setVida(0);
                    }
                }
            }
        }
        //Este es el caso en el que no pega critico que es el caso anterior, pero sin el x2
        else{
            damage=getJugador1().getAtk();
            if(getJugador2().getEscudo()==0){
                //se actualiza la vida del jugador 2, recibiendo el daño del jugador 1
                getJugador2().setVida(getJugador2().getVida()-damage);
                //Si la vida resulta ser negativa entonces se actualiza a 0
                if(getJugador2().getVida()<0){
                    getJugador2().setVida(0);
                }
            }
            else{
                //Si tiene escudo
                getJugador2().setEscudo(getJugador2().getEscudo()-damage);
                //Si despues de recibir la hostia el escudo se queda negativo
                if(getJugador2().getEscudo()<0){
                    //Entonces Calculamos lo que te tiene que quedar respectivamente en la vida haciendo el resto y quitandoselo a la vida
                    getJugador2().setVida(getJugador2().getVida()-(damage+getJugador2().getEscudo()));
                    //Ponemos el escudo a 0
                    getJugador2().setEscudo(0);
                    //Si resulta que la vida es negativa lo actualizamos a 0
                    if(getJugador2().getVida()<0){
                        getJugador2().setVida(0);
                    }
                }
            }
        }
        try{
            System.out.println("Has metido una hostia de "+damage);
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        if(randOpcionBot==1){
            if(jugador2.getCrit()*10>=randDamage){
                damage=getJugador2().getAtk()*2;
                //si el escudo es 0
                if(getJugador1().getEscudo()==0){
                    //se actualiza la vida del jugador 2, recibiendo el daño del jugador 1
                    getJugador1().setVida(getJugador1().getVida()-damage);
                    //Si la vida resulta ser negativa entonces se actualiza a 0
                    if(getJugador1().getVida()<0){
                        getJugador1().setVida(0);
                    }
                }
                else{
                    //Si tiene escudo
                    getJugador1().setEscudo(getJugador1().getEscudo()-damage);
                    //Si despues de recibir la hostia el escudo se queda negativo
                    if(getJugador1().getEscudo()<0){
                        //Entonces Calculamos lo que te tiene que quedar respectivamente en la vida haciendo el resto y quitandoselo a la vida
                        getJugador1().setVida(getJugador1().getVida()-(damage+getJugador1().getEscudo()));
                        //Ponemos el escudo a 0
                        getJugador1().setEscudo(0);
                        //Si resulta que la vida es negativa lo actualizamos a 0
                        if(getJugador1().getVida()<0){
                            getJugador1().setVida(0);
                        }
                    }
                }
            }
            //Este es el caso en el que no pega critico que es el caso anterior, pero sin el x2
            else{
                damage=getJugador2().getAtk();
                if(getJugador1().getEscudo()==0){
                    //se actualiza la vida del jugador 2, recibiendo el daño del jugador 1
                    getJugador1().setVida(getJugador1().getVida()-damage);
                    //Si la vida resulta ser negativa entonces se actualiza a 0
                    if(getJugador1().getVida()<0){
                        getJugador1().setVida(0);
                    }
                }
                else{
                    //Si tiene escudo
                    getJugador1().setEscudo(getJugador1().getEscudo()-damage);
                    //Si despues de recibir la hostia el escudo se queda negativo
                    if(getJugador1().getEscudo()<0){
                        //Entonces Calculamos lo que te tiene que quedar respectivamente en la vida haciendo el resto y quitandoselo a la vida
                        getJugador1().setVida(getJugador1().getVida()-(damage+getJugador1().getEscudo()));
                        //Ponemos el escudo a 0
                        getJugador1().setEscudo(0);
                        //Si resulta que la vida es negativa lo actualizamos a 0
                        if(getJugador1().getVida()<0){
                            getJugador1().setVida(0);
                        }
                    }
                }
            }
        }
        else{
            HabilidadJugador2(jugador1);
        }
    }
    //Este metodo va a utilizar las habilidades del jugador 1 sobre el jugador2, tambien habrá que hacer lo mismo con el ActionListener
    public void HabilidadJugador1(){
        Random random=new Random();
        int randDamage=random.nextInt(10)+1;
        int randOpcionBot=random.nextInt(2)+1;
        int damage=0;
        getJugador1().usarHabilidad(jugador2);
        if(randOpcionBot==1){
            if(jugador2.getCrit()*10>=randDamage){
                damage=getJugador2().getAtk()*2;
                //si el escudo es 0
                if(getJugador1().getEscudo()==0){
                    //se actualiza la vida del jugador 2, recibiendo el daño del jugador 1
                    getJugador1().setVida(getJugador1().getVida()-damage);
                    //Si la vida resulta ser negativa entonces se actualiza a 0
                    if(getJugador1().getVida()<0){
                        getJugador1().setVida(0);
                    }
                }
                else{
                    //Si tiene escudo
                    getJugador1().setEscudo(getJugador1().getEscudo()-damage);
                    //Si despues de recibir la hostia el escudo se queda negativo
                    if(getJugador1().getEscudo()<0){
                        //Entonces Calculamos lo que te tiene que quedar respectivamente en la vida haciendo el resto y quitandoselo a la vida
                        getJugador1().setVida(getJugador1().getVida()-(damage+getJugador1().getEscudo()));
                        //Ponemos el escudo a 0
                        getJugador1().setEscudo(0);
                        //Si resulta que la vida es negativa lo actualizamos a 0
                        if(getJugador1().getVida()<0){
                            getJugador1().setVida(0);
                        }
                    }
                }
            }
            //Este es el caso en el que no pega critico que es el caso anterior, pero sin el x2
            else{
                damage=getJugador2().getAtk();
                if(getJugador1().getEscudo()==0){
                    //se actualiza la vida del jugador 2, recibiendo el daño del jugador 1
                    getJugador1().setVida(getJugador1().getVida()-damage);
                    //Si la vida resulta ser negativa entonces se actualiza a 0
                    if(getJugador1().getVida()<0){
                        getJugador1().setVida(0);
                    }
                }
                else{
                    //Si tiene escudo
                    getJugador1().setEscudo(getJugador1().getEscudo()-damage);
                    //Si despues de recibir la hostia el escudo se queda negativo
                    if(getJugador1().getEscudo()<0){
                        //Entonces Calculamos lo que te tiene que quedar respectivamente en la vida haciendo el resto y quitandoselo a la vida
                        getJugador1().setVida(getJugador1().getVida()-(damage+getJugador1().getEscudo()));
                        //Ponemos el escudo a 0
                        getJugador1().setEscudo(0);
                        //Si resulta que la vida es negativa lo actualizamos a 0
                        if(getJugador1().getVida()<0){
                            getJugador1().setVida(0);
                        }
                    }
                }
            }
        }
        else{
            System.out.println("El bot ha usado la habilidad");
            HabilidadJugador2(jugador1);
        }
    }
    public void HabilidadJugador2(Jugador jugador){
        getJugador2().usarHabilidad(jugador);
    }


}
