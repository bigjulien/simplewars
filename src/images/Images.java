package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

public class Images {

public static final String CHATEAU = "Images/Batiment/chateau.png";

// Unites
public static final String ARCHERG = "Images/Unites/unit_archG.png";
public static final String ARCHERD = "Images/Unites/unit_archD.png";
public static final String PIQUIERG = "Images/Unites/unit_piqG.png";
public static final String PIQUIERD = "Images/Unites/unit_piqD.png";
public static final String CHEVALIERG = "Images/Unites/unit_chevG.png";
public static final String CHEVALIERD = "Images/Unites/unit_chevD.png";


// Unites avec formes

public static final String ARCHER = "Images/Unites/triangle.png";
public static final String PIQUIER = "Images/Unites/carre.png";
public static final String CHEVALIER = "Images/Unites/rond.png";

// Terrain

// Terrain praticable
public static String lienPraticable = "Images/Terrains/Praticable/";

public static BufferedImage[] tabTerrainPraticable = new BufferedImage[6];

// Terrain impraticable
public static String lienImpraticable = "Images/Terrains/Impraticable/";

public static BufferedImage[] tabImpraticable = new BufferedImage[1];



// Selecteurs
public static final String selecteur = "Images/Selecteurs/";
public static final String selecJAUNE = selecteur + "/selectajaune.png";
public static final String selecVERT = selecteur + "/selectaalliedi.png";
public static final String selecROUGE = selecteur + "/selectaennemi.png";
public static final String selecBLEU = selecteur + "/selecta.png";
public static final String selecNOIR = selecteur + "/dejadeplace.png";

public static BufferedImage selecteurJauneB,arch_G,arch_D,chev_D,chev_G,piq_D,piq_G,arch,piq,chev;

// Set les images
static {

    try {
        //TODO serieux c'est ultra salle ca, vraiment : faire les choses bien ou ne rien faire
        selecteurJauneB = ImageIO
                .read(new File(selecJAUNE));
        final BufferedImage selecteurVertB = ImageIO.read(new File(selecVERT));
        final BufferedImage selecteurRougeB = ImageIO
                .read(new File(selecROUGE));
        final BufferedImage selecteurBleuB = ImageIO.read(new File(selecBLEU));
        final BufferedImage selecteurNoirB = ImageIO.read(new File(selecNOIR));
        
        
        arch_G = ImageIO.read(new File(ARCHERG));
        arch_D = ImageIO.read(new File(ARCHERD));
        chev_G = ImageIO.read(new File(CHEVALIERG));
        chev_D = ImageIO.read(new File(CHEVALIERD));
        piq_G = ImageIO.read(new File(PIQUIERG));
        piq_D = ImageIO.read(new File(PIQUIERD));
        arch = ImageIO.read(new File(ARCHER));
        piq = ImageIO.read(new File(PIQUIER));
        chev = ImageIO.read(new File(CHEVALIER));

    } catch (Exception e) {
        System.err.println("image non trouvee");
    }

    // Terrains impraticables
    for (int i = 0; i < tabTerrainPraticable.length; i++) {
        try {
            tabTerrainPraticable[i] = ImageIO.read(new File(lienPraticable
                    + "snow_" + i+".png"));
        } catch (Exception e) {
            System.out.println("Fichier manquant "+lienPraticable
                    + "snow_" + i+".png");
        }
    }
    
 // Terrains praticables
    for (int i = 0; i < tabImpraticable.length; i++) {
        try {
            tabImpraticable[i] = ImageIO.read(new File(lienImpraticable
                    + "imprat_" + i+".png"));
        } catch (Exception e) {
            System.out.println("Fichier manquant "+lienImpraticable
                    + "imprat_" + i+".png");
        }
    }

}

public static BufferedImage pickATerrainPraticable() {
    Random rand = new Random();
    int n = rand.nextInt(5);
    return tabTerrainPraticable[n];
}

public static BufferedImage pickATerrainImpraticable() {
    Random rand = new Random();
    int n = rand.nextInt(tabImpraticable.length);
    return tabImpraticable[n];
}

}
