package map;

import unit.Unite;

public class Cellule {
	private Coordonnee coord;
	private Unite unit;
	
	// Getters
	
	/**
	 * Renvoie l'unite presente sur la cellule
	 * @return
	 */
	public Unite getUnit() {
		return unit;
	}
	
	/**
	 * Renvoie les coordonnees de la case
	 * @return les coordonnees de la case
	 */
	public Coordonnee getCoordonnee() {
		return coord;
	}
	
	// Setters
	
	/**
	 * Affecter une unite a la cellule
	 * @param unit la nouvelle unite
	 */
	public void setUnit(Unite unit) {
		this.unit = unit;
	}
	
	/**
	 * Change les coordonnees de la case
	 * @param coord les nouvelles coordonnees de la case
	 */
	public void setCoordonnee (Coordonnee coord) {
		this.coord = coord;
	}
	
}
