package ru.job4j.tracker.department;

import java.util.*;

public class Departments {

    /**
     * Чтобы реализовать метод fillGaps, нужно определить, какие элементы отсутствуют в системе.
     * Для этого каждую входящую строку нужно разбить на одиночные элементы. Для этого можно использовать
     * метод String.split("/"). Этот метод вернет массив одиночных элементов. Далее нужно через цикл последовательно
     * складывать элементы и добавлять их в множество. Используйте в качестве промежуточного хранения LinkedHashSet.
     *
     * @param deps
     * @return
     */

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (tmp.isEmpty()) {
                    tmp.add(el);
                    start = el;
                } else if(deps.size() == value.split("/").length){
                    tmp.add(value);
                    break;
                } else {
                    tmp.add(start + "/" + el);
                    start = start + "/" + el;
                }
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {

    }

    public static void sortDesc(List<String> orgs) {
    }
}