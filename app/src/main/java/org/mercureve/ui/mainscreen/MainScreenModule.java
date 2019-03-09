package org.mercureve.ui.mainscreen;

import org.mercureve.service.AuthService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

;

@Module
public class MainScreenModule {

    @Provides
    @Singleton
    MainScreenController provideMainScreenController(AuthService authService) {
        return new MainScreenControllerImpl(authService);
    }

}
