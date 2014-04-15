package simplewars.map;

import java.awt.image.BufferedImage;

import simplewars.joueur.Joueur;

public abstract class Batiment {

    protected BufferedImage bufferedImage;
    protected Joueur joueur;
    protected Cellule cell;
    
    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public Joueur getJoueur() {
       return joueur;
    }
    
}
