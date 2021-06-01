package Lesson5_HW;

import java.io.*;
import java.util.ArrayList;

public class AppData {
    private String[] header;
    private Integer[][] data;

    public String[] getHeader() {
        return header;
    }

    public Integer[][] getData() {
        return data;
    }

    public AppData() {
        header = new String[]{"value1", "value2", "value3"};
        data = new Integer[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    }

    public void save(String fileName, String delimeter) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(rowToString(header, delimeter));
            for (Integer[] array : data) {
                bufferedWriter.write(rowToString(array, delimeter));
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//
/*    private <T> String rowToString(T[] row, String delimeter) {
        String result = "";
        for (int i = 0; i < row.length; i++) {
            if (i < row.length - 1) {
                result = result + row[i] + delimeter;
            } else result = result + row[i];
        }
        result += "\n";
        return result;
    }*/
    private <T> String rowToString(T[] row, String delimeter) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < row.length; i++) {
            if (i < row.length - 1) {
                result.append(row[i]).append(delimeter);
            } else result.append(row[i]);
        }
        result.append("\n");
        return result.toString();
    }


    public void load(String fileName, String delimetr) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            header = bufferedReader.readLine().split(delimetr);
            String line;
            ArrayList<Integer[]> arrayList = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                arrayList.add(stringToIntArray(line, delimetr));
            }
            data = arrayList.toArray(new Integer[][]{});
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Integer[] stringToIntArray(String str, String delimetr) {
        String[] stringArr = str.split(delimetr);
        Integer[] intArray = new Integer[stringArr.length];
        for (int i = 0; i < stringArr.length; i++) {
            intArray[i] = Integer.parseInt(stringArr[i]);
        }
        return intArray;
    }
}


