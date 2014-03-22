package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import affichage.Frame;

import joueur.Joueur;

import map.Chateau;
import map.Map;


import unit.Archer;
import unit.Chevalier;
import unit.Piquier;
import unit.Unite;
import gestionnaireInfos.Infos;
import map.Cellule;
import map.Coordonnee;

/**
 * Permet de gerer les mecanismes de jeu
 * @author Julien Le Van Suu
 * 
 */
public class Controlleur {
	private Map map;
	private Random rand;
	Frame f;
	private boolean run;
	
	public static Infos infos = new Infos() ;
	List<Joueur> joueurs;
	private Joueur joueurCourrant;
	
	private static final String CONFIGPATH = "Map0";
		
	public Joueur getJoueurCourrant() {
		return joueurCourrant;
	}
	
	public Controlleur() {
		initJoueurs();
		initMap();
		initChateaux();
		f = new Frame(map);
		// Ready to play
		this.rand = new Random();
		this.run = true;
	}
	
	public void initJoueurs() {
		joueurs = new ArrayList<>();
		
		// Deux joueur dans cette version du jeu
		
		joueurs.add(new Joueur ("Joueur 1"));
		joueurs.add(new Joueur ("Joueur 2"));
	}
	
	public void initChateaux() {
		// Placer chaque chateau sur la carte et l'affecter a un joueur
		
		Chateau c;
		joueurs.get(1).setChateau(map.getChateau1());
		joueurs.get(1).setChateau(map.getChateau2());
		
	}
	
	public void run() {
		while (run) {
			phaseCreation();
			phaseDeplacement();
		}
	}
	
	public void phaseCreation() {
		for (Joueur j : joueurs) {
			joueurCourrant = j;
			creation();
		}
	}
	
	public void creation () {
		
	}
	
	public void phaseDeplacement() {
		for (Joueur j : joueurs) {
			joueurCourrant = j;
			deplacement(j);
		}
	}
	
	public void deplacement (Joueur j) {
		
	}
	
	public boolean deplacer (Joueur j, Coordonnee org, Coordonnee dst) {
		Unite unit = map.getCellule(org).getUnit();
		
		// Si il n'y a pas d'unite a deplacer ou que l'unite selectionnee n'appartient pas au joueur
		if (unit == null || unit.getJoueur() != j || !respecteLimiteDeplacement(org, dst))
			return false;
		
		Cellule cellOrg = map.getCellule(org),
				cellDst = map.getCellule(dst);
		
		if (!cellDst.getTerrain().isPraticable() || (cellDst.getUnit() != null && !combat(cellOrg, cellDst)))
			return false;
		
		// Bon pour deplacement
		cellDst.setUnit(cellOrg.getUnit());
		cellOrg.setUnit(null);
		
		return true;
	}
	
	private boolean combat (Cellule org, Cellule dst) {
		if (attack(org.getUnit(), dst.getUnit())) {
			dst.setUnit(null);
			return true;
		}
		
		org.setUnit(null);
		return false;
	}
	
	private boolean attackFavorable() {
		return true;
	}
	
	private boolean attackDefavorable() {
		return false;
	}
	
	private boolean attackEgal() {
		return rand.nextBoolean();
	}
	
	private boolean attack(Unite unit1, Unite unit2)
	{
		
		//Pas de combat fratricide
		if (unit1.getJoueur() == unit2.getJoueur())
			return false;
		
		if (unit1 instanceof Archer) {
			if (unit2 instanceof Piquier)
				return attackFavorable();
			
			if (unit2 instanceof Chevalier)
				return attackDefavorable();
			
			return attackEgal();
		}
		if (unit1 instanceof Piquier) {
			if (unit2 instanceof Chevalier)
				return attackFavorable();
			
			if (unit2 instanceof Archer)
				return attackDefavorable();
			
			return attackEgal();
		}
		if (unit1 instanceof Chevalier) {
			if (unit2 instanceof Archer)
				return attackFavorable();
			
			if (unit2 instanceof Piquier)
				return attackDefavorable();
			
			return attackEgal();
		}
		
		return false;
	}
	
	public boolean respecteLimiteDeplacement(Coordonnee a, Coordonnee b) {
		// Si on change de place en Y
		if(a.getX() == b.getX() && a.getY() != b.getY())
		{
			// Alors il faudrait que Y1-Y2 soit plus petit que le ddéplacement max. 
			if(Math.abs(a.getY()-b.getY())<=infos.getMAX_DEPLACEMENT())
			{
				return true;
			}
		}
		
		else if(a.getX() != b.getX() && a.getY() == b.getY())
		{
			if(Math.abs(a.getX()-b.getX())<=infos.getMAX_DEPLACEMENT())
			{
				return true;
			}
		}
		return false;
	}
	
	public void initMap() {
		map = new Map(CONFIGPATH);
	}
	
	
	
	private void creerUnit(Joueur joueur, Unite unit) {
	    joueur.getChateau().getCell().setUnit(unit);
	}
	
	public void creerArcher(Joueur joueur) {
	    creerUnit(joueur, new Archer(joueur));
	}
	
	public void creerChevalier(Joueur joueur) {
	    creerUnit(joueur, new Chevalier(joueur));
	}
	
	public void creerPiquier(Joueur joueur) {
	    creerUnit(joueur, new Piquier(joueur));
	}

	
	private boolean Obstacle(Cellule carr) {
		if(carr.getTerrain().isPraticable())
		{
			return true;
		}
		return false;
	}

	private Cellule getCellule(Coordonnee a)
	{
		Cellule[][] g = map.getGrille();
		return g[a.getX()][a.getY()];
	}

}
