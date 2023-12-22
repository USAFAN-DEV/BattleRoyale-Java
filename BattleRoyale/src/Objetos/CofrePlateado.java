package Objetos;

import java.util.Random;

import Entidades.Personaje;
import Main.Mapa;

public class CofrePlateado extends Cofre {
    
    public CofrePlateado(Mapa mapa, String imagePath, int mapaX, int mapaY){

        super(mapa, imagePath, mapaX, mapaY);
        setName("cofrePlateado");

    }

    @Override
    public String lootCofre(Personaje jugador) {
        Random random = new Random();
        random.setSeed(System.nanoTime());
        int loot = random.nextInt(100) + 1;
        System.out.println(loot);
        String res;

        if(loot <= 10){
            if(jugador.getArma() == null || jugador.getArma().getEstrellasArma() != 5){

                jugador.setArma(recibirArma(jugador.getTipo(), 5));
                jugador.getArma().aplicarStatsArma(jugador);

                res = "Te ha tocado el arma " + jugador.getArma().getNombreArma();


            }
            else{

                jugador.setContadorPociones(jugador.getContadorPociones() + 1);
                res = "Ahora tienes " + jugador.getContadorPociones() + " pociones";
                
            }
            
        }  
        else if(loot > 10 && loot <= 40){
            if(jugador.getArma() == null){

                jugador.setArma(recibirArma(jugador.getTipo(), 4));
                res = "Te ha tocado el arma " + jugador.getArma().getNombreArma();
                jugador.getArma().aplicarStatsArma(jugador);

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



