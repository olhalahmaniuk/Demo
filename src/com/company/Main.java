package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // write your code here


        List<Fruit> fruitsList = new ArrayList<>();
//        fruitsList.add(new Fruit("banana", "yellow"));
//        fruitsList.add(new Fruit("apple", "green"));
//        fruitsList.add(new Fruit("plum", "purple"));
//       fruitsList.add(new Fruit("grape", "green"));
//        fruitsList.add(new Fruit("pear", "yellow"));
//       fruitsList.add(new Citrus("lemon", "yellow",12 ));
//       fruitsList.add(new Citrus("orange", "red",10 ));


       /*for (int i = 0 ; i<2; i++){
           Fruit fruit = new Fruit();
           fruit.input();
           fruitsList.add(fruit);
       }

        for (Fruit f: fruitsList
             ) {f.print();

        }*/

        //Fruit.saveFruitInFile(fruitsList);


        /*try {
            FileWriter fw=new FileWriter("F1.txt");
            Iterator<Fruit> iterator = fruits.iterator();

            while (iterator.hasNext()) {
                Fruit fruit = iterator.next();
                fw.write("Hello");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/


        // read Fruits from file

        /*try {
            fruitsList = Fruit.getFruitFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Fruit f:fruitsList) {
            f.print();
        }*/

        // Fruits with same color
//        System.out.println("Fruits with same color: ");
//        List<Fruit> listFruitsByColor= Output.theSameColor("yellow", fruitsList);
//        for (Fruit f:listFruitsByColor){
//            f.print();
//        }
//
//        System.out.println("Sorted Fruits: ");
//
//        // Sorted Fruits
//        Output.sortByName(fruitsList);
//        for (Fruit f:fruitsList){
//            f.print();
//        }

        /*try {
            Output.saveFruitInFile(fruitsList);
        } catch (IOException e) {
            e.printStackTrace();
        }*/



        //Deserialization from xml
//        try {
//            List<Fruit> lists = Fruit.readFruitFromFile();
//            for (Fruit f : lists) {
//                System.out.println(f);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



        /*for (int i = 0; i < 5; i++) {
            Fruit fruit = new Fruit();
            fruit.input();
            fruits.add(fruit);
        }*/

        List<Fruit> fruits = new ArrayList<>();

//        Citrus citrus = new Citrus();
//        Fruit fruit = new Fruit();
//        for (Fruit f : fruit.getFruitFromFile()) {
//            fruits.add(f);
//        }
//        for (Fruit f : citrus.getFruitFromFile()) {
//
//            fruits.add(f);
//        }
//        for (Fruit f : fruits) {
//            f.print();
//
//        }
        BufferedReader br = new BufferedReader(new FileReader("Fruits.txt"));
        Fruit f=new Fruit();
        while (f.readFromFile(br)){

            fruitsList.add(f);
            f=new Fruit();

        }

        for(Fruit f1: fruitsList){
            System.out.println(f1);
        }


    }
}
