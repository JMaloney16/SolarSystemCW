package com.company;

public class Main {

    public static void main(String[] args) {
        SolarSystem galaxy = new SolarSystem("Milky Way", 1.5);
        galaxy.addPlanet("Earth", 4.0, 1);
        galaxy.addPlanet("Mars", 3.2, 4.1);
        System.out.println(galaxy.toString());
    }
}
