package Sound;

import  java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Musica {
    
    Clip clip;
    File musicaPaths[] = new File[2];

    public Musica(){

        try {
            musicaPaths[0] = new File("./BattleRoyale-Java/BattleRoyale/sound/musicaMapa.wav");
            musicaPaths[1] = new File("./BattleRoyale-Java/BattleRoyale/sound/musicaCombate.wav");
        } catch (Exception e) {e.printStackTrace();}
         
    }

    public void setupMusica(int i){

        System.out.println(musicaPaths[i]);
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(musicaPaths[i].toURI().toURL());  
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {e.printStackTrace();}

    }

    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }

}


