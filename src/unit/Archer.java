package unit;

public class Archer extends Unite {
    private static final String imageSoldat = "Units/2673.gif";
    private static final int NBDEPLACEMENT = 1;
        
    public Archer(){
        setBufferedImage(imageSoldat);
    }
    
    public int getNbDeplacement() {
        return NBDEPLACEMENT;
    }

}
