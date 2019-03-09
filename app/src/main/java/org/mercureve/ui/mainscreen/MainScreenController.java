package org.mercureve.ui.mainscreen;

import org.mercureve.domain.AuthorizedCharacter;
import org.mercureve.domain.Location;

public interface MainScreenController {

    public interface Display {

    }

    void setDisplay(Display display);
    void authenticate(String authCode);
    AuthorizedCharacter getCharacter();
    Location getLocation(String characterId);
}
