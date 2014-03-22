package affichage;

import java.awt.GridLayout;

import main.Controlleur;
import map.Map;

import javax.swing.JPanel;

public class PanelCarte extends JPanel {
	private Controlleur c;
    private Map map;
    private int largeur,hauteur;
    private AfficheurCellule[][] tableauDeCellules;
    
    /**
     * Panel sur lequel est affiche la carte de jeu
     * @param map
     */
    public PanelCarte(Map map, Controlleur c){
        this.map=map;
        
        largeur = map.getLargeur();
        hauteur = map.getHauteur();
        
        setLayout(new GridLayout(largeur,hauteur));
        for (int i = 0; i <largeur ; i++) {
            for (int j = 0; j <largeur ; j++){
                AfficheurCellule aC = new AfficheurCellule(map.getGrille()[i][j]);
                aC.setControl(c);
           
                add(aC);
            }
        }       
    }    
}
