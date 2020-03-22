package org.wirvsvirus.expertexchange.service.model;

public class RessourceValue {

    private Ressource ressource;
    private int numberOfAvailableValues;
    private String duration;

    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }

    public int getNumberOfAvailableValues() {
        return numberOfAvailableValues;
    }

    public void setNumberOfAvailableValues(int numberOfAvailableValues) {
        this.numberOfAvailableValues = numberOfAvailableValues;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
