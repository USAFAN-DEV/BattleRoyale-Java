package Interfaces2;

import javax.swing.JPanel;

import Objetos.AdministradorDeObjetos;
import Objetos.Objeto;

import java.awt.*;
import Personaje.Jugador;
import Personaje.PersonajeAtk.Mei;
import Personaje.PersonajeHealer.Qiqi;
import Personaje.PersonajeDefensa.Zhongli;
import Texturas.AdministradorDeCasillas;

public class Mapa extends JPanel implements Runnable{

    //array jugadores en el mapa
    
    //Constantes
    final int casillaSize = 16; // 16x16. Tamano personajes. Esto se usaba antes cuando las resoluciones eran mas pequenas. Tendremos que hacer escala de esto. 
    public final int escala = 3; 

    public final int casillaSizeEscalada = casillaSize * escala; //Asi los personajes son 48x48
    public final int maxScreenColumnas = 20;
    public final int maxScreenFilas = 15; //Ratio 4x3;
    public final int maxScreenWidht = casillaSizeEscalada * maxScreenColumnas; //48 * 20 = 960pixels
    public final int maxScreenHeight = casillaSizeEscalada * maxScreenFilas; //48 * 15 = 720pixels


    //World variables
    public final int maxMapaColumnas = 103;
    public final int maxMapaFilas = 82;
    public final int mapaWidth = casillaSize * maxMapaColumnas;
    public final int mapaHeight = casillaSize * maxMapaFilas;

    //FPS (Frames per second)

    int FPS = 60;

    AdministradorDeCasillas administradorC = new AdministradorDeCasillas(this);
    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    public AdministradorDeObjetos AdministradorO = new AdministradorDeObjetos(this);
    public ColisionCheck colisionCheck = new ColisionCheck(this);
    public Jugador player1 = new Zhongli(this, keyHandler);
    public Jugador player2 = new Mei(this, keyHandler);
    public Objeto objetos[] = new Objeto[10]; 
    //Jugador player2 = new YunJin(this, keyHandler);

    
    

    public Mapa(){

        this.setPreferredSize(new Dimension(maxScreenWidht, maxScreenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); //Mejora el rendimiento de la renderizacion del juego
        this.addKeyListener(keyHandler); //Anadimos el keyListener
        this.setFocusable(true); // puede ser "focused" para recibir key inputs
        this.AdministradorO.colocarObjetos();

    }
    //getter y setter
    public Jugador getJugador1(){
        return player1;
    }

    public void startGameThread(){

        gameThread = new Thread(this); //Instanciamos el Thread
        gameThread.start(); //Llama a run()

    }

    @Override
    public void run() {
        // Funcion llamada cuando empieza gameThread. Core del juego
        double drawInterval = 1000000000/FPS; //Intervalo de dibujo. 1 segundo (1000000000 nanosegundos) / FPS (60) = 0.016666 segundos. Cada 0.016666 segundos dibujaremos el siguiente frame
        double delta = 0;
        long lastTime = System.nanoTime(); //En nanosegundos
        long currentTime;
        int timer = 0;
        int contDraw = 0;

        while(gameThread != null){ //Mientras gameThread exista

            //Delta/Acumulator Method. 
            currentTime = System.nanoTime(); //Chequeamos el current time
            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;

            if(delta >= 1){ //Si la diferencia entre currentTime(Tiempo actual) y lastTime(tiempo antes de que se ejecutara el anterior update() y repaint()), es decir el tiempo que ha pasado desde la ultima vez que actualizamos y dibujamos la informacion, supera o iguala el drawInterval, podemos volvemos a ejecutar update() y repaint()

                //Actualizar: actualizar informacion como la posicion del personaje
                update();
                //Dibujar: dibujar la informacion actualizada
                repaint();
                delta--;
                contDraw++;

            }
            if(timer >= 1000000000){ //Cuando timer llegue a un segundo (1000000000 nanosegundos). Timer es la resta entre current time y last time. Es decir, cuando el tiempo de ejecucion del programa llegue a un segundo

                System.out.println("FPS:" + contDraw);
                timer = 0;
                contDraw = 0;

            }
           

        }
    }

    public void update(){

        player1.update();
        //player2.update(keyHandler);

    }
    public void paintComponent(Graphics g){ //metodo built-in java. Uno de los metodos estandares para dibujar cosas en un JPanel

        super.paintComponent(g); //Pintar en el parent class (JPanel)

        Graphics2D g2 = (Graphics2D)g; //cambiamos g de Graphics a Graphics2d. Graphics2D tiene mas metodos y nos da mas control

        administradorC.draw(g2);
        for(int i = 0; i < objetos.length; i++){

            if(objetos[i] != null){
                objetos[i].draw(g2, this);
            }

        }
        player1.draw(g2);
        
        g2.dispose();

    }

}
