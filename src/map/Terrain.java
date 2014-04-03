package map;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public abstract class Terrain {
	
	private Color couleur;
	private boolean praticable;
	private BufferedImage bufferedImage;
	
	
	public Terrain (Color couleur, boolean praticable) {
		this.couleur = couleur;
		this.praticable = praticable;
	}
	
	public abstract String getPathImage();
	
	public Terrain (boolean particable){
	    this.praticable=praticable;
        
        String path =  getPathImage();

        try {
            setBufferedImage(ImageIO.read(new File(path)));
            
        } catch (Exception e) {
            System.out.println("Fichier manquant : " + path);
        }    
	}
	
	public Color getCouleur() {
		return couleur;
	}
	
	public boolean isPraticable() {
		return praticable;
	}
	
	/**
	 * Representation du terrain sous forme de chaine de character
	 */
	public String toString (){
	    String praticabilite = praticable ? "praticable" : "impraticable";
	    return "terrain "+praticabilite;
	}

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }
    
    public void setBufferedImage(String path){
        try {
            setBufferedImage(ImageIO.read(new File(path)));
            
        } catch (Exception e) {
            System.out.println("Fichier manquant : " + path);
        }    
    }
}
