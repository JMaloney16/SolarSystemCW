package com.company;

import java.text.DecimalFormat;

public class Planet {
    // Planet attributes don't change after initialisation so they are final.
    private final String name;
    private final double mass;
    private final double distance;
    private final double period;
    private final SolarSystem system; // The parent system of the planet
    private final double sqrtLuminosity;

    public Planet(String name, double mass, double distance, SolarSystem system) {
        this.name = name;
        this.mass = mass;
        this.distance = distance;
        this.period = Math.sqrt(distance * distance * distance);
        this.system = system; /* While we only need luminosity, this allows us to get any attribute of the parent
                               * system if wanted later on */
        this.sqrtLuminosity = Math.sqrt(system.getLuminosity()); /* Don't need the original luminosity of
                                                                  * the system so we only store the square root */
    }

    // Checks mass and compares distance to luminosity to see if the planet is habitable
    public boolean isHabitable(){
        if (mass >= 0.6 && mass <= 7.0 &&
                distance >= (sqrtLuminosity * 0.75) && distance <= (sqrtLuminosity * 2.0)) {
            return true;
        }else{
            return false;
        }
    }

    // Getters for each attribute, not used in the tests
    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }

    public double getDistance() {
        return distance;
    }

    public double getPeriod() {
        return period;
    }

    public SolarSystem getSystem() {
        return system;
    }

    public double getSqrtLuminosity() {
        return sqrtLuminosity;
    }

    @Override
    public String toString() {
        DecimalFormat periodFormat = new DecimalFormat("0.0##"); // Required to output period in the desired format
        return "Planet " + name + " has a mass of " + mass + " Earths, is "
                + distance + "AU from its star, and orbits in " + periodFormat.format(period)
                + " years: could be habitable? " + (this.isHabitable() ? "yes" : "no") +"\n";
    }
}
