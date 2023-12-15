package Combate;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Interfaces2.Mapa; 
import Combate.MetodoCombate;
import Personaje.Jugador;

public class InterfazCombate extends JPanel implements ActionListener{
    private static final int EXIT_ON_CLOSE = 0;
    public MetodoCombate jugadores;
    public JTextField vidaJugador1;
    public JTextField vidaJugador2;
    public JTextField escudoJugador1;
    public JTextField escudoJugador2;
    public int turnos;
    public JTextField turno;
    JButton botonHabilidad;

    public InterfazCombate(Jugador jugador1,Jugador jugador2){
        turnos=1;
        setLayout(null);
        //declaracion del boton de Ataque
        JButton botonAtaque=new JButton("Atacar");
        //botonAtaque.setBackground(Color.BLACK); 
        botonAtaque.setBounds(500,500,250,50);
        botonAtaque.addActionListener(this);
        //declaracion del boton de habilidad
        botonHabilidad=new JButton("Habilidad"); 
        //botonHabilidad.setBackground(Color.BLUE);
        botonHabilidad.setBounds(500,550,250,50);
        botonHabilidad.addActionListener(this);
        //declaracion del boton de pocion
        JButton botonPocion=new JButton("Pocion");
        botonPocion.setBounds(500,600,250,50);
        botonPocion.addActionListener(this);
        add(botonAtaque);
        add(botonHabilidad);
        add(botonPocion);
        //declaracion de clase MetodoCombate para poder utilizar las funciones para el daño, pociones etc
        jugadores=new MetodoCombate(jugador1,jugador2);
        //vida y escudo del jugador 1
        vidaJugador1=new JTextField(String.valueOf(jugadores.getJugador1().getVida()));
        escudoJugador1=new JTextField(String.valueOf(jugadores.getJugador1().getEscudo()));
        escudoJugador1.setBounds(75,400,150,50);
        vidaJugador1.setBounds(75,450,150,50);
        escudoJugador1.setEditable(false);
        vidaJugador1.setEditable(false);
        add(vidaJugador1);
        add(escudoJugador1);
        //Vida y escudo del jugador 2
        vidaJugador2=new JTextField(String.valueOf(jugadores.getJugador2().getVida()));
        escudoJugador2=new JTextField(String.valueOf(jugadores.getJugador2().getEscudo()));
        escudoJugador2.setBounds(250,60,150,50);
        vidaJugador2.setBounds(250,110,150,50);
        escudoJugador2.setEditable(false);
        vidaJugador2.setEditable(false);
        add(vidaJugador2);
        add(escudoJugador2);
        //imagenes de los jugadores
        
        BufferedImage imagenJugador1=jugador1.characterImage;
        //BufferedImage imagenJugador2=jugador2.characterImage;
        JLabel image1=new JLabel();
        image1.setBounds(200,250,350,450);
        image1.setIcon(new ImageIcon("C:\\Users\\nicol\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\images\\player\\zhongli.gif"));
        JLabel image2=new JLabel();
        image2.setBounds(350,-30,450,450);
        image2.setIcon(new ImageIcon("C:\\Users\\nicol\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\images\\player\\eula.gif"));
        add(image1);
        add(image2);

        //Nombre de los pesonajes
        JLabel nombreJugador1=new JLabel(jugadores.getJugador1().getNombre());
        nombreJugador1.setBounds(75,365,150,50);
        JLabel nombreJugador2=new JLabel(jugadores.getJugador2().getNombre());
        nombreJugador2.setBounds(250,25,150,50);
        add(nombreJugador1);
        add(nombreJugador2);
        //turnos 
        JLabel nombreTurno=new JLabel("Turno");
        nombreTurno.setBounds(25,0,150,50);
        turno=new JTextField(String.valueOf(turnos));
        turno.setBounds(25,35,150,50);
        turno.setEditable(false);
        add(nombreTurno);
        add(turno);
        
    }

    public void actionPerformed(ActionEvent event){
        //falta hacer el sistema de turno para que el bot te pege una hostia
        JButton clickedButton=(JButton) event.getSource();
        String Opcion=clickedButton.getText();
        if(Opcion=="Atacar"){
            jugadores.Ataque();
            vidaJugador1.setText(String.valueOf(jugadores.getJugador1().getVida()));
            vidaJugador2.setText(String.valueOf(jugadores.getJugador2().getVida()));
            escudoJugador1.setText(String.valueOf(jugadores.getJugador1().getEscudo()));
            escudoJugador2.setText(String.valueOf(jugadores.getJugador2().getEscudo()));
            turnos++;
            turno.setText(String.valueOf(turnos));

            if(jugadores.getJugador2().getVida()==0){
                System.out.println("Has ganado el combate");
                try{
                    Thread.sleep(5000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.exit(-1);
            }
            if(jugadores.getJugador1().getVida()==0){
                System.out.println("Has perdidio el combate");
                try{
                    Thread.sleep(5000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.exit(-1);
            }
        }
        else if(Opcion=="Habilidad"){
            jugadores.HabilidadJugador1();
            vidaJugador1.setText(String.valueOf(jugadores.getJugador1().getVida()));
            vidaJugador2.setText(String.valueOf(jugadores.getJugador2().getVida()));
            escudoJugador1.setText(String.valueOf(jugadores.getJugador1().getEscudo()));
            escudoJugador2.setText(String.valueOf(jugadores.getJugador2().getEscudo()));
            botonHabilidad.setEnabled(false);
        }
        else{
            //pociones
        }
    }

    public static void main(String[] args){
        Mapa mapa=new Mapa();
        InterfazCombate interfazC=new InterfazCombate(mapa.player1,mapa.player2);
        JFrame frameC=new JFrame();
        frameC.setResizable(false);
        frameC.add(interfazC);
        frameC.setSize(850,750);
        frameC.setTitle("Combate");
        frameC.setVisible(true);
        frameC.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
