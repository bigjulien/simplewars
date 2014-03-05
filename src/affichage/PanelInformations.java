package affichage;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel comportant les informations de jeu tel que le joueur actuel etc...
 * @author Benjamin CLAQUIN
 *
 */
public class PanelInformations extends JPanel implements MouseListener {

    private JButton tourSuivant;
    private JLabel joueurActuel;
    private JLabel points;
    private Dimension dimension = new Dimension(100,100);
    
    public PanelInformations() {
        
        
        tourSuivant = new JButton("suivant");
        joueurActuel = new JLabel("moi");
        points = new JLabel("12");
        
        add(joueurActuel);
        add(points);
        add(tourSuivant);
         
    }

    /**
     * Paint la cellule
     */
    public void paintComponent(Graphics g) {      
    }
    
    
    
    
    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    
    
    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimention) {
        this.dimension = dimention;
    }
    
    
}
