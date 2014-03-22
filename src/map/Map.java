package map;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import joueur.Joueur;
import unit.Archer;


/**
 * Gere les informations de la carte
 * @author Benjamin CLAQUIN
 *
 */
public class Map {

    protected Cellule[][] grille;
    
    private int largeur,hauteur;
    private Chateau chateau1, chateau2;
    
    private String configFile;
    
    
    public Map (int largeur,int hauteur){
        this.largeur=largeur;
        this.hauteur=hauteur;
        this.grille= new Cellule[largeur][hauteur];
    }
    
    public Cellule getCellule (Coordonnee c) {
    	return grille[c.getX()][c.getY()];
    }
    
    public Chateau getChateau1() {
    	return chateau1;
    }

    public Chateau getChateau2() {
        return chateau1;
    }
    
    public Coordonnee getCoordoneeChateau1(){
        return chateau1.getCell().getCoordonnee();
    }
    
    public Coordonnee getCoordoneeChateau2(){
        return chateau2.getCell().getCoordonnee();
    }
    
    public Map(String configFile){
        this.configFile=configFile;
        mapReader();
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
    public void mapInterpretor (String s){
        
        String[] tab = s.split(" ");
        if (tab.length==0 || tab.length==1)
            return;
        switch (tab[0]){
            case "largeur":largeur=Integer.parseInt(tab[1]);break;
            case "hauteur":hauteur=Integer.parseInt(tab[1]);break;
            case "chateau1": chateau1 = new Chateau(grille[Integer.parseInt(tab[1])][Integer.parseInt(tab[2])]);
                             grille[Integer.parseInt(tab[1])][Integer.parseInt(tab[2])].setBatiment(chateau1);; break;
            case "chateau2": chateau2 = new Chateau(grille[Integer.parseInt(tab[1])][Integer.parseInt(tab[2])]);
                             grille[Integer.parseInt(tab[1])][Integer.parseInt(tab[2])].setBatiment(chateau1);; break;
            case "Archer":  Archer archer = new Archer(new Joueur("joueur",true));
                            archer.setJoueur(new Joueur("babar"));
                            grille[Integer.parseInt(tab[1])][Integer.parseInt(tab[2])].setUnit(archer);; break;
        }
        System.out.println(""+largeur+";"+hauteur);
    }
    
    /**
     * Interprete un fichier de configuration pour configurer la map
     * 
     * Le fichier s'ecrit de la fa�on suivente
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
    public void mapReader (){
        
        String[] tab;
        try {
            FileInputStream fstream = new FileInputStream(configFile);
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
            this.grille= new Cellule[largeur][hauteur];
            
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
            
                        interpreteMapElement(tab[j+1],i,j);
            
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
        }
        catch(IOException e){
            System.err.println("Fichier de configuration de la map introuvable");
        }
    }
    
    /**
     * Interprete les 0 et les 1 et ajoute en consequence
     * les elements corespondants sur la grille
     * @param s
     * @param i
     * @param j
     */
    public void interpreteMapElement (String s,int i,int j){
        //System.out.println("une interpretation "+s+" ("+i+","+j+")");
        switch (s){
        case "0":grille[i][j]= new Cellule(new Coordonnee(i,j),new TerrainPraticable());break;
        case "1":grille[i][j]= new Cellule(new Coordonnee(i,j),new TerrainImpraticable());break;
        default : grille[i][j] = new Cellule(new Coordonnee(i,j),new TerrainPraticable());break;
        }
    }

	public Cellule getVoisinLibre(Cellule cell) {
		Coordonnee coord =cell.getCoordonnee();
		if(grille[coord.getX()+1][coord.getY()].estVideetPrat() )
		{
			return grille[coord.getX()+1][coord.getY()];
		}
		else if(grille[coord.getX()][coord.getY()+1].estVideetPrat())
		{
			return grille[coord.getX()][coord.getY()+1];
		}
		return null;
	}

}
