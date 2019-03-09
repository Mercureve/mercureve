package org.mercureve.domain;

public class Location {

    private SolarsystemResource solarSystem;

    public SolarsystemResource getSolarSystem() {
        return solarSystem;
    }

    public void setSolarSystem(SolarsystemResource solarSystem) {
        this.solarSystem = solarSystem;
    }

    @Override
    public String toString() {
        return "Location{" +
                "solarSystem=" + solarSystem +
                '}';
    }
}
