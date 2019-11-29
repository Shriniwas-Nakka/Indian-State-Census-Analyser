package com.statecensusanalyser;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
    private static final String SAMPLE_CSV_FILE_PATH = "/home/suraj/IdeaProjects/Indian State Census Analyser/src/main/java/com/statecensusanalyser/StateCode.csv";

    public int csvReader() {
        int count=0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));

            CsvToBean<CSVStates> cavToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVStates.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<CSVStates> csvUserIterator = cavToBean.iterator();
            while (csvUserIterator.hasNext()) {
                CSVStates csvUser = csvUserIterator.next();
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

}
