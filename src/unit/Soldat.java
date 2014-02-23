package unit;

public class Soldat extends Unite{

    private static final String imageSoldat = "Units/2673.gif";
    
    public Soldat (){
        setBufferedImage(imageSoldat);
    }
    
    @Override
    public int getNbDeplacement() {
        // TODO Auto-generated method stub
        return 0;
    }

}
