import javax.swing.JFrame;

import Interfaces.Mapa;


public class Main {
    
    public static void main(String[] args) {
        
        JFrame window = new JFrame();
        Mapa mapa = new Mapa();
        window.add(mapa);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Para que cuando el usuario le de a la x se cierre la ventana
        window.setResizable(false);
        window.setTitle("Genshin Royale");
        window.pack(); //Hace que el JFrame tenga el tamano de sus componentes ()


        window.setLocationRelativeTo(null); //No especificamos la localizacion de la ventana. Por default en el centro
        window.setVisible(true);

        mapa.startGameThread();

    }
}
