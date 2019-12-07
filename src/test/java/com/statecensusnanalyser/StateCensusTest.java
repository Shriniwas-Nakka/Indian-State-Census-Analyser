package com.statecensusnanalyser;

import com.statecensusanalyser.StateAnalyserException;
import com.statecensusanalyser.StateCensusAnalyser;
import org.junit.Assert;
import org.junit.Test;

public class StateCensusTest {

    private static final String SAMPLE_CSV_FILE_PATH = "/home/suraj/IdeaProjects/Indian State Census Analyser/src/main/java/com/statecensusanalyser/StateCensusData.csv";
    private static final String SAMPLE_JSON_FILE_PATH = "/home/suraj/IdeaProjects/Indian State Census Analyser/src/main/java/com/statecensusanalyser/State.json";
    StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();

    // UC1 Ability for the analyser to load the Indian States Census Information from a csv
    @Test
    public void givenStateCSVfileNumberOfRecord_WhenRecordsMatches_ShouldReturnHappy() {
        try {
            Assert.assertEquals(29, stateCensusAnalyser.csvReader(SAMPLE_CSV_FILE_PATH));
        } catch (StateAnalyserException e) {
            Assert.assertEquals(StateAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFile_WhenIncorrectReturn_ShouldReturnSad() {
        try {
            Assert.assertEquals(29, stateCensusAnalyser.csvReader(SAMPLE_CSV_FILE_PATH));
        } catch (StateAnalyserException e) {
            Assert.assertEquals(StateAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFile_whenImProperButTypeIncorrect_ReturnCustomException() {
        try {
            Assert.assertEquals(29, stateCensusAnalyser.csvReader(SAMPLE_CSV_FILE_PATH));
        } catch (StateAnalyserException e) {
            Assert.assertEquals(StateAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFile_whenDelimiterIncorrect_ReturnCustomException() {
        try {
            Assert.assertEquals(29, stateCensusAnalyser.csvReader(SAMPLE_CSV_FILE_PATH));
        } catch (StateAnalyserException e) {
            Assert.assertEquals(StateAnalyserException.ExceptionType.SOME_OTHER_FILE_ERRORS, e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFile_whenHeaderIncorrect_ReturnCustomException() {
        try {
            Assert.assertEquals(29, stateCensusAnalyser.csvReader(SAMPLE_CSV_FILE_PATH));
        } catch (StateAnalyserException e) {
            Assert.assertEquals(StateAnalyserException.ExceptionType.SOME_OTHER_FILE_ERRORS, e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFile_whenProper_SortStateAlphabeticalOrderAndWriteToJSONFile() {
        try {
            Assert.assertEquals(29, stateCensusAnalyser.sortStateDetails(SAMPLE_CSV_FILE_PATH, "State", SAMPLE_JSON_FILE_PATH));
        } catch (StateAnalyserException e) {
            Assert.assertEquals(StateAnalyserException.ExceptionType.SOME_OTHER_FILE_ERRORS, e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFile_whenProper_SortStatePopulationAndWriteToJSONFile() {
        try {
            Assert.assertEquals(29, stateCensusAnalyser.sortStateDetails(SAMPLE_CSV_FILE_PATH, "Population", SAMPLE_JSON_FILE_PATH));
        } catch (StateAnalyserException e) {
            Assert.assertEquals(StateAnalyserException.ExceptionType.SOME_OTHER_FILE_ERRORS, e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFile_whenProper_SortStateDensityAndWriteToJSONFile() {
        try {
            Assert.assertEquals(29, stateCensusAnalyser.sortStateDetails(SAMPLE_CSV_FILE_PATH, "DestinyPerSqKm", SAMPLE_JSON_FILE_PATH));
        } catch (StateAnalyserException e) {
            Assert.assertEquals(StateAnalyserException.ExceptionType.SOME_OTHER_FILE_ERRORS, e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFile_whenProper_SortLargestStateByAreaAndWriteToJSONFile() {
        try {
            Assert.assertEquals(29, stateCensusAnalyser.sortStateDetails(SAMPLE_CSV_FILE_PATH, "AreaInSQKm", SAMPLE_JSON_FILE_PATH));
        } catch (StateAnalyserException e) {
            Assert.assertEquals(StateAnalyserException.ExceptionType.SOME_OTHER_FILE_ERRORS, e.type);
        }
    }
}








