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
    final int numeroCasillasDistintas = 3; //Numero de fotos de Casillas diferentes
    
    //Atributos
    Mapa mapa;
    Casilla[] Casillas;
    int mapInNumbers[][];

    //Constructor
    public AdministradorDeCasillas(Mapa mapa){

        this.mapa = mapa;
        Casillas = new Casilla[numeroCasillasDistintas];
        this.mapInNumbers = new int[mapa.maxMapaColumnas][mapa.maxMapaFilas];

        getCasillaImage();
        loadMap("C:\\Users\\nicol\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\maps\\map01.txt");

    }


    //METODOS

    //Funcion para obtener las imagenes de cada Casilla de la carpeta
    public void getCasillaImage(){

        try {

            String[] tiposDeCasillas = {"grass.png", "wall.jpg", "water.png"}; //Fotos de cada tipo de casilla

            for(int i = 0; i < numeroCasillasDistintas; i++){ //Obtenemos las imagenes de cada tipo de casilla

                Casillas[i] = new Casilla();
                String imagePath = "C:\\Users\\nicol\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\images\\textures\\" + tiposDeCasillas[i];
                Casillas[i].image = ImageIO.read(new File(imagePath));

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
        int drawedCols = 0; 
        int drawedRows = 0;
        int x = 0;
        int y = 0;

        while(drawedCols < mapa.maxMapaColumnas && drawedRows < mapa.maxMapaFilas){ //Mientras que el numero de columnas dibujadas sea menor que el maximo numero de columnas del mapa y el numero de filas dibujadas sea menor que el maximo numero de filas del mapa

            int CasillaNum = mapInNumbers[drawedCols][drawedRows];//Tipo de Casilla correspondiente a cada 

            g2.drawImage(Casillas[CasillaNum].image, x, y, mapa.CasillaSizeEscalada, mapa.CasillaSizeEscalada, null); //Dibujamos una Casilla
            drawedCols++; //Incrementamos el contador de columnas dibujadas
            x += mapa.CasillaSizeEscalada; //Aumentamos la x para posicionarnos en las coordenadas donde tenemos que dibujar la siguiente casilla

            if(drawedCols == mapa.maxMapaColumnas){ //Si hemos llegado al maximo de columnas, Las reseteamos a 0 y pasamos a la siguiente fila

                //reseteamos las columnas dibujadas y la x
                drawedCols = 0;
                x = 0;
                //aumentamos las filas dibujadas y la y
                drawedRows++;
                y += mapa.CasillaSizeEscalada;

            }
        }

    }
}
