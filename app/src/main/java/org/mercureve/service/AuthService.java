package org.mercureve.service;

import org.mercureve.domain.AuthorizedCharacter;

public interface AuthService {

    void authenticate(String authCode);
    void refreshToken();
    AuthorizedCharacter verifyAndGetCharacter();
}
