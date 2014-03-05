package joueur;

import map.Chateau;

public class Joueur {
	private String nom;
	private Chateau chateau;
	
	public Joueur (String nom) {
		this.nom = nom;
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
	
}
