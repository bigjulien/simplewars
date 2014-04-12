package main;

import java.io.FileInputStream;

import javazoom.jl.player.Player;
import map.Map;
import map.MapReader;
import affichage.Frame;
import affichage.PanelCarte;
import affichage.PanelInformations;


/**
 * Classe de lancement du programme
 * @author Benjamin CLAQUIN
 *
 */
public class Main {
    private static final String CONFIGPATH = "Map0";
    
    private static final String MUSIQUE = "snd/musique.mp3";
        
    public static void playSound(final String url) {
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
    
    public static void musiqueAmbiante() {
        new Thread(new Runnable() {
              public void run() {
                  try{
                      while (true) {
                          FileInputStream fis = new FileInputStream(MUSIQUE);
                          Player playMP3 = new Player(fis);
                          playMP3.play();
                      }
        }
        catch(Exception exc){
            exc.printStackTrace();
             System.out.println("Failed to play the file.");

        }
        }
        }).start();

}

    
	public static void main(String[] args)
	{
	    boolean musique = true;

	    MapReader mapReader = new MapReader();
		Map map = mapReader.readMap(CONFIGPATH);
		
		PanelCarte panelCarte = new PanelCarte(map);
		PanelInformations panelInfo = new PanelInformations();
	    
	    Frame frame = new Frame(map, panelCarte, panelInfo);
	    
	    Controlleur c = new Controlleur(map, frame, panelInfo);
	    
	    panelCarte.setControl(c);
	    panelInfo.setControl(c);
	    
	    if (musique) {
	        musiqueAmbiante();
	    }
	}
}
