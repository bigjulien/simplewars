package unit;

import joueur.Joueur;

public class Piquier extends Unite{

    private static final int NBDEPLACEMENT = 1;
    
    private static final String ABREV = "piq";
    
    public Piquier (Joueur joueur){
        super(joueur);
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

    public String getNomAbrev() {
        return ABREV;
    }
}
