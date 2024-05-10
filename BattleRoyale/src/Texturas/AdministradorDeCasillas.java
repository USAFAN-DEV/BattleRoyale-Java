package Texturas;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.Mapa;

public class AdministradorDeCasillas {

    //Constantes
    final int numeroCasillasDistintas = 32; //Numero de fotos de Casillas diferentes
    final int numeroDecoracionesDistintas = 130;
    
    //Atributos
    private Mapa mapa;
    private Casilla[] casillas;
    private Casilla[] decorations;
    private int mapInNumbers[][];
    private int decorationsInNumbers[][];

    //Constructor
    public AdministradorDeCasillas(Mapa mapa){

        this.mapa = mapa;
        casillas = new Casilla[numeroCasillasDistintas];
        decorations = new Casilla[numeroDecoracionesDistintas];
        this.mapInNumbers = new int[mapa.getMaxMapaColumnas()][mapa.getMaxMapaFilas()];
        this.decorationsInNumbers = new int[mapa.getMaxMapaColumnas()][mapa.getMaxMapaFilas()];

        getCasillaImage();
        getCasillaCollision();
        getDecorationImage();
        getDecorationCollision();
        loadMap("./BattleRoyale-Java/BattleRoyale/maps/map01.txt", mapInNumbers);
        loadMap("./BattleRoyale-Java/BattleRoyale/maps/map02.txt", decorationsInNumbers);

    }

    public Casilla[] getCasillas(){
        return this.casillas;
    }
    public Casilla[] getDecorations(){
        return this.decorations;
    }
    public int[][] getMapInNumbers(){
        return this.mapInNumbers;
    }
    public int[][] getDecorationsInNumbers(){
        return this.decorationsInNumbers;
    }


    //METODOS

    //Funcion para obtener las imagenes de cada Casilla de la carpeta
    public void getCasillaImage(){

        try {

            
            String[] tiposDeCasillas = {"grass.png", "water.png", "water2.png", "water-sand.png", "water-sand2.png", "sand.png", "ground-water-down.png", "ground-water-down-left.png", "ground-water-left.png", "ground-water-top-left.png", "ground-water-top.png", "ground-water-top-right.png", "ground-water-right.png", "ground-water-down-right.png", "snow1.png", "snow2.png", "snow3.png", "snow4.png", "ground-water-left-snow.png", "ground-water-top-left-snow.png", "ground-water-top-snow.png", "ground-water-top-right-snow.png", "ground-water-right-snow.png", "ground-water-down-snow.png", "ground-water-down-left-snow.png", "ground-water-down-right-snow.png", "ground-water-down-left-sand.png", "ground-water-left-sand.png", "ground-water-top-left-sand.png", "ground-water-top-sand.png", "ground-water-down-sand.png", "suelo-templo.png"}; //Fotos de cada tipo de casilla

            for(int i = 0; i < numeroCasillasDistintas; i++){ //Obtenemos las imagenes de cada tipo de casilla

                casillas[i] = new Casilla();
                String imagePath = "./BattleRoyale-Java/BattleRoyale/images/textures/" + tiposDeCasillas[i];
                casillas[i].image = ImageIO.read(new File(imagePath));

            }

        } catch (IOException e) {e.printStackTrace();}

    }

    public void getCasillaCollision(){

        try {

            BufferedReader in = new BufferedReader(new FileReader("./BattleRoyale-Java/BattleRoyale/maps/casillasCollision.txt"));
            String linea;
            String[] lineaParseada;

            for(int i = 0; i < numeroCasillasDistintas; i++){

                linea = in.readLine();
                lineaParseada = linea.split(",");

                if("true".equalsIgnoreCase(lineaParseada[1].trim())){
                    casillas[i].setCasillaCollision(true);
                }

            }

            in.close();
            
        } catch (Exception e) {e.printStackTrace();}
        
    }

    public void getDecorationImage(){

         try {

            String[] tiposDeDecorations = {"tree-winter.png", "tree-winter-cut.png", "house.png", "castle-topleft.png", "castle-topright.png", "castle-bottomleft.png", "castle-bottomright.png", "bridge-topleft.png", "bridge-topright.png", "bridge-centerleft.png", "bridge-centerright.png", "bridge-bottomleft.png", "bridge-bottomright.png", "bridge-center.png", "bridge-topleft-hor.png", "bridge-bottomleft-hor.png", "bridge-centertop-hor.png", "bridge-centerbottom-hor.png", "bridge-center-hor.png", "bridge-topright-hor.png", "bridge-bottomright-hor.png", "rock-winter1.png", "rock-winter2.png", "tumba.png", "mina.png", "tree.png", "trigo.png", "rock1.png", "rock2.png", "muralla-hor.png", "muralla-vert.png", "muralla-torre.png", "cuartel-topleft.png", "cuartel-topright.png", "cuartel-bottomleft.png", "cuartel-bottomright.png", "cuartel-casa.png", "cuartel-estatua.png", "cuartel-lanzas.png", "cuartel-barracones1.png", "cuartel-barracones2.png", "iglesia.png", "market1.png", "market2.png", "market3.png", "cartel.png", "pozo.png", "taberna.png", "tienda-vida-escudos.png", "tree-winter-dead.png", "portal.png", "cuartel-casa-guerreros.png", "hacha1.png", "hacha2.png", "tree-coconut.png", "cactus.png", "planta-desierto.png", "castle-sand-topleft.png", "castle-sand-topright.png", "castle-sand-bottomleft.png", "castle-sand-bottomright.png", "house-sand.png", "wall-bottom-temple1.png", "wall-bottom-temple2.png", "wall-bottom-temple3.png", "wall-bottom-temple4.png", "wall-bottom-temple5.png", "wall-bottom-temple6.png", "wall-bottom-temple7.png", "wall-bottom-temple8.png", "wall-bottom-temple9.png", "wall-bottom-temple10.png", "wall-bottom-temple11.png", "wall-bottom-temple12.png", "wall-bottom-temple13.png", "wall-bottom-temple14.png", "wall-bottom-temple15.png", "wall-bottom-temple16.png", "esquina-left-temple1.png", "esquina-left-temple2.png", "esquina-left-temple3.png", "esquina-left-temple4.png", "wall-left-temple1.png", "wall-left-temple2.png", "wall-left-temple3.png", "wall-left-temple4.png", "wall-left-temple5.png", "wall-left-temple6.png", "esquina-topleft-temple1.png", "esquina-topleft-temple2.png", "esquina-topleft-temple3.png", "esquina-topleft-temple4.png", "esquina-topright-temple1.png", "esquina-topright-temple2.png", "esquina-topright-temple3.png", "esquina-topright-temple4.png", "wall-right-temple1.png", "wall-right-temple2.png", "wall-right-temple3.png", "wall-right-temple4.png", "wall-right-temple5.png", "wall-right-temple6.png", "esquina-right-temple1.png", "esquina-right-temple2.png", "esquina-right-temple3.png", "esquina-right-temple4.png", "estatua-diosa1.png", "estatua-diosa2.png", "estatua-diosa3.png", "estatua-diosa4.png", "estatua-diosa5.png", "estatua-diosa6.png", "estatua-diosa7.png", "estatua-diosa8.png", "banco-down1.png", "banco-down2.png", "banco-down3.png", "banco-down4.png", "pilar-templo1.png", "pilar-templo2.png", "pilar-templo3.png", "pilar-templo4.png", "pilar-templo5.png", "pilar-templo6.png", "pilar-templo7.png", "pilar-templo8.png", "invocacion-templo1.png", "invocacion-templo2.png", "invocacion-templo3.png", "invocacion-templo4.png"}; //Fotos de cada tipo de decoracion

            for(int i = 0; i < numeroDecoracionesDistintas; i++){ //Obtenemos las imagenes de cada tipo de casilla

                decorations[i] = new Casilla();
                String imagePath = "./BattleRoyale-Java/BattleRoyale/images/decorations/" + tiposDeDecorations[i];
                decorations[i].image = ImageIO.read(new File(imagePath));
            }

        } catch (IOException e) {e.printStackTrace();}

    }

    
    public void getDecorationCollision(){

        try {

            BufferedReader in = new BufferedReader(new FileReader("./BattleRoyale-Java/BattleRoyale/maps/decoracionesCollision.txt"));
            String linea;
            String[] lineaParseada;

            for(int i = 0; i < numeroDecoracionesDistintas; i++){

                linea = in.readLine();
                lineaParseada = linea.split(",");

                if("true".equalsIgnoreCase(lineaParseada[1].trim())){
                    decorations[i].setCasillaCollision(true);
                }

                //System.out.println(decorations[i].collision);
                
            }

            in.close();
            
        } catch (Exception e) {e.printStackTrace();}
        
    }

    public void loadMap(String filePath, int[][] fileInNumbers){

        try {
            
            BufferedReader in = new BufferedReader(new FileReader(filePath)); //Creamos un buffered reader para leer el archivo en el que se encuentra la distribucion de las diferentes Casillas en nuestro mapa
            int col = 0;
            int row = 0;

            while(col < mapa.getMaxMapaColumnas() && row < mapa.getMaxMapaFilas()){ //Mientras col y row no superen el numero maximo de columnas y filas del mapa

                String linea = in.readLine(); //Leemos una linea

                while(col < mapa.getMaxMapaColumnas()){ //Vamos cogiendo los numeros de la linea y los guardamos en nuestra matriz mapInNumbers

                    String numbers[] = linea.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    fileInNumbers[col][row] = num;
                    col++;

                }

                if(col == mapa.getMaxMapaColumnas()){ //Cuando llegamos al final de la fila, pasamos a la siguiente

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

        while(drawedMapaCols < mapa.getMaxMapaColumnas() && drawedMapaRows < mapa.getMaxMapaFilas()){ //Mientras que el numero de columnas dibujadas sea menor que el maximo numero de columnas del mapa y el numero de filas dibujadas sea menor que el maximo numero de filas del mapa

            int casillaNum = mapInNumbers[drawedMapaCols][drawedMapaRows];//Tipo de Casilla correspondiente a cada 
            int decorationNum = decorationsInNumbers[drawedMapaCols][drawedMapaRows];//Tipo de Casilla correspondiente a cada 

            int mapaX = drawedMapaCols * mapa.getCasillaSizeEscalada(); //coordenada x de la casilla en el mapa
            int mapaY = drawedMapaRows * mapa.getCasillaSizeEscalada(); //coordenada y de la casilla en el mapa
            int screenX = mapaX - mapa.getJugador().getMapaX() + mapa.getJugador().getScreenX(); //coordenada x de la casilla en la pantalla
            int screenY = mapaY - mapa.getJugador().getMapaY() + mapa.getJugador().getScreenY(); //coordenada y de la casilla en la pantalla

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
            if((mapaX + mapa.getCasillaSizeEscalada() > mapa.getJugador().getMapaX() - mapa.getJugador().getScreenX() && mapaX - mapa.getCasillaSizeEscalada() < mapa.getJugador().getMapaX() + mapa.getJugador().getScreenX()) && (mapaY + mapa.getCasillaSizeEscalada() > mapa.getJugador().getMapaY() - mapa.getJugador().getScreenY() && mapaY - mapa.getCasillaSizeEscalada() < mapa.getJugador().getMapaY() + mapa.getJugador().getScreenY())){

                g2.drawImage(casillas[casillaNum].image, screenX, screenY, mapa.getCasillaSizeEscalada(), mapa.getCasillaSizeEscalada(), null); //Dibujamos una Casilla
                
                if(decorationNum >=0){

                    g2.drawImage(decorations[decorationNum].image, screenX, screenY, mapa.getCasillaSizeEscalada(), mapa.getCasillaSizeEscalada(), null);

                }

            }

            drawedMapaCols++; //Incrementamos el contador de columnas dibujadas

            if(drawedMapaCols == mapa.getMaxMapaColumnas()){ //Si hemos llegado al maximo de columnas, Las reseteamos a 0 y pasamos a la siguiente fila

                //reseteamos las columnas dibujadas y la x
                drawedMapaCols = 0;
                //aumentamos las filas dibujadas y la y
                drawedMapaRows++;

            }
        }

    }

}

