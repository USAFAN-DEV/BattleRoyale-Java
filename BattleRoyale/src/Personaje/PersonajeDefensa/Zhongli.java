package Personaje.PersonajeDefensa;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import Interfaces2.Mapa;
import Interfaces2.KeyHandler;
import Personaje.Jugador;

public class Zhongli extends Jugador{

    //Hereda todos los atributos de la clase Jugador

    //Constructor
    public Zhongli(Mapa mapa, KeyHandler keyHandler){

        super(100,100,25,0,200,0.25,0.25,"Defensa","Zhongli","Dominus Lapidis");
        this.mapa = mapa;
        this.keyHandler = keyHandler;
        getPlayerImage();
        
    }

    //METODOS

    //declaracion de la habilidad y que estadisticas va a modificar
    public void usarHabilidad(Jugador equipo[]){

        for(int i=0;i<equipo.length;i++){

            equipo[i].setEscudo((int)(equipo[i].getEscudo()+super.getEstadisticaHabilidad()*super.getEscudoMaximo()));

            if(equipo[i].getEscudo()>equipo[i].getEscudoMaximo()){

                equipo[i].setEscudo(equipo[i].getEscudoMaximo());

            }
        }

    } 

    //descripcion de la habilidad
    public void descripcionHabilidad(){

        System.out.printf("Da escudo escudo al resto del equipo en función de su escudo máximo. El escudo recibido por un personaje no puede superar su escudo máximo. Escudo recibido= %f*%d",super.getEstadisticaHabilidad(),super.getEscudoMaximo());

    } 

    //Funcion para obtener la imagen del personaje de la carpeta
    public void getPlayerImage(){

        try {

            System.out.println("Image loading started");
            characterImage = ImageIO.read(new File("C:\\Users\\nicol\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\images\\player\\zhongli.png"));
            /* 
            up2 = ImageIO.read(new File("C:\\Users\\nicol\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\images\\player\\boy_up_2.png"));
            down1 = ImageIO.read(new File("C:\\Users\\nicol\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\images\\player\\boy_down_1.png"));
            down2 = ImageIO.read(new File("C:\\Users\\nicol\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\images\\player\\boy_down_2.png"));
            left1 = ImageIO.read(new File("C:\\Users\\nicol\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\images\\player\\boy_left_1.png"));
            left2 = ImageIO.read(new File("C:\\Users\\nicol\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\images\\player\\boy_left_2.png"));
            right1 = ImageIO.read(new File("C:\\Users\\nicol\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\images\\player\\boy_right_1.png"));
            right2 = ImageIO.read(new File("C:\\Users\\nicol\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\images\\player\\boy_right_2.png"));
            */
            System.out.println("Image loading ended");

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
