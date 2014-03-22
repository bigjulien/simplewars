package map;

import joueur.Joueur;

public class Chateau implements Batiment {

	private static String IMAGEPATH = "Units/unit_arch.png";
	
	private Joueur joueur;
	private Cellule cell;

	public Chateau (Cellule cell) {
        this.cell = cell;
    }
    
	
	public Chateau (Joueur j) {
		this.joueur = j;
	}
	
	public Chateau (Cellule cell, Joueur j) {
		this.joueur = j;
		this.cell = cell;
	}
	
	public String getImagePath() {
		return IMAGEPATH;
	}
	
	public Joueur getJoueur() {
	    return joueur;
	}
	
	public Cellule getCell() {
	    return cell;
	}
	
	public String toString(){
	    if (cell!=null && joueur!=null)
	        return " (Chateau du joueur "+joueur+" "+cell+" "+") ";
	    else if (joueur==null)
	        System.err.println("l�l, ce chateau n'a pas de joueur");
	    else if (cell==null)
	        System.err.println("l�l, ce chateau n'a pas de cellule");
	    return "chateau n'ayant pas de joueur ou de cellule";
	    
	}

}
