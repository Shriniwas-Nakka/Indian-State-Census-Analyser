package com.statecensusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus {
    @CsvBindByName(column = "State")
    private int StateName;

    @CsvBindByName(column = "Population")
    private String Population;

    @CsvBindByName(column = "AreaInSqKm")
    private String AreaInSQKm;

    @CsvBindByName(column = "DensityPerSqKm")
    private int DestinyPerSqKm;
}
