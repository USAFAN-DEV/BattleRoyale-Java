package Main;

import Entidades.Entidad;

public class ColisionCheck {
    
    private Mapa mapa;

    public ColisionCheck(Mapa mapa){

        this.mapa = mapa;

    }

    public void checkCasilla(Entidad jugador){

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

        switch (jugador.getDirection()) {
            case "up":

                areaDeColisionTopRow = (areaDeColisionTopMapaY - jugador.getSpeed())/mapa.getCasillaSizeEscalada(); //Restamos la velocidad para predecir la posicion del jugador antes de que este se mueva. Si la posicion esta en contacto con alguna casilla solida el jugador no debera poder avanzar
                casillaNum1 = mapa.getAdministradorDeCasillas().getMapInNumbers()[areaDeColisionLeftCol][areaDeColisionTopRow];
                casillaNum2 = mapa.getAdministradorDeCasillas().getMapInNumbers()[areaDeColisionRightCol][areaDeColisionTopRow];

                if((decoracionNum1 = mapa.getAdministradorDeCasillas().getDecorationsInNumbers()[areaDeColisionLeftCol][areaDeColisionTopRow]) < 0){
                    decoracionNum1 = 7;//Decoracion que no tiene colision = no hay decoracion
                }
                if((decoracionNum2 = mapa.getAdministradorDeCasillas().getDecorationsInNumbers()[areaDeColisionRightCol][areaDeColisionTopRow]) < 0){
                    decoracionNum2 = 7;//Decoracion que no tiene colision = no hay decoracion
                }

                if(mapa.getAdministradorDeCasillas().getCasillas()[casillaNum1].getCasillaCollision() == true || mapa.getAdministradorDeCasillas().getCasillas()[casillaNum2].getCasillaCollision() == true){
                    jugador.setColisionEstado(true);
                }
                else{

                    if(mapa.getAdministradorDeCasillas().getDecorations()[decoracionNum1].getCasillaCollision() == true || mapa.getAdministradorDeCasillas().getDecorations()[decoracionNum2].getCasillaCollision() == true){
                        jugador.setColisionEstado(true);
                    }

                }
                
                break;
            case "down":

                areaDeColisionBottomRow = (areaDeColisionBottomMapaY + jugador.getSpeed())/mapa.getCasillaSizeEscalada();
                casillaNum1 = mapa.getAdministradorDeCasillas().getMapInNumbers()[areaDeColisionLeftCol][areaDeColisionBottomRow];
                casillaNum2 = mapa.getAdministradorDeCasillas().getMapInNumbers()[areaDeColisionRightCol][areaDeColisionBottomRow];
                
                if((decoracionNum1 = mapa.getAdministradorDeCasillas().getDecorationsInNumbers()[areaDeColisionLeftCol][areaDeColisionBottomRow]) < 0){
                    decoracionNum1 = 7;//Decoracion que no tiene colision = no hay decoracion
                }
                if((decoracionNum2 = mapa.getAdministradorDeCasillas().getDecorationsInNumbers()[areaDeColisionRightCol][areaDeColisionBottomRow]) < 0){
                    decoracionNum2 = 7;//Decoracion que no tiene colision = no hay decoracion
                }

                if(mapa.getAdministradorDeCasillas().getCasillas()[casillaNum1].getCasillaCollision() == true || mapa.getAdministradorDeCasillas().getCasillas()[casillaNum2].getCasillaCollision() == true){
                    jugador.setColisionEstado(true);
                }
                else{

                    if(mapa.getAdministradorDeCasillas().getDecorations()[decoracionNum1].getCasillaCollision() == true || mapa.getAdministradorDeCasillas().getDecorations()[decoracionNum2].getCasillaCollision() == true){
                        jugador.setColisionEstado(true);
                    }

                }

                break;
            case "left":

                areaDeColisionLeftCol = (areaDeColisionLeftMapaX - jugador.getSpeed())/mapa.getCasillaSizeEscalada(); 
                casillaNum1 = mapa.getAdministradorDeCasillas().getMapInNumbers()[areaDeColisionLeftCol][areaDeColisionTopRow];
                casillaNum2 = mapa.getAdministradorDeCasillas().getMapInNumbers()[areaDeColisionLeftCol][areaDeColisionBottomRow];
                
                if((decoracionNum1 = mapa.getAdministradorDeCasillas().getDecorationsInNumbers()[areaDeColisionLeftCol][areaDeColisionTopRow]) < 0){
                    decoracionNum1 = 7;//Decoracion que no tiene colision = no hay decoracion
                }
                if((decoracionNum2 = mapa.getAdministradorDeCasillas().getDecorationsInNumbers()[areaDeColisionLeftCol][areaDeColisionBottomRow]) < 0){
                    decoracionNum2 = 7;//Decoracion que no tiene colision = no hay decoracion
                }

                if(mapa.getAdministradorDeCasillas().getCasillas()[casillaNum1].getCasillaCollision() == true || mapa.getAdministradorDeCasillas().getCasillas()[casillaNum2].getCasillaCollision() == true){
                    jugador.setColisionEstado(true);
                }
                else{

                    if(mapa.getAdministradorDeCasillas().getDecorations()[decoracionNum1].getCasillaCollision() == true || mapa.getAdministradorDeCasillas().getDecorations()[decoracionNum2].getCasillaCollision() == true){
                        jugador.setColisionEstado(true);
                    }

                }

                break;
            case "right":
                
                areaDeColisionRightCol = (areaDeColisionRightMapaX + jugador.getSpeed())/mapa.getCasillaSizeEscalada(); 
                casillaNum1 = mapa.getAdministradorDeCasillas().getMapInNumbers()[areaDeColisionRightCol][areaDeColisionTopRow];
                casillaNum2 = mapa.getAdministradorDeCasillas().getMapInNumbers()[areaDeColisionRightCol][areaDeColisionBottomRow];
                
                if((decoracionNum1 = mapa.getAdministradorDeCasillas().getDecorationsInNumbers()[areaDeColisionRightCol][areaDeColisionTopRow]) < 0){
                    decoracionNum1 = 7;//Decoracion que no tiene colision = no hay decoracion
                }
                if((decoracionNum2 = mapa.getAdministradorDeCasillas().getDecorationsInNumbers()[areaDeColisionRightCol][areaDeColisionBottomRow]) < 0){
                    decoracionNum2 = 7;//Decoracion que no tiene colision = no hay decoracion
                }

                if(mapa.getAdministradorDeCasillas().getCasillas()[casillaNum1].getCasillaCollision() == true || mapa.getAdministradorDeCasillas().getCasillas()[casillaNum2].getCasillaCollision() == true){
                    jugador.setColisionEstado(true);
                }
                else{

                    if(mapa.getAdministradorDeCasillas().getDecorations()[decoracionNum1].getCasillaCollision() == true || mapa.getAdministradorDeCasillas().getDecorations()[decoracionNum2].getCasillaCollision() == true){
                        jugador.setColisionEstado(true);
                    }

                }

                break;
            default:
                break;
        }

    }

    public int checkObject(Entidad jugador){

        int index = -1;

        for(int i = 0; i < mapa.getObjetos().length; i++){

            if(mapa.getObjetos()[i] != null){

                //Necesitamos la posicion del area de colision de la entidad en el mapa
                jugador.getAreaDeColision().x = jugador.getMapaX() + jugador.getAreaDeColision().x;
                jugador.getAreaDeColision().y = jugador.getMapaY() + jugador.getAreaDeColision().y;

                //Necesitamos la posicion del area de colision del objeto en el mapa
                //Realmente no haria falta hacer esto si la x y la y del objeto son 0,0, pero por si se da el caso de que un objeto no tenga 48x48 de area de colision, lo escribimos
                mapa.getObjetos()[i].getAreaDeColision().x = mapa.getObjetos()[i].getMapaX() + mapa.getObjetos()[i].getAreaDeColision().x;
                mapa.getObjetos()[i].getAreaDeColision().y = mapa.getObjetos()[i].getMapaY() + mapa.getObjetos()[i].getAreaDeColision().y;

                switch(jugador.getDirection()){

                    case "up":
                        jugador.getAreaDeColision().y -= jugador.getSpeed();
                        if(jugador.getAreaDeColision().intersects(mapa.getObjetos()[i].getAreaDeColision())){

                            if(mapa.getObjetos()[i].getColision() == true){
                                jugador.setColisionEstado(true);
                            }
                            if(jugador instanceof Entidad){

                                index = i;

                            }

                        }
                        break;
                    case "down":
                        jugador.getAreaDeColision().y += jugador.getSpeed();
                        if(jugador.getAreaDeColision().intersects(mapa.getObjetos()[i].getAreaDeColision())){

                            if(mapa.getObjetos()[i].getColision() == true){
                                jugador.setColisionEstado(true);
                            }
                            if(jugador instanceof Entidad){

                                index = i;

                            }

                        }
                        break;
                    case "left":
                        jugador.getAreaDeColision().x -= jugador.getSpeed();
                        if(jugador.getAreaDeColision().intersects(mapa.getObjetos()[i].getAreaDeColision())){

                            if(mapa.getObjetos()[i].getColision() == true){
                                jugador.setColisionEstado(true);
                            }
                            if(jugador instanceof Entidad){

                                index = i;

                            }

                        }
                        break;
                    case "right":
                        jugador.getAreaDeColision().x += jugador.getSpeed();
                        if(jugador.getAreaDeColision().intersects(mapa.getObjetos()[i].getAreaDeColision())){

                            if(mapa.getObjetos()[i].getColision() == true){
                                jugador.setColisionEstado(true);
                            }
                            if(jugador instanceof Entidad){

                                index = i;

                            }

                        }
                        break;
                    default:
                    break;

                }

                jugador.getAreaDeColision().x = jugador.getAreaDeColisionDefaultX();
                jugador.getAreaDeColision().y = jugador.getAreaDeColisionDefaultY();
                mapa.getObjetos()[i].getAreaDeColision().x = mapa.getObjetos()[i].getAreaDeColisionDefaultX();
                mapa.getObjetos()[i].getAreaDeColision().y = mapa.getObjetos()[i].getAreaDeColisionDefaultY();

            }

        }

        return index;

    }

    public int checkBot(Entidad jugador, Entidad[] bots){

        int index = -1;

        for(int i = 0; i < bots.length; i++){

            if(bots[i] != null){

                jugador.getAreaDeColision().x = jugador.getMapaX() + jugador.getAreaDeColision().x;
                jugador.getAreaDeColision().y = jugador.getMapaY() + jugador.getAreaDeColision().y;

                bots[i].getAreaDeColision().x = bots[i].getMapaX() + bots[i].getAreaDeColision().x;
                bots[i].getAreaDeColision().y = bots[i].getMapaY() + bots[i].getAreaDeColision().y;

                switch(jugador.getDirection()){

                    case "up":
                        jugador.getAreaDeColision().y -= jugador.getSpeed();
                        if(jugador.getAreaDeColision().intersects(bots[i].getAreaDeColision())){
                            jugador.setColisionEstado(true);
                            index = i;
                        }
                        break;
                    case "down":
                        jugador.getAreaDeColision().y += jugador.getSpeed();
                        if(jugador.getAreaDeColision().intersects(bots[i].getAreaDeColision())){
                            jugador.setColisionEstado(true);
                            index = i;
                        }
                        break;
                    case "left":
                        jugador.getAreaDeColision().x -= jugador.getSpeed();
                        if(jugador.getAreaDeColision().intersects(bots[i].getAreaDeColision())){
                            jugador.setColisionEstado(true);
                            index = i;
                        }
                        break;
                    case "right":
                        jugador.getAreaDeColision().x += jugador.getSpeed();
                        if(jugador.getAreaDeColision().intersects(bots[i].getAreaDeColision())){
                            jugador.setColisionEstado(true);
                            index = i;
                        }
                        break;
                    default:
                    break;

                }

                jugador.getAreaDeColision().x = jugador.getAreaDeColisionDefaultX();
                jugador.getAreaDeColision().y = jugador.getAreaDeColisionDefaultY();
                bots[i].getAreaDeColision().x = bots[i].getAreaDeColisionDefaultX();
                bots[i].getAreaDeColision().y = bots[i].getAreaDeColisionDefaultY();

            }

        }

        return index;


    }

    public void checkPlayer(Entidad bot){

        bot.getAreaDeColision().x = bot.getMapaX() + bot.getAreaDeColision().x;
        bot.getAreaDeColision().y = bot.getMapaY() + bot.getAreaDeColision().y;

        mapa.getJugador().getAreaDeColision().x = mapa.getJugador().getMapaX() + mapa.getJugador().getAreaDeColision().x;
        mapa.getJugador().getAreaDeColision().y = mapa.getJugador().getMapaY() + mapa.getJugador().getAreaDeColision().y;

        switch(bot.getDirection()){

            case "up":
                bot.getAreaDeColision().y -= bot.getSpeed();
                if(bot.getAreaDeColision().intersects(mapa.getJugador().getAreaDeColision())){
                    bot.setColisionEstado(true);
                }
                break;
            case "down":
                bot.getAreaDeColision().y += bot.getSpeed();
                if(bot.getAreaDeColision().intersects(mapa.getJugador().getAreaDeColision())){
                    bot.setColisionEstado(true);
                }
                break;
            case "left":
                bot.getAreaDeColision().x -= bot.getSpeed();
                if(bot.getAreaDeColision().intersects(mapa.getJugador().getAreaDeColision())){
                    bot.setColisionEstado(true);
                }
                break;
            case "right":
                bot.getAreaDeColision().x += bot.getSpeed();
                if(bot.getAreaDeColision().intersects(mapa.getJugador().getAreaDeColision())){
                    bot.setColisionEstado(true);
                }
                break;
            default:
            break;

        }

        bot.getAreaDeColision().x = bot.getAreaDeColisionDefaultX();
        bot.getAreaDeColision().y = bot.getAreaDeColisionDefaultY();
        mapa.getJugador().getAreaDeColision().x = mapa.getJugador().getAreaDeColisionDefaultX();
        mapa.getJugador().getAreaDeColision().y = mapa.getJugador().getAreaDeColisionDefaultY();

    }

}
