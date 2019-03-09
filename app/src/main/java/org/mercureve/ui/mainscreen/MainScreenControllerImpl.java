package org.mercureve.ui.mainscreen;

import org.mercureve.service.AuthService;

public class MainScreenControllerImpl implements MainScreenController {

    private Display display;

    private AuthService authService;

    public MainScreenControllerImpl(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public void setDisplay(Display display) {
        this.display = display;
    }

    @Override
    public void authenticate(String authCode) {
        authService.authenticate(authCode);
    }
}
