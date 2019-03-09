package org.mercureve;

import android.util.Base64;

public interface ApplicationConstants {

    public static final String EVE_API_CLIENT_ID = "<InsertApiClientID>";
    public static final String EVE_API_SECRET = "<InsertApiSecret>";
    public static final String EVE_API_CALLBACK_URL = "eveauth-mercureve://callback";
    public static final String EVE_API_SCOPES = "characterLocationRead";

    public static final String EVE_LOGIN_AUTH_UNIQUE_STATE_IDENTIFIER = "testState";
    public static final String EVE_LOGIN_AUTH_CODE_URL = "https://login.eveonline.com/oauth/authorize/?response_type=code&redirect_uri="+ EVE_API_CALLBACK_URL +"&client_id="+ EVE_API_CLIENT_ID +"&scope="+ EVE_API_SCOPES +"&state="+ EVE_LOGIN_AUTH_UNIQUE_STATE_IDENTIFIER;

    public static final String EVE_LOGIN_OAUTH_AUTHENTICATION_HEADER = "Basic " + Base64.encode((EVE_API_CLIENT_ID + ":" + EVE_API_SECRET).getBytes(), Base64.DEFAULT);
    public static final String EVE_LOGIN_OAUTH_CONTENT_TYPE_HEADER = "application/x-www-form-urlencoded";
    public static final String EVE_LOGIN_OAUTH_HOST_HEADER = "login.eveonline.com";
    public static final String EVE_LOGIN_OAUTH_GRANT_TYPE_BODY_PREFIX = "grant_type=authorization_code&code=";
}
