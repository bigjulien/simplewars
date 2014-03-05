package map;

import joueur.Joueur;

public class Chateau implements Batiment {

	private static String IMAGEPATH = "img/chateau.png";
	
	private Joueur joueur;
	
	public Chateau (Joueur j) {
		this.joueur = j;
	}
	
	public String getImagePath() {
		return IMAGEPATH;
	}

}
