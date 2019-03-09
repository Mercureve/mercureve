package org.mercureve.ui.mainscreen;

import org.mercureve.service.EveLoginOAuthService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainScreenModule {

    @Provides
    @Singleton
    MainScreenController provideMainScreenController(EveLoginOAuthService eveLoginOAuthService) {
        return new MainScreenControllerImpl(eveLoginOAuthService);
    }

}
