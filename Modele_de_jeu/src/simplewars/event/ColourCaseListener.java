package simplewars.event;

import simplewars.map.Coordonnee;

public interface ColourCaseListener {

    public void colourCase(Coordonnee c);
    public void decolourCase(Coordonnee c);
}
