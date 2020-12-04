package ru.job4j.tracker.department;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (tmp.isEmpty()) {
                    tmp.add(el);
                    start = el;
                } else if (deps.size() == value.split("/").length) {
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
}