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
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
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

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = this.indexOf(id);
        if (index != -1) {
            items[index] = item;
            items[index].setId(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(int id) {
        int index = this.indexOf(id);
        if (index == -1) {
            return false;
        }
        System.arraycopy(items, index + 1, items, index, size - index   );
        items[size - 1] = null;
        size--;
        return true;
    }
}