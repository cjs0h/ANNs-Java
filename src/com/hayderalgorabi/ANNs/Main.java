package com.hayderalgorabi.ANNs;

public class Main {

    public static void main(String[] args) {
        try {
            new Network(6,12,0.1,500,"e:/Patterns.csv");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
