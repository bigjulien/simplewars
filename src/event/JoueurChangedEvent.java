package event;

import java.util.EventObject;

import joueur.Joueur;

public class JoueurChangedEvent extends EventObject {
    private static final long serialVersionUID = 1878576034849504974L;
    
    private Joueur nouveau;
    
    public JoueurChangedEvent(Object source, Joueur nouveau) {
        super(source);
        
        this.nouveau = nouveau;
    }
    
    public Joueur getJoueur() {
        return nouveau;
    }

}
