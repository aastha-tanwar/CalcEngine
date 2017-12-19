package com.aastha.calcengine;

//Demonstrating Inheritance

public abstract class CalculateBase {
    private double leftVal, rightVal, result;

    public void setLeftVal(double leftVal){this.leftVal=leftVal;}
    public double getLeftVal(){return  leftVal;}
    public void setRightVal(double rightVal){this.rightVal=rightVal;}
    public double getRightVal(){return  rightVal;}
    public void setResult(double result){this.result=result;}
    public double getResult(){return result;}

    public  CalculateBase(){}
    public CalculateBase(double leftVal,double rightVal){
        this.leftVal=leftVal;
        this.rightVal=rightVal;
    }

    public abstract void calculate();
}
