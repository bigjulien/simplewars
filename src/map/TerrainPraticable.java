package map;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class TerrainPraticable extends Terrain {


    private static final Color COULEUR = Color.WHITE;
	private static final boolean PRATICABLE = true;
	private final String pathImage = "Units/snow0.png";
	public TerrainPraticable(){
        super(PRATICABLE);
    }
	
	public TerrainPraticable (BufferedImage bufferedImage) {
        super (bufferedImage,PRATICABLE);
    }
	
	   public TerrainPraticable(String pathImage){
	        super(PRATICABLE);
	        setBufferedImage(pathImage);
	    }
	
	public Color getCouleur() {
		return COULEUR;
	}

	public boolean isPraticable() {
		return PRATICABLE;
	}

    @Override
    public String getPathImage() {
        return pathImage;
    }

}
