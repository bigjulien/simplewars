package map;

import java.awt.Color;

public class Terrain {
	
	private Color couleur;
	private boolean praticable;
	
	public Terrain (Color couleur, boolean praticable) {
		this.couleur = couleur;
		this.praticable = praticable;
	}
	
	public Color getCouleur() {
		return couleur;
	}
	
	public boolean isPraticable() {
		return praticable;
	}
	
	/**
	 * Représentation du terrain sous forme de chaine de character
	 */
	public String toString (){
	    String praticabilité = praticable ? "praticable" : "impraticable";
	    return "terrain "+praticabilité;
	}
}
