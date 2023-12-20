package Objetos;

import Entidades.Personaje;
import Herramientas.Armas;

public class CofrePlateado extends Cofre {
    
    public CofrePlateado(String imagePath, int mapaX, int mapaY){

        super(imagePath, mapaX, mapaY);
        name = "cofrePlateado";

    }

    @Override
    public Armas recibirArma(String tipoPersonaje, int numEstrellas) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recibirArma'");
    }

    @Override
    public void lootCofre(Personaje jugador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lootCofreDorado'");
    }

}

