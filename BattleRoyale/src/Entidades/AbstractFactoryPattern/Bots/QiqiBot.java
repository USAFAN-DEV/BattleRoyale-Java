package Entidades.AbstractFactoryPattern.Bots;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import Entidades.Bot;
import Entidades.Entidad;
import Main.KeyHandler;
import Main.Mapa;

public class QiqiBot extends Bot{

    private int revivir;
    
    public QiqiBot(Mapa mapa, KeyHandler keyHandler, int mapaX, int mapaY){

        super(150,150,25,0,100,0.25,0.25,"Healer","Qiqi","Preserver of Fortune",mapaX, mapaY, mapa);
        this.keyHandler = keyHandler;

        this.speed = 2;
        getCharacterImage();
        this.setMapaX(mapaX);
        this.setMapaY(mapaY);
        setRevivir(0);

    }

    //getters y setters del hijo
    public int getRevivir(){

        return revivir;

    }

    public void setRevivir(int revivir){

        this.revivir=revivir;

    }

    //METODOS

    public String getPlayerGif(){

        return "./BattleRoyale-Java/BattleRoyale/images/player/qiqi.gif";

    }

    public void usarHabilidad(Entidad jugador){

        if(super.getVida()==0 && getRevivir()==0){

            setRevivir(1);
            super.setVida(100);
            System.out.println("Qiqi ha revivido y tiene 100 de vida\n");

        } 

        else{

            System.out.println("Error. La habilidad ya se ha utilizado");

        }    
    }

    //descripcion de la habilidad
    public String descripcionHabilidad(){
        
        String descHabilidad = "Qiqi se revive a si misma con el 100 de la vida.\nSe puede usar una vez por combate";
        return descHabilidad;
        
    }

    @Override
    public void getCharacterImage() {
        try {

            String imagePath = "./BattleRoyale-Java/BattleRoyale/images/player/qiqi/";
            up1 = ImageIO.read(new File(imagePath + "qiqi-up-1.png")); 
            up2 = ImageIO.read(new File(imagePath + "qiqi-up-2.png"));
            down1 = ImageIO.read(new File(imagePath + "qiqi-down-1.png"));
            down2 = ImageIO.read(new File(imagePath + "qiqi-down-2.png"));
            left1 = ImageIO.read(new File(imagePath + "qiqi-left-1.png"));
            left2 = ImageIO.read(new File(imagePath + "qiqi-left-2.png"));
            right1 = ImageIO.read(new File(imagePath + "qiqi-right-1.png"));
            right2 = ImageIO.read(new File(imagePath + "qiqi-right-2.png"));

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

}

