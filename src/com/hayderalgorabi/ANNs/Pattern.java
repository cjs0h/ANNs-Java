package com.hayderalgorabi.ANNs;


public class Pattern {
    private double[] _inputs;
    private double _output;

    public Pattern(String value, int inputSize) throws Exception {
        String[] line = value.split(",");
        if (line.length - 1 != inputSize)
            throw new Exception("Input does not match network configuration " + value );
        _inputs = new double[inputSize];
        for (int i = 0; i < inputSize; i++)
        {
            _inputs[i] = Double.parseDouble(line[i]);
        }
        _output = Double.parseDouble(line[inputSize]);
    }

    public double[] Inputs()
    {
         return _inputs;
    }

    public double Output()
    {
         return _output;
    }
}
