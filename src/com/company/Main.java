package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // write your code here

        List<Fruit> fruitsList = new ArrayList<>();
        Output op = new Output();
        while (true) {
            System.out.println("To exit press 0");
            System.out.println("Input number from 1-6: ");
            int a = scanner.nextInt();
            switch (a) {
                case 1:
                    System.out.println("1)Input fruits from console and print: ");
                    for (int i = 0; i < 2; i++) {
                        Fruit fruit = new Fruit();
                        Citrus citrus = new Citrus();
                        fruit.input();
                        citrus.input();
                        fruitsList.add(fruit);
                        fruitsList.add(citrus);
                        for (Fruit f : fruitsList) {
                            f.print();
                        }
                    }
                    break;
                case 2:
                    System.out.println("2)Read fruits from file and print: ");
                    try {
                        fruitsList = op.getFruitFromFile();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    for (Fruit f : fruitsList) {
                        f.print();
                    }
                    break;
                case 3:
                    System.out.println("3) Sort fruits and output into file:  ");
                    Output.sortByName(fruitsList);
                    op.saveListFruitsInFile(fruitsList);
                    System.out.println("Check saveFruits.txt");
                    break;
                case 4:
                    System.out.println("4)Output fruits with yellow color:  ");
                    List<Fruit> yellowFruits = Output.theSameColor("yellow", fruitsList);
                    for (Fruit f : yellowFruits) {
                        f.print();
                    }
                    break;
                case 5:
                    System.out.println("5) Serialization into xml file: ");
                    try {
                        Output.saveFruitInFile(fruitsList);
                        System.out.println("Check fruits.xml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("6) Deserialization from xml file and print: ");
                    try {
                        List<Fruit> lists = Output.readFruitFromFile();
                        for (Fruit f : lists) {
                            System.out.println(f);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                case 0:
                    return;
                default:
                    System.out.println("No such action");
            }
        }
    }
}





