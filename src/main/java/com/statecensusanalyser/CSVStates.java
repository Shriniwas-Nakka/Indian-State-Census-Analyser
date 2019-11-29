package com.statecensusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStates {

    @CsvBindByName
    private int serialNumber;

    @CsvBindByName
    private String stateName;

    @CsvBindByName
    private String tin;

    @CsvBindByName
    private int StateCode;

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public int getStateCode() {
        return StateCode;
    }

    public void setStateCode(int stateCode) {
        StateCode = stateCode;
    }
}