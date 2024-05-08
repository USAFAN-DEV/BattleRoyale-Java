package Entidades.PersonajeHealer;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Entidades.Personaje;
import Main.KeyHandler;
import Main.Mapa;

public class Qiqi extends Personaje{
    private int revivir;

    //Constructor
    public Qiqi(Mapa mapa, KeyHandler keyHandler){

        super(150,150,25,0,100,0.25,0.25,"Healer","Qiqi","Preserver of Fortune",0, 0, mapa);
        this.keyHandler = keyHandler;
        getCharacterImage();
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

    //declaracion de la habilidad y que estadisticas va a modificar
    public void usarHabilidad(Personaje jugador){
        //necesito mas clases porque tengo que cambiar sus estadisticas 
        //revive a una persona
        if(super.getVida()==0 && getRevivir()==0){
            setRevivir(1);
            super.setVida(100);
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

            //System.out.println("Image loading started");
            String imagePath = "./BattleRoyale-Java/BattleRoyale/images/player/qiqi/";
            up1 = ImageIO.read(new File(imagePath + "qiqi-up-1.png")); 
            up2 = ImageIO.read(new File(imagePath + "qiqi-up-2.png"));
            down1 = ImageIO.read(new File(imagePath + "qiqi-down-1.png"));
            down2 = ImageIO.read(new File(imagePath + "qiqi-down-2.png"));
            left1 = ImageIO.read(new File(imagePath + "qiqi-left-1.png"));
            left2 = ImageIO.read(new File(imagePath + "qiqi-left-2.png"));
            right1 = ImageIO.read(new File(imagePath + "qiqi-right-1.png"));
            right2 = ImageIO.read(new File(imagePath + "qiqi-right-2.png"));
            //System.out.println("Image loading ended");

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
