package Combate;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Combate.StrategyPattern.AccionStrategyContext;
import Combate.StrategyPattern.BotStrategy;
import Combate.StrategyPattern.UserStrategy;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Entidades.Personaje;
import Main.Mapa;
import Sound.Musica;

public class InterfazCombateCopia extends JPanel implements ActionListener{
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
    public Mapa mapa;

    public Personaje jugador1;
    public Personaje jugador2;
    public AccionStrategyContext contexto;
    public UserStrategy userStrategy;
    public BotStrategy botStrategy;

    public InterfazCombateCopia(Personaje jugador1,Personaje jugador2, JFrame frameC,Mapa mapa){
        //declaracion del contexto y estrategias
        this.jugador1=jugador1;
        this.jugador2=jugador2;
        userStrategy=new UserStrategy(jugador1, jugador2);
        botStrategy=new BotStrategy(jugador1, jugador2);
        contexto=new AccionStrategyContext(userStrategy);

        //fondo
        JLabel fondo2=new JLabel();
        fondo2.setBounds(0,0,850,750);
        fondo2.setIcon(new ImageIcon("./BattleRoyale-Java/BattleRoyale/images/player/background2.gif"));
        add(fondo2,3,0);
        
        JLabel fondo=new JLabel();
        fondo.setBounds(-80,0,850,750);
        fondo.setIcon(new ImageIcon("./BattleRoyale-Java/BattleRoyale/images/player/background.png"));
        add(fondo,2,0);
        //

        this.mapa=mapa;
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
        if(jugador1.getNombre().equals("Qiqi")){

            botonHabilidad.setEnabled(false);

        }
        //declaracion del boton de pocion
        JButton botonPocion=new JButton("Pocion");
        botonPocion.setBounds(550,600,250,50);
        botonPocion.addActionListener(this);
        add(botonAtaque,1,0);
        add(botonHabilidad,1,0);
        add(botonPocion,1,0);
        //declaracion de clase MetodoCombate para poder utilizar las funciones para el daño, pociones etc
        
        //vida y escudo del jugador 1
        vidaJugador1=new JTextField(String.valueOf(jugador1.getVida()));
        escudoJugador1=new JTextField(String.valueOf(jugador1.getEscudo()));
        escudoJugador1.setBounds(35,400,150,50);
        vidaJugador1.setBounds(35,450,150,50);
        escudoJugador1.setEditable(false);
        vidaJugador1.setEditable(false);
        add(vidaJugador1,1,0);
        add(escudoJugador1,1,0);
        //Vida y escudo del jugador 2
        vidaJugador2=new JTextField(String.valueOf(jugador2.getVida()));
        escudoJugador2=new JTextField(String.valueOf(jugador2.getEscudo()));
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
        image1.setIcon(new ImageIcon(jugador1.getPlayerGif()));
        JLabel image2=new JLabel();
        image2.setBounds(400,-30,450,450);
        image2.setIcon(new ImageIcon(jugador2.getPlayerGif()));
        add(image1,1,0);
        add(image2,1,0);

        //Nombre de los pesonajes
        JLabel nombreJugador1=new JLabel(jugador1.getNombre());
        nombreJugador1.setBounds(35,365,150,50);
        JLabel nombreJugador2=new JLabel(jugador2.getNombre());
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
        //estado del juego

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
        Random random=new Random();
        int randOpcionBot=random.nextInt(2)+1;
        if(Opcion=="Atacar"){
            contexto.accion(0);
            if(jugador2.getVida() != 0){
                contexto.setStrategy(botStrategy);
                contexto.accion(randOpcionBot);
            }
            contexto.setStrategy(userStrategy);
            ActualizacionEstadisticas();
            if(cooldownHabilidad==turnos){
                System.out.println("Vuelves a tener la habilidad activa");
                botonHabilidad.setEnabled(true);
            }
            FinPrograma();
        }
        else if(Opcion=="Habilidad"){
            contexto.accion(1);
            if(jugador2.getVida() != 0){
                contexto.setStrategy(botStrategy);
                contexto.accion(randOpcionBot);
            }
            contexto.setStrategy(userStrategy);
            cooldownHabilidad=turnos+3;
            ActualizacionEstadisticas();
            botonHabilidad.setEnabled(false);
            System.out.println("Tienes la habilidad en cooldown, 3 turnos sin habilidad");
            FinPrograma();
        }
        else{
            //pociones
            contexto.accion(3);
            ActualizacionEstadisticas();
        }
    }
    public void ActualizacionEstadisticas(){
        vidaJugador1.setText(String.valueOf(jugador1.getVida()));
        vidaJugador2.setText(String.valueOf(jugador2.getVida()));
        escudoJugador1.setText(String.valueOf(jugador1.getEscudo()));
        escudoJugador2.setText(String.valueOf(jugador2.getEscudo()));
        turnos++;
        turno.setText(String.valueOf(turnos));
    }
    public void FinPrograma(){
        if(jugador2.getVida()==0){
            if(jugador2.getNombre()=="Qiqi" && jugador2.getRevivir() == 0){
                jugador2.usarHabilidad(jugador1);
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
                mapa.setSolicitudCambioEstado("Combate ganado");
                mapa.setNumeroDeBots(mapa.getNumeroDeBots()-1);
                frameC.dispose();
                this.musica.stop();
                mapa.playMusic(0);
            }  
        }
        else if(jugador1.getVida()==0){
            if(jugador1.getNombre()=="Qiqi" && jugador1.getRevivir() == 0){
                jugador1.usarHabilidad(jugador2);
                ActualizacionEstadisticas();
            }
            else{
                System.out.println("Has perdido el combate");
                try{
                    Thread.sleep(3000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                mapa.setSolicitudCambioEstado("Combate perdido");
                frameC.dispose();
                this.musica.stop();
                mapa.playMusic(0);
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
}