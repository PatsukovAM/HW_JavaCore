package Lesson4_HW;

import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
        System.out.println("Задание 1");
        String[] words = {"Apple", "Orange", "Tomato", "Banana", "Apple"};
        HashMap<String, Integer> wordsUniqueWithRepeats = new HashMap<>();

        for(int i=0; i<words.length;i++) {
            wordsUniqueWithRepeats.computeIfPresent(words[i], (String,Integer) -> Integer+1);
            wordsUniqueWithRepeats.putIfAbsent(words[i],1);
            }
        System.out.println(wordsUniqueWithRepeats);

        System.out.println("\nЗадание 2");

        Phonebook phonebook=new Phonebook();
        phonebook.add("9212112121","Иванов");
        phonebook.add("9212112122","Всечкин");
        phonebook.add("9212112123","Никитин");
        phonebook.add("9212112124","Иванов");

        phonebook.get("Никитин");
        System.out.println("");
        phonebook.get("Иванов");
        System.out.println("");
        phonebook.get("Сидоров");
        }

    }

