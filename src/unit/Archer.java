package unit;

import joueur.Joueur;

public class Archer extends Unite {
    

    private static final String ABREV = "arch";
    
    private static final int NBDEPLACEMENT = 1;
    private static final String SOULDSELECTED = "snd/archer.mp3";
        
    public Archer(Joueur joueur){
        super(joueur);
    }
    
    public int getNbDeplacement() {
        return NBDEPLACEMENT;
    }
    
    public String toString(){
        try {
        return "archer du joueur "+joueur;
        }
        catch (NullPointerException e) {
            System.err.println("lel, un archer n'a pas de joueur");
        }
        return "error";
    }

    @Override
    public String getNomAbrev() {
        return ABREV;
    }

	@Override
	public String getSoundSelected() {
		return SOULDSELECTED;
	}

}
