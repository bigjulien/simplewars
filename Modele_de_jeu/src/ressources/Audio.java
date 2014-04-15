package ressources;

import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Audio {
    private static final String SND = Ressources.RESS + "sons/";
    
    public static final String MUSIQUE = SND + "musique.mp3";
    public static final String AIDE = SND + "aide.mp3";
    
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
}
