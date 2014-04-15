package simplewars.unit;

import java.awt.image.BufferedImage;
import java.io.File;

import ressources.Audio;
import simplewars.joueur.Joueur;
import simplewars.map.Cellule;

public abstract class Unite {
	
	private Cellule cell;
	private BufferedImage bufferedImage;
	private BufferedImage bufferedImageForme;
	private boolean dejaDeplace;
	
	protected Joueur joueur;
	
	
	public Unite (Joueur j){
        this.joueur = j;
        bufferedImageForme=getImageForme();
        if(j.isGauche())
            bufferedImage=getImageGauche();
        else
            bufferedImage=getImageDroite();
	}
	
	
    /**
	 * Recupere le nombre de deplacement possible pour le tour actuel
	 * @return le nombre de deplacement
	 */
	public abstract int getNbDeplacement();
	public abstract String getSoundSelected();
	
	public void playSoundSelected() {
		System.out.println("exist : " + new File(getSoundSelected()).exists());
		System.out.println(getSoundSelected());
		Audio.playSound(getSoundSelected());
	}
	
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
    
   
    public abstract BufferedImage getImageDroite();
    public abstract BufferedImage getImageGauche();
    public abstract BufferedImage getImageForme();
    
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
