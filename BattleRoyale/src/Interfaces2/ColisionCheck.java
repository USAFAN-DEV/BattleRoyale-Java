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

    public int checkObject(Jugador jugador){

        int index = -1;
        //Revisar si es necesario crear un atributo de jugador para resetear el area de colision despues de calcular la del mapa, o puedo crear aqui una variable

        for(int i = 0; i < mapa.objetos.length; i++){

            if(mapa.objetos[i] != null){

                //Necesitamos la posicion del area de colision de la entidad en el mapa
                jugador.areaDeCollision.x = jugador.getMapaX() + jugador.areaDeCollision.x;
                jugador.areaDeCollision.y = jugador.getMapaY() + jugador.areaDeCollision.y;

                //Necesitamos la posicion del area de colision del objeto en el mapa
                //Realmente no haria falta hacer esto si la x y la y del objeto son 0,0, pero por si se da el caso de que un objeto no tenga 48x48 de area de colision, lo escribimos
                mapa.objetos[i].areaDeColision.x = mapa.objetos[i].mapaX + mapa.objetos[i].areaDeColision.x;
                mapa.objetos[i].areaDeColision.y = mapa.objetos[i].mapaY + mapa.objetos[i].areaDeColision.y;

                switch(jugador.direction){

                    case "up":
                        jugador.areaDeCollision.y -= jugador.speed;
                        if(jugador.areaDeCollision.intersects(mapa.objetos[i].areaDeColision)){

                            if(mapa.objetos[i].collision == true){
                                jugador.collisionEstado = true;
                            }
                            if(jugador instanceof Jugador){

                                index = i;

                            }

                        }
                        break;
                    case "down":
                        jugador.areaDeCollision.y += jugador.speed;
                        if(jugador.areaDeCollision.intersects(mapa.objetos[i].areaDeColision)){

                            if(mapa.objetos[i].collision == true){
                                jugador.collisionEstado = true;
                            }
                            if(jugador instanceof Jugador){

                                index = i;

                            }

                        }
                        break;
                    case "left":
                        jugador.areaDeCollision.x -= jugador.speed;
                        if(jugador.areaDeCollision.intersects(mapa.objetos[i].areaDeColision)){

                            if(mapa.objetos[i].collision == true){
                                jugador.collisionEstado = true;
                            }
                            if(jugador instanceof Jugador){

                                index = i;

                            }

                        }
                        break;
                    case "right":
                        jugador.areaDeCollision.x += jugador.speed;
                        if(jugador.areaDeCollision.intersects(mapa.objetos[i].areaDeColision)){

                            if(mapa.objetos[i].collision == true){
                                jugador.collisionEstado = true;
                            }
                            if(jugador instanceof Jugador){

                                index = i;

                            }

                        }
                        break;
                    default:
                    break;

                }

                jugador.areaDeCollision.x = jugador.areaDeColisionDefaultX;
                jugador.areaDeCollision.y = jugador.areaDeColisionDefaultY;
                mapa.objetos[i].areaDeColision.x = mapa.objetos[i].areaDeColisionDefaultX;
                mapa.objetos[i].areaDeColision.y = mapa.objetos[i].areaDeColisionDefaultY;

            }

        }

        return index;

    }

}
