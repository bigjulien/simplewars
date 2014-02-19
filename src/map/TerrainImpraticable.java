package map;

import java.awt.Color;

public class TerrainImpraticable extends Terrain {
	
	public TerrainImpraticable(Color couleur, boolean praticable) {
        super(couleur, praticable);
        // TODO Auto-generated constructor stub
    }

    private static final Color COULEUR = Color.BLACK;
	private static final boolean PRATICABLE = false;
	
	public Color getCouleur() {
		return COULEUR;
	}

	public boolean isPraticable() {
		return PRATICABLE;
	}
}
