package Lesson3_HW;

import java.util.Arrays;

public class Main {

    public static void swapArrayElements(Object[] array, int i, int j) {
        Object tempElement = array[i];
        array[i] = array[j];
        array[j] = tempElement;
    }

    public static void main(String[] args) {
        System.out.println("Задание 1");
        Integer intMas[] = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(intMas));
        swapArrayElements(intMas, 2, 4);
        System.out.println(Arrays.toString(intMas));
        System.out.println();
        String strMas[] = {"A", "B", "C", "D", "I"};
        System.out.println(Arrays.toString(strMas));
        swapArrayElements(strMas, 0, 4);
        System.out.println(Arrays.toString(strMas));

        System.out.println("\nЗадание 2");

        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruits(new Apple(), 4);
        System.out.println(appleBox1);
        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruits(new Apple(), 4);
        System.out.println(appleBox2);
        System.out.println("\nСравнение коробок c apple " + appleBox1.compare(appleBox2));

        Box<Apple> appleBox3 = new Box<>();
        appleBox2.swapFruits(appleBox3);
        System.out.println("\nПеремещение apple");
        System.out.println(appleBox2);
        System.out.println(appleBox3);

        System.out.println("\nВызов метода вычисления массы коробки у пустой коробки");
        appleBox2.calculateBoxWeight();

        System.out.println("\nСравнение c пустой коробкой " + appleBox1.compare(appleBox2)); //не понял почему тут сначала  произошла подстановка а уже потом вывод строки

        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.addFruits(new Orange(), 5);
        System.out.println("\nВес коробки " + orangeBox1.calculateBoxWeight());

        System.out.println("\nСравнение коробок c apple и orange " + appleBox1.compare(orangeBox1));

    }
}