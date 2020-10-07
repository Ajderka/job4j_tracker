package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Create please interface"));
        System.out.println(tracker.findById(1));
    }
}
