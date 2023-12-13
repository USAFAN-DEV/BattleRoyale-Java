package Personaje.PersonajeDefensa;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Interfaces2.KeyHandler;
import Interfaces2.Mapa;
import Personaje.Jugador;

public class YunJin extends Jugador{
    
    //Hereda todos los atributos de la clase Jugador

    //Constructor
    public YunJin(Mapa mapa, KeyHandler keyHandler){

        super(100,100,25,0,200,0.25,0.25,"Defensa","Yunjin","Cliffbreaker's Banner");
        this.mapa = mapa;
        this.keyHandler = keyHandler;
        getPlayerImage();

    }

    //METODOS

    //declaracion de la habilidad y que estadisticas va a modificar
    public void usarHabilidad(Jugador equipo[]){
        //necesito mas clases porque tengo que cambiar sus estadisticas
        //hace daño extra en base de su escudo durante un turno
        for(int i=0;i<equipo.length;i++){
            
        }
    }

    //descripcion de la habilidad
    public void descripcionHabilidad(){

        System.out.println("Nanosexo");
        
    }

    //Funcion para obtener la imagen del personaje de la carpeta
    public void getPlayerImage(){

        try {
            System.out.println("Image loading started");
            characterImage = ImageIO.read(new File("C:\\Users\\nicol\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\images\\player\\zhongli.png"));
            System.out.println("Image loading ended");

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
