package ru.job4j.tracker.userAction;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

import java.util.Arrays;

public class FindItemByName implements UserAction {
    private final Output out;

    public FindItemByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        System.out.println(Arrays.toString(tracker.findByName(name)));
        return true;
    }
}
