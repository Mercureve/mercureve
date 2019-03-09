package org.mercureve.service;

import org.mercureve.ApplicationConstants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface EveLoginOAuthService {

    @POST("oauth/token")
    Call<String> getOAuthToken(@Header("Authentication") String authentication, @Header("Content-Type") String contentType, @Header("Host") String host, @Body String authCode);

}
