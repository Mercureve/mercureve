package org.mercureve.rest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RestModule {

    @Provides
    @Singleton
    EveLoginOAuthRestInterface provideEveLoginOAuthRestInterface() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://login.eveonline.com/").addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(EveLoginOAuthRestInterface.class);
    }

    @Provides
    @Singleton
    CharacterLocationCRESTInterface provideCharacterLocationCRESTInterface() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://crest-tq.eveonline.com/").addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(CharacterLocationCRESTInterface.class);
    }
}
