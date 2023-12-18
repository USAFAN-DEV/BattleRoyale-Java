package Personaje.PersonajeDefensa;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import Herramientas.ArmasDefensa.StaffOfHoma;
import Interfaces2.Mapa;
import Interfaces2.KeyHandler;
import Personaje.Jugador;

public class Zhongli extends Jugador{

    //Hereda todos los atributos de la clase Jugador

    //Constructor
    public Zhongli(Mapa mapa, KeyHandler keyHandler){

        super(100,100,25,0,200,0.25,0.25,"Defensa","Zhongli","Dominus Lapidis", mapa.casillaSizeEscalada * 30, mapa.casillaSizeEscalada * 30);
        this.mapa = mapa;
        this.keyHandler = keyHandler;
        setArma(new StaffOfHoma());
        areaDeCollision = new Rectangle(4 * mapa.escala, 6 * mapa.escala, 8 * mapa.escala, 10 * mapa.escala);
        areaDeColisionDefaultX = areaDeCollision.x;
        areaDeColisionDefaultY = areaDeCollision.y;
        getPlayerImage();
        arma.aplicarStatsArma(this);
        
    }

    //METODOS

    //declaracion de la habilidad y que estadisticas va a modificar
    public void usarHabilidad(Jugador jugador){
        super.setEscudo((int)(super.getEscudo()+super.getEstadisticaHabilidad()*super.getEscudoMaximo()));
        if(super.getEscudo()>super.getEscudoMaximo()){
            super.setEscudo(super.getEscudoMaximo());
        }
        System.out.println("Tienes un escudo de "+super.getEscudo());
    } 

    //descripcion de la habilidad
    public void descripcionHabilidad(){

        System.out.printf("Da escudo escudo al resto del equipo en función de su escudo máximo. El escudo recibido por un personaje no puede superar su escudo máximo. Escudo recibido= %f*%d",super.getEstadisticaHabilidad(),super.getEscudoMaximo());

    } 

    //Funcion para obtener la imagen del personaje de la carpeta
    public String getPlayerGif(){
        return "./BattleRoyale-Java/BattleRoyale/images/player/zhongli.gif";
    }
    public void getPlayerImage(){

        try {

            System.out.println("Image loading started");
            String imagePath = "./BattleRoyale-Java/BattleRoyale/images/player/";
            up1 = ImageIO.read(new File(imagePath + "zhongli-up-1.png")); 
            up2 = ImageIO.read(new File(imagePath + "zhongli-up-2.png"));
            down1 = ImageIO.read(new File(imagePath + "zhongli-down-1.png"));
            down2 = ImageIO.read(new File(imagePath + "zhongli-down-2.png"));
            left1 = ImageIO.read(new File(imagePath + "zhongli-left-1.png"));
            left2 = ImageIO.read(new File(imagePath + "zhongli-left-2.png"));
            right1 = ImageIO.read(new File(imagePath + "zhongli-right-1.png"));
            right2 = ImageIO.read(new File(imagePath + "zhongli-right-2.png"));
            System.out.println("Image loading ended");

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
