package com.company;

public class FruitException extends Exception {
    public FruitException(String str){
        System.err.println(str);
    }
}
