package com.company;

import java.util.ArrayList;

public class SolarSystem {
    private final String NAME;
    private final double LUMINOSITY;
    private ArrayList<Planet> planets;

    public SolarSystem(String name, double luminosity) {
        this.NAME = name;
        this.LUMINOSITY = luminosity;
        this.planets = new ArrayList<Planet>();
    }

    public void addPlanet(String name, double mass, double distance){
        planets.add(new Planet(name, mass, distance, LUMINOSITY));
    }

    public String outputElements(){
        String list = "";
        for (Planet current: planets) {
            list += current.toString();
        }
        return list;
    }

    public String getNAME() {
        return NAME;
    }

    public double getLUMINOSITY() {
        return LUMINOSITY;
    }

    @Override
    public String toString() {
        return NAME + "\n" + outputElements();
        //return NAME + "\n" + planets.toString();
    }
}
