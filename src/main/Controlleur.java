package main;

import java.util.ArrayList;
import java.util.List;

import joueur.Joueur;

import map.Chateau;
import map.Map;

/**
 * Permet de gerer les mecanismes de jeu
 * @author Benjamin CLAQUIN
 *
 */
public class Controlleur {
	private Map map;
	
	List<Joueur> joueurs;
	
	public Controlleur() {
		joueurs = new ArrayList<>();
		
		// Deux joueur dans cette version du jeu
		
		joueurs.add(new Joueur ("Joueur 1"));
		joueurs.add(new Joueur ("Joueur 2"));
	}
	
	public void lireCarte(String configPath) {
		map = new Map(configPath);
	}
	
	public void affecterChateaux() {
		Chateau c;
		c = new Chateau(joueurs.get(0));
		joueurs.get(1).setChateau(c);
		c = new Chateau(joueurs.get(1));
		joueurs.get(1).setChateau(c);
	}
	
	public void init (String configPath) {
		lireCarte(configPath);
		affecterChateaux();
	}
}
