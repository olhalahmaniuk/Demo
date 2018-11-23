package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Citrus extends Fruit {
    private int vitaminCContent;

    public Citrus(){

    }

    public Citrus(String fruitName, String fruitColor, int vitaminCContent) {
        super(fruitName, fruitColor);
        this.vitaminCContent = vitaminCContent;
    }

    public int getVitaminCContent() {
        return vitaminCContent;
    }

    public void setVitaminCContent(int vitaminCContent) {
        this.vitaminCContent = vitaminCContent;
    }

    @Override
    public void input() {
        System.out.println("Input vitamin C content: ");
        vitaminCContent = Main.scanner.nextInt();
        super.input();
    }

    @Override
    public void print() {
        System.out.println(this);

    }


    public static List<Fruit> getFruitFromFile() throws IOException {
        List<Fruit> fruits = new ArrayList<Fruit>();

        try (BufferedReader br = new BufferedReader(new FileReader("Fruits.txt"))) {
            // Read file line by line
            String line = "";
            while ((line = br.readLine()) != null) {
                // Parse line to extract individual fields
                Citrus citrus = new Citrus();
                String[] data = line.split(" ");
                if (data.length == 3) {
                    citrus.setFruitName(data[0]);
                    citrus.setFruitColor(data[1]);
                    citrus.vitaminCContent = Integer.parseInt(data[2]);
                    // Add object to list
                    fruits.add(citrus);
                }

            }
        }
        return fruits;
    }

    @Override
    public boolean readFromFile(BufferedReader br) throws IOException {
        String line = "";
        if(!super.readFromFile(br)){
            return false;
        }
        else {
            String[] value = line.split(" ");
            this.setFruitName(value[0]);
            this.setFruitColor(value[1]);
            this.setVitaminCContent(Integer.parseInt(value[2]));

        }
        return true;
    }


    @Override
    public String toString() {
        return super.toString() + "Citrus [cVitaminContent=" + vitaminCContent + "]";
    }
}
