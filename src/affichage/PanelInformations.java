package affichage;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;

import joueur.Joueur;

import event.JoueurChangedEvent;
import event.JoueurChangedListener;

import main.Controlleur;

/**
 * Panel comportant les informations de jeu tel que le joueur actuel etc...
 * @author Benjamin CLAQUIN
 *
 */
public class PanelInformations extends JPanel implements MouseListener, JoueurChangedListener {

    private JButton tourSuivant;
    private JLabel joueurActuel;
    private JLabel points;
    private Dimension dimension = new Dimension(100,100);
    
    private Controlleur control;
    
    private EventListenerList listenersChangementJoueur;
    
    public PanelInformations() {
        listenersChangementJoueur = new EventListenerList();
        
        tourSuivant = new JButton("suivant");
        tourSuivant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                changerJoueur();
            }
        });
        
        joueurActuel = new JLabel("moi");
        points = new JLabel("12");
        
        add(joueurActuel);
        add(points);
        add(tourSuivant);
         
    }
    
    public void changed(JoueurChangedEvent e) {
        Joueur j = e.getJoueur();
        joueurActuel.setText(j.getNom());
        
    }
    
    public void changerJoueur() {
        control.joueurSuivant();
        fireJoueurChangedEvent();
    }
    
    public void fireJoueurChangedEvent() {
        
        JoueurChangedEvent evt = new JoueurChangedEvent(this, control.getJoueurCourant());
        
        for (JoueurChangedListener l : listenersChangementJoueur.getListeners(JoueurChangedListener.class)) {
            l.changed(evt);
        }
    }
    
    public void addJoueurChangedListener(JoueurChangedListener l) {
        listenersChangementJoueur.add(JoueurChangedListener.class, l);
    }
    
    public void setControl (Controlleur c) {
        this.control = c;
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
