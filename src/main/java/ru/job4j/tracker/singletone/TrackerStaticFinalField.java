package ru.job4j.tracker.singletone;

import ru.job4j.tracker.Tracker;

public class TrackerStaticFinalField {
    private static final Tracker INSTANCE = new Tracker();

    private TrackerStaticFinalField() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerStaticFinalField.getInstance();
    }
}
