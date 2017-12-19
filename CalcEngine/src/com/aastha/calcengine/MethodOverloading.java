package com.aastha.calcengine;

public class MethodOverloading {
    private double leftVal, rightVal, result;
    private char opCode;

    public void setLeftVal(double leftVal){this.leftVal=leftVal;}//example of mutator
    public double getResult(){return result;}

    public MethodOverloading(char opCode)
    {
        this.opCode=opCode;
    }

    public MethodOverloading(double leftVal, double rightVal, char opCode)  //example for constructor
    {
        this(opCode);                   //chaining constructors
        this.leftVal=leftVal;
        this.rightVal=rightVal;

    }

    public void execute(double leftVal, double rightVal)
    {
        this.leftVal=leftVal;
        this.rightVal=rightVal;

        execute();
    }

    public void execute(int leftVal, int rightVal)
    {
        this.leftVal=leftVal;
        this.rightVal=rightVal;

        execute();
        result=(int) result;  //to satisfy integer division
    }


    public void execute(){
        switch (opCode) {
            case 'd':
                result = rightVal != 0 ? leftVal / rightVal : 0.0d;
                break;
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            default:
                result = 0.0d;
                break;
        }
    }

}
