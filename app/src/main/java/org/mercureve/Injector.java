package org.mercureve;

import org.mercureve.rest.RestModule;
import org.mercureve.service.ServiceModule;
import org.mercureve.ui.UiInjector;
import org.mercureve.ui.UiModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        RestModule.class,
        ServiceModule.class,
        UiModule.class})
public interface Injector extends UiInjector{

    void inject(MercureveApplication application);

}
