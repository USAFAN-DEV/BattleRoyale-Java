package Personaje.PersonajeAtk;

import Personaje.Jugador;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import Interfaces2.KeyHandler;
import Interfaces2.Mapa;

public class Mei extends Jugador{
    
    //Hereda todos los atributos de la clase Jugador

    //Constructor
    public Mei(Mapa mapa, KeyHandler keyHandler){

        super(100,100,25,0,100,0.5,1.3,"Atk","Raiden Mei","Musou Shinsetsu", mapa.casillaSizeEscalada * 50, mapa.casillaSizeEscalada * 38);
        this.mapa = mapa;
        this.keyHandler = keyHandler;
        getPlayerImage();

    }

    //METODOS

    public String getPlayerGif(){
        return "./BattleRoyale-Java/BattleRoyale/images/player/eula.gif";
    }
    public void getPlayerImage(){
        /*try {
            System.out.println("Image loading started");
            characterImage = ImageIO.read(new File("C:\\Users\\nicol\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\images\\player\\mei.gif"));
            System.out.println("Image loading ended");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
    //declaracion de la habilidad y que estadisticas va a modificar
    public void usarHabilidad(Jugador jugador){

        //Random random=new Random();
        //int num=random.nextInt(10)+1;
        int damage=0;
        //necesito mas clases porque tengo que cambiar sus estadisticas 
        //if(super.getCrit()*10>=num){
            damage=(int)((super.getAtk()*2)*super.getEstadisticaHabilidad());//le puse 1.5 para que tenga un daño original porque si no es igual que el critico asegurado //he quitado *super.estadisticahabilidad()
       //}
        //else{
            //damage=(int)(super.getAtk()*super.getEstadisticaHabilidad());
       //}
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
        System.out.println("La habilidad de mei ha quitado "+damage);
    }

    //descripcion de la habilidad
    public void descripcionHabilidad(){

        System.out.printf("Mei realiza daño en función a su ataque y su porcentaje de crítico a un enemigo. Daño realizado(crítico)= %d*2*%f,Daño realizado(Sin crítico)=%d*%f",super.getAtk(),super.getEstadisticaHabilidad(),super.getAtk(),super.getEstadisticaHabilidad());

    }
    
}
