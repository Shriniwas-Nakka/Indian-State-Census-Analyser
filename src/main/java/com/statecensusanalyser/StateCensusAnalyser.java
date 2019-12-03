package com.statecensusanalyser;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
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

    public Boolean sortStateRecords(String FilePath) throws StateAnalyserException {
        sortThisListBasedOnStateName(CsvCensusDataList);
        sortThisListBasedOnPopulation(CsvCensusDataList);
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

    private static void sortThisListBasedOnStateName(List<CSVStateCensus> censusList) {
        Comparator<CSVStateCensus> c = (s1, s2) -> s1.getState().compareTo(s2.getState());
        censusList.sort(c);
    }

    private static void sortThisListBasedOnPopulation(List<CSVStateCensus> censusList) {
        Comparator<CSVStateCensus> c = (s1, s2) -> Integer.parseInt(s2.getPopulation()) - Integer.parseInt(s1.getPopulation());
        censusList.sort(c);
//        Comparator<CSVStateCensus> c = (s1, s2) -> s1.getPopulation().compareTo(s2.getPopulation());
//        censusList.sort(c);
    }
}










