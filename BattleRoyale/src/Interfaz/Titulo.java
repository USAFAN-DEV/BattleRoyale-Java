/*package Interfaz;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import java.awt.Image;
import java.awt.Window;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Container;

public class Titulo extends JFrame implements ActionListener{
    public Titulo(){
        ImageIcon img = new ImageIcon("C:\\Users\\eduar\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\src\\Interfaz\\Titulo.jpg");
        JPanel panel=new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(img.getImage(), 0, 0, null);
            }
        };
        setSize(800,450);
        setVisible(true);
        add(panel);
        /*JLabel titulo=new JLabel();
        titulo.setBounds(50,50,100,30);
        titulo.setText("Titulo del juego");
        ImageIcon background=new ImageIcon("C:\\Users\\eduar\\Documents\\GitHub\\BattleRoyale-Java\\BattleRoyale\\src\\Interfaz\\Titulo.jpg");
        JLabel label=new JLabel();
        label.setBounds(0,0,getWidth(),getHeight());
        label.setIcon(new ImageIcon(background.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT)));
        
        add(label);
        add(titulo);
        
        setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
          
    }



    public void actionPerformed(ActionEvent event){

    }

    public static void main(String[] args){
        Titulo t=new Titulo();
    }  
        
    
}*/
