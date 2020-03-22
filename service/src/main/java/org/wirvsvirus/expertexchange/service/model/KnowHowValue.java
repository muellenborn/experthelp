package org.wirvsvirus.expertexchange.service.model;

public class KnowHowValue {

    private KnowHow knowHow;
    private int numberOfAvailableValues;
    private String level;
    private String duration;

    public KnowHow getKnowHow() {
        return knowHow;
    }

    public void setKnowHow(KnowHow knowHow) {
        this.knowHow = knowHow;
    }

    public int getNumberOfAvailableValues() {
        return numberOfAvailableValues;
    }

    public void setNumberOfAvailableValues(int numberOfAvailableValues) {
        this.numberOfAvailableValues = numberOfAvailableValues;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
