package map;

import java.awt.image.BufferedImage;

import joueur.Joueur;

public abstract class Batiment {

    protected BufferedImage bufferedImage;
    protected Joueur joueur;
    protected Cellule cell;
    
    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }
    
    public Joueur getJoueur(){
        return joueur;
    }
    
    public void setJoueur(Joueur j){
       this.joueur=j;
    }
    
}
