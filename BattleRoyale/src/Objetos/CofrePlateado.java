package Objetos;

import Entidades.Personaje;
import Herramientas.Armas;
import Interfaces.Mapa;

public class CofrePlateado extends Cofre {
    
    public CofrePlateado(Mapa mapa, String imagePath, int mapaX, int mapaY){

        super(mapa, imagePath, mapaX, mapaY);
        name = "cofrePlateado";

    }

    @Override
    public Armas recibirArma(String tipoPersonaje, int numEstrellas) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recibirArma'");
    }

    @Override
    public String lootCofre(Personaje jugador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lootCofreDorado'");
    }

}

