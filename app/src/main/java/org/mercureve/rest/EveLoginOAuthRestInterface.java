package org.mercureve.rest;

import org.mercureve.ApplicationConstants;
import org.mercureve.domain.AuthorizedCharacter;
import org.mercureve.domain.EveOAuthToken;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface EveLoginOAuthRestInterface {

    @FormUrlEncoded
    @Headers({
            ApplicationConstants.EVE_LOGIN_OAUTH_CONTENT_TYPE_HEADER,
            ApplicationConstants.EVE_LOGIN_OAUTH_HOST_HEADER
    })
    @POST("oauth/token")
    Call<EveOAuthToken> getOAuthToken(@Header("Authorization") String authentication, @Field("grant_type") String grantType, @Field("code") String authCode);

    @Headers({
            ApplicationConstants.EVE_LOGIN_OAUTH_HOST_HEADER
    })
    @GET("oauth/verify")
    Call<AuthorizedCharacter> verify(@Header("Authorization") String authentication);

}
