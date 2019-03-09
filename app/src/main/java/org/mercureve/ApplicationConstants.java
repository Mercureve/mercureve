package org.mercureve;

import android.util.Base64;

public interface ApplicationConstants {

    public static final String SPACE = " ";

    public static final String EVE_API_CLIENT_ID = "";
    public static final String EVE_API_SECRET = "";
    public static final String EVE_API_CALLBACK_URL = "eveauth-mercureve://callback";
    public static final String EVE_API_SCOPES = "characterLocationRead";

    public static final String EVE_LOGIN_AUTH_UNIQUE_STATE_IDENTIFIER = "testState";
    public static final String EVE_LOGIN_AUTH_CODE_URL = "https://login.eveonline.com/oauth/authorize/?response_type=code&redirect_uri="+ EVE_API_CALLBACK_URL +"&client_id="+ EVE_API_CLIENT_ID +"&scope="+ EVE_API_SCOPES +"&state="+ EVE_LOGIN_AUTH_UNIQUE_STATE_IDENTIFIER;

    public static final String EVE_LOGIN_OAUTH_AUTHENTICATION_HEADER = "Basic " + Base64.encodeToString((EVE_API_CLIENT_ID + ":" + EVE_API_SECRET).getBytes(), Base64.NO_WRAP);
    public static final String EVE_LOGIN_OAUTH_CONTENT_TYPE_HEADER = "Content-Type: application/x-www-form-urlencoded";
    public static final String EVE_LOGIN_OAUTH_HOST_HEADER = "Host: login.eveonline.com";
    public static final String EVE_LOGIN_OAUTH_GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code";
    public static final String EVE_LOGIN_OAUTH_GRANT_TYPE_REFRESH_TOKEN = "refresh_token";
}
