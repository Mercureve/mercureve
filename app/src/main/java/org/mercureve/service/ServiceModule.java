package org.mercureve.service;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ServiceModule {

    @Provides
    @Singleton
    EveLoginOAuthService provideEveLoginOAuthService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://login.eveonline.com/").addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(EveLoginOAuthService.class);
    }
}
