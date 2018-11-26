package com.company;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Output {

    List<Fruit> fruitsList = new ArrayList<Fruit>();

    public static List<Fruit> theSameColor(String color, List<Fruit> fruitsList) {
        Iterator<Fruit> iterator = fruitsList.iterator();
        List<Fruit> yellowFruits = new ArrayList<>();
        while (iterator.hasNext()) {
            Fruit fruit = iterator.next();
            if (fruit.getFruitColor().equals(color)) {
                yellowFruits.add(fruit);
            }
        }
        return yellowFruits;
    }

    public static List<Fruit> sortByName(List<Fruit> fruitsList) {

        Collections.sort(fruitsList, new SortByName());
        return fruitsList;
    }

    public static void saveFruitInFile(List<Fruit> fruits) throws IOException {
        FileOutputStream fos = new FileOutputStream("fruits.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.writeObject(fruits);
        encoder.close();
        fos.close();
    }

    public static List<Fruit> readFruitFromFile() throws IOException {
        FileInputStream fis = new FileInputStream("fruits.xml");
        XMLDecoder decoder = new XMLDecoder(fis);
        List<Fruit> decodedFruits = (List<Fruit>) decoder.readObject();
        decoder.close();
        fis.close();
        return decodedFruits;
    }

    public void saveListFruitsInFile(List<Fruit> fruits) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("saveFruits.txt"));
        for (Fruit f : fruits) {
            f.saveObjectInFile(bufferedWriter);
        }
        bufferedWriter.close();
    }

    public List<Fruit> getFruitFromFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("Fruits.txt"))) {
            // Read file line by line
            String line = "";
            while ((line = br.readLine()) != null) {
                // Parse line to extract individual fields
                String[] data = line.split(" ");
                if (data.length == 3) {
                    Citrus citrus = new Citrus();
                    citrus.setFruitName(data[0]);
                    citrus.setFruitColor(data[1]);
                    citrus.setVitaminCContent(Integer.parseInt(data[2]));
                    fruitsList.add(citrus);
                } else if (data.length == 2) {
                    Fruit fruit = new Fruit();
                    fruit.setFruitName(data[0]);
                    fruit.setFruitColor(data[1]);
                    fruitsList.add(fruit);
                }
            }
        }
        return fruitsList;
    }
}







