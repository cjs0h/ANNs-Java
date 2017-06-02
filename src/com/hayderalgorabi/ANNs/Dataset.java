package com.hayderalgorabi.ANNs;

public class Dataset {
    private String Input;
    private double Output;
    public Dataset(String Input,double Output){
        this.Input = Input;
        this.Output = Output;
    }
    public Dataset(){}
    public double GetOutPut(){
        return this.Output;
    }
    public String GetName(){
        return this.Input;
    }
}
