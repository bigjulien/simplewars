package unit;

import images.Images;

import java.awt.image.BufferedImage;

import joueur.Joueur;

public class Archer extends Unite {
    

    
    private static final BufferedImage ImageGauche = Images.arch_G;
    private static final BufferedImage ImageDroite = Images.arch_D;
    private static final BufferedImage ImageForme = Images.arch;
    
    private static final int NBDEPLACEMENT = 1;
    
    public Archer(Joueur joueur){
        super(joueur);
    }
    
    public int getNbDeplacement() {
        return NBDEPLACEMENT;
    }
    
    public String toString(){
        try {
        return "archer du joueur "+joueur;
        }
        catch (NullPointerException e) {
            System.err.println("lel, un archer n'a pas de joueur");
        }
        return "error";
    }

    @Override
    public BufferedImage getImageDroite() {
        return ImageDroite;
    }

    @Override
    public BufferedImage getImageGauche() {
        return ImageGauche;
    }

    @Override
    public BufferedImage getImageForme() {
        // TODO Auto-generated method stub
        return ImageForme;
    }


}
