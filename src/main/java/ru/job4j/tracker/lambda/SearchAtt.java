package ru.job4j.tracker.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchAtt {
    private static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> predicate) {
        return list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
}

    public static List<Attachment> filterSizePredicate(List<Attachment> list) {
        return filter(list, x -> x.getSize() > 100);
    }

    public static List<Attachment> filterNamePredicate(List<Attachment> list) {
        return filter(list, x -> x.getName().equals("bug"));
    }

    public static void main(String[] args) {
        List<Attachment> list = Stream.of(
                new Attachment("Cinema", 45),
                new Attachment("Auto", 450),
                new Attachment("Home", 101),
                new Attachment("bug", 10))
                .collect(Collectors.toList());
        for (Attachment a: filterSizePredicate(list)) {
            System.out.println(a);
        }
        for (Attachment a: filterNamePredicate(list)) {
            System.out.println(a);
        }
    }
}
