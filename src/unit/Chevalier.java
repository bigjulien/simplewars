package unit;

import joueur.Joueur;

public class Chevalier extends Unite {
    
    private static final String ABREV = "chev";
    
    private static final int NBDEPLACEMENT = 2;
    
    public Chevalier (Joueur joueur){
        super(joueur);

    }
    
    public int getNbDeplacement() {
        return NBDEPLACEMENT;
    }
    
    public String toString(){
        try {
        return "chevalier du joueur "+joueur;
        }
        catch (NullPointerException e) {
            System.err.println("lel, un chevalier n'a pas de joueur");
        }
        return "error";
    }

    public String getNomAbrev() {
        return ABREV;
    }

}
