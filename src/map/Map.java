package map;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Gere les informations de la carte
 * @author Benjamin CLAQUIN
 *
 */
public abstract class Map {

    protected Cellule[][] grille;
    
    private int largeur,hauteur;
    private String configFile;
    
    
    public Map (int largeur,int hauteur){
        this.largeur=largeur;
        this.hauteur=hauteur;
        this.grille= new Cellule[largeur][hauteur];
    }
    
    
    public Map(String configFile){
        this.configFile=configFile;
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
    
    /**
     * Ajoute des caracteristiques a la carte en fonction
     * des informations lues sur le fichier de config
     * @param fileName
     * @throws IOException 
     */
    public void mapReader() throws IOException {
        
        String[] tab;
        FileInputStream fstream = new FileInputStream(configFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;

        while ((strLine = br.readLine()) != null)   {
            mapInterpretor(strLine);
        }
        
        br.close();
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
        String[] tab = s.split(":");
        if (tab.length==0 || tab.length==1)
            return;
        switch (tab[0]){
            case "largeur":largeur=Integer.parseInt(tab[1]);break;
            case "hauteur":hauteur=Integer.parseInt(tab[1]);break;
        }
    }

}
