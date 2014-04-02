package map;


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

	public Cellule getVoisinLibre(Cellule cell) {
		Coordonnee coord =cell.getCoordonnee();
		
		try{
			if(grille[coord.getX()+1][coord.getY()].estVideetPrat() )
			{
				return grille[coord.getX()+1][coord.getY()];
			}
			if(grille[coord.getX()][coord.getY()+1].estVideetPrat())
			{
				return grille[coord.getX()][coord.getY()+1];
			}
			if(grille[coord.getX()-1][coord.getY()].estVideetPrat())
			{
				return grille[coord.getX()-1][coord.getY()];
			}
			if(grille[coord.getX()][coord.getY()-1].estVideetPrat())
			{
				return grille[coord.getX()][coord.getY()-1]; 
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.print("Plus de place");
		}
		
		return null;
	}

}
