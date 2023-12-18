package Objetos;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Cofre extends Objeto {
    
    public Cofre(String imageName, int mapaX, int mapaY){

        name = "cofre";
        try {
            image = ImageIO.read(new File("C:\\Users\\nicol\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\images\\objetos\\" + imageName)); 
        } catch (IOException e) {e.printStackTrace();}

        this.mapaX = mapaX;
        this.mapaY = mapaY;

    }

}
