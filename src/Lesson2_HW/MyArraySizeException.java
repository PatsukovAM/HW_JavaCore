package Lesson2_HW;

public class MyArraySizeException extends Exception {
    public MyArraySizeException(int errorStingquantity) {
        super("Неверное количество строк в массиве: " + errorStingquantity);
    }

    public MyArraySizeException(int errorRowquantity, int stringNumber) {
        super("Неверное количество элеметов: " + errorRowquantity + " в строке: " + stringNumber);
    }
}
