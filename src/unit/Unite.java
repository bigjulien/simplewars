package unit;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javazoom.jl.player.Player;

import joueur.Joueur;
import map.Cellule;

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
		playSound(getSoundSelected());
	}
	
	public static synchronized void playSound(final String url) {
		new Thread(new Runnable() {
		  // The wrapper thread is unnecessary, unless it blocks on the
		  // Clip finishing; see comments.
		    public void run() {
		    	try{
		    	    FileInputStream fis = new FileInputStream(url);
		    	    Player playMP3 = new Player(fis);
		    	    playMP3.play();
		    	}
		    	catch(Exception exc){
		    	    exc.printStackTrace();
		    	    System.out.println("Failed to play the file.");
		    	}
		    }
		  }).start();
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
