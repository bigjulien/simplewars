package jeu.map;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class TerrainImpraticable extends Terrain {
	
    private static final Color COULEUR = Color.BLACK;
	private static final boolean PRATICABLE = false;
	private final String pathImage="Units/water_0.png";
	public TerrainImpraticable(){
	    super(PRATICABLE);
	}
	
    public TerrainImpraticable (BufferedImage bufferedImage) {
        super (bufferedImage,false);
    }
	public TerrainImpraticable(String pathImage){
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
        // TODO Auto-generated method stub
        return pathImage;
    }
}
