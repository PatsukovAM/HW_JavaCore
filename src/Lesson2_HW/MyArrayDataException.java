package Lesson2_HW;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int i, int j) {
        super("Элемент " + i + ":" + j + " не является элементом целого типа (integer)");
    }
}
