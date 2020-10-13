package ru.job4j.tracker.userAction;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class FindItemById implements UserAction {
    private final Output out;

    public FindItemById(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by id ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        System.out.println(tracker.findById(id));
        return true;
    }
}
