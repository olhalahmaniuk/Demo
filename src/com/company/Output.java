package com.company;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Output {


    public static List<Fruit> theSameColor(String color, List<Fruit> fruitsList) {
        Iterator<Fruit> iterator = fruitsList.iterator();
        List<Fruit> yellowfruits = new ArrayList<>();
        while (iterator.hasNext()) {
            Fruit fruit = iterator.next();
            if (fruit.getFruitColor().equals(color)) {
                yellowfruits.add(fruit);
            }
        }
        return yellowfruits;
    }
    public static List<Fruit> sortByName(List<Fruit> fruits) {

        Collections.sort(fruits, new SortByName());
        return fruits;
    }

    public static void saveFruitInFile(List<Fruit> fruits) throws IOException {
        FileOutputStream fos = new FileOutputStream("fruits.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.writeObject(fruits);
        encoder.close();
        fos.close();
    }




    public static Fruit parseToFruit(String line) {
        Fruit fruit = new Fruit();
        String company = "";

        String newLine = line.replaceAll(company, " ");
        newLine = newLine.replaceAll("\"", " ");
        newLine = newLine.replaceAll(" +", " ");

        List<String> values = new ArrayList<String>();

        for (String value : newLine.split(" ")) {
            value.trim();
            values.add(value);
        }

        fruit.setFruitName(values.get(0));
        fruit.setFruitColor(values.get(1));
        return fruit;
    }
}







