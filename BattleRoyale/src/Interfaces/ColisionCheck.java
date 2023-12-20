package Interfaces;

import Entidades.Personaje;

public class ColisionCheck {
    
    Mapa mapa;

    public ColisionCheck(Mapa mapa){

        this.mapa = mapa;

    }

    public void checkCasilla(Personaje jugador){

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

    public int checkObject(Personaje jugador){

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
                            if(jugador instanceof Personaje){

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
                            if(jugador instanceof Personaje){

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
                            if(jugador instanceof Personaje){

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
                            if(jugador instanceof Personaje){

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

    public int checkBot(Personaje jugador, Personaje[] bots){

        int index = -1;
        //Revisar si es necesario crear un atributo de jugador para resetear el area de colision despues de calcular la del mapa, o puedo crear aqui una variable

        for(int i = 0; i < bots.length; i++){

            if(bots[i] != null){

                //Necesitamos la posicion del area de colision de la entidad en el mapa
                jugador.areaDeCollision.x = jugador.getMapaX() + jugador.areaDeCollision.x;
                jugador.areaDeCollision.y = jugador.getMapaY() + jugador.areaDeCollision.y;

                //Necesitamos la posicion del area de colision del objeto en el mapa
                //Realmente no haria falta hacer esto si la x y la y del objeto son 0,0, pero por si se da el caso de que un objeto no tenga 48x48 de area de colision, lo escribimos
                bots[i].areaDeCollision.x = bots[i].mapaX + bots[i].areaDeCollision.x;
                bots[i].areaDeCollision.y = bots[i].mapaY + bots[i].areaDeCollision.y;

                switch(jugador.direction){

                    case "up":
                        jugador.areaDeCollision.y -= jugador.speed;
                        if(jugador.areaDeCollision.intersects(bots[i].areaDeCollision)){
                            jugador.collisionEstado = true;
                            index = i;
                        }
                        break;
                    case "down":
                        jugador.areaDeCollision.y += jugador.speed;
                        if(jugador.areaDeCollision.intersects(bots[i].areaDeCollision)){
                            jugador.collisionEstado = true;
                            index = i;
                        }
                        break;
                    case "left":
                        jugador.areaDeCollision.x -= jugador.speed;
                        if(jugador.areaDeCollision.intersects(bots[i].areaDeCollision)){
                            jugador.collisionEstado = true;
                            index = i;
                        }
                        break;
                    case "right":
                        jugador.areaDeCollision.x += jugador.speed;
                        if(jugador.areaDeCollision.intersects(bots[i].areaDeCollision)){
                            jugador.collisionEstado = true;
                            index = i;
                        }
                        break;
                    default:
                    break;

                }

                jugador.areaDeCollision.x = jugador.areaDeColisionDefaultX;
                jugador.areaDeCollision.y = jugador.areaDeColisionDefaultY;
                bots[i].areaDeCollision.x = bots[i].areaDeColisionDefaultX;
                bots[i].areaDeCollision.y = bots[i].areaDeColisionDefaultY;

            }

        }

        return index;


    }

    public void checkPlayer(Personaje bot){

        //Necesitamos la posicion del area de colision de la entidad en el mapa
        bot.areaDeCollision.x = bot.getMapaX() + bot.areaDeCollision.x;
        bot.areaDeCollision.y = bot.getMapaY() + bot.areaDeCollision.y;

        //Necesitamos la posicion del area de colision del objeto en el mapa
        //Realmente no haria falta hacer esto si la x y la y del objeto son 0,0, pero por si se da el caso de que un objeto no tenga 48x48 de area de colision, lo escribimos
        mapa.player1.areaDeCollision.x = mapa.player1.mapaX + mapa.player1.areaDeCollision.x;
        mapa.player1.areaDeCollision.y = mapa.player1.mapaY + mapa.player1.areaDeCollision.y;

        switch(bot.direction){

            case "up":
                bot.areaDeCollision.y -= bot.speed;
                if(bot.areaDeCollision.intersects(mapa.player1.areaDeCollision)){
                    bot.collisionEstado = true;
                }
                break;
            case "down":
                bot.areaDeCollision.y += bot.speed;
                if(bot.areaDeCollision.intersects(mapa.player1.areaDeCollision)){
                    bot.collisionEstado = true;
                }
                break;
            case "left":
                bot.areaDeCollision.x -= bot.speed;
                if(bot.areaDeCollision.intersects(mapa.player1.areaDeCollision)){
                    bot.collisionEstado = true;
                }
                break;
            case "right":
                bot.areaDeCollision.x += bot.speed;
                if(bot.areaDeCollision.intersects(mapa.player1.areaDeCollision)){
                    bot.collisionEstado = true;
                }
                break;
            default:
            break;

        }

        bot.areaDeCollision.x = bot.areaDeColisionDefaultX;
        bot.areaDeCollision.y = bot.areaDeColisionDefaultY;
        mapa.player1.areaDeCollision.x = mapa.player1.areaDeColisionDefaultX;
        mapa.player1.areaDeCollision.y = mapa.player1.areaDeColisionDefaultY;

    }

}
