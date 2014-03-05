package unit;

public class Piquier extends Unite{
    private static final String imageSoldat = "Units/2673.gif";
    private static final int NBDEPLACEMENT = 1;
    
    public Piquier (){
        setBufferedImage(imageSoldat);
    }
    
    public int getNbDeplacement() {
        return NBDEPLACEMENT;
    }

}
