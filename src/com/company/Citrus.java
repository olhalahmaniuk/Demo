package com.company;

import java.io.BufferedWriter;
import java.io.IOException;


public class Citrus extends Fruit {
    private int vitaminCContent;

    public Citrus() {

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
    public void input() throws IOException {
        System.out.println("Input vitamin C content: ");
        try {
            vitaminCContent = Main.scanner.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("Input number!");
        }
        super.input();
    }

    @Override
    public void saveObjectInFile(BufferedWriter bw) {
        String data = this.getFruitName() + " " + this.getFruitColor() + " " + this.vitaminCContent + "\n";
        try {
            bw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() + "Citrus [cVitaminContent=" + vitaminCContent + "]";
    }
}
