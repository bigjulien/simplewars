package jeu.map;

import jeu.images.Images;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Interprete un fichier de configuration pour configurer la map
 * 
 * Le fichier s'ecrit de la facon suivente
 * 
 * largeur ...
 * hauteur ...
 * chateau1 ...
 * chateau2 ...
 * 
 * Map
 * 010101011010
 * 010101010101
 * 
 * 0 represente un terrain praticable
 * 1 un terrain impraticable
 * @param s
 */
public class MapReader {
	
	private int hauteur;
	private int largeur;
	
	private Chateau[] chateaux;
	private List<Coordonnee> coordonneesChateaux;
		
	public MapReader() {
		reset();
	}
	
	private void reset() {
		this.largeur = 0;
		this.hauteur = 0;
		
		this.coordonneesChateaux = new ArrayList<Coordonnee>();
		this.chateaux = null;
	}
	
	public Chateau[] getChateaux() {
		return chateaux;
	}
	

	private void initChateaux(Cellule[][] grille) {
		// Placer chaque chateau sur la carte et l'affecter a un joueur
		
		chateaux = new Chateau[coordonneesChateaux.size()];
		
		for (int i = 0; i < coordonneesChateaux.size(); ++i) {
			Coordonnee c = coordonneesChateaux.get(i);
			chateaux[i] = new Chateau(grille[c.getX()][c.getY()]);
			grille[c.getX()][c.getY()].setBatiment(chateaux[i]);
		}
	}
	
    /**
     * Cette methode sert pour la fonction mapReader
     * elle permet d'interpreter les parametre du fichier de configuration
     * d'une carte
     * ex : si on a
     *          largeur:1000
     * on effectue
     *           setLargeur(1000);
     * @param s
     */
    private void mapInterpretor (String s){
        
        String[] tab = s.split(" ");
        if (tab.length==0 || tab.length==1)
            return;
        switch (tab[0]){
        
        case "largeur":
        	largeur = Integer.parseInt(tab[1]);
        	break;
        case "hauteur":
        	hauteur = Integer.parseInt(tab[1]);
        	break;
        case "chateau": 
        	coordonneesChateaux.add(new Coordonnee(Integer.parseInt(tab[1]), Integer.parseInt(tab[2])));
        }
    }
    

    
    
    /**
     * Interprete les 0 et les 1 et ajoute en consequence
     * les elements corespondants sur la grille
     * @param s
     * @param i
     * @param j
     */
    public void interpreteMapElement (Cellule[][] grille, String s,int i,int j){
        //System.out.println("une interpretation "+s+" ("+i+","+j+")");
        switch (s){
        case "0":grille[i][j]= new Cellule(new Coordonnee(i,j),new TerrainPraticable(Images.pickATerrainPraticable()));break;
        case "1":grille[i][j]= new Cellule(new Coordonnee(i,j),new TerrainImpraticable(Images.pickATerrainImpraticable()));break;
        default : grille[i][j] = new Cellule(new Coordonnee(i,j),new TerrainPraticable(Images.pickATerrainPraticable()));break;
        }
    }
	
	public Map readMap(String configPath) {
	        
	    String[] tab;
	    
	    try {
	        FileInputStream fstream = new FileInputStream(configPath);
	        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
	        String strLine;
	        //strLine est la ligne actuellement lue
	        strLine =br.readLine();
	        
	        // Premiere phase d'analyse : lit les informations comme la largeur ou la hauteur
	        while (strLine != null && !strLine.equals("Map"))   {                
	            mapInterpretor(strLine);
	            strLine =br.readLine();
	        }
	        
	        // Maintenant que l'on dispose des informations de largeur et de
	        // hauteur de la grille on instencie cette derniere
	        
	        
	        Cellule[][] grille = new Cellule[largeur][hauteur];
	        
	        // j correspond a l'ordonnee de l'element de la carte lu
	        int i=0;
	        strLine =br.readLine();
	        
	        // Dechiffre les lignes suivant la ligne Map 
	        while (strLine != null && !strLine.equals("Chateaux")){
	            //tab est un tableau composee des chiffres caracterisant
	            //les elements de la carte
	            tab = strLine.split("");
	            // i est l'abscisse de l'element lu
	            for (int j=0;j<tab.length-1;j++){
	        
	                    interpreteMapElement(grille, tab[j+1],i,j);
	        
	            }
	            strLine =br.readLine();
	            i++;
	        }
	        
	        while (strLine!=null){
	            // Troisieme phase d'analyse, chateaux et unites                
	                mapInterpretor(strLine);
	                strLine =br.readLine();
	            }
	        
	        br.close();
	        
	        initChateaux(grille);
	        
	        return new Map(grille, chateaux);
	    }
	    catch(IOException e){
	        System.err.println("Fichier de configuration de la map introuvable");
	    }
		
	    return null;
	}
}
