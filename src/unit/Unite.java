package unit;

import map.Cellule;

public abstract class Unite {
	
	private Cellule cell;
	
	/**
	 * Recupere le nombre de deplacement possible pour le tour actuel
	 * @return le nombre de deplacement
	 */
	public abstract int getNbDeplacement();
	
	/**
	 * Renvoie la cellule de l'unite
	 * @return les cellule de l'unite
	 */
	public Cellule getCell() {
		return cell;
	}
	
	/**
	 * Change la cellule de l'unite
	 * @param cell la nouvelle cellule de l'unite
	 */
	public void setCell (Cellule cell) {
		this.cell = cell;
	}
	
}
