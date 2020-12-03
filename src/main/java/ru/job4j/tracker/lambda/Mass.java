package ru.job4j.tracker.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Mass {
    public static void main(String[] args) {
        String[] names = {
                "Ivan",
                "Petr"
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return left.length() - right.length();
        };
        Arrays.sort(names, lengthCmp);
    }
}
