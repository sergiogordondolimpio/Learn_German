package DataBase;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public interface ManageFile {

    public static void writeCsv(String filePath, List<WordsData> wordsDataList) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);
            for (WordsData wordsData : wordsDataList) {
                fileWriter.append(wordsData.getArticles()
                        + ',' +
                        wordsData.getWord()
                        + '\n');
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * this function read a .csv file and make the list of the words
     *
     * @return wordDataList, a list of WordsData
     */
    public static List<WordsData> readCsv(String filePath) {

        BufferedReader reader = null;
        List<WordsData> wordsDataList = new ArrayList<WordsData>();
        try {
            String line = "";
            reader = new BufferedReader(new FileReader(filePath));
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length > 0) {
                    WordsData wordsData = new WordsData(
                            fields[1], fields[0]);
                    wordsDataList.add(wordsData);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return wordsDataList;
    }

    /**
     * this function read a .csv file and make the list of the words
     *
     * @return wordDataList, a list of WordsData
     */
    public static List<String> readPrepositionCsv(String filePath) {

        BufferedReader reader = null;
        List<String> List = new ArrayList<>();
        try {
            String line = "";
            reader = new BufferedReader(new FileReader(filePath));
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                List.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return List;
    }
}
