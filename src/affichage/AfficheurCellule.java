package affichage;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class AfficheurCellule extends JPanel{

    public int i;
    public AfficheurCellule(int i){
        
        this.i=i;

       
    }
    
    public void paintComponent(Graphics g) {
        
        if (i%2==0)
            g.setColor(Color.GREEN);
        else 
            g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
            
    }

}
