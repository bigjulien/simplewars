package unit;

import map.Coordonnee;

public abstract class Unite {
	
	private Coordonnee coord;
	
	/**
	 * Recupere le nombre de deplacement possible pour le tour actuel
	 * @return le nombre de deplacement
	 */
	public abstract int getNbDeplacement();
	
	/**
	 * Renvoie les coordonnees de l'unite
	 * @return les coordonnees de l'unite
	 */
	public Coordonnee getCoordonnee() {
		return coord;
	}
	
	/**
	 * Change les coordonnees de l'unite
	 * @param coord les nouvelles coordonnees de l'unite
	 */
	public void setCoordonnee (Coordonnee coord) {
		this.coord = coord;
	}
	
}
