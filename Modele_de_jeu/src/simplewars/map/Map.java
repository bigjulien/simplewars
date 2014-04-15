package simplewars.map;

import java.util.ArrayList;
import java.util.List;


/**
 * Gere les informations de la carte
 * @author Benjamin CLAQUIN
 *
 */
public class Map {

    protected Cellule[][] grille;
    
    private int largeur,hauteur;
    private Chateau[] chateaux;
        
    public Cellule getCellule (Coordonnee c) {
    	return grille[c.getX()][c.getY()];
    }
    
    public Chateau getChateau(int i) {
    	return chateaux[i];
    }
    
    public Coordonnee getCoordoneeChateau(int i){
        return chateaux[i].getCell().getCoordonnee();
    }
    
    public Map(Cellule[][] grille, Chateau[] chateaux){
        this.grille = grille;
        this.chateaux = chateaux;
        
        this.hauteur = grille[0].length;
        this.largeur = grille.length;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }
    
    public Cellule[][] getGrille(){
        return grille;
    }
    
    private boolean isValid(Coordonnee coordonnee) {
    	int x = coordonnee.getX(),
    		y = coordonnee.getY();
    	
    	return 0 <= x && x < largeur && 0 <= y && y < hauteur; 
    }
    
    public List<Cellule> getVoisins(Cellule cell) {
    	List<Cellule> voisins = new ArrayList<>();
    	Coordonnee coordonnee = cell.getCoordonnee();
    	
    	int x = coordonnee.getX(),
    		y = coordonnee.getY();
    	
    	List<Coordonnee> coordonneeVoisines = new ArrayList<>();
    	coordonneeVoisines.add(new Coordonnee(x + 1, y));
    	coordonneeVoisines.add(new Coordonnee(x - 1, y));
    	coordonneeVoisines.add(new Coordonnee(x, y -1));
    	coordonneeVoisines.add(new Coordonnee(x, y + 1));
    	
    	for (Coordonnee c : coordonneeVoisines) {
    		if (isValid(c)) {
    			Cellule voisin = getCellule(c);
        		
    			if (voisin.getTerrain().isPraticable())
    				voisins.add(voisin);
    		}
    	}
    	
    	return voisins;
    }

	public Cellule getVoisinLibre(Cellule cell) {				
		for (Cellule c : getVoisins(cell)) {
			if (!c.contientUnite())
				return c;
		}
		
		return null;
	}

}
