package Lesson4_HW;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private HashMap<String,String> pBook= new HashMap<>();

    public void add(String phone, String surName) {
        pBook.putIfAbsent(phone,surName);
    }

    public void get(String surname) {
        System.out.println("По запросу "+surname+" найдено:");
        int counter=0;
        for (Map.Entry<String,String> entry:pBook.entrySet()) {
            if(entry.getValue().equals(surname)) {
                counter++;
                System.out.println(entry.getKey());
            }
        }
        System.out.println("Всего "+counter);
    }
}
