package Lesson2_HW;

public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {


        String[][] mas4x4 = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };
        System.out.println("Sum mas4x4= " + ArrayUtils.arraySum(mas4x4, 4));

/*        String[][] mas4x3 = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };
        System.out.println("Sum mas4x4= " + ArrayUtils.arraySum(mas4x4, 4));*/

/*        String[][] mas4x4x5 = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };
        System.out.println("Sum mas4x4x5= " + ArrayUtils.arraySum(mas4x4x5, 4));*/

        String[][] mas4x4noint = {
                {"1", "1", "1", "1"},
                {"1", "1", "X", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };
        System.out.println("Sum mas4x4noint= " + ArrayUtils.arraySum(mas4x4noint, 4));
    }
}
