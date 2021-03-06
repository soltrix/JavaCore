package ru.solodkov.javacore;

import java.util.HashMap;
import java.util.Map;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("Задача 1");
        repeat();
        System.out.println("\t");
        System.out.println("Задача 2");
        phonebook();
    }

    // 1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
    // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
    // Посчитать, сколько раз встречается каждое слово.
    private static void repeat() {
        String[] arr = {"аквариум", "аккомпанемент", "аккумулятор", "вагон", "валенки", "варежки", "жаворонок", "жалоба", "жёлтый", "лаборатория", "ладонь", "обаяние", "обезьяна", "аккомпанемент", "лаборатория", "варежки"};
        Map<String, Integer> hm = new HashMap<>();
        for(String i: arr) {
            hm.put(i, hm.getOrDefault(i,0) + 1);
        }
        System.out.println(hm);
    }

    // Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
    // В этот телефонный справочник с помощью метода add() можно добавлять записи.
    // С помощью метода get() искать номер телефона по фамилии.
    // Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
    // тогда при запросе такой фамилии должны выводиться все телефоны.
    private static void phonebook() {
        Phonebook phonebook = new Phonebook();
        phonebook.addContact("Иванов", "89203215648");
        phonebook.addContact("Смирнов", "89106853424");
        phonebook.addContact("Кузнецов", "89993545453");
        phonebook.addContact("Смирнов", "89035468546");
        phonebook.addContact("Кузнецов", "89066543865");
        phonebook.addContact("Петров", "89155436354");
        phonebook.addContact("Смирнов", "89058867434");
        phonebook.addContact("Попов", "89029687868");

        phonebook.getContact("Иванов");
        phonebook.getContact("Смирнов");
        phonebook.getContact("Кузнецов");
        phonebook.getContact("Попов");
        phonebook.getContact("Васильев");
    }
}
