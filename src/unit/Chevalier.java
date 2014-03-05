package unit;

public class Chevalier extends Unite {
    private static final String imageSoldat = "Units/2673.gif";
    private static final int NBDEPLACEMENT = 2;
    
    
    public Chevalier (){
        setBufferedImage(imageSoldat);
    }
    
    public int getNbDeplacement() {
        return NBDEPLACEMENT;
    }

}
