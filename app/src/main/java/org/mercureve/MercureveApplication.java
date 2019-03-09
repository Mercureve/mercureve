package org.mercureve;

import android.app.Application;

import org.mercureve.util.InjectorUtils;

public class MercureveApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        InjectorUtils.initInjector(this);
    }
}
