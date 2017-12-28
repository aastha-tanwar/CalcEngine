package com.aastha.myapp;

import com.aastha.calcengine.CalculateBase;
import com.aastha.calcengine.CalculateHelper;
import com.aastha.calcengine.DynamicHelper;
import com.aastha.calcengine.InvalidStatementException;
import com.aastha.calcengine.MathEquation;
import com.aastha.calcengine.MathProcessing;
import com.aastha.calcengine.MethodOverloading;
import com.aastha.calcengine.PowerOf;
import com.aastha.calcengine.Subtractor;
import com.aastha.calcengine.Multiplier;
import com.aastha.calcengine.Divider;
import com.aastha.calcengine.Adder;

public class Main {

	public static void main(String[] args) {
		double val1 = 100.0d;
		double val2 = 50.0d;
		double result;
		char opCode = 'd';

		if (opCode == 'a')
			result = val1 + val2;
		else if (opCode == 's')
			result = val1 - val2;
		else if (opCode == 'd')
			result = val2 != 0 ? val1 / val2 : 0.0d;
		/*if (val2!=0)
	    result=val1/val2;
		else
		result=0.0d;*/
		else if (opCode == 'm')
			result = val1 * val2;
		else {
			System.out.println("Error--invalid opCode");
			result = 0.0d;
		}
		System.out.println(result);

//	float[] theVals= new float[3];
		float[] theVals = {10.0f, 20.0f, 15.0f};
//	theVals[0]=10.0f;
//	theVals[1]=20.0f;
//	theVals[2]=15.0f;
		float sum = 0.0f, sum1 = 0.0f;
		for (int i = 0; i < theVals.length; i++)
			sum += theVals[i];
		System.out.println(sum);
		for (float currentVal : theVals)
			sum1 += currentVal;
		System.out.println(sum1);

		//Using arrays, for-each, switch
		double[] leftVals = {220.0d, 20.0d, 11.0d, 24.0d};
		double[] rightVals = {10.0d, 3.0d, 9.0d, 450.0d};
		char[] opCodes = {'d', 's', 'a', 'm'};
		double[] results = new double[opCodes.length];
		for (int i = 0; i < opCodes.length; i++) {
			switch (opCodes[i]) {
				case 'd':
					results[i] = rightVals[i] != 0 ? leftVals[i] / rightVals[i] : 0.0d;
					break;
				case 'a':
					results[i] = leftVals[i] + rightVals[i];
					break;
				case 's':
					results[i] = leftVals[i] - rightVals[i];
					break;
				case 'm':
					results[i] = leftVals[i] * rightVals[i];
					break;
				default:
					results[i] = 0.0d;
					break;
			}
		}
		for (double theResult:results)
		{
			System.out.print("result=");
			System.out.println(theResult);
		}

		//using Classes
		System.out.println("Calc engine using Classes and objects:");
		MathEquation[] equations= new MathEquation[4];
		equations[0] = new MathEquation(8.2d,6.4d,'a');
		equations[1]=new MathEquation(6.7d,8.67d,'d');
		equations[2]=new MathEquation(225.0d,17.0d,'s');
		equations[3]=new MathEquation(9.0d,8.0d,'m');
		for (MathEquation resulteq:equations
			 ) {
			resulteq.execute();
			System.out.println(resulteq.getResult());
		}

		//Using Method Overloading
		System.out.println("Using Method Overloading:");

		double leftDouble=9.0d;
		double rightDouble=4.0d;
		int leftInt=9;
		int rightInt=4;

		MethodOverloading equationOverload=new MethodOverloading('d');
		equationOverload.execute(leftDouble,rightDouble);
		System.out.println("Result:");
		System.out.println(equationOverload.getResult());

		equationOverload.execute(leftInt,rightInt);
		System.out.println("Result:");
		System.out.println(equationOverload.getResult());

		equationOverload.execute((double) leftInt,rightInt);
		System.out.println("Result:");
		System.out.println(equationOverload.getResult());

		System.out.println("Using Inheritance:");




		CalculateBase[] calculators={
				new Adder(15.0d,58.0d),
				new Subtractor(87.0d,9.0d)
		};

		for (CalculateBase calculaor:calculators
			 ) {
			calculaor.calculate();
			System.out.println("result:");
			System.out.println(calculaor.getResult());

		}

		//Using Strings,enum

		System.out.println("Using Strings, enum:");

		String[] statements={
				"add 1.0",
				"add xx 25.0",
				"addX 0.0 0.0",
				"divide 100.0 50.0",
				"add 25.0 92.0",
				"subtract 225.0 17.0",
				"Multiply 11.0 3.0"
		};

		CalculateHelper helper= new CalculateHelper();
		for (String statement:statements
			 ) {
			try {
				helper.process(statement);
				System.out.println(helper);   //calls our overriden toString method
			}
			catch (InvalidStatementException e)
			{
				System.out.println(e.getMessage());

				if(e.getCause()!=null)                   //to check if there was another exception other than Invalid statement exception-here it will be "Number Format exception'
					System.out.println("Original exception:"+ e.getCause().getMessage());
			}

		}

		//using interfaces and dynamic helper
		System.out.println("Using interface and dynamic helper:");

		String[] statementsNew={
				"power 5.0 2.0",  //5.0 ^ 2.0 =25.0
				"add 23.0 5.0"

		};

		DynamicHelper helperDynamic=new DynamicHelper( new MathProcessing[]{
				new PowerOf(),
				new Adder()
		});

		for (String statement:statementsNew) {
			String output=helperDynamic.process(statement);
			System.out.println(output);
		}

	}
}
