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

        int areaDeColisionLeftCol = areaDeColisionLeftMapaX/mapa.getCasillaSizeEscalada();
        int areaDeColisionRightCol = areaDeColisionRightMapaX/mapa.getCasillaSizeEscalada();
        int areaDeColisionTopRow = areaDeColisionTopMapaY/mapa.getCasillaSizeEscalada();
        int areaDeColisionBottomRow = areaDeColisionBottomMapaY/mapa.getCasillaSizeEscalada();

        int casillaNum1, casillaNum2, decoracionNum1, decoracionNum2;

        switch (jugador.direction) {
            case "up":

                areaDeColisionTopRow = (areaDeColisionTopMapaY - jugador.getSpeed())/mapa.getCasillaSizeEscalada(); //Restamos la velocidad para predecir la posicion del jugador antes de que este se mueva. Si la posicion esta en contacto con alguna casilla solida el jugador no debera poder avanzar
                casillaNum1 = mapa.getAdministradorDeCasillas().mapInNumbers[areaDeColisionLeftCol][areaDeColisionTopRow];
                casillaNum2 = mapa.getAdministradorDeCasillas().mapInNumbers[areaDeColisionRightCol][areaDeColisionTopRow];

                if((decoracionNum1 = mapa.getAdministradorDeCasillas().decorationsInNumbers[areaDeColisionLeftCol][areaDeColisionTopRow]) < 0){
                    decoracionNum1 = 7;//Decoracion que no tiene colision = no hay decoracion
                }
                if((decoracionNum2 = mapa.getAdministradorDeCasillas().decorationsInNumbers[areaDeColisionRightCol][areaDeColisionTopRow]) < 0){
                    decoracionNum2 = 7;//Decoracion que no tiene colision = no hay decoracion
                }

                if(mapa.getAdministradorDeCasillas().casillas[casillaNum1].collision == true || mapa.getAdministradorDeCasillas().casillas[casillaNum2].collision == true){
                    jugador.collisionEstado = true;
                }
                else{

                    if(mapa.getAdministradorDeCasillas().decorations[decoracionNum1].collision == true || mapa.getAdministradorDeCasillas().decorations[decoracionNum2].collision == true){
                        jugador.collisionEstado = true;
                    }

                }
                
                break;
            case "down":

                areaDeColisionBottomRow = (areaDeColisionBottomMapaY + jugador.getSpeed())/mapa.getCasillaSizeEscalada();
                casillaNum1 = mapa.getAdministradorDeCasillas().mapInNumbers[areaDeColisionLeftCol][areaDeColisionBottomRow];
                casillaNum2 = mapa.getAdministradorDeCasillas().mapInNumbers[areaDeColisionRightCol][areaDeColisionBottomRow];
                
                if((decoracionNum1 = mapa.getAdministradorDeCasillas().decorationsInNumbers[areaDeColisionLeftCol][areaDeColisionBottomRow]) < 0){
                    decoracionNum1 = 7;//Decoracion que no tiene colision = no hay decoracion
                }
                if((decoracionNum2 = mapa.getAdministradorDeCasillas().decorationsInNumbers[areaDeColisionRightCol][areaDeColisionBottomRow]) < 0){
                    decoracionNum2 = 7;//Decoracion que no tiene colision = no hay decoracion
                }

                if(mapa.getAdministradorDeCasillas().casillas[casillaNum1].collision == true || mapa.getAdministradorDeCasillas().casillas[casillaNum2].collision == true){
                    jugador.collisionEstado = true;
                }
                else{

                    if(mapa.getAdministradorDeCasillas().decorations[decoracionNum1].collision == true || mapa.getAdministradorDeCasillas().decorations[decoracionNum2].collision == true){
                        jugador.collisionEstado = true;
                    }

                }

                break;
            case "left":

                areaDeColisionLeftCol = (areaDeColisionLeftMapaX - jugador.getSpeed())/mapa.getCasillaSizeEscalada(); 
                casillaNum1 = mapa.getAdministradorDeCasillas().mapInNumbers[areaDeColisionLeftCol][areaDeColisionTopRow];
                casillaNum2 = mapa.getAdministradorDeCasillas().mapInNumbers[areaDeColisionLeftCol][areaDeColisionBottomRow];
                
                if((decoracionNum1 = mapa.getAdministradorDeCasillas().decorationsInNumbers[areaDeColisionLeftCol][areaDeColisionTopRow]) < 0){
                    decoracionNum1 = 7;//Decoracion que no tiene colision = no hay decoracion
                }
                if((decoracionNum2 = mapa.getAdministradorDeCasillas().decorationsInNumbers[areaDeColisionLeftCol][areaDeColisionBottomRow]) < 0){
                    decoracionNum2 = 7;//Decoracion que no tiene colision = no hay decoracion
                }

                if(mapa.getAdministradorDeCasillas().casillas[casillaNum1].collision == true || mapa.getAdministradorDeCasillas().casillas[casillaNum2].collision == true){
                    jugador.collisionEstado = true;
                }
                else{

                    if(mapa.getAdministradorDeCasillas().decorations[decoracionNum1].collision == true || mapa.getAdministradorDeCasillas().decorations[decoracionNum2].collision == true){
                        jugador.collisionEstado = true;
                    }

                }

                break;
            case "right":
                
                areaDeColisionRightCol = (areaDeColisionRightMapaX + jugador.getSpeed())/mapa.getCasillaSizeEscalada(); 
                casillaNum1 = mapa.getAdministradorDeCasillas().mapInNumbers[areaDeColisionRightCol][areaDeColisionTopRow];
                casillaNum2 = mapa.getAdministradorDeCasillas().mapInNumbers[areaDeColisionRightCol][areaDeColisionBottomRow];
                
                if((decoracionNum1 = mapa.getAdministradorDeCasillas().decorationsInNumbers[areaDeColisionRightCol][areaDeColisionTopRow]) < 0){
                    decoracionNum1 = 7;//Decoracion que no tiene colision = no hay decoracion
                }
                if((decoracionNum2 = mapa.getAdministradorDeCasillas().decorationsInNumbers[areaDeColisionRightCol][areaDeColisionBottomRow]) < 0){
                    decoracionNum2 = 7;//Decoracion que no tiene colision = no hay decoracion
                }

                if(mapa.getAdministradorDeCasillas().casillas[casillaNum1].collision == true || mapa.getAdministradorDeCasillas().casillas[casillaNum2].collision == true){
                    jugador.collisionEstado = true;
                }
                else{

                    if(mapa.getAdministradorDeCasillas().decorations[decoracionNum1].collision == true || mapa.getAdministradorDeCasillas().decorations[decoracionNum2].collision == true){
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

        for(int i = 0; i < mapa.getObjetos().length; i++){

            if(mapa.getObjetos()[i] != null){

                //Necesitamos la posicion del area de colision de la entidad en el mapa
                jugador.areaDeCollision.x = jugador.getMapaX() + jugador.areaDeCollision.x;
                jugador.areaDeCollision.y = jugador.getMapaY() + jugador.areaDeCollision.y;

                //Necesitamos la posicion del area de colision del objeto en el mapa
                //Realmente no haria falta hacer esto si la x y la y del objeto son 0,0, pero por si se da el caso de que un objeto no tenga 48x48 de area de colision, lo escribimos
                mapa.getObjetos()[i].areaDeColision.x = mapa.getObjetos()[i].mapaX + mapa.getObjetos()[i].areaDeColision.x;
                mapa.getObjetos()[i].areaDeColision.y = mapa.getObjetos()[i].mapaY + mapa.getObjetos()[i].areaDeColision.y;

                switch(jugador.direction){

                    case "up":
                        jugador.areaDeCollision.y -= jugador.speed;
                        if(jugador.areaDeCollision.intersects(mapa.getObjetos()[i].areaDeColision)){

                            if(mapa.getObjetos()[i].collision == true){
                                jugador.collisionEstado = true;
                            }
                            if(jugador instanceof Personaje){

                                index = i;

                            }

                        }
                        break;
                    case "down":
                        jugador.areaDeCollision.y += jugador.speed;
                        if(jugador.areaDeCollision.intersects(mapa.getObjetos()[i].areaDeColision)){

                            if(mapa.getObjetos()[i].collision == true){
                                jugador.collisionEstado = true;
                            }
                            if(jugador instanceof Personaje){

                                index = i;

                            }

                        }
                        break;
                    case "left":
                        jugador.areaDeCollision.x -= jugador.speed;
                        if(jugador.areaDeCollision.intersects(mapa.getObjetos()[i].areaDeColision)){

                            if(mapa.getObjetos()[i].collision == true){
                                jugador.collisionEstado = true;
                            }
                            if(jugador instanceof Personaje){

                                index = i;

                            }

                        }
                        break;
                    case "right":
                        jugador.areaDeCollision.x += jugador.speed;
                        if(jugador.areaDeCollision.intersects(mapa.getObjetos()[i].areaDeColision)){

                            if(mapa.getObjetos()[i].collision == true){
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
                mapa.getObjetos()[i].areaDeColision.x = mapa.getObjetos()[i].areaDeColisionDefaultX;
                mapa.getObjetos()[i].areaDeColision.y = mapa.getObjetos()[i].areaDeColisionDefaultY;

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
        mapa.getJugador().areaDeCollision.x = mapa.getJugador().mapaX + mapa.getJugador().areaDeCollision.x;
        mapa.getJugador().areaDeCollision.y = mapa.getJugador().mapaY + mapa.getJugador().areaDeCollision.y;

        switch(bot.direction){

            case "up":
                bot.areaDeCollision.y -= bot.speed;
                if(bot.areaDeCollision.intersects(mapa.getJugador().areaDeCollision)){
                    bot.collisionEstado = true;
                }
                break;
            case "down":
                bot.areaDeCollision.y += bot.speed;
                if(bot.areaDeCollision.intersects(mapa.getJugador().areaDeCollision)){
                    bot.collisionEstado = true;
                }
                break;
            case "left":
                bot.areaDeCollision.x -= bot.speed;
                if(bot.areaDeCollision.intersects(mapa.getJugador().areaDeCollision)){
                    bot.collisionEstado = true;
                }
                break;
            case "right":
                bot.areaDeCollision.x += bot.speed;
                if(bot.areaDeCollision.intersects(mapa.getJugador().areaDeCollision)){
                    bot.collisionEstado = true;
                }
                break;
            default:
            break;

        }

        bot.areaDeCollision.x = bot.areaDeColisionDefaultX;
        bot.areaDeCollision.y = bot.areaDeColisionDefaultY;
        mapa.getJugador().areaDeCollision.x = mapa.getJugador().areaDeColisionDefaultX;
        mapa.getJugador().areaDeCollision.y = mapa.getJugador().areaDeColisionDefaultY;

    }

}
