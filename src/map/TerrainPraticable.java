package map;

import java.awt.Color;

public class TerrainPraticable implements Terrain {

	private static final Color COULEUR = Color.WHITE;
	private static final boolean PRATICABLE = true;
	
	public Color getCouleur() {
		return COULEUR;
	}

	public boolean isPraticable() {
		return PRATICABLE;
	}

}
