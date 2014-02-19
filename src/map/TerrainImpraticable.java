package map;

import java.awt.Color;

public class TerrainImpraticable implements Terrain {
	
	private static final Color COULEUR = Color.BLACK;
	private static final boolean PRATICABLE = false;
	
	public Color getCouleur() {
		return COULEUR;
	}

	public boolean isPraticable() {
		return PRATICABLE;
	}
}
