package affichage;

import map.Map;

import javax.swing.JPanel;

public class PanelCarte extends JPanel {

    private Map map;
    private int largeur,hauteur;
    public PanelCarte(Map map){
        this.map=map;
        largeur = map.getLargeur();
        hauteur = map.getHauteur();
    }
}
