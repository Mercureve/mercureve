package org.mercureve.service;

import org.mercureve.rest.CharacterLocationCRESTInterface;
import org.mercureve.rest.EveLoginOAuthRestInterface;
import org.mercureve.service.impl.CharacterLocationServiceImpl;
import org.mercureve.service.impl.EveLoginOAuthService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceModule {

    @Provides
    @Singleton
    AuthService provideAuthService(EveLoginOAuthRestInterface eveLoginOAuthRestInterface) {
        return new EveLoginOAuthService(eveLoginOAuthRestInterface);
    }

    @Provides
    @Singleton
    CharacterLocationService provideCharacterLocationService(CharacterLocationCRESTInterface characterLocationCRESTInterface) {
        return new CharacterLocationServiceImpl(characterLocationCRESTInterface);
    }

}
