package com.company;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fruit implements Serializable {
    private String fruitName;
    private String fruitColor;

    public Fruit() {

    }

    public Fruit(String fruitName, String fruitColor) {
        this.fruitName = fruitName;
        this.fruitColor = fruitColor;
    }

    public void input() {
        System.out.println("Input fruit name: ");
        fruitName = Main.scanner.next();
        System.out.println("Input fruit color: ");
        fruitColor = Main.scanner.next();
    }


    public void print() {
        System.out.println(this);
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitColor() {
        return fruitColor;
    }

    public void setFruitColor(String fruitColor) {
        this.fruitColor = fruitColor;
    }

    public static List<Fruit> readFruitFromFile() throws IOException {
        FileInputStream fis = new FileInputStream("fruits.xml");
        XMLDecoder decoder = new XMLDecoder(fis);
        List<Fruit> decodedFruits = (List<Fruit>) decoder.readObject();
        decoder.close();
        fis.close();
        return decodedFruits;
    }

    public static void saveFruitInFile(List<Fruit> fruits) throws IOException {
        FileOutputStream fos = new FileOutputStream("fruits.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.writeObject(fruits);
        encoder.close();
        fos.close();
    }

    public static List<Fruit> getFruitFromFile() throws IOException {
        List<Fruit> fruits = new ArrayList<Fruit>();

        try (BufferedReader br = new BufferedReader(new FileReader("Fruits.txt"))) {

            // Read file line by line
            String line = "";
            while ((line = br.readLine()) != null) {

                Fruit fruit = new Fruit();

                String[] value = line.split(" ");
                if (value.length == 2) {
                    fruit.fruitName = value[0];
                    fruit.fruitColor = value[1];

                    fruits.add(fruit);
                }

            }
        }
        return fruits;
    }

    public boolean readFromFile(BufferedReader br) throws IOException {
        String line = "";
        if((line = br.readLine()) == null){
            return false;
        }
        else {
            String[] value = line.split(" ");
            this.setFruitName(value[0]);
            this.setFruitColor(value[1]);
        }
        return true;
    }



    @Override
    public String toString() {
        return String.format("Fruit [fruitName=%s, fruitColor=%s]", fruitName, fruitColor);
    }


}
