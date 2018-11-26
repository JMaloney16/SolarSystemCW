package com.company;

import java.text.DecimalFormat;

public class Planet {
    private String name;
    private double mass;
    private double distance;
    private double period;
    private double luminosity;

    public Planet(String name, double mass, double distance, double luminosity) {
        this.name = name;
        this.mass = mass;
        this.distance = distance;
        this.period = Math.sqrt(distance * distance * distance);
        this.luminosity = luminosity;
    }

    public String isHabitable(){
        if (mass >= 0.6 && mass <= 7.0 &&
                (distance * Math.sqrt(luminosity)) >= 0.75 && (distance * Math.sqrt(luminosity)) <= 2.0) {
            return "yes";
        }else{
            return "no";
        }
    }



    @Override
    public String toString() {
        DecimalFormat periodFormat = new DecimalFormat("0.0##");
        return "Planet " + name + " has a mass of " + mass + " Earths, is "
                + distance + "AU from its star, and orbits in " + periodFormat.format(period) + " years: could be habitable? " + this.isHabitable() +"\n";
    }
}
