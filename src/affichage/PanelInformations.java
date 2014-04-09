package affichage;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;
import joueur.Joueur;
import event.JoueurChangedEvent;
import event.JoueurChangedListener;
import main.Controlleur;
import main.Main;

/**
 * Panel comportant les informations de jeu tel que le joueur actuel etc...
 * @author Benjamin CLAQUIN
 *
 */
public class PanelInformations extends JPanel implements JoueurChangedListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String PATHAIDE = "snd/aide.mp3";
	
	private JButton tourSuivant,aide;
    private JLabel joueurActuel;
    private Dimension dimension = new Dimension(300,300);
    
    private Controlleur control;
    
    private EventListenerList listenersChangementJoueur;
    
    public PanelInformations() {
        listenersChangementJoueur = new EventListenerList();
        
        tourSuivant = new JButton("suivant");
        aide = new JButton("aide");
        aide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                aide();
            }

			private void aide() {
				Main.playSound(PATHAIDE);
				
				aide.setVisible(true);
				
			}
        });
        
        
        tourSuivant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                changerJoueur();
            }
        });
        
        aide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFrame aide = new JFrame();
        		aide.setSize(800,1000);
        		JPanel jp = new JPanel();
        		//aide.add()
        		JLabel image = new JLabel(new ImageIcon("Images/Expliquations/explic.jpg"));
        		jp.add(image);
        		aide.add(jp);
        		aide.setVisible(true); 
            }
        });
        
        tourSuivant.setFont(new Font("sansserif",Font.BOLD,50));
        joueurActuel = new JLabel("Joueur 1");
        joueurActuel.setFont(new Font("sansserif",Font.BOLD,50));
        aide.setFont(new Font("sansserif",Font.BOLD,50));
        setLayout(new BorderLayout());
        
        add(joueurActuel,BorderLayout.CENTER);
        
        add(tourSuivant,BorderLayout.NORTH);
        add(aide,BorderLayout.SOUTH);
		

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

    
    
    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimention) {
        this.dimension = dimention;
    }
    
    
}
