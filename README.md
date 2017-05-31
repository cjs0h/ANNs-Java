# ANNs-Java
  this project is a simple implementation for back propagation neural network in java


# Usage 
* import the package into ur project 
* create a Main class that Contain the main function
* Now you Need to set the required parameters to run the network
  * The input Nodes
  * The Hidden Nodes
  * The acceptable error rate
  * training iteration
  * The full path for Patterns.csv
* Now Make New Object for the Network class

## Ex:
```java
package com.hayderalgorabi.ANNs;

public class Main {

    public static void main(String[] args) {
        try {
            int InputNodes = 6;
            int HiddenNodes = 12;
            double Error = 0.01;
            int Itertaion = 500;
            String PatternsPath = "e:/Patterns.csv";
            new Network(InputNodes,HiddenNodes,Error,Itertaion,PatternsPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

```
