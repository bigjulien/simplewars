package jeu.affichage;

import java.awt.GridLayout;

import jeu.main.Controlleur;
import jeu.map.Coordonnee;
import jeu.map.Map;

import javax.swing.JPanel;

public class PanelCarte extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private int largeur,hauteur;
    private AfficheurCellule[][] tableauDeCellules;
    
    /**
     * Panel sur lequel est affiche la carte de jeu
     * @param map
     */
    public PanelCarte(Map map){
        
        
        largeur = map.getLargeur();
        hauteur = map.getHauteur();
                
        tableauDeCellules = new AfficheurCellule[largeur][hauteur];
        
        setLayout(new GridLayout(largeur,hauteur));
        for (int i = 0; i <largeur ; i++) {
            for (int j = 0; j <largeur ; j++){
                AfficheurCellule aC = new AfficheurCellule(map.getCellule(new Coordonnee(i,j)));
                tableauDeCellules[i][j] = aC;
                add(aC);
            }
        }
        
    }
    
    public void setControl (Controlleur c) {
      
        
        //Propagation du controlleur aux cellules
        for (int i = 0; i < tableauDeCellules.length ; i++) {
            for (int j = 0; j < tableauDeCellules[i].length ; j++){
                tableauDeCellules[i][j].setControl(c);

            }
        }     
    }
}
