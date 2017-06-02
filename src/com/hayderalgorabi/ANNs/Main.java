package com.hayderalgorabi.ANNs;

public class Main {

    public static void main(String[] args) {
        try {
            Encoder en = new Encoder();
            try {
                en.SetInputDataPath("e:/in2.data");
                en.SetOutputDataPath("e:/out.csv");
                en.BuildDataset();
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }

            int InputNodes = 32;
            int HiddenNodes = 60;
            double Error = 0.01;
            int Itertaion = 700000;
            String PatternsPath = "e:/out.csv";
            new Network(InputNodes,HiddenNodes,Error,Itertaion,PatternsPath,en);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
