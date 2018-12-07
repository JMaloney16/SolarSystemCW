package com.company;

import java.text.DecimalFormat;

public class Planet {
    private final String NAME;
    private final double MASS;
    private final double DISTANCE;
    private final double PERIOD;
    private final double SQRT_LUMINOSITY;

    public Planet(String name, double mass, double distance, double luminosity) {
        this.NAME = name;
        this.MASS = mass;
        this.DISTANCE = distance;
        this.PERIOD = Math.sqrt(distance * distance * distance);
        this.SQRT_LUMINOSITY = Math.sqrt(luminosity);
    }

    public boolean isHabitable(){
        if (MASS >= 0.6 && MASS <= 7.0 &&
                DISTANCE >= (SQRT_LUMINOSITY * 0.75) && (DISTANCE <= (SQRT_LUMINOSITY * 2.0))) {
            return true;
        }else{
            return false;
        }
    }

    public String getNAME() {
        return NAME;
    }

    public double getMASS() {
        return MASS;
    }

    public double getDISTANCE() {
        return DISTANCE;
    }

    public double getPERIOD() {
        return PERIOD;
    }

    public double getSQRT_LUMINOSITY() {
        return SQRT_LUMINOSITY;
    }

    @Override
    public String toString() {
        DecimalFormat periodFormat = new DecimalFormat("0.0##");
        return "Planet " + NAME + " has a mass of " + MASS + " Earths, is "
                + DISTANCE + "AU from its star, and orbits in " + periodFormat.format(PERIOD) + " years: could be habitable? " + (this.isHabitable() ? "yes" : "no") +"\n";
    }
}
