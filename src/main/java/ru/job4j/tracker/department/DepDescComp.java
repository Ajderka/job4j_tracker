package ru.job4j.tracker.department;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        List<String> o1str = new ArrayList<>();
        o1str = Arrays.asList(o1.split("/"));
        List<String> o2str = new ArrayList<>();
        o2str = Arrays.asList(o2.split("/"));
        int result = 0;
        if (o1str.size() < o2str.size()) {
            return -1;
        } else if (o1str.size() > o2str.size()) {
            return 1;
        }
        for (int i = 0; i < o1str.size(); i++) {
            if (o1str.get(i).compareTo(o2str.get(i)) == 0) {
                continue;
            } else {
                result = o1str.get(i).compareTo(o2str.get(i));
                break;
            }
        }
        return result;
    }
}
