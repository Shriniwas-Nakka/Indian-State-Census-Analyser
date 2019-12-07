package com.statecensusanalyser;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.lang.reflect.Field;
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

    public boolean sortStateDetails(String csvFile, String fieldName, String SAMPLE_JSON_FILE_BASED_ON_FIELD) throws StateAnalyserException {
        csvReader(csvFile);

        Collections.sort(CsvCensusDataList, new Comparator<CSVStateCensus>() {
            @Override
            public int compare(CSVStateCensus stateName1, CSVStateCensus stateName2) {
                Field fieldType = null;
                try {
                    fieldType = CSVStateCensus.class.getDeclaredField(fieldName);
                    fieldType.setAccessible(true);
                    Comparable stateCensusFieldValue1 = (Comparable) fieldType.get(stateName1);
                    Comparable stateCensusFieldValue2 = (Comparable) fieldType.get(stateName2);
                    return stateCensusFieldValue1.compareTo(stateCensusFieldValue2);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
        csvReader(SAMPLE_JSON_FILE_BASED_ON_FIELD);
        return true;
    }
}










