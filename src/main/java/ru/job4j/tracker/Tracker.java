package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> res = new ArrayList();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                res.add(item);
            }
        }
        return res;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (Item item : items) {
            if (item.getId() == id) {
                rsl = items.indexOf(item);
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        boolean result = false;
        for (Item i : items) {
            if (i.getId() == id) {
                items.set(items.indexOf(i), item);
                item.setId(id);
                result = true;
            }
        }
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        for (Item item : items) {
            if (item.getId() == id) {
                items.remove(item);
                result = true;
                break;
            }
        }
        return result;
    }
}