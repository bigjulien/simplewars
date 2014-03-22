package affichage;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import main.Controlleur;
import map.*;
import unit.*;
/**
 * Panel affichant une case de la grille
 * @author Benjamin CLAQUIN
 *
 */
public class AfficheurCellule extends JPanel implements MouseListener{
    private Color color=Color.BLACK;
    private Coordonnee coordonee;
    private Cellule cellule;
    Controlleur c;


   private final int BORDERBOLD =4;

    public AfficheurCellule(Cellule cellule) {
        this.addMouseListener(this);
        this.cellule=cellule;
        try {
        this.coordonee=cellule.getCoordonnee();
        }
        catch (NullPointerException e){
            System.err.println("[AfficheurCellule] Vous essayez d'afficher une celule ne contenant pas de coordonees");
        }
        
    }
    
    /**
     * Paint la cellule
     */
    public void paintComponent(Graphics g) {
        
        
        paintCellule(g);
            
    }

    /**
     * Paint successivement les differents composants de la cellule a savoir :
     * 
     * le terrain
     * le batiment
     * l'unite
     * 
     * Si la cellule contient ces dernieres
     * Envoi un message d'erreur si une image est introuvable
     * @param g
     */
    public void paintCellule(Graphics g){
        if(cellule.contientTerrain()){
            g.setColor(cellule.getTerrain().getCouleur());
            g.fillRect(0, 0, getWidth(), getHeight());
            setBorder(BorderFactory.createLineBorder(Color.black,BORDERBOLD));

           
            
        }
        if(cellule.contientBatiment()){
            Batiment u =  cellule.getBatiment();
            try {
                BufferedImage bI=u.getBufferedImage();

                g.drawImage(bI,2*BORDERBOLD, 2*BORDERBOLD, getWidth()-4*BORDERBOLD, getHeight()-4*BORDERBOLD,this);

            }catch(Exception e){
                System.err.println("image batiment introuvable");
            }
        }
        
        if(cellule.contientUnite()){
            Unite u = cellule.getUnit();
            try {
                BufferedImage bI=u.getBufferedImage();

                g.drawImage(bI,2*BORDERBOLD,2*BORDERBOLD, getWidth()-4*BORDERBOLD, getHeight()-4*BORDERBOLD,this);

            }catch(Exception e){
                System.err.println("image unite introuvable");
            }
        }
    }
    
    
    public void mouseClicked(MouseEvent arg0) {
        if(cellule.contientBatiment())
        {
        	c.creation();
        }
        else
        {
        	if(c.nbClick)
        	{
        		c.prepareDeplacement(c.getJoueurCourant(), coordonee);
        	}
        	else
        	{
        		c.deplacer(c.getJoueurCourant(),c.memoire , coordonee);
        	}
        }

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    
    public void setControl(Controlleur c)
    {
    	this.c  =c;
    }

}
