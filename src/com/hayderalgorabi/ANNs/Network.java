package com.hayderalgorabi.ANNs;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Network {
    private int _hiddenDims = 64;        // Number of hidden neurons.
    private int _inputDims = 32;        // Number of input neurons.
    private double _error = 0.001;       // Desired error value
    private int _iteration;            // Current training iteration.
    private int _restartAfter = 2000;   // Restart training if iterations exceed this.
    private String _PatternsPath;      // Patterns csv file full path
    private Layer _hidden;              // Collection of hidden neurons.
    private Layer _inputs;              // Collection of input neurons.
    private List<Pattern> _patterns;    // Collection of training patterns.
    private Neuron _output;            // Output neuron.
    private Random _rnd = new Random(); // Global random number generator.
    private Encoder e;


    public Network(int InputNodes,int HiddenNodes, double Error,int Itertaion, String PatternsPath,Encoder M) throws Exception
    {
        e = M;
        _hiddenDims = HiddenNodes;
        _inputDims = InputNodes;
        _error = Error;
        _restartAfter = Itertaion;
        _PatternsPath = PatternsPath;
        long startTime = System.currentTimeMillis();
        LoadPatterns();
        Initialise();
        Train();
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("execution time - " + totalTime);
        Test();
    }
    public Network(int InputNodes,int HiddenNodes, double Error,int Itertaion, String PatternsPath) throws Exception
    {

        _hiddenDims = HiddenNodes;
        _inputDims = InputNodes;
        _error = Error;
        _restartAfter = Itertaion;
        _PatternsPath = PatternsPath;
        long startTime = System.currentTimeMillis();
        LoadPatterns();
        Initialise();
        Train();
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("execution time - " + totalTime);
        Test();
    }

    private void Train()
    {
        double error;
        do
        {
            error = 0;

            for (Pattern pattern :  _patterns)
            {
                double delta = pattern.Output() - Activate(pattern);
                AdjustWeights(delta);
                error += Math.pow(delta, 2);
            }

            System.out.println("Iteration "+ _iteration + "  \tError "+ error);
            _iteration++;
            if (_iteration > _restartAfter) Initialise();
        } while (error > _error);
    }



    private void Test()
    {
        System.out.println("\nBegin network testing\nPress Ctrl C to exit\n");
        Decoder Obj = new Decoder();
        while (true)
        {
            try {
                if (e != null) {
                    Encoder enn = new Encoder();
                    Scanner re = new Scanner(System.in);
                    System.out.println("Input Your Data in the same format that stored at the csv file -> ");
                    String values = re.nextLine();
                    System.out.println(Obj.Unlock(Activate(new Pattern(enn.BuildTestData(values), _inputDims)), this.e) + " | " + Activate(new Pattern(enn.BuildTestData(values), _inputDims)));
                } else {

                    Scanner re = new Scanner(System.in);
                    System.out.println("Input Your Data in the same format that stored at the csv file -> ");
                    String values = re.nextLine() ;
                    values += ",0";
                    System.out.println(Activate(new Pattern(values, _inputDims)));

                }
            }
            catch (Exception e)
            {
                System.out.println("Error : "+e.getStackTrace());
            }
        }
    }

    private double Activate(Pattern pattern)
    {
        double[] aInputs = pattern.Inputs();
        for (int i = 0; i < aInputs.length; i++)
        {
            _inputs.get(i).Output(aInputs[i]);
        }
        for (Neuron neuron :  _hidden)
        {
            neuron.Activate();
        }
        _output.Activate();
        return _output.Output();
    }

    private void AdjustWeights(double delta)
    {
        _output.AdjustWeights(delta);
        for (Neuron neuron : _hidden)
        {
            neuron.AdjustWeights(_output.ErrorFeedback(neuron));
        }
    }

    private void Initialise()
    {
        _inputs = new Layer(_inputDims);
        _hidden = new Layer(_hiddenDims, _inputs, _rnd);
        _output = new Neuron(_hidden, _rnd);
        _iteration = 0;
        System.out.println("Network Initialised");
    }

    private void LoadPatterns() throws Exception {
        _patterns = new ArrayList<>();
        FileInputStream file = new FileInputStream(_PatternsPath);
        BufferedReader br = new BufferedReader(new InputStreamReader(file));
        String strLine;
        while ((strLine = br.readLine()) != null)
        {
            Pattern p = new Pattern(strLine, _inputDims);
            _patterns.add(p);
        }
        br.close();
    }
}


