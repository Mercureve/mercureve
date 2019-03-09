package org.mercureve.rest;

import org.mercureve.domain.Location;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface CharacterLocationCRESTInterface {

    @GET("/characters/{characterId}/location/")
    Call<Location> getLocation(@Header("Authorization") String authentication, @Path("characterId") String characterId);
}
