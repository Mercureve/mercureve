package org.mercureve.util;

import org.mercureve.domain.EveOAuthToken;
import org.mercureve.exception.AuthTokenExpiredException;

import java.util.Calendar;
import java.util.Date;

public class SessionContext {

    private static EveOAuthToken oAuthToken;
    private static Date validUntil;

    public static void setOAuthToken(EveOAuthToken token) {
        oAuthToken = token;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.SECOND, token.getExpiresIn());
        validUntil = calendar.getTime();
    }

    public static EveOAuthToken getEveOauthToken() throws AuthTokenExpiredException {
        if (oAuthToken == null || validUntil.before(new Date())) {
            throw new AuthTokenExpiredException();
        }
        return oAuthToken;
    }

}
