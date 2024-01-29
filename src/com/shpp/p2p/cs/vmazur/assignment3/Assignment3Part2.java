package com.shpp.p2p.cs.vmazur.assignment3;

import com.shpp.cs.a.console.TextProgram;

//This program calculate numbers grading
public class Assignment3Part2 extends TextProgram {
    public void run() {

        int n = readInt("Enter Number ");
        if (n == 1 || n == 0) {
            // In case when user entered number 0 or 1 program execute this part with information for user.
            System.out.println("Invalid number. You must begin from 2 minimum");
        } else {
            calculateN(n);
        }
    }

    /**
     * I created variable a for calculate and property work method calculateN
     */
    int a = 0;

    /**
     * Method calculate number that user entered regards requirement for task.
     * @param n - number witch user entered
     */
    private void calculateN(int n) {
        while (!(a == 1)) {
            if (n % 2 == 0) {
                System.out.println(n + " is even so I take half:");
                n = n / 2;
                System.out.println("I have got " + n);
            } else {
                System.out.println(n + " is odd so I make 3n +1: ");//If number not even it is odd.
                n = (n * 3) + 1;
                System.out.println("I have got " + n);
            }
            a = n;
        }
    }
}
