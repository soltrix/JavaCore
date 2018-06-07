package ru.solodkov.javacore;

import java.util.HashMap;
import java.util.HashSet;

class Phonebook {
    HashMap<String, HashSet<String>> hm;

    Phonebook() {
        this.hm = new HashMap<>();
    }

    void addContact(String name, String phone) {
        HashSet<String> hs = hm.getOrDefault(name, new HashSet<>());
        hs.add(phone);
        hm.put(name, hs);
    }

    void getContact(String name) {
        if(hm.containsKey(name)) {
            System.out.println(name + " " + hm.get(name));
        } else {
            System.out.println("Контакт " + "'" + name + "'" + " в телефонном справочнике отсутствует");
        }
    }
}
