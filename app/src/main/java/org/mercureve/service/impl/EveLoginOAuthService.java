package org.mercureve.service.impl;

import org.mercureve.ApplicationConstants;
import org.mercureve.domain.EveOAuthToken;
import org.mercureve.rest.EveLoginOAuthRestInterface;
import org.mercureve.service.AuthService;
import org.mercureve.util.SessionContext;

import java.io.IOException;

import retrofit2.Call;

public class EveLoginOAuthService implements AuthService {

    private EveLoginOAuthRestInterface eveLoginOAuthRestInterface;

    public EveLoginOAuthService(EveLoginOAuthRestInterface eveLoginOAuthRestInterface) {
        this.eveLoginOAuthRestInterface = eveLoginOAuthRestInterface;
    }

    @Override
    public void authenticate(String authCode) {
        Call<EveOAuthToken> oAuthTokenCall = eveLoginOAuthRestInterface.getOAuthToken(
                ApplicationConstants.EVE_LOGIN_OAUTH_AUTHENTICATION_HEADER,
                ApplicationConstants.EVE_LOGIN_OAUTH_GRANT_TYPE, authCode);
        try {
            EveOAuthToken eveOAuthToken = oAuthTokenCall.execute().body();
            SessionContext.setOAuthToken(eveOAuthToken);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
