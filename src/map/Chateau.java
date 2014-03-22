package map;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import joueur.Joueur;

public class Chateau extends Batiment {

	private static String IMAGEPATH = "Units/chateau.png";


	public Chateau (Cellule cell) {
	    setBufferedImage(IMAGEPATH);
        this.cell = cell;
    }
    
	
	public Chateau (Joueur j) {
		this.joueur = j;
	}
	
	public Chateau (Cellule cell, Joueur j) {
		this.joueur = j;
		this.cell = cell;
	}
	
	public String getImagePath() {
		return IMAGEPATH;
	}
	
	public Joueur getJoueur() {
	    return joueur;
	}
	
	public Cellule getCell() {
	    return cell;
	}
	
	public String toString(){
	    if (cell!=null && joueur!=null)
	        return " (Chateau du joueur "+joueur+" "+cell+" "+") ";
	    else if (joueur==null)
	        System.err.println("l�l, ce chateau n'a pas de joueur");
	    else if (cell==null)
	        System.err.println("l�l, ce chateau n'a pas de cellule");
	    return "chateau n'ayant pas de joueur ou de cellule";
	    
	}


	public void setBufferedImage(String imageLink) {
        try {
            bufferedImage = ImageIO.read(new File(imageLink));
        } catch (Exception e) {
            System.out.println("Fichier" + imageLink + " manquant ! ");
        }
    }


    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }


    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    
}
