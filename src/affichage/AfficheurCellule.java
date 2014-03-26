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

import event.ColourCaseListener;
import main.Controlleur;
import map.*;
import unit.*;
/**
 * Panel affichant une case de la grille
 * @author Benjamin CLAQUIN
 *
 */
public class AfficheurCellule extends JPanel implements MouseListener,ColourCaseListener{
    private Color color=Color.BLACK;
    private Coordonnee coordonee;
    private Cellule cellule;
    Controlleur controlleur;
    private boolean belongToChampDeMovement=false;
    private boolean onOver=false;
    
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
        if(this.belongToChampDeMovement){
            
            g.setColor(Color.decode("#3399CC"));
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        if(this.onOver){
            g.setColor(Color.BLUE);
            g.fillRect(0, 0, getWidth(), getHeight());
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
        // Si on clique sur une cellule qui a un batiment au premier clic
        if(cellule.contientBatiment() && cellule.getBatiment().getJoueur().equals(controlleur.getJoueurCourant()))
        {
            // si le batiment appartient au joueur
            if (cellule.getBatiment().getJoueur().equals(controlleur.getJoueurCourant())){
                controlleur.creation();
            }
            controlleur.unColourAllCorrectCase();
        }
        else
        {

        	if(!controlleur.deuxiemeClick && this.cellule.contientUnite())
        	{

        	    controlleur.getRespectfullCases(coordonee);
        	    controlleur.colourAllCorrectCase();
        		controlleur.prepareDeplacement(controlleur.getJoueurCourant(), coordonee);

        	}
        	else
        	{
        	    controlleur.unColourAllCorrectCase();
        	    controlleur.deplacer(controlleur.getJoueurCourant(),controlleur.memoire , coordonee);
        	}
        }

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        onOver=true;
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        onOver=false;
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
    	this.controlleur  =c;
    	controlleur.onStateRealized(this);
    }

    @Override
    public void colourCase(Coordonnee c) {

        if (c.equals(this.coordonee)){
            this.belongToChampDeMovement=true;
            System.out.println("coord" +c);
            System.out.println(belongToChampDeMovement);
        }
    }

    @Override
    public void decolourCase(Coordonnee c) {
        if (c.equals(this.coordonee))
            this.belongToChampDeMovement=false;
    }

}
