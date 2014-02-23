package map;

import java.awt.Color;

public class TerrainImpraticable extends Terrain {
	
    private static final Color COULEUR = Color.BLACK;
	private static final boolean PRATICABLE = false;
	
	public TerrainImpraticable(){
	    super(COULEUR,PRATICABLE);
	}
	
	public Color getCouleur() {
		return COULEUR;
	}

	public boolean isPraticable() {
		return PRATICABLE;
	}
}
