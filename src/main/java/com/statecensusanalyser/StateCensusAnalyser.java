package com.statecensusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {

    public int giveNumberOfStateRecord(String STATE_CODE_CSV_FILE_PATH) throws StateAnalyserException {
        CSVStates csvStates= new CSVStates();
        int record = csvReader(csvStates,STATE_CODE_CSV_FILE_PATH);
        return record;
    }

    public int giveNumberOfRecordOfStateCensusData(String STATE_CENSUS_DATA_CSV_FILE_PATH) throws StateAnalyserException {
        CSVStateCensus csvStateCensus=new CSVStateCensus();
        int record = csvReader(csvStateCensus,STATE_CENSUS_DATA_CSV_FILE_PATH);
        return record;
    }

    public int csvReader(Object className, String csvFilePath) throws StateAnalyserException {
        Object obj=className;
        int count = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBean<Object> cavToBean = new CsvToBeanBuilder(reader)
                    .withType(Object.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<Object> csvUserIterator = cavToBean.iterator();
            while (csvUserIterator.hasNext()) {
                Object csvUser = csvUserIterator.next();
                count++;
            }
        } catch (NoSuchFileException e) {
            throw new StateAnalyserException(StateAnalyserException.ExceptionType.NO_SUCH_FILE, "Enter proper file path", e);
        } catch (RuntimeException e) {
            throw new StateAnalyserException(StateAnalyserException.ExceptionType.SOME_OTHER_FILE_ERRORS, "Enter proper File Type or Delimiter Incorrect or Header Incorrect", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}










