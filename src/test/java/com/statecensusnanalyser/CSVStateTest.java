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
    public void givenStateCSVFile_WhenIncorrectReturn_ShouldReturnSad() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            Assert.assertEquals(37, stateCensusAnalyser.csvReader());
        } catch (StateAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(StateAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void givenStateCSVFile1_whenImProper_ReturnCustomException(){
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            Assert.assertEquals(37, stateCensusAnalyser.csvReader());
        } catch (StateAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(StateAnalyserException.ExceptionType.INVALID_EXTENSION, e.type);
        }
    }

    @Test
    public void givenStateCSVFile_whenDelimiterIncorrect_ReturnCustomException(){
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            Assert.assertEquals(37, stateCensusAnalyser.csvReader());
        } catch (StateAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(StateAnalyserException.ExceptionType.INVALID_EXTENSION, e.type);
        }
    }

    @Test
    public void givenStateCSVFile_whenHeaderIncorrect_ReturnCustomException(){
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            Assert.assertEquals(37, stateCensusAnalyser.csvReader());
        } catch (StateAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(StateAnalyserException.ExceptionType.SOME_OTHER_FILE_ERRORS, e.type);
        }
    }
}
