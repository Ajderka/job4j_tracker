package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = items[index];
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        int count = 0;
        Item[] result = new Item[size];
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                result[count++] = items[i];
            }
        }
        result = Arrays.copyOf(result, count);
        return result;
    }

    public Item[] findByName(String key) {
        int count = 0;
        Item[] result = new Item[size];
        for (int i = 0; i < size; i++) {
            if(items[i].getName().equals(key)) {
                result[count++] = items[i];
            }
        }
        result = Arrays.copyOf(result,count);
        return result;
    }
}