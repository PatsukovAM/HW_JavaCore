package Lesson2_HW;

public class ArrayUtils {
    public static int arraySum(String[][] strings, int arrayResolution) throws MyArraySizeException, MyArrayDataException {
        if (strings.length != arrayResolution) {
            throw new MyArraySizeException(strings.length);
        }
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length != arrayResolution) {
                throw new MyArraySizeException(strings[i].length, i + 1);
            }
        }

        int arraySum = 0;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                try {
                    arraySum += Integer.parseInt(strings[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i + 1, j + 1);
                }
            }
        }
        return arraySum;
    }
}
