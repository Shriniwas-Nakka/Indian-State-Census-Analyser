package com.statecensusnanalyser;

import com.statecensusanalyser.StateAnalyserException;
import com.statecensusanalyser.StateCensusAnalyser;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CSVStateTest {

    private static final String SAMPLE_CSV_FILE_PATH = "/home/suraj/IdeaProjects/Indian State Census Analyser/src/main/java/com/statecensusanalyser/StateCensusData.csv";


    // UC1 Ability for the analyser to load the Indian States Census Information from a csv
    @Test
    public void givenStateCSVfileNumberOfRecord_WhenRecordsMatches_ShouldReturnHappy() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            Assert.assertEquals(29, stateCensusAnalyser.csvReader(SAMPLE_CSV_FILE_PATH));
        } catch (StateAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenStateCensusCSVFile_WhenIncorrectReturn_ShouldReturnSad() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            Assert.assertEquals(29, stateCensusAnalyser.csvReader(SAMPLE_CSV_FILE_PATH));
        } catch (StateAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(StateAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFile_whenImProperButTypeIncorrect_ReturnCustomException(){
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            Assert.assertEquals(29, stateCensusAnalyser.csvReader(SAMPLE_CSV_FILE_PATH));
        } catch (StateAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(StateAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFile_whenDelimiterIncorrect_ReturnCustomException(){
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            Assert.assertEquals(29, stateCensusAnalyser.csvReader(SAMPLE_CSV_FILE_PATH));
        } catch (StateAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(StateAnalyserException.ExceptionType.SOME_OTHER_FILE_ERRORS, e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFile_whenHeaderIncorrect_ReturnCustomException(){
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            Assert.assertEquals(29, stateCensusAnalyser.csvReader(SAMPLE_CSV_FILE_PATH));
        } catch (StateAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(StateAnalyserException.ExceptionType.SOME_OTHER_FILE_ERRORS, e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFile_whenProper_SortStateAlphabeticalOrderAndWriteToJSONFile() throws StateAnalyserException {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        Assert.assertEquals(29, stateCensusAnalyser.csvReader(SAMPLE_CSV_FILE_PATH));
        Assert.assertTrue( stateCensusAnalyser.sortStateRecords("/home/suraj/IdeaProjects/Indian State Census Analyser/src/main/java/com/statecensusanalyser/State.json"));
    }
}








