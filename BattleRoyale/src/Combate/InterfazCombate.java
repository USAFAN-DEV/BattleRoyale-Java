package Combate;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Combate.MetodoCombate;
import Entidades.Personaje;
import Interfaces.Mapa;
import Sound.Musica;

public class InterfazCombate extends JPanel implements ActionListener{
    public MetodoCombate jugadores;
    public int cooldownHabilidad;
    public JTextField vidaJugador1;
    public JTextField vidaJugador2;
    public JTextField escudoJugador1;
    public JTextField escudoJugador2;
    public int turnos;
    public JTextField turno;
    public JButton botonHabilidad;
    public Musica musica;
    public JFrame frameC;

    public InterfazCombate(Personaje jugador1,Personaje jugador2, JFrame frameC){
        //fondo
        JLabel fondo2=new JLabel();
        fondo2.setBounds(0,0,850,750);
        fondo2.setIcon(new ImageIcon("./BattleRoyale-Java/BattleRoyale/images/player/background2.gif"));
        add(fondo2,3,0);
        
        JLabel fondo=new JLabel();
        fondo.setBounds(-80,0,850,750);
        fondo.setIcon(new ImageIcon("./BattleRoyale-Java/BattleRoyale/images/player/background.png"));
        add(fondo,2,0);

        //Musica 
        musica=new Musica();
        
        turnos=1;
        setLayout(null);
        //declaracion del boton de Ataque
        JButton botonAtaque=new JButton("Atacar"); 
        botonAtaque.setBounds(550,500,250,50);
        botonAtaque.addActionListener(this);
        //declaracion del boton de habilidad
        botonHabilidad=new JButton("Habilidad"); 
        botonHabilidad.setBounds(550,550,250,50);
        botonHabilidad.addActionListener(this);
        //declaracion del boton de pocion
        JButton botonPocion=new JButton("Pocion");
        botonPocion.setBounds(550,600,250,50);
        botonPocion.addActionListener(this);
        add(botonAtaque,1,0);
        add(botonHabilidad,1,0);
        add(botonPocion,1,0);
        //declaracion de clase MetodoCombate para poder utilizar las funciones para el daño, pociones etc
        jugadores=new MetodoCombate(jugador1,jugador2);
        //vida y escudo del jugador 1
        vidaJugador1=new JTextField(String.valueOf(jugadores.getJugador1().getVida()));
        escudoJugador1=new JTextField(String.valueOf(jugadores.getJugador1().getEscudo()));
        escudoJugador1.setBounds(35,400,150,50);
        vidaJugador1.setBounds(35,450,150,50);
        escudoJugador1.setEditable(false);
        vidaJugador1.setEditable(false);
        add(vidaJugador1,1,0);
        add(escudoJugador1,1,0);
        //Vida y escudo del jugador 2
        vidaJugador2=new JTextField(String.valueOf(jugadores.getJugador2().getVida()));
        escudoJugador2=new JTextField(String.valueOf(jugadores.getJugador2().getEscudo()));
        escudoJugador2.setBounds(250,60,150,50);
        vidaJugador2.setBounds(250,110,150,50);
        escudoJugador2.setEditable(false);
        vidaJugador2.setEditable(false);
        add(vidaJugador2,1,0);
        add(escudoJugador2,1,0);
        //imagenes de los jugadores
        
        //BufferedImage imagenJugador1=jugador1.characterImage;
        //BufferedImage imagenJugador2=jugador2.characterImage;
        JLabel image1=new JLabel();
        image1.setBounds(100,300,350,450);
        image1.setIcon(new ImageIcon(jugadores.getJugador1().getPlayerGif()));
        JLabel image2=new JLabel();
        image2.setBounds(400,-30,450,450);
        image2.setIcon(new ImageIcon(jugadores.getJugador2().getPlayerGif()));
        add(image1,1,0);
        add(image2,1,0);

        //Nombre de los pesonajes
        JLabel nombreJugador1=new JLabel(jugadores.getJugador1().getNombre());
        nombreJugador1.setBounds(35,365,150,50);
        JLabel nombreJugador2=new JLabel(jugadores.getJugador2().getNombre());
        nombreJugador2.setBounds(250,25,150,50);
        add(nombreJugador1,1,0);
        add(nombreJugador2,1,0);
        //turnos 
        JLabel nombreTurno=new JLabel("Turno");
        nombreTurno.setBounds(25,0,150,50);
        turno=new JTextField(String.valueOf(turnos));
        turno.setBounds(25,35,150,50);
        turno.setEditable(false);
        add(nombreTurno,1,0);
        add(turno,1,0);
        //Nos declaramos el frame como un atributo para que en el momento que ganes o pierdas se cambie solo la pantalla
        this.frameC = frameC;  
        frameC.setResizable(false);
        frameC.add(this);
        frameC.setSize(850,750);
        frameC.setTitle("Combate");
        frameC.setVisible(true);
        frameC.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);      
    }

    public void actionPerformed(ActionEvent event){
        //falta hacer el sistema de turno para que el bot te pege una hostia
        JButton clickedButton=(JButton) event.getSource();
        String Opcion=clickedButton.getText();
        if(Opcion=="Atacar"){
            jugadores.Ataque();
            ActualizacionEstadisticas();
            if(cooldownHabilidad==turnos){
                System.out.println("Vuelves a tener la habilidad activa");
                botonHabilidad.setEnabled(true);
            }
            FinPrograma();
        }
        else if(Opcion=="Habilidad"){
            jugadores.HabilidadJugador1();
            cooldownHabilidad=turnos+3;
            ActualizacionEstadisticas();
            botonHabilidad.setEnabled(false);
            System.out.println("Tienes la habilidad en cooldown, 3 turnos sin habilidad");
            FinPrograma();
        }
        else{
            //pociones
            jugadores.usarPociones();
            ActualizacionEstadisticas();
        }
    }
    public void ActualizacionEstadisticas(){
        vidaJugador1.setText(String.valueOf(jugadores.getJugador1().getVida()));
        vidaJugador2.setText(String.valueOf(jugadores.getJugador2().getVida()));
        escudoJugador1.setText(String.valueOf(jugadores.getJugador1().getEscudo()));
        escudoJugador2.setText(String.valueOf(jugadores.getJugador2().getEscudo()));
        turnos++;
        turno.setText(String.valueOf(turnos));
    }
    public void FinPrograma(){
        if(jugadores.getJugador2().getVida()==0){
            if(jugadores.getJugador2().getNombre()=="Qiqi"){
                jugadores.getJugador2().usarHabilidad(jugadores.getJugador1());
                ActualizacionEstadisticas();
            }
            else{
                System.out.println("Has ganado el combate");
                try{
                    Thread.sleep(3000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                frameC.dispose();
                
            }  
        }
        if(jugadores.getJugador1().getVida()==0){
            if(jugadores.getJugador1().getNombre()=="Qiqi"){
                jugadores.getJugador1().usarHabilidad(jugadores.getJugador2());
                ActualizacionEstadisticas();
            }
            else{
                System.out.println("Has perdidio el combate");
                try{
                    Thread.sleep(3000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                frameC.dispose();
            }
        }
    }
    public void playMusic(int i){
        musica.setupMusica(i);
        musica.play();
        musica.loop();
    }
    public void stopMusic(){
        musica.stop();
    }
        
    public static void main(String[] args){
        Mapa mapa=new Mapa();
        JFrame frameC= new JFrame();
        mapa.player1.setContadorPociones(1);
        InterfazCombate interfazC=new InterfazCombate(mapa.player1,mapa.player2, frameC);
        mapa.stopMusic();
        interfazC.playMusic(1);
    }
}
