package map;

public class Coordonnee {
	private int x;
	private int y;
	
	public Coordonnee (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// Setters
	
	/**
	 * Change la composante x des coordonnees
	 * @param x le nouvelle composante x
	 */
	public void setX (int x) {
		this.x = x;
	}
	
	/**
	 * Change la composante y des coordonnees
	 * @param y la nouvelle composante y
	 */
	public void setY (int y) {
		this.y = y;
	}
	
	// Getters
	
	/**
	 * Renvoie la composante x des coordonnees
	 * @return le composante x des coordonnees
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Renvoie la composante y des coordonnees
	 * @return la composante y des coordonnees
	 */
	public int getY() {
		return y;
	}
	
	public boolean equals(Coordonnee c){
	    return (y==c.y&&x==c.x);
	}
	
	public String toString(){
	    return "("+x+";"+y+")";
	}
}
