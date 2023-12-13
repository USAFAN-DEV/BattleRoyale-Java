
//import Armas.Armas;
import Armas.ArmasDefensa.StaffOfHoma;
//import Personaje.Jugador;
import Personaje.PersonajeDefensa.Zhongli;

public class prueba {
    
    public static void main(String[] args) {
        
        Zhongli Zhongli = new Zhongli();
        StaffOfHoma armaZhongli = new StaffOfHoma();

        Zhongli.setArma(armaZhongli);

        Zhongli.imprimeInfo();

        armaZhongli.aplicarStatsArma(Zhongli);

        Zhongli.imprimeInfo();


    }
}
