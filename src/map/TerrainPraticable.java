package map;

import java.awt.Color;

public class TerrainPraticable extends Terrain {

	public TerrainPraticable(Color couleur, boolean praticable) {
        super(couleur, praticable);
        // TODO Auto-generated constructor stub
    }

    private static final Color COULEUR = Color.WHITE;
	private static final boolean PRATICABLE = true;
	
	public Color getCouleur() {
		return COULEUR;
	}

	public boolean isPraticable() {
		return PRATICABLE;
	}

}
