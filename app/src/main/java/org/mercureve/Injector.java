package org.mercureve;

import org.mercureve.service.ServiceModule;
import org.mercureve.ui.UiInjector;
import org.mercureve.ui.UiModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

@Singleton
@Component(modules = {
        ServiceModule.class,
        UiModule.class})
public interface Injector extends UiInjector{

    void inject(MercureveApplication application);

}
