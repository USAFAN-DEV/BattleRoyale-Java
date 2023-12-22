package Objetos;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import Entidades.Personaje;
import Herramientas.Armas;
import Herramientas.ArmasAtaque.EngulfingLightning;
import Herramientas.ArmasAtaque.SacrificialFragments;
import Herramientas.ArmasDefensa.StaffOfHoma;
import Herramientas.ArmasDefensa.TheCatch;
import Herramientas.ArmasVida.AquilaFavonia;
import Herramientas.ArmasVida.SacrificialSword;
import Main.Mapa;

public abstract class Cofre extends Objeto {
    
    public Cofre(Mapa mapa, String imageName, int mapaX, int mapaY){

        super(mapa);

        try {
            image = ImageIO.read(new File("./BattleRoyale-Java/BattleRoyale/images/objetos/" + imageName)); 
        } catch (IOException e) {e.printStackTrace();}

        this.mapaX = mapaX;
        this.mapaY = mapaY;
        areaDeColision =  new Rectangle(0, 0, 16 * escala, 16 * escala);
        areaDeColisionDefaultX = areaDeColision.x;
        areaDeColisionDefaultY = areaDeColision.y;
        this.colision = false;

    }

    public Armas recibirArma(String tipoPersonaje, int numEstrellas){

        Armas arma = null;

        switch (tipoPersonaje) {
            case "Atk":
                if(numEstrellas == 4){arma = new SacrificialFragments();}
                else{arma = new EngulfingLightning();}
                break;

            case "Healer":
                if(numEstrellas == 4){arma = new SacrificialSword();}
                else{arma = new AquilaFavonia();}
                break;

            case "Defensa":
                if(numEstrellas == 4){arma = new TheCatch();}
                else{arma = new StaffOfHoma();}
                break;
        
            default:
                break;
        }

        return arma;
        
    }

    public abstract String lootCofre(Personaje jugador);

}
