package Entidades.PersonajeHealer;

import Entidades.Personaje;
import Interfaces.KeyHandler;
import Interfaces.Mapa;

public class Qiqi extends Personaje{
    private int revivir;

    //Constructor
    public Qiqi(Mapa mapa, KeyHandler keyHandler){

        super(150,150,15,0,100,0.25,0.25,"Healer","Qiqi","Preserver of Fortune",mapa.casillaSizeEscalada * 50, mapa.casillaSizeEscalada * 38, mapa);
        this.keyHandler = keyHandler;
        getPlayerImage();
        setRevivir(0);

    }

    //getters y setters del hijo
    public int getRevivir(){
        return revivir;
    }
    public void setRevivir(int revivir){
        this.revivir=revivir;
    }

    //METODOS
    public String getPlayerGif(){
        return "./BattleRoyale-Java/BattleRoyale/images/player/qiqi.gif";
    }
    public void getPlayerImage(){
        /*try {
            System.out.println("Image loading started");
            characterImage = ImageIO.read(new File("C:\\Users\\nicol\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\images\\player\\qiqi.png"));
            System.out.println("Image loading ended");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
    //declaracion de la habilidad y que estadisticas va a modificar
    public void usarHabilidad(Personaje jugador){
        //necesito mas clases porque tengo que cambiar sus estadisticas 
        //revive a una persona
        if(super.getVida()==0 && getRevivir()==0){
            System.out.println("Qiqi ha revivido y tiene 100 de vida\n");
            setRevivir(1);
            super.setVida(100);
        } 
        else{
            System.out.println("Error. La habilidad ya se ha utilizado");
        }    
    }

    //descripcion de la habilidad
    public String descripcionHabilidad(){
        String descHabilidad = "Qiqi se revive a si misma con el 100 de la vida.\nSe puede usar una vez por combate";
        return descHabilidad;
        
    }

    @Override
    public void getCharacterImage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCharacterImage'");
    }
}
