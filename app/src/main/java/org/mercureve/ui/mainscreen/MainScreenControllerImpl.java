package org.mercureve.ui.mainscreen;

import org.mercureve.domain.AuthorizedCharacter;
import org.mercureve.domain.Location;
import org.mercureve.service.AuthService;
import org.mercureve.service.CharacterLocationService;

public class MainScreenControllerImpl implements MainScreenController {

    private Display display;

    private AuthService authService;
    private CharacterLocationService locationService;

    public MainScreenControllerImpl(AuthService authService, CharacterLocationService locationService) {
        this.authService = authService;
        this.locationService = locationService;
    }

    @Override
    public void setDisplay(Display display) {
        this.display = display;
    }

    @Override
    public void authenticate(String authCode) {
        authService.authenticate(authCode);
    }

    @Override
    public AuthorizedCharacter getCharacter() {
        return authService.verifyAndGetCharacter();
    }

    @Override
    public Location getLocation(String characterId) {
        return locationService.getLocation(characterId);
    }
}
