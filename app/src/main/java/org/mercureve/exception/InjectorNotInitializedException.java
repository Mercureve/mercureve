package org.mercureve.exception;

public class InjectorNotInitializedException extends RuntimeException {

    public InjectorNotInitializedException() {
        super();
    }

    public InjectorNotInitializedException(String s) {
        super(s);
    }

}
