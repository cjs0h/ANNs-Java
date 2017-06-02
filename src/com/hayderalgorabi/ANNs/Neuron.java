package com.hayderalgorabi.ANNs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Neuron {
    private double _bias;                       // Bias value.
    private double _error;                      // Sum of error.
    private double _input;                      // Sum of inputs.
    private double _lambda = .008;                // Steepness of sigmoid curve.
    private double _learnRate = .5;            // Learning rate.
    private double _output = Double.MIN_VALUE;   // Preset value of neuron.
    private List<Weight> _weights;              // Collection of weights to inputs.
    public Neuron() { }

    public Neuron(Layer inputs, Random rnd)
    {
        _weights = new ArrayList<Weight>();
        for (Neuron input : inputs) {
            Weight w = new Weight();
            w.Input = input;
            w.Value = ((rnd.nextDouble() * 2)
                    - 1);
            _weights.add(w);
        }

    }
    public void Activate()
    {
        _input = 0;
        for (Weight w : _weights)
        {
            _input += w.Value * w.Input.Output();
        }
    }
    public double ErrorFeedback(Neuron input)
    {

        Weight w = new Weight();
        for(Weight t : _weights){
            if(t.Input == input)
                w = t;
        }
        return _error * Derivative() * w.Value;
    }

    public void AdjustWeights(double value)
    {
        _error = value;
        for (int i = 0; i < _weights.size(); i++)
        {
            _weights.get(i).Value += _error * Derivative() * _learnRate * _weights.get(i).Input.Output();
        }
        _bias += _error * Derivative() * _learnRate;
    }

    private double Derivative()
    {

            double activation = Output();
            return activation * (1 - activation);

    }

    public double Output()
    {

            if (_output != Double.MIN_VALUE)
            {
                return _output;
            }
            return 1 / (1 + Math.exp(-_lambda * (_input + _bias)));



    }
    public void Output(double d){
        _output = d;
    }
}
