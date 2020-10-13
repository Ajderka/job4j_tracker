package ru.job4j.tracker.userAction;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class ShowAll implements UserAction {
    private final Output out;

    public ShowAll(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ====");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            System.out.println(item);
        }
        return true;
    }
}

