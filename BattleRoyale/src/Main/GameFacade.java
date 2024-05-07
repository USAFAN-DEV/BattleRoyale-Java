package Main;
import javax.swing.JFrame;


public class GameFacade {
    
    public Mapa createMapa(){

        Mapa mapa = new Mapa();

        return mapa;
        
    }

    public JFrame createJFrame(){
        
        JFrame window = new JFrame();

        return window;

    }

    public void prepareJFrame(Mapa mapa, JFrame window){

        window.add(mapa);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Para que cuando el usuario le de a la x se cierre la ventana
        window.setResizable(false);
        window.setTitle("Genshin Royale");
        window.pack(); //Hace que el JFrame tenga el tamano de sus componentes ()
        window.setLocationRelativeTo(null); //No especificamos la localizacion de la ventana. Por default en el centro
        window.setVisible(true);

    }

    public void startGame() {
        
        Mapa mapa = this.createMapa();
        JFrame window = this.createJFrame();
        this.prepareJFrame(mapa, window);
        mapa.startGameThread();

    }
}
