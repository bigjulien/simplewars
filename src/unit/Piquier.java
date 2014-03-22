package unit;

import joueur.Joueur;

public class Piquier extends Unite{
   
    private static final String imageSoldatGauche = "Units/unit_piq - Copie.png";
    private static final String imageSoldatDroite = "Units/unit_piq.png";

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

    public String toString(){
        try {
        return "Piquer du joueur "+joueur;
        }
        catch (NullPointerException e) {
            System.err.println("lel, un piquier n'a pas de joueur");
        }
        return "error";
    }
}
