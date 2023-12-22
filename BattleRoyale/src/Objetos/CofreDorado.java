package Objetos;

import java.util.Random;
import Entidades.Personaje;
import Interfaces.Mapa;

public class CofreDorado extends Cofre {
    
    public CofreDorado(Mapa mapa, String imagePath, int mapaX, int mapaY){

        super(mapa, imagePath, mapaX, mapaY);
        name = "cofreDorado";

    }


    public String lootCofre(Personaje jugador){ //Arma4 estrellas, Arma5 estrellas, pocionVida, pocionEscudo.

        Random random = new Random();
        random.setSeed(System.nanoTime());
        int loot = random.nextInt(100) + 1;
        System.out.println(loot);
        String res;

        if(loot <= 30){
            if(jugador.getArma() == null || jugador.getArma().getEstrellasArma() != 5){

                jugador.setArma(recibirArma(jugador.getTipo(), 5));
                jugador.arma.aplicarStatsArma(jugador);

                res = "Te ha tocado el arma " + jugador.arma.getNombreArma();


            }
            else{

                jugador.setContadorPociones(jugador.getContadorPociones() + 1);
                res = "Ahora tienes " + jugador.getContadorPociones() + " pociones";
                
            }
            
        }  
        else if(loot > 30 && loot <= 40){
            if(jugador.getArma() == null){

                jugador.setArma(recibirArma(jugador.getTipo(), 4));
                res = "Te ha tocado el arma " + jugador.arma.getNombreArma();
                jugador.arma.aplicarStatsArma(jugador);

            }
            else{

                jugador.setContadorPociones(jugador.getContadorPociones() + 1);
                res = "Ahora tienes " + jugador.getContadorPociones() + " pociones";

            }
        }      
        else if(loot > 40 && loot <= 50){

            jugador.setContadorPociones(jugador.getContadorPociones() + 1);
            res = "Ahora tienes " + jugador.getContadorPociones() + " pociones";

        }
        else{

            if(jugador.getEscudo() == jugador.getEscudoMaximo()){

                res = "Ya tienes el escudo al maximo, recibiras una pocion de vida a cambio.";
                jugador.setContadorPociones(jugador.getContadorPociones() + 1);

            }
            else if(jugador.getEscudo() > (jugador.getEscudoMaximo() - 50)){

                res = "Has recibido solo " + (jugador.getEscudoMaximo() - jugador.getEscudo());
                jugador.setEscudo(jugador.getEscudoMaximo());

            }
            else{

                res = "Has recibido 50 de escudo";
                jugador.setEscudo(jugador.getEscudo() + 50);

            }

        }

        return res;

    }
}
