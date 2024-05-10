package Entidades.AbstractFactoryPattern.Bots;



import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import Entidades.Bot;
import Entidades.Entidad;
import Main.KeyHandler;
import Main.Mapa;

public class ZhongliBot extends Bot{
    
    public ZhongliBot(Mapa mapa, KeyHandler keyHandler, int mapaX, int mapaY){

        super(100,100,25,0,200,0.25,0.25,"Defensa","Zhongli","Dominus Lapidis", mapaX, mapaY, mapa);
        this.keyHandler = keyHandler;

        this.speed = 2;
        getCharacterImage();
        this.setMapaX(mapaX);
        this.setMapaY(mapaY);

    }

   //declaracion de la habilidad y que estadisticas va a modificar
    public void usarHabilidad(Entidad jugador){

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

            String imagePath = "./BattleRoyale-Java/BattleRoyale/images/player/zhongli/";
            up1 = ImageIO.read(new File(imagePath + "zhongli-up-1.png")); 
            up2 = ImageIO.read(new File(imagePath + "zhongli-up-2.png"));
            down1 = ImageIO.read(new File(imagePath + "zhongli-down-1.png"));
            down2 = ImageIO.read(new File(imagePath + "zhongli-down-2.png"));
            left1 = ImageIO.read(new File(imagePath + "zhongli-left-1.png"));
            left2 = ImageIO.read(new File(imagePath + "zhongli-left-2.png"));
            right1 = ImageIO.read(new File(imagePath + "zhongli-right-1.png"));
            right2 = ImageIO.read(new File(imagePath + "zhongli-right-2.png"));

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
