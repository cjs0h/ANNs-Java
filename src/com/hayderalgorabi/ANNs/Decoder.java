package com.hayderalgorabi.ANNs;

import java.io.*;

public class Decoder {
    public String Unlock(double Output, Encoder en){
        String City;
        int Index = 0,O = 0;
        double distance = Math.abs(en.ds.get(0).GetOutPut() - Output);
        for(Dataset dss : en.ds){
            double cdistance = Math.abs(dss.GetOutPut() - Output);
            if(cdistance < distance){
                O = Index;
                distance = cdistance;
            }
            Index +=1;
        }
        City = en.ds.get(O).GetName();
        return City;
    }
}
