package com.statecensusnanalyser;

import com.statecensusanalyser.StateAnalyserException;
import com.statecensusanalyser.StateCensusAnalyser;
import org.junit.Assert;
import org.junit.Test;

public class CSVStateTest {

    // UC1 Ability for the analyser to load the Indian States Information from a csv file
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
            Assert.assertEquals(StateAnalyserException.ExceptionType.SOME_OTHER_FILE_ERRORS, e.type);
        }
    }

    @Test
    public void givenStateCSVFile_whenDelimiterIncorrect_ReturnCustomException(){
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            Assert.assertEquals(37, stateCensusAnalyser.csvReader());
        } catch (StateAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(StateAnalyserException.ExceptionType.SOME_OTHER_FILE_ERRORS, e.type);
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

    // UC2 Ability for the analyser to load the Indian States Census Information from a csv
    @Test
    public void givenStateCSVfileNumberOfRecord_WhenRecordsMatches_ShouldReturnHappy() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            Assert.assertEquals(29, stateCensusAnalyser.csvStateCensusReader());
        } catch (StateAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenStateCensusCSVFile_WhenIncorrectReturn_ShouldReturnSad() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            Assert.assertEquals(29, stateCensusAnalyser.csvStateCensusReader());
        } catch (StateAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(StateAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }
}
