package Texturas;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

import Interfaces2.Mapa;

public class AdministradorDeCasillas {

    //Constantes
    final int numeroCasillasDistintas = 18; //Numero de fotos de Casillas diferentes
    
    //Atributos
    Mapa mapa;
    Casilla[] casillas;
    int mapInNumbers[][];

    //Constructor
    public AdministradorDeCasillas(Mapa mapa){

        this.mapa = mapa;
        casillas = new Casilla[numeroCasillasDistintas];
        this.mapInNumbers = new int[mapa.maxMapaColumnas][mapa.maxMapaFilas];

        getCasillaImage();
        loadMap("C:\\Users\\nicol\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\maps\\map02.txt");

    }


    //METODOS

    //Funcion para obtener las imagenes de cada Casilla de la carpeta
    public void getCasillaImage(){

        try {

            String[] tiposDeCasillas = {"grass.png", "water.png", "water2.png", "water-sand.png", "water-sand.png", "sand.png", "ground-water-down.png", "ground-water-down-left.png", "ground-water-left.png", "ground-water-top-left.png", "ground-water-top.png", "ground-water-top-right.png", "ground-water-right.png", "ground-water-down-right.png", "snow1.png", "snow2.png", "snow3.png", "snow4.png"}; //Fotos de cada tipo de casilla

            for(int i = 0; i < numeroCasillasDistintas; i++){ //Obtenemos las imagenes de cada tipo de casilla

                casillas[i] = new Casilla();
                String imagePath = "C:\\Users\\nicol\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\images\\textures\\" + tiposDeCasillas[i];
                System.out.println(imagePath);
                casillas[i].image = ImageIO.read(new File(imagePath));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadMap(String filePath){

        try {
            
            BufferedReader in = new BufferedReader(new FileReader(filePath)); //Creamos un buffered reader para leer el archivo en el que se encuentra la distribucion de las diferentes Casillas en nuestro mapa
            int col = 0;
            int row = 0;

            while(col < mapa.maxMapaColumnas && row < mapa.maxMapaFilas){ //Mientras col y row no superen el numero maximo de columnas y filas del mapa

                String linea = in.readLine(); //Leemos una linea

                while(col < mapa.maxMapaColumnas){ //Vamos cogiendo los numeros de la linea y los guardamos en nuestra matriz mapInNumbers

                    String numbers[] = linea.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapInNumbers[col][row] = num;
                    col++;

                }

                if(col == mapa.maxMapaColumnas){ //Cuando llegamos al final de la fila, pasamos a la siguiente

                    col = 0;
                    row++;

                }

            }
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Funcion para dibujar las Casillas en el mapa
    public void draw(Graphics2D g2){

        //Variables
        int drawedMapaCols = 0; 
        int drawedMapaRows = 0;

        while(drawedMapaCols < mapa.maxMapaColumnas && drawedMapaRows < mapa.maxMapaFilas){ //Mientras que el numero de columnas dibujadas sea menor que el maximo numero de columnas del mapa y el numero de filas dibujadas sea menor que el maximo numero de filas del mapa

            int casillaNum = mapInNumbers[drawedMapaCols][drawedMapaRows];//Tipo de Casilla correspondiente a cada 

            int mapaX = drawedMapaCols * mapa.casillaSizeEscalada; //coordenada x de la casilla en el mapa
            int mapaY = drawedMapaRows * mapa.casillaSizeEscalada; //coordenada y de la casilla en el mapa
            int screenX = mapaX - mapa.player1.getMapaX() + mapa.player1.screenX; //coordenada x de la casilla en la pantalla
            int screenY = mapaY - mapa.player1.getMapaY() + mapa.player1.screenY; //coordenada y de la casilla en la pantalla

            /*
            Si el jugador esta en la posicion 500, 500:
                La casilla [0][0], que esta en la posicion (0,0) respecto del mapa estara en la posicion (-500,-500) respecto del jugador
                Sumamos la posicion del jugador en la pantalla porque realmente la posicion x del jugador es jugador.mapaX + screenX para que este en el centro de la pantalla por lo que
                tambien tenemos que sumarle a la posicion x de cada casilla jugador.screenX. Pasa lo mismo con la posicion Y

            Para dibujar solo las casillas que esta viendo el jugador, necesitamos 4 condiciones: 
                Que la posicion x de la casilla en el mapa este en el rango de vision del jugador
                    mapaX > player.mapaX - player.screenX --> Que la posicion de la casilla en el mapa sea mayor que la posicion del jugador en el mapa menos lo que "movemos" al jugador para que este en el centro de la pantalla
                    mapaX < player.mapaX + player.screenX --> Que la posicion de la casilla en el mapa sea menor que la posicion del jugador en el mapa mas lo que "movemos" al jugador para que este en el centro de la pantalla

                Que la posicion y de la casilla en el mapa este en el rango de vision del jugador estableciendo las mismas condiciones que con la coordenada X

                sumamos el tamano de una casilla para que el rango de casillas que se dibujan sea un poco mas grande y nunca veamos un fondo negro
            */
            if((mapaX + mapa.casillaSizeEscalada > mapa.player1.getMapaX() - mapa.player1.screenX && mapaX - mapa.casillaSizeEscalada < mapa.player1.getMapaX() + mapa.player1.screenX) && (mapaY + mapa.casillaSizeEscalada > mapa.player1.getMapaY() - mapa.player1.screenY && mapaY - mapa.casillaSizeEscalada < mapa.player1.getMapaY() + mapa.player1.screenY)){

                g2.drawImage(casillas[casillaNum].image, screenX, screenY, mapa.casillaSizeEscalada, mapa.casillaSizeEscalada, null); //Dibujamos una Casilla

            }

            drawedMapaCols++; //Incrementamos el contador de columnas dibujadas

            if(drawedMapaCols == mapa.maxMapaColumnas){ //Si hemos llegado al maximo de columnas, Las reseteamos a 0 y pasamos a la siguiente fila

                //reseteamos las columnas dibujadas y la x
                drawedMapaCols = 0;
                //aumentamos las filas dibujadas y la y
                drawedMapaRows++;

            }
        }

    }
}
