package com.company;

import java.util.Comparator;

public class SortByName implements Comparator<Fruit> {
    @Override
    public int compare(Fruit o1, Fruit o2) {
        return o1.getFruitName().compareTo(o2.getFruitName());
    }
}
