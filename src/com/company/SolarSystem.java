package com.company;

import java.util.ArrayList;

public class SolarSystem {
    private String name;
    private double luminosity;
    private ArrayList<Planet> planets;

    public SolarSystem(String name, double luminosity) {
        this.name = name;
        this.luminosity = luminosity;
        this.planets = new ArrayList<Planet>();
    }

    public void addPlanet(String name, double mass, double distance){
        planets.add(new Planet(name, mass, distance, luminosity));
    }

    public String outputElements(){
        String list = "";
        for (Planet current: planets) {
            list += current.toString();
        }
        return list;
    }

    @Override
    public String toString() {
        return name + "\n" + outputElements();
        //return name + "\n" + planets.toString();
    }
}
