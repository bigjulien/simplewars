package unit;

public class Archer extends Unite {
    

    private static final String imageSoldatGauche = "unit_arch - Copie.png";
    private static final String imageSoldatDroite = "unit_arch.png";
    
    private static final int NBDEPLACEMENT = 1;
        
    public Archer(){
        if (joueur.isGauche())
            setBufferedImage(imageSoldatDroite);
        if (joueur.isGauche())
            setBufferedImage(imageSoldatGauche);
    }
    
    public int getNbDeplacement() {
        return NBDEPLACEMENT;
    }

}
