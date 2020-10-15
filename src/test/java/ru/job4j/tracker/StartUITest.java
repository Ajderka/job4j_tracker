package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import ru.job4j.tracker.userAction.*;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenFindByIdAction() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("first item"));
        tracker.add(new Item("second item"));
        UserAction[] actions = {
                new FindItemById(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is("Menu."
                + System.lineSeparator()
                + "0. === Find item by id ===="
                + System.lineSeparator()
                + "1. === Exit ===="
                + System.lineSeparator()
                + "=== Find item by id ===="
                + System.lineSeparator()
                + "Item{id=1, name='first item'}"
                + System.lineSeparator()
                + "Menu."
                + System.lineSeparator()
                + "0. === Find item by id ===="
                + System.lineSeparator()
                + "1. === Exit ===="
                + System.lineSeparator()
                + "=== Exit ===="
                + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByNameAction() {
        Output output = new StubOutput();
        Input input = new StubInput(
                new String[]{"0", "second item", "1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("first item"));
        tracker.add(new Item("second item"));
        UserAction[] actions = {
                new FindItemByName(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is("Menu."
                + System.lineSeparator()
                + "0. === Find items by name ===="
                + System.lineSeparator()
                + "1. === Exit ===="
                + System.lineSeparator()
                + "=== Find items by name ===="
                + System.lineSeparator()
                + "[Item{id=2, name='second item'}]"
                + System.lineSeparator()
                + "Menu."
                + System.lineSeparator()
                + "0. === Find items by name ===="
                + System.lineSeparator()
                + "1. === Exit ===="
                + System.lineSeparator()
                + "=== Exit ===="
                + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllItems() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("first item"));
        tracker.add(new Item("second item"));
        UserAction[] actions = {
                new ShowAll(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu."
                + System.lineSeparator()
                + "0. === Show all items ===="
                + System.lineSeparator()
                + "1. === Exit ===="
                + System.lineSeparator()
                + "=== Show all items ===="
                + System.lineSeparator()
                + "Item{id=1, name='first item'}"
                + System.lineSeparator()
                + "Item{id=2, name='second item'}"
                + System.lineSeparator()
                + "Menu."
                + System.lineSeparator()
                + "0. === Show all items ===="
                + System.lineSeparator()
                + "1. === Exit ===="
                + System.lineSeparator()
                + "=== Exit ===="
                + System.lineSeparator()
        ));
    }

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu."
                + System.lineSeparator()
                + "0. === Exit ===="
                + System.lineSeparator()
        ));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

}