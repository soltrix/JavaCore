package ru.solodkov.javacore;

import java.util.HashMap;
import java.util.HashSet;

public class Phonebook {
    HashMap<String, HashSet<String>> hm;

    public Phonebook() {
        this.hm = new HashMap<>();
    }

    public void add(String name, String phone) {
        HashSet<String> hs = hm.getOrDefault(name, new HashSet<>());
        hs.add(phone);
        hm.put(name, hs);
    }

    public void get(String name) {
        if(hm.containsKey(name)) {
            System.out.println(name + " " + hm.get(name));
        } else {
            System.out.println("Фамилия " + "'" + name + "'" + " в телефонном справочнике отсутствует");
        }
    }
}
