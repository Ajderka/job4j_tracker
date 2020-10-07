package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Create please interface"));
        System.out.println(tracker.findById(1));
    }
}
