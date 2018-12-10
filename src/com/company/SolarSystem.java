package com.company;
/* I've tried to improve my work by using good practices such as providing getters for every attribute even though
 * they aren't needed for this problem, my methods all return values instead of printing and the habitable method
 * returns a boolean instead of 'yes'/'no' which is much easier to work with if needed for another use */
import java.util.ArrayList;

public class SolarSystem {
    private final String name;
    private final double luminosity;
    private ArrayList<Planet> planets;

    public SolarSystem(String name, double luminosity) {
        this.name = name;
        this.luminosity = luminosity;
        this.planets = new ArrayList<Planet>();
    }

    /* Creates a new planet and adds it to the planets arraylist, takes name, mass and distance input and
     * also includes the system itself as an attribute in the planet constructor */
    public void addPlanet(String name, double mass, double distance){
        planets.add(new Planet(name, mass, distance, this));
    }

    /* Calls the toString method of each planet in the planets array list and adds them to an empty string,
     * this is to get the correct output for the class toString method. */
    public String outputElements(){
        String list = "";
        for (Planet current: planets) {
            list += current.toString();
        }
        return list;
    }

    public String getName() {
        return name;
    }

    /* This returns the planets with square brackets and commas between them which means that it won't pass the
     * tests hence why it's not used */
    public ArrayList<Planet> getPlanets() {
        return planets;
    }

    public double getLuminosity() {
        return luminosity;
    }

    @Override
    public String toString() {
        return name + "\n" + outputElements();
    }
}
