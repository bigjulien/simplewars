package event;

import java.util.EventListener;

public interface JoueurChangedListener extends EventListener {
    public void changed(JoueurChangedEvent e);
}
