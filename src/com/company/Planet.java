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

    private static final double MAX_MASS = 7.0;
    private static final double MIN_MASS = 0.6;
    private static final double MIN_LUMINOSITY_MULTI = 0.75;
    private static final double MAX_LUMINOSITY_MULTI = 2.0;
    // Required to output period in the desired format
    private static final DecimalFormat periodFormat = new DecimalFormat("0.0##");


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
        if (mass >= MIN_MASS && mass <= MAX_MASS &&
                distance >= (sqrtLuminosity * MIN_LUMINOSITY_MULTI) && distance <= (sqrtLuminosity * MAX_LUMINOSITY_MULTI)) {
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
        return "Planet " + name + " has a mass of " + mass + " Earths, is "
                + distance + "AU from its star, and orbits in " + periodFormat.format(period)
                + " years: could be habitable? " + (this.isHabitable() ? "yes" : "no") +"\n";
    }
}
