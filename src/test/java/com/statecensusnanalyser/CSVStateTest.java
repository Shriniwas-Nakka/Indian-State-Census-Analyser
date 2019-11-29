package com.statecensusnanalyser;

import com.statecensusanalyser.StateAnalyserException;
import com.statecensusanalyser.StateCensusAnalyser;
import org.junit.Assert;
import org.junit.Test;

public class CSVStateTest {

    @Test
    public void givenNumberOfRecord_WhenRecordsMatches_ShouldReturnHappy() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            Assert.assertEquals(37, stateCensusAnalyser.csvReader());
        } catch (StateAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenStateCSVFile_WhenInccorectReturn_ShouldReturnSad() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            Assert.assertEquals(37, stateCensusAnalyser.csvReader());
        } catch (StateAnalyserException e) {
            Assert.assertEquals(StateAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }
}
