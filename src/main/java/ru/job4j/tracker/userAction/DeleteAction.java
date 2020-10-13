package ru.job4j.tracker.userAction;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete item ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        tracker.delete(id);
        System.out.println("Delete complete");
        return true;
    }
}
