package Objetos;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import Entidades.Personaje;
import Herramientas.Armas;

public abstract class Cofre extends Objeto {
    
    public Cofre(String imageName, int mapaX, int mapaY){

        try {
            image = ImageIO.read(new File("./BattleRoyale-Java/BattleRoyale/images/objetos/" + imageName)); 
        } catch (IOException e) {e.printStackTrace();}

        this.mapaX = mapaX;
        this.mapaY = mapaY;
        areaDeColision =  new Rectangle(0, 0, 16 * escala, 16 * escala);
        areaDeColisionDefaultX = areaDeColision.x;
        areaDeColisionDefaultY = areaDeColision.y;
        this.collision = false;

    }

    public abstract Armas recibirArma(String tipoPersonaje, int numEstrellas);
    public abstract void lootCofre(Personaje jugador);

}
