package org.mercureve.ui.mainscreen;

import org.mercureve.ApplicationConstants;
import org.mercureve.service.EveLoginOAuthService;

import java.io.IOException;

import retrofit2.Call;

public class MainScreenControllerImpl implements MainScreenController {

    private Display display;

    private EveLoginOAuthService eveLoginOAuthService;

    public MainScreenControllerImpl(EveLoginOAuthService eveLoginOAuthService) {
        this.eveLoginOAuthService = eveLoginOAuthService;
    }

    @Override
    public void setDisplay(Display display) {
        this.display = display;
    }

    @Override
    public String getAuthorizationString(String authCode) {
        try {
            Call<String> oAuthToken = eveLoginOAuthService.getOAuthToken(ApplicationConstants.EVE_LOGIN_OAUTH_AUTHENTICATION_HEADER, ApplicationConstants.EVE_LOGIN_OAUTH_CONTENT_TYPE_HEADER,
                    ApplicationConstants.EVE_LOGIN_OAUTH_HOST_HEADER, ApplicationConstants.EVE_LOGIN_OAUTH_GRANT_TYPE_BODY_PREFIX + authCode);
            return oAuthToken.request().headers().toString() +"\\n" + oAuthToken.execute().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    return "";
    }
}
