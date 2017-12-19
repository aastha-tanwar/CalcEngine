package com.aastha.calcengine;

public class MathEquation {
    private double leftVal, rightVal, result;
    private char opCode;

    public void setLeftVal(double leftVal){this.leftVal=leftVal;}//example of mutator
    public double getResult(){return result;} //example of accessor

    public MathEquation(){}            //default constructor

    public MathEquation(char opCode)
    {
        this.opCode=opCode;
    }

    public MathEquation(double leftVal, double rightVal, char opCode)  //example for constructor
    {
        this(opCode);                   //chaining constructors
        this.leftVal=leftVal;
        this.rightVal=rightVal;

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
