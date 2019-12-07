package com.statecensusanalyser;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class StateCensusAnalyser {

    List<CSVStateCensus> CsvCensusDataList = new ArrayList<>();

    public int csvReader(String FilePath) throws StateAnalyserException {
        int stateCount = 0;
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(FilePath));
            CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder(reader).withType(CSVStateCensus.class)
                    .withIgnoreLeadingWhiteSpace(true).build();
            Iterator<CSVStateCensus> CsvStateIterator = csvToBean.iterator();

            while (CsvStateIterator.hasNext()) {
                stateCount++;
                CSVStateCensus csvUser = CsvStateIterator.next();
                CsvCensusDataList.add(csvUser);
            }
        } catch (IOException e) {
            throw new StateAnalyserException(StateAnalyserException.ExceptionType.NO_SUCH_FILE, "Enter proper file path");
        } catch (RuntimeException e) {
            throw new StateAnalyserException(StateAnalyserException.ExceptionType.SOME_OTHER_FILE_ERRORS,
                    "Enter proper File Type or Delimiter Incorrect or Header Incorrect ");
        }
        return stateCount;
    }

    public Boolean writeRecords(String FilePath) throws StateAnalyserException {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(CsvCensusDataList);
            FileWriter writer = new FileWriter(FilePath);
            writer.write(json);
            writer.close();
            return true;
        } catch (IOException e) {
            throw new StateAnalyserException(StateAnalyserException.ExceptionType.NO_SUCH_FILE, "File Not Found");
        }
    }

    public int sortThisListBasedOnStateName(String filePath, String jsonFile) throws StateAnalyserException {
        int count = csvReader(filePath);
        Comparator<CSVStateCensus> c = (s1, s2) -> s1.getState().compareTo(s2.getState());
        CsvCensusDataList.sort(c);
        writeRecords(jsonFile);
        return count;
    }

    public int sortThisListBasedOnPopulation(String filePath, String jsonFile) throws StateAnalyserException {
        int count = csvReader(filePath);
        Comparator<CSVStateCensus> c = (s1, s2) -> Integer.parseInt(s2.getPopulation()) - Integer.parseInt(s1.getPopulation());
        CsvCensusDataList.sort(c);
        writeRecords(jsonFile);
        return count;
    }

    public int sortThisListBasedOnStateDensity(String filePath, String jsonFile) throws StateAnalyserException {
        int count = csvReader(filePath);
        Comparator<CSVStateCensus> c = (s1, s2) -> Integer.parseInt(s2.getDestinyPerSqKm()) - Integer.parseInt(s1.getDestinyPerSqKm());
        CsvCensusDataList.sort(c);
        writeRecords(jsonFile);
        return count;
    }

    public int sortThisListBasedOnLargestStateArea(String filePath, String jsonFile) throws StateAnalyserException {
        int count = csvReader(filePath);
        Comparator<CSVStateCensus> c = (s1, s2) -> Integer.parseInt(s2.getAreaInSQKm()) - Integer.parseInt(s1.getAreaInSQKm());
        CsvCensusDataList.sort(c);
        writeRecords(jsonFile);
        return count;
    }
}










