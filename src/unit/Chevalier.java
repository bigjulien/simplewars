package unit;

import joueur.Joueur;

public class Chevalier extends Unite {

    private static final String imageSoldatGauche = "Units/unit_arch - Copie.png";
    private static final String imageSoldatDroite = "Units/unit_arch.png";
    
    private static final int NBDEPLACEMENT = 2;
    
    public Chevalier (Joueur joueur){
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
