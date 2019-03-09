package org.mercureve.ui;

import org.mercureve.ui.mainscreen.MainScreenModule;

import dagger.Module;

@Module(includes = {
        MainScreenModule.class
})
public class UiModule {
}
