package map;

import unit.Archer;
import unit.Chevalier;
import unit.Piquier;
import joueur.Joueur;

public class Chateau implements Batiment {

	private static String IMAGEPATH = "img/chateau.png";
	
	private Joueur joueur;
	private Cellule cell;
	
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
	
	public void produireArcher() {
	    cell.setUnit(new Archer());
	}
	
	public void produireChevalier() {
	    cell.setUnit(new Chevalier());
	}
	
	public void produirePiquier() {
	    cell.setUnit(new Piquier());
	}

}
