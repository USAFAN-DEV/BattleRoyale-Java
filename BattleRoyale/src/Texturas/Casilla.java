package Texturas;

import java.awt.image.BufferedImage;

public class Casilla {
    protected BufferedImage image;
    private boolean colision = false;

    public void setCasillaCollision(boolean colision){
        this.colision = colision;
    }
    public boolean getCasillaCollision(){
        return this.colision;
    }

}


