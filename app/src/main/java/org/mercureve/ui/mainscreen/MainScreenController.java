package org.mercureve.ui.mainscreen;

public interface MainScreenController {

    public interface Display {

    }

    void setDisplay(Display display);
    String getAuthorizationString(String authCode);
}
