package com.hayderalgorabi.ANNs;

public class Main {

    public static void main(String[] args) {
        try {
            int InputNodes = 2;
            int HiddenNodes = 12;
            double Error = 0.01;
            int Itertaion = 500;
            String PatternsPath = "e:/Patterns.csv";
            new Network(InputNodes,HiddenNodes,Error,Itertaion,PatternsPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
