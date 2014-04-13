package jeu;

import java.io.File;

/** classe pour lancer le jeu
 * Elle cr�� simplement une instance de MenuJeu
 * 
 * @author helene
 *
 */
public class LancementJeu{

    public static void main(String args[]){
        System.out.println(new File("./ressources/si_vox_ihm.conf").exists());
        
        new jeu.MenuJeu("Exemple de jeu");
    }

}
