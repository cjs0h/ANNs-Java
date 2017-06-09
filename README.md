# ANNs-Java
  this project is a simple implementation for back propagation neural network in java

## Features
* Easy to use
* clene code
* you can use text string as input and output
 

# Usage 
* import the package into ur project 
* create a Main class that Contain the main function
* Now you Need to set the required parameters to run the network
  * The input Nodes if you don't know the input size use 0 the lib will try to know it
  * The Hidden Nodes
  * The acceptable error rate
  * training iteration
  * The full path for Patterns.csv
* The lambda (Optional)
* The learn Rate (Optional)


* Now Make New Object for the Network class
  * [Normal Dataset](https://github.com/cjs0h/ANNs-Java#ex)
  * [String Dataset](https://github.com/cjs0h/ANNs-Java#ex2)
## Ex:
```java
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

```

## Ex2:

This is  example  using a  text strings csv file

```java

package com.hayderalgorabi.ANNs;

public class Main {

    public static void main(String[] args) {
        try {
            Encoder en = new Encoder();
            try {
                en.SetInputDataPath("e:/nicknames.csv");
                en.SetOutputDataPath("e:/out.csv");
                en.BuildDataset();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            int InputNodes = 32;
            int HiddenNodes = 60;
            double Error = 0.1;
            int Itertaion = 700000;
            String PatternsPath = "e:/out.csv";
            new Network(InputNodes,HiddenNodes,Error,Itertaion,PatternsPath,en);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
### ScreenShots 
![country capital](https://cdn.pbrd.co/images/dKlOo6uXD.png)

## Note

All efforts have been made to ensure the smooth and correct running of this Library.

 If you find this Library is behaving abnormaly though, there are 3 options :

1) recompile your app. Not an option I would advise.

2) Write a harsh comment that says how this Library is a pile of **** and you can't believe I even dared to waste your time.. Again, not a great option, but it does make me laugh when I read some of 
the stuff.. :-)

3) Send me a short email with error type and any other information you think is relevant, and I'll fix it. Jackpot.

When I find a bug, I crush it. If I don't find it, and you do, and don't tell me, it lives and we all lose.. I'm not a mind-reader. Or a Computer-reader. I'm not one of the X-Men. i'm hayderalgorabi
