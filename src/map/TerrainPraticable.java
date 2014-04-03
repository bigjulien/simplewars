package map;

import java.awt.Color;

public class TerrainPraticable extends Terrain {


    private static final Color COULEUR = Color.WHITE;
	private static final boolean PRATICABLE = true;
	private final String pathImage = "Units/sand.png";
	public TerrainPraticable(){
        super(PRATICABLE);
    }
	
	   public TerrainPraticable(String pathImage){
	        super(PRATICABLE);
	        pathImage=pathImage;
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
