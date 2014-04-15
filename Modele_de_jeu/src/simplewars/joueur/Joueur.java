package simplewars.joueur;


import java.util.ArrayList;
import java.util.List;

import simplewars.unit.Unite;

import simplewars.map.Chateau;

public class Joueur {
	private String nom;
	private Chateau chateau;
	
	private List<Unite> listUnit;
	
	// Donne le sens du joueur, pour que ses images soit tournees vers l'ennemi
	private boolean gauche=true;
	
	public Joueur (String nom) {
		this.nom = nom;
		
		listUnit = new ArrayList<>();
	}
	
	public void resetDejaDeplace() {
	    for (Unite u : listUnit)
	        u.setDejaDeplace(false);
	}
	
	public void addUnit(Unite u) {
	    listUnit.add(u);
	}
	
	public void delUnit(Unite u) {
	    listUnit.remove(u);
	}
	
	public Joueur (String nom,boolean gauche) {
	    this.nom = nom;
	    this.gauche=gauche;
	}
	
	public String getNom() {
		return nom;
	}
	
	public Chateau getChateau() {
		return chateau;
	}
	
	public void setChateau (Chateau chateau) {
		this.chateau = chateau;
	}

    public boolean isGauche() {
        return gauche;
    }

    public void setGauche(boolean gauche) {
        this.gauche = gauche;
    }
	
}
