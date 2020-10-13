package ru.job4j.tracker.userAction;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class FindItemById implements UserAction {
    @Override
    public String name() {
        return "=== Find item by id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        System.out.println(tracker.findById(id));
        return true;
    }
}
