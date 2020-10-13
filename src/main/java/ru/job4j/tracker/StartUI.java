package ru.job4j.tracker;

import ru.job4j.tracker.input.*;
import ru.job4j.tracker.userAction.*;

import java.util.Arrays;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAll(Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.replace(id, item);
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        tracker.delete(id);
        System.out.println("Delete complete");
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id. ===");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        System.out.println(tracker.findById(id));
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        System.out.println(Arrays.toString(tracker.findByName(name)));
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions); //Просто выводит на экран меню, методом перебора массива action (массив действий)
            int select = input.askInt("Select: "); //вводим интовую переменную с выбором дейсвия пользователя
            UserAction action = actions[select]; //создаем новое действие уже не ввиде массива, а как отдельное. И вытаскиваем с массива выбранное пользователем дейсвие
            run = action.execute(input, tracker); //передаем в само дейсвие которое выбрал пользователь - параметры
        }
    }


    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] userActions = {new CreateAction(), new ShowAll(), new ReplaceItem(), new DeleteItem(), new FindItemById(), new FindItemByName(), new Exit()};
        new StartUI().init(input, tracker, userActions);
    }
}
