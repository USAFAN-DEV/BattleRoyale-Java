package Combate;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class InterfazCombate extends JPanel implements ActionListener{
    public InterfazCombate(){
        setLayout(null);
        JButton botonAtaque=new JButton("Atacar");
        botonAtaque.setBackground(Color.BLACK); 
        botonAtaque.setBounds(500,-250,250,250);
        botonAtaque.addActionListener(this);
        JButton botonHabilidad=new JButton("Habilidad"); 
        botonHabilidad.setBackground(Color.BLUE);
        botonHabilidad.setBounds(250,200,500,500);
        botonHabilidad.addActionListener(this);
        add(botonAtaque);
        add(botonHabilidad);
    }

    public void actionPerformed(ActionEvent event){
        JButton clickedButton=(JButton) event.getSource();
        String Opcion=clickedButton.getText();
        if(Opcion=="Ataque"){

        }
        else{

        }
    }

    public static void main(String[] args){
        InterfazCombate interfazC=new InterfazCombate();
        JFrame frameC=new JFrame();
        frameC.add(interfazC);
        frameC.setSize(500,500);
        frameC.setTitle("Combate");
        frameC.setVisible(true);
    }
}
