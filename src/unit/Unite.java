package unit;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import joueur.Joueur;
import map.Cellule;

public abstract class Unite {
	
	private Cellule cell;
	private BufferedImage bufferedImage;
	private boolean dejaDeplace;

	private Joueur joueur;
	
	/**
	 * Recupere le nombre de deplacement possible pour le tour actuel
	 * @return le nombre de deplacement
	 */
	public abstract int getNbDeplacement();
	
	/**
	 * Renvoie la cellule de l'unite
	 * @return les cellule de l'unite
	 */
	public Cellule getCell() {
		return cell;
	}
	
	/**
	 * Change la cellule de l'unite
	 * @param cell la nouvelle cellule de l'unite
	 */
	public void setCell (Cellule cell) {
		this.cell = cell;
	}

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }
    
    public void setBufferedImage(String imageLink) {
        try {
            bufferedImage = ImageIO.read(new File(imageLink));
        } catch (Exception e) {
            System.out.println("Fichier" + imageLink + " manquant ! ");
        }
    }

    public boolean isDejaDeplace() {
        return dejaDeplace;
    }

    public void setDejaDeplace(boolean dejaDeplace) {
        this.dejaDeplace = dejaDeplace;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }	
}
