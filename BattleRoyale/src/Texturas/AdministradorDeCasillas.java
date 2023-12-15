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
    final int numeroCasillasDistintas = 21; //Numero de fotos de Casillas diferentes
    final int numeroDecorationsDistintas = 14;
    
    //Atributos
    Mapa mapa;
    Casilla[] casillas;
    Casilla[] decorations;
    int mapInNumbers[][];
    int decorationsInNumbers[][];

    //Constructor
    public AdministradorDeCasillas(Mapa mapa){

        this.mapa = mapa;
        casillas = new Casilla[numeroCasillasDistintas];
        decorations = new Casilla[numeroDecorationsDistintas];
        this.mapInNumbers = new int[mapa.maxMapaColumnas][mapa.maxMapaFilas];
        this.decorationsInNumbers = new int[mapa.maxMapaColumnas][mapa.maxMapaFilas];

        getCasillaImage();
        getDecorationImage();

    }


    //METODOS

    //Funcion para obtener las imagenes de cada Casilla de la carpeta
    public void getCasillaImage(){

        try {

            String[] tiposDeCasillas = {"snow1.png", "snow2.png", "water2.png", "snow3.png", "snow4.png", "ground-water-left-snow.png", "ground-water-top-left-snow.png", "ground-water-top-snow.png", "ground-water-top-right-snow.png", "ground-water-right-snow.png", "ground-water-down-right-snow.png", "ground-water-down-snow.png", "ground-water-down-left-snow.png", "ground-water-left.png", "ground-water-top-left.png", "ground-water-top.png", "ground-water-top-right.png", "ground-water-right.png", "ground-water-down-right.png", "ground-water-down.png", "ground-water-down-left.png"}; //Fotos de cada tipo de casilla

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

    public void getDecorationImage(){

         try {

            String[] tiposDeDecorations = {"tree-winter.png", "tree-winter-cut.png", "house.png", "castle-topleft.png", "castle-topright.png", "castle-bottomleft.png", "castle-bottomright.png", "bridge-topleft.png", "bridge-topright.png", "bridge-centerleft.png", "bridge-centerright.png", "bridge-bottomleft.png", "bridge-bottomright.png", "bridge-center.png"}; //Fotos de cada tipo de decoracion

            for(int i = 0; i < numeroDecorationsDistintas; i++){ //Obtenemos las imagenes de cada tipo de casilla

                decorations[i] = new Casilla();
                String imagePath = "C:\\Users\\nicol\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\images\\decoration\\" + tiposDeDecorations[i];
                System.out.println(imagePath);
                decorations[i].image = ImageIO.read(new File(imagePath));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadMap(String filePath, int[][] fileInNumbers){

        try {
            
            BufferedReader in = new BufferedReader(new FileReader(filePath)); //Creamos un buffered reader para leer el archivo en el que se encuentra la distribucion de las diferentes Casillas en nuestro mapa
            int col = 0;
            int row = 0;

            while(col < mapa.maxMapaColumnas && row < mapa.maxMapaFilas){ //Mientras col y row no superen el numero maximo de columnas y filas del mapa

                String linea = in.readLine(); //Leemos una linea

                while(col < mapa.maxMapaColumnas){ //Vamos cogiendo los numeros de la linea y los guardamos en nuestra matriz mapInNumbers

                    String numbers[] = linea.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    fileInNumbers[col][row] = num;
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
    public void drawCasillas(Graphics2D g2){

        loadMap("C:\\Users\\nicol\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\maps\\map01.txt", mapInNumbers);
        loadMap("C:\\Users\\nicol\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\maps\\map02.txt", decorationsInNumbers);

        //Variables
        int drawedMapaCols = 0; 
        int drawedMapaRows = 0;

        while(drawedMapaCols < mapa.maxMapaColumnas && drawedMapaRows < mapa.maxMapaFilas){ //Mientras que el numero de columnas dibujadas sea menor que el maximo numero de columnas del mapa y el numero de filas dibujadas sea menor que el maximo numero de filas del mapa

            int casillaNum = mapInNumbers[drawedMapaCols][drawedMapaRows];//Tipo de Casilla correspondiente a cada 
            int decorationNum = decorationsInNumbers[drawedMapaCols][drawedMapaRows];//Tipo de Casilla correspondiente a cada 

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

                if(decorationNum != -1){

                    g2.drawImage(decorations[decorationNum].image, screenX, screenY, mapa.casillaSizeEscalada, mapa.casillaSizeEscalada, null);

                }

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

