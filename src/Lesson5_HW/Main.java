package Lesson5_HW;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String delimeter = ";";

        AppData appData = new AppData();
        appData.save("testsave.csv", delimeter);
        appData.load("testread.csv", delimeter);
        System.out.println(Arrays.toString(appData.getHeader()));
        System.out.println(Arrays.deepToString(appData.getData()));
    }
}
