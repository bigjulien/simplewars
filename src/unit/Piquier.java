package unit;

import joueur.Joueur;

public class Piquier extends Unite{
   
    private static final String imageSoldatGauche = "unit_piq - Copie.png";
    private static final String imageSoldatDroite = "unit_piq.png";

    private static final int NBDEPLACEMENT = 1;
    
    public Piquier (Joueur joueur){
        this.joueur=joueur;
        if (joueur.isGauche())
            setBufferedImage(imageSoldatDroite);
        if (joueur.isGauche())
            setBufferedImage(imageSoldatGauche);
    }
    
    public int getNbDeplacement() {
        return NBDEPLACEMENT;
    }

}
