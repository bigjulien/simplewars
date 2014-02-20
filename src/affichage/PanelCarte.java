package affichage;

import java.awt.GridLayout;

import map.Map;

import javax.swing.JPanel;

public class PanelCarte extends JPanel {

    private Map map;
    private int largeur,hauteur;
    public PanelCarte(Map map){
        this.map=map;
        setLayout(new GridLayout(3,3));
        largeur = map.getLargeur();
        hauteur = map.getHauteur();
        for (int i = 0; i < 9; i++) {
            AfficheurCellule aC = new AfficheurCellule(i);
            add(aC);
        }
        
    }
}
