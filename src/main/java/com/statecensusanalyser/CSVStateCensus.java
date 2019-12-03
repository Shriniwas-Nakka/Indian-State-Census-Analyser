package com.statecensusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus {
    @CsvBindByName(column = "State")
    private String State;

    @CsvBindByName(column = "Population")
    private String Population;

    @CsvBindByName(column = "AreaInSqKm")
    private String AreaInSQKm;

    @CsvBindByName(column = "DensityPerSqKm")
    private String DestinyPerSqKm;

    public String getState() {
        return State;
    }

    public String getPopulation() {
        return Population;
    }

    public String getAreaInSQKm() {
        return AreaInSQKm;
    }

    public String getDestinyPerSqKm() {
        return DestinyPerSqKm;
    }


    public void setState(String state) {
        State = state;
    }

    public void setPopulation(String population) {
        Population = population;
    }

    public void setAreaInSQKm(String areaInSQKm) {
        AreaInSQKm = areaInSQKm;
    }

    public void setDestinyPerSqKm(String destinyPerSqKm) {
        DestinyPerSqKm = destinyPerSqKm;
    }


}
