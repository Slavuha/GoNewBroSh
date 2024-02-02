package com.shpp.p2p.cs.vmazur.assignment3;

import com.shpp.cs.a.console.TextProgram;

//Program calculate exponentiation of number.
public class Assignment3Part3 extends TextProgram {
    //I have added two constants to control program
    private static final double NUMBER = 0.5;
    private static final int EXP = -2;

    public void run() {
        raiseToPower(NUMBER, EXP);
        System.out.println("Result " + result);
    }

    /**
     * Method calculate result
     *
     * @param number our number
     * @param exp    our exponent
     */
    private void raiseToPower(double number, int exp) {
        //I created different cases for test scenarios with exp
        if (exp == 0) {
            result = 1;
        }
        if (exp > 0) {
            calculatePositiveExp(number, exp);
        }
        if (exp < 0) {
            calculateNegativeExp(number, exp);
        }
    }

    /**
     * Method calculate number with negative exp
     * @param number from start
     * @param exp from start
     * @return result
     */
    private double calculateNegativeExp(double number, int exp) {
        double firstNum = number;
        exp = exp * -1; //Here I transform negative in positive

        for (int i = 1; i < exp; i++) {
            number = number * firstNum;
            number = 1 / number; //I added this row to right calculate.
        }
        result = number;
        return result;
    }
//I created variable to change it
    double result = 0;
    /**
     * Method calculate number with positive exp
     * @param number from start
     * @param exp from start
     * @return result
     */
    private double calculatePositiveExp(double number, int exp) {
        double firstNum = number;

        for (int i = 1; i < exp; i++) {
            number = number * firstNum;
        }
        result = number;
        return result;
    }
}

