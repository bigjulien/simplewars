package unit;

public class Chevalier extends Unite {

    private static final String imageSoldatGauche = "unit_arch - Copie.png";
    private static final String imageSoldatDroite = "unit_arch.png";
    
    private static final int NBDEPLACEMENT = 2;
    
    public Chevalier (){
        if (joueur.isGauche())
            setBufferedImage(imageSoldatDroite);
        if (joueur.isGauche())
            setBufferedImage(imageSoldatGauche);
    }
    
    public int getNbDeplacement() {
        return NBDEPLACEMENT;
    }

}
