package Entidades.PersonajeDefensa;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import Entidades.Personaje;
import Interfaces.KeyHandler;
import Interfaces.Mapa;

public class Zhongli extends Personaje{

    //Hereda todos los atributos de la clase Jugador

    //Constructor
    public Zhongli(Mapa mapa, KeyHandler keyHandler){

        super(100,100,25,0,200,0.25,0.25,"Defensa","Zhongli","Dominus Lapidis", 0, 0, mapa);
        this.keyHandler = keyHandler;
        getCharacterImage();
        
    }

    //METODOS

    //declaracion de la habilidad y que estadisticas va a modificar
    public void usarHabilidad(Personaje jugador){
        super.setEscudo((int)(super.getEscudo()+super.getEstadisticaHabilidad()*super.getEscudoMaximo()));
        if(super.getEscudo()>super.getEscudoMaximo()){
            super.setEscudo(super.getEscudoMaximo());
        }
        System.out.println("Tienes un escudo de "+super.getEscudo());
    } 

    //descripcion de la habilidad
    public String descripcionHabilidad(){

        String descHabilidad = "Da escudo al resto del equipo en función de su escudo\nmáximo. El escudo recibido por un personaje no puede\nsuperar su escudo máximo.\nEscudo recibido = " + super.getEstadisticaHabilidad() + "*" + super.getEscudoMaximo();
        return descHabilidad;

    } 

    //Funcion para obtener la imagen del personaje de la carpeta
    public String getPlayerGif(){
        return "./BattleRoyale-Java/BattleRoyale/images/player/zhongli.gif";
    }
    public void getCharacterImage(){

        try {

            //System.out.println("Image loading started");
            String imagePath = "./BattleRoyale-Java/BattleRoyale/images/player/zhongli/";
            up1 = ImageIO.read(new File(imagePath + "zhongli-up-1.png")); 
            up2 = ImageIO.read(new File(imagePath + "zhongli-up-2.png"));
            down1 = ImageIO.read(new File(imagePath + "zhongli-down-1.png"));
            down2 = ImageIO.read(new File(imagePath + "zhongli-down-2.png"));
            left1 = ImageIO.read(new File(imagePath + "zhongli-left-1.png"));
            left2 = ImageIO.read(new File(imagePath + "zhongli-left-2.png"));
            right1 = ImageIO.read(new File(imagePath + "zhongli-right-1.png"));
            right2 = ImageIO.read(new File(imagePath + "zhongli-right-2.png"));
            //System.out.println("Image loading ended");

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
