package com.statecensusanalyser;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class StateCensusData {

    public int genericPOJO(String file1Name, String file2Name) throws IOException {

        int counter = 0;
        String[] headers = new String[1];
        Scanner scanner = null;
        List<String> listOfFile = new ArrayList<>();
        listOfFile.add(file1Name);
        listOfFile.add(file2Name);
        try {
             scanner = new Scanner(new File(String.valueOf(file1Name)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (scanner.hasNextLine()) {
            headers[counter] = String.valueOf(scanner.nextLine().split(","));
            counter++;
        }

        scanner.close();

        Iterator<String> iterFiles = listOfFile.iterator();
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file1Name, true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (iterFiles.hasNext()) {
            String nextFile = iterFiles.next();
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(nextFile));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            String line = null;
            String[] firstLine = null;
            try {
                if ((line = reader.readLine()) != null)
                    firstLine = line.split(",");
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (!Arrays.equals(headers, firstLine))
                try {
                    throw new StateAnalyserException(StateAnalyserException.ExceptionType.HEADERS_MISS_MATCHED, "Headers miss matched");
                } catch (StateAnalyserException e) {
                    e.printStackTrace();
                }

            while (true) {
                try {
                    if (!((line = reader.readLine()) != null))
                        break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    writer.write(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(null);
    }



//public static void main(String[] args) throws IOException {
//
//
//        List<Path> paths = Arrays.asList(Paths.get("/home/suraj/IdeaProjects/Indian State Census Analyser/src/main/java/com/statecensusanalyser/StateCode.csv"), Paths.get("/home/suraj/IdeaProjects/Indian State Census Analyser/src/main/java/com/statecensusanalyser/StateCensusData.csv"));
//        List<String> mergedLines = getMergedLines(paths);
//        Path target = Paths.get("./merged.csv");
//        Files.write(target, mergedLines, Charset.forName("UTF-8"));
//    }
//
//    private static List<String> getMergedLines(List<Path> paths) throws IOException {
//        List<String> mergedLines = new ArrayList<>();
//        for (Path p : paths) {
//            List<String> lines = Files.readAllLines(p, Charset.forName("UTF-8"));
//            if (!lines.isEmpty()) {
//                if (mergedLines.isEmpty()) {
//                    mergedLines.add(lines.get(0)); //add header only once
//                }
//                mergedLines.addAll(lines.subList(1, lines.size()));
//            }
//        }
//        return mergedLines;
//    }
}

//}
