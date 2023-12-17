package Interfaces2;

import Personaje.Jugador;

public class ColisionCheck {
    
    Mapa mapa;

    public ColisionCheck(Mapa mapa){

        this.mapa = mapa;

    }

    public void checkCasilla(Jugador jugador){

        //Tendremos que checkear las cuatro esquinas del rectangulo areaDeColision del jugador y ver si alguna esta tocando con alguna casilla solida
        int areaDeColisionLeftMapaX = jugador.getMapaX() + jugador.getAreaDeColision().x;
        int areaDeColisionRightMapaX = jugador.getMapaX() + jugador.getAreaDeColision().x + jugador.getAreaDeColision().width;
        int areaDeColisionTopMapaY = jugador.getMapaY() + jugador.getAreaDeColision().y;
        int areaDeColisionBottomMapaY = jugador.getMapaY() + jugador.getAreaDeColision().y + jugador.getAreaDeColision().height;

        int areaDeColisionLeftCol = areaDeColisionLeftMapaX/mapa.casillaSizeEscalada;
        int areaDeColisionRightCol = areaDeColisionRightMapaX/mapa.casillaSizeEscalada;
        int areaDeColisionTopRow = areaDeColisionTopMapaY/mapa.casillaSizeEscalada;
        int areaDeColisionBottomRow = areaDeColisionBottomMapaY/mapa.casillaSizeEscalada;

        int casillaNum1, casillaNum2, decoracionNum1, decoracionNum2;

        switch (jugador.direction) {
            case "up":

                areaDeColisionTopRow = (areaDeColisionTopMapaY - jugador.getSpeed())/mapa.casillaSizeEscalada; //Restamos la velocidad para predecir la posicion del jugador antes de que este se mueva. Si la posicion esta en contacto con alguna casilla solida el jugador no debera poder avanzar
                casillaNum1 = mapa.administradorC.mapInNumbers[areaDeColisionLeftCol][areaDeColisionTopRow];
                casillaNum2 = mapa.administradorC.mapInNumbers[areaDeColisionRightCol][areaDeColisionTopRow];

                if((decoracionNum1 = mapa.administradorC.decorationsInNumbers[areaDeColisionLeftCol][areaDeColisionTopRow]) < 0){
                    decoracionNum1 = 7;//Decoracion que no tiene colision = no hay decoracion
                }
                if((decoracionNum2 = mapa.administradorC.decorationsInNumbers[areaDeColisionRightCol][areaDeColisionTopRow]) < 0){
                    decoracionNum2 = 7;//Decoracion que no tiene colision = no hay decoracion
                }

                if(mapa.administradorC.casillas[casillaNum1].collision == true || mapa.administradorC.casillas[casillaNum2].collision == true){
                    jugador.collisionEstado = true;
                }
                else{

                    if(mapa.administradorC.decorations[decoracionNum1].collision == true || mapa.administradorC.decorations[decoracionNum2].collision == true){
                        jugador.collisionEstado = true;
                    }

                }
                
                break;
            case "down":

                areaDeColisionBottomRow = (areaDeColisionBottomMapaY + jugador.getSpeed())/mapa.casillaSizeEscalada;
                casillaNum1 = mapa.administradorC.mapInNumbers[areaDeColisionLeftCol][areaDeColisionBottomRow];
                casillaNum2 = mapa.administradorC.mapInNumbers[areaDeColisionRightCol][areaDeColisionBottomRow];
                
                if((decoracionNum1 = mapa.administradorC.decorationsInNumbers[areaDeColisionLeftCol][areaDeColisionBottomRow]) < 0){
                    decoracionNum1 = 7;//Decoracion que no tiene colision = no hay decoracion
                }
                if((decoracionNum2 = mapa.administradorC.decorationsInNumbers[areaDeColisionRightCol][areaDeColisionBottomRow]) < 0){
                    decoracionNum2 = 7;//Decoracion que no tiene colision = no hay decoracion
                }

                if(mapa.administradorC.casillas[casillaNum1].collision == true || mapa.administradorC.casillas[casillaNum2].collision == true){
                    jugador.collisionEstado = true;
                }
                else{

                    if(mapa.administradorC.decorations[decoracionNum1].collision == true || mapa.administradorC.decorations[decoracionNum2].collision == true){
                        jugador.collisionEstado = true;
                    }

                }

                break;
            case "left":

                areaDeColisionLeftCol = (areaDeColisionLeftMapaX - jugador.getSpeed())/mapa.casillaSizeEscalada; 
                casillaNum1 = mapa.administradorC.mapInNumbers[areaDeColisionLeftCol][areaDeColisionTopRow];
                casillaNum2 = mapa.administradorC.mapInNumbers[areaDeColisionLeftCol][areaDeColisionBottomRow];
                
                if((decoracionNum1 = mapa.administradorC.decorationsInNumbers[areaDeColisionLeftCol][areaDeColisionTopRow]) < 0){
                    decoracionNum1 = 7;//Decoracion que no tiene colision = no hay decoracion
                }
                if((decoracionNum2 = mapa.administradorC.decorationsInNumbers[areaDeColisionLeftCol][areaDeColisionBottomRow]) < 0){
                    decoracionNum2 = 7;//Decoracion que no tiene colision = no hay decoracion
                }

                if(mapa.administradorC.casillas[casillaNum1].collision == true || mapa.administradorC.casillas[casillaNum2].collision == true){
                    jugador.collisionEstado = true;
                }
                else{

                    if(mapa.administradorC.decorations[decoracionNum1].collision == true || mapa.administradorC.decorations[decoracionNum2].collision == true){
                        jugador.collisionEstado = true;
                    }

                }

                break;
            case "right":
                
                areaDeColisionRightCol = (areaDeColisionRightMapaX + jugador.getSpeed())/mapa.casillaSizeEscalada; 
                casillaNum1 = mapa.administradorC.mapInNumbers[areaDeColisionRightCol][areaDeColisionTopRow];
                casillaNum2 = mapa.administradorC.mapInNumbers[areaDeColisionRightCol][areaDeColisionBottomRow];
                
                if((decoracionNum1 = mapa.administradorC.decorationsInNumbers[areaDeColisionRightCol][areaDeColisionTopRow]) < 0){
                    decoracionNum1 = 7;//Decoracion que no tiene colision = no hay decoracion
                }
                if((decoracionNum2 = mapa.administradorC.decorationsInNumbers[areaDeColisionRightCol][areaDeColisionBottomRow]) < 0){
                    decoracionNum2 = 7;//Decoracion que no tiene colision = no hay decoracion
                }

                if(mapa.administradorC.casillas[casillaNum1].collision == true || mapa.administradorC.casillas[casillaNum2].collision == true){
                    jugador.collisionEstado = true;
                }
                else{

                    if(mapa.administradorC.decorations[decoracionNum1].collision == true || mapa.administradorC.decorations[decoracionNum2].collision == true){
                        jugador.collisionEstado = true;
                    }

                }

                break;
            default:
                break;
        }

    }

}
