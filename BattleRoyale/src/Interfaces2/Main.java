package Interfaces2;

import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args) {
        
        JFrame window = new JFrame();
        Ciudad interfaz = new Ciudad();
        window.add(interfaz);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Para que cuando el usuario le de a la x se cierre la ventana
        window.setResizable(false);
        window.setTitle("Genshin Royale");
        window.pack(); //Hace que el JFrame tenga el tamano de sus componentes ()


        window.setLocationRelativeTo(null); //No especificamos la localizacion de la ventana. Por default en el centro
        window.setVisible(true);

        interfaz.startGameThread();

        
        

    }
}
