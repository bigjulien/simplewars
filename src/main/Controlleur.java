package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;



import event.ColourCaseListener;

import javax.swing.JOptionPane;

import affichage.ChoixUnite;
import affichage.Frame;
import affichage.PanelInformations;
import joueur.Joueur;
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
	// Nombre de joueurs fixe
	private static final int NBJOUEURS = 2;
	
	private Map map;
	private Random rand;
	private Frame f;
	private boolean deuxiemeClick =false;
	private Coordonnee memoire ;
	private static Infos infos = new Infos() ;
	
	private Joueur[] joueurs;
	
	private int joueurCourrant;
	private HashMap <Coordonnee,ColourCaseListener> colourCaseListener = new HashMap<>();
	
	private ArrayList<Coordonnee> listeCasesColoriees=new ArrayList<Coordonnee>();
	public Joueur getJoueurCourant() {
		return joueurs[joueurCourrant];
	}
	
	public Controlleur(Map map, Frame frame, PanelInformations panelInfo) {
        this.map = map;
		initJoueurs();
		f = frame;
		
		panelInfo.addJoueurChangedListener(panelInfo);
		
		// Ready to play
		this.rand = new Random();
	}
	
	
	
	public void onStateRealized(ColourCaseListener l,Coordonnee c) {
	    this.colourCaseListener.put(c,l);
	}
	
	
	public void joueurSuivant() {
	    joueurCourrant = (joueurCourrant + 1) % joueurs.length;
	    getJoueurCourant().resetDejaDeplace();
	    getJoueurCourant().getChateau().setProduced(false);
	}
	
	public void initJoueurs() {
		joueurs = new Joueur[NBJOUEURS];
		
		// Deux joueur dans cette version du jeu
		
		for (int i = 0; i < joueurs.length; ++i) {
			Joueur joueur = new Joueur ("Joueur " + (i + 1));
			
			// un joueur sur deux a des unitees regardant a gauche
			joueur.setGauche((i % 2) != 0);
			joueur.setChateau(map.getChateau(i));
			
			map.getChateau(i).setJoueur(joueur);
			
			joueurs[i] = joueur;
		}
		
		// Initialisation du premier joueur
		joueurCourrant = 0;
	}
	
	public void creation () {
	    if (!getJoueurCourant().getChateau().canProduce())
	        return;
	        
		new ChoixUnite(this);	
	}
	
	
	public void prepareDeplacement (Joueur j, Coordonnee c) {
		memoire = c;		
	}
	
	public void partieGagnee(Joueur j) {
		JOptionPane.showMessageDialog(f, "Partie gagnee", "Le joueur " + j.getNom() + " gagne !", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public boolean deplacer (Joueur j, Coordonnee org, Coordonnee dst) {
		System.out.println("Hello");
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
				/*int i=a.getY();
				while(i<=a.getY()+infos.getMAX_DEPLACEMENT())
				{
					i++;
					Coordonnee cn=new Coordonnee(a.getX(),i);
					try
					{
					if(!(getCellule(cn).estVideetPrat()))
					{
						
						return false;
					}			
					}
					catch(ArrayIndexOutOfBoundsException np)
					{
						
						System.out.println("");
					}
					
				}*/
				return true;
			}
		}
		
		else if(a.getX() != b.getX() && a.getY() == b.getY())
		{
			if(Math.abs(a.getX()-b.getX())<=infos.getMAX_DEPLACEMENT())
			{
				/*int i = a.getX();
				while(i<=a.getX()+infos.getMAX_DEPLACEMENT())
				{
					i++;
					Coordonnee cn=new Coordonnee(i,a.getY());	
					try
					{
					if(!(getCellule(cn).estVideetPrat()))
					{
						
						return false;
					}			
					}
					catch(ArrayIndexOutOfBoundsException np)
					{
						System.out.println("");
						
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
	
	@SuppressWarnings("static-access")
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

	private Cellule getCellule(Coordonnee a)
	{
		Cellule[][] g = map.getGrille();
		return g[a.getX()][a.getY()];
	}
	
	public void click(Coordonnee coordonnee) {
		
		Cellule cellule = getCellule(coordonnee);
		System.err.println("La cellule contient :"+cellule.contientUnite());
		System.err.println("C'est le 2ème clique :"+deuxiemeClick);
        // Si on clique sur une cellule qui a un batiment au premier clic
        if(cellule.contientBatiment() && cellule.getBatiment().getJoueur().equals(getJoueurCourant()))
        {
            // si le batiment appartient au joueur
            if (cellule.getBatiment().getJoueur().equals(getJoueurCourant())){
                creation();
            }
            unColourAllCorrectCase();
            
        }
        
        else if (cellule.contientUnite() && !deuxiemeClick)
        {        	
    		if (cellule.getUnit().isDejaDeplace()) return;
    		getRespectfullCases(coordonnee);
    	    colourAllCorrectCase();    	   
    		prepareDeplacement(getJoueurCourant(), coordonnee);
    		deuxiemeClick = true;

    	}
    	else if(deuxiemeClick && !(cellule.contientUnite() && cellule.getUnit().getJoueur() == getJoueurCourant()))
    	{
    		
    	    unColourAllCorrectCase();
    	    deplacer(getJoueurCourant(), memoire , coordonnee);
    	    deuxiemeClick = false; 	
    	}

	}
}
