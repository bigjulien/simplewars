package joueur;

import map.Chateau;

public class Joueur {
	private String nom;
	private Chateau chateau;
	
	// Donne le sens du joueur, pour que ses images soit tournees vers l'ennemi
	private boolean gauche=true;
	
	public Joueur (String nom) {
		this.nom = nom;
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
    
    public String toString (){
        return nom+chateau;
    }
	
}
