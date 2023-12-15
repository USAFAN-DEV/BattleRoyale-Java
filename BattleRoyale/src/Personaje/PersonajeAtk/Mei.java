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

        super(100,100,25,0,100,0.5,0.25,"Atk","Raiden Mei","Musou Shinsetsu", mapa.casillaSizeEscalada * 50, mapa.casillaSizeEscalada * 38);
        this.mapa = mapa;
        this.keyHandler = keyHandler;
        getPlayerImage();

    }

    //METODOS


    public void getPlayerImage(){
        try {
            System.out.println("Image loading started");
            characterImage = ImageIO.read(new File("C:\\Users\\eduar\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\images\\player\\mei.gif"));
            System.out.println("Image loading ended");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //declaracion de la habilidad y que estadisticas va a modificar
    public void usarHabilidad(Jugador jugador){

        Random random=new Random();
        int num=random.nextInt(10)+1;
        int damage;
        //necesito mas clases porque tengo que cambiar sus estadisticas 
        if(super.getCrit()*10>=num){

            damage=(int)((super.getAtk()*2)*super.getEstadisticaHabilidad());

        }
        else{

            damage=(int)(super.getAtk()*super.getEstadisticaHabilidad());

        }
        if(jugador.getEscudo()>0){

            if((jugador.getEscudo()-damage)<0){

                damage=damage-jugador.getEscudo();
                jugador.setEscudo(0);
                jugador.setVida(jugador.getVida()-damage);

                if(jugador.getVida()<0){

                    jugador.setVida(0);

                }

            }
            
        }

        else{

            jugador.setVida(jugador.getVida()-damage);

            if(jugador.getVida()<0){

                jugador.setVida(0);

            }

        }

    }

    //descripcion de la habilidad
    public void descripcionHabilidad(){

        System.out.printf("Mei realiza daño en función a su ataque y su porcentaje de crítico a un enemigo. Daño realizado(crítico)= %d*2*%f,Daño realizado(Sin crítico)=%d*%f",super.getAtk(),super.getEstadisticaHabilidad(),super.getAtk(),super.getEstadisticaHabilidad());

    }
    
}
