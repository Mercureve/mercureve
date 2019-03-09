package org.mercureve.service.impl;

import android.util.Log;

import org.mercureve.ApplicationConstants;
import org.mercureve.domain.AuthorizedCharacter;
import org.mercureve.domain.EveOAuthToken;
import org.mercureve.exception.AuthTokenExpiredException;
import org.mercureve.rest.EveLoginOAuthRestInterface;
import org.mercureve.service.AuthService;
import org.mercureve.util.SessionContext;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class EveLoginOAuthService implements AuthService {

    private EveLoginOAuthRestInterface eveLoginOAuthRestInterface;

    public EveLoginOAuthService(EveLoginOAuthRestInterface eveLoginOAuthRestInterface) {
        this.eveLoginOAuthRestInterface = eveLoginOAuthRestInterface;
    }

    @Override
    public void authenticate(String authCode) {
        getOAuthToken(ApplicationConstants.EVE_LOGIN_OAUTH_GRANT_TYPE_AUTHORIZATION_CODE, authCode);
    }

    private void getOAuthToken(String tokenType, String token) {
        Call<EveOAuthToken> oAuthTokenCall = eveLoginOAuthRestInterface.getOAuthToken(
                ApplicationConstants.EVE_LOGIN_OAUTH_AUTHENTICATION_HEADER,
                tokenType, token);
        try {
            EveOAuthToken eveOAuthToken = oAuthTokenCall.execute().body();
            SessionContext.setOAuthToken(eveOAuthToken);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void refreshToken() {
        try {
            getOAuthToken(ApplicationConstants.EVE_LOGIN_OAUTH_GRANT_TYPE_REFRESH_TOKEN, SessionContext.getEveOauthToken().getRefreshToken());
        } catch (AuthTokenExpiredException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AuthorizedCharacter verifyAndGetCharacter() {
        try {
            String auhToken = SessionContext.getEveOauthToken().getTokenType() + ApplicationConstants.SPACE + SessionContext.getEveOauthToken().getAccessToken();
            Response<AuthorizedCharacter> execute = eveLoginOAuthRestInterface.verify(auhToken).execute();
            return execute.body();
        } catch (IOException | AuthTokenExpiredException e) {
            e.printStackTrace();
        }
        return null;
    }
}
