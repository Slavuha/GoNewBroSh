package com.shpp.p2p.cs.vmazur.assignment2;

import com.shpp.cs.a.console.TextProgram;

// Program calculate square roots from input numbers.
public class Assignment2Part1 extends TextProgram {

    public void run() {
        double a = 0;
        double b = 0;
        double c = 0;
        for (int i = 1; i < 4; i++) {
            double number = readDouble("Enter " + i + " number ");
            if (i == 1) {
                a = number;
            }
            if (i == 2) {
                b = number;
            }
            if (i == 3) {
                c = number;
            }
        }
        calculateDiscriminant(a, b, c);
    }

    /**
     * Method take input numbers and calculate it regards to formula.
     *
     * @param a
     * @param b
     * @param c
     */
    private void calculateDiscriminant(double a, double b, double c) {
        double d = (b * b) - (4 * a * c);
        if (d > 0) {
            double x1 = (-b + Math.sqrt(d))
                    / (2 * a);

            double x2 = (-b - Math.sqrt(d))
                    / (2 * a);
            System.out.println("The roots are " + x1 + " and " + x2);
        } else if (d == 0) {
            double x1 = -b
                    / (2 * a);
            System.out.println("The root is " + x1);
        } else {
            System.out.println("Roots are not real.");
        }
    }
}
