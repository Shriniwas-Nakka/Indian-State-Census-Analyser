package com.statecensusnanalyser;

import com.statecensusanalyser.StateCensusAnalyser;
import org.junit.Assert;
import org.junit.Test;

public class CSVStateTest {

    @Test
    public void givenNumberOfRecord_WhenRecordsMatches_ShouldReturnHappy() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        Assert.assertEquals(37, stateCensusAnalyser.csvReader());
    }
}
