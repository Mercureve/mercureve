package org.mercureve.ui.mainscreen;

public interface MainScreenController {

    public interface Display {

    }

    void setDisplay(Display display);
    void authenticate(String authCode);
}
