package org.mercureve.util;

import android.content.Context;

import org.mercureve.DaggerInjector;
import org.mercureve.Injector;
import org.mercureve.exception.InjectorNotInitializedException;

public class InjectorUtils {

    private static Injector injector;

    public static Injector getInjector() {
        if (injector == null) {
            throw new InjectorNotInitializedException("Injector must be initilaized before it can be used.");
        }
        return injector;
    }

    public static void initInjector(Context context) {
        if (injector == null) {
            injector = DaggerInjector.builder().build();
        }
    }
}
