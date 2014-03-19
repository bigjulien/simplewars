package main;

import java.util.ArrayList;
import java.util.List;

import joueur.Joueur;

import map.Chateau;
import map.Map;


import unit.Archer;
import unit.Chevalier;
import unit.Piquier;
import unit.Unite;
import gestionnaireInfos.Infos;
import map.Cellule;
import map.Chateau;
import map.Coordonnee;
import map.Map;

/**
 * Permet de gerer les mecanismes de jeu
 * @author Julien Le Van Suu
 * 
 */
public class Controlleur {
	private Map map;
	public static Infos infos = new Infos() ;
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
	
	private void creerUnit(Joueur joueur, Unite unit) {
	    joueur.getChateau().getCell().setUnit(unit);
	}
	
	public void creerArcher(Joueur joueur) {
	    creerUnit(joueur, new Archer());
	}
	
	public void creerChevalier(Joueur joueur) {
	    creerUnit(joueur, new Chevalier());
	}
	
	public void creerPiquier(Joueur joueur) {
	    creerUnit(joueur, new Piquier());
	}
	
	public void init (String configPath) {
		lireCarte(configPath);
		affecterChateaux();
	}

	public void changerDePlaceUnite(Coordonnee a, Coordonnee b)
	{
		Cellule cdedep=getCellule(a);
		Cellule carr=getCellule(b);
		if(respecteDeplace(a, b))
		{
			if(Obstacle(carr))
			{
				if(carr.getUnit()==null)
				{
					Unite u1=cdedep.getUnit();					
					cdedep.setUnit(null);
					carr.setUnit(u1);
				}
				else
				{
					attack(cdedep, carr);
				}
			}
			
			
		}
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
	
	private boolean respecteDeplace(Coordonnee a, Coordonnee b)
	{
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
	
	private void attack(Cellule cdep,Cellule carr)
	{
		//if(cdep )
	}

}
