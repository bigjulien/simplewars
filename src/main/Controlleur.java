package main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;



import event.ColourCaseListener;

import javax.swing.JOptionPane;

import affichage.ChoixUnite;
import affichage.Frame;
import affichage.PanelInformations;
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
	public boolean deuxiemeClick =false;
	public Coordonnee memoire ;
	public static Infos infos = new Infos() ;
	List<Joueur> joueurs;
	Joueur j1 = new Joueur ("Joueur 1");
	Joueur j2 = new Joueur ("Joueur 2");
	
	private int joueurCourrant;
	public HashMap<Coordonnee,ColourCaseListener> colourCaseListener=new HashMap();
	private static final String CONFIGPATH = "Map0";
	
	// Dit si l'on affiche ou non les cases de deplacemenent
	public boolean displayChamp=false;
	
	private ArrayList<Coordonnee> listeCasesColoriees=new ArrayList<Coordonnee>();
	public Joueur getJoueurCourant() {
		return joueurs.get(joueurCourrant);
	}
	
	public Controlleur(Map map, Frame frame, PanelInformations panelInfo) {
        this.map = map;
		initJoueurs();
		initChateaux();
		f = frame;
		
		panelInfo.addJoueurChangedListener(panelInfo);
		
		// Ready to play
		this.rand = new Random();
		this.run = true;
	}
	
	
	
	public void onStateRealized(ColourCaseListener l,Coordonnee c) {
	    this.colourCaseListener.put(c,l);
	}
	
	
	public void joueurSuivant() {
	    joueurCourrant = (joueurCourrant + 1) % joueurs.size();
	    getJoueurCourant().resetDejaDeplace();
	    getJoueurCourant().getChateau().setProduced(false);
	}
	
	public void initJoueurs() {
		joueurs = new ArrayList<>();
		
		// Deux joueur dans cette version du jeu
		
		j1.setGauche(false);
		j2.setGauche(true);
		joueurs.add(j1);
		joueurs.add(j2);
		
		joueurCourrant = 0;
	}
	
	public void initChateaux() {
		// Placer chaque chateau sur la carte et l'affecter a un joueur
		Chateau a = map.getChateau1();
		Chateau b = map.getChateau2();
		a.setJoueur(j1);
		b.setJoueur(j2);
		j1.setChateau(a);
		j2.setChateau(b);

		
	}
	
	public void creation () {
	    if (!getJoueurCourant().getChateau().canProduce())
	        return;
	        
		ChoixUnite choix = new ChoixUnite(this);	
	}
	
	
	public void prepareDeplacement (Joueur j, Coordonnee c) {
		memoire = c;
		deuxiemeClick = true;
	}
	
	public void partieGagnee(Joueur j) {
		new JOptionPane().showMessageDialog(f, "Partie gagnee", "Le joueur " + j.getNom() + " gagne !", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public boolean deplacer (Joueur j, Coordonnee org, Coordonnee dst) {
		Unite unit = map.getCellule(org).getUnit();
		
		// Si il n'y a pas d'unite a deplacer ou que l'unite selectionnee n'appartient pas au joueur
		if (unit == null || unit.getJoueur() != j || !respecteLimiteDeplacement(org, dst))
			return false;
		
		Cellule cellOrg = map.getCellule(org),
				cellDst = map.getCellule(dst);
		
		if (!cellDst.getTerrain().isPraticable())
			return false;
		
		if (cellDst.contientBatiment()) {
			// La cellule contiend le chateau ennemi
			partieGagnee(j);
			
			cellDst.setBatiment(null);
			
		}
		else if(cellDst.getUnit() != null && !combat(cellOrg, cellDst))
			return false;
		
		// Bon pour deplacement
		cellDst.setUnit(cellOrg.getUnit());
		cellOrg.setUnit(null);
		cellDst.getUnit().setDejaDeplace(true);
		deuxiemeClick = false;
		return true;
	}
	
	private void deleteUnit(Cellule c) {
        c.getUnit().getJoueur().delUnit(c.getUnit());
        c.setUnit(null);
	}
	
	private boolean combat (Cellule org, Cellule dst) {
		boolean win = attack(org.getUnit(), dst.getUnit());
		
		deleteUnit(win ? dst : org);
		
		return win;
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
				for(int i=a.getY();i<=a.getY()+infos.getMAX_DEPLACEMENT();i++)
				{
					Coordonnee cn=new Coordonnee(a.getX(),i) ;
					if(!(getCellule(cn).estVideetPrat()))
					{
						return false;
					}
				}
				return true;
			}
		}
		
		else if(a.getX() != b.getX() && a.getY() == b.getY())
		{
			if(Math.abs(a.getX()-b.getX())<=infos.getMAX_DEPLACEMENT())
			{
				/*for(int i=a.getX();i<=a.getX()+infos.getMAX_DEPLACEMENT();i++)
				{
					Coordonnee cn=new Coordonnee(i,a.getY()) ;
					if(!(getCellule(cn).estVideetPrat()))
					{
						return false;
					}
				}*/
				return true;
			}
		}
		return false;
	}

	
	/**
	 * Fonction permettant de recuperer toutes les coordonnes de la grille accessible a partir d'une coordonne, pour un deplacement simple
	 * 
	 * @param a
	 * @return
	 */
	public void getRespectfullCases(Coordonnee a){
	    
	    listeCasesColoriees.clear();
	    for (int i=0;i<map.getGrille().length;i++){
	        for (int j=0;j<map.getGrille()[i].length;j++){
	            if (respecteLimiteDeplacement(a,map.getGrille()[i][j].getCoordonnee())){
	                if (map.getGrille()[i][j].getTerrain().isPraticable())
	                    listeCasesColoriees.add(map.getGrille()[i][j].getCoordonnee());
	            }
	        }
	    }

	}
	
	/**
	 * Colorie toutes les cases etant dans le tableau listeCasesColoriees
	 */
	public void colourAllCorrectCase (){
	    if (listeCasesColoriees!=null){
	    Iterator<Coordonnee> it = listeCasesColoriees.iterator();
	    while (it.hasNext()) {
	           Coordonnee coordonnee = it.next();
	           colourCaseListener.get(coordonnee).colourCase(coordonnee);
	    }   
	    }
	}
	
	   /**
     * Colorie toutes les cases etant dans le tableau listeCasesColoriees
     */
    public void unColourAllCorrectCase (){
        if (listeCasesColoriees!=null){
        Iterator<Coordonnee> it = listeCasesColoriees.iterator();
        while (it.hasNext()) {
               Coordonnee coordonnee = it.next();
               colourCaseListener.get(coordonnee).decolourCase(coordonnee);
        }   
        }
    }
    
	
	public void initMap() {
		map = new Map(CONFIGPATH);
	}
	
	
	
	private void creerUnit(Joueur joueur, Unite unit) {
		try
		{
		    map.getVoisinLibre(joueur.getChateau().getCell()).setUnit(unit);	    
			joueur.addUnit(unit);
	        joueur.getChateau().setProduced(true);

		}
		catch(NullPointerException e)
		{
			JOptionPane jop = new JOptionPane();
			jop.showMessageDialog(null, "<HTML> <FONT SIZE=200><B>Plus de place</B></HTML>", "", JOptionPane.WARNING_MESSAGE);
			
		}
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
