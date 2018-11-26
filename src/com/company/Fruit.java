package com.company;

import java.io.*;
import java.util.Objects;

public class Fruit implements Serializable {
    private String fruitName;
    private String fruitColor;

    public Fruit() {

    }

    public Fruit(String fruitName, String fruitColor) {
        this.fruitName = fruitName;
        this.fruitColor = fruitColor;
    }

    public void input() throws IOException {
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

    public void saveObjectInFile(BufferedWriter bw) {

        String data = this.fruitName + " " + this.fruitColor + "\n";
        try {
            bw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return String.format("Fruit [fruitName=%s, fruitColor=%s]", fruitName, fruitColor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Objects.equals(fruitName, fruit.fruitName) &&
                Objects.equals(fruitColor, fruit.fruitColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitName, fruitColor);
    }

}
