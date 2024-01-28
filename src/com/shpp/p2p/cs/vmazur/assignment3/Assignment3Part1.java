package com.shpp.p2p.cs.vmazur.assignment3;
import com.shpp.cs.a.console.TextProgram;
//Medical program for calculate cardiovascular health.
public class Assignment3Part1 extends TextProgram {

    //I added counter of days as constanta.
    private static final int COUNT_OF_DAYS = 7;
    //Cardio health means lower than need for day training.
    private static final int CARDIO_HEALTH = 29;
    //Blood health mead lower than need for day training.
    private static final int BLOOD_HEALTH = 39;

    public void run(){

        for (int i = 0; i<COUNT_OF_DAYS; i++){
            calculate(readNumber(i));
        }
        resultCardio();
        resultBlood();

    }

    //I added this variable to count wonderful blood days.
    int blood = 0;
    /**
     * Method print result of blood health
     */
    private void resultBlood() {

        if (blood>2){
            System.out.println(" Blood pressure: " +
                    "Great job! You've done enough exercise to keep a low blood pressure.");
        } else {
            System.out.println(" Blood pressure: " +
                    "You needed to train hard for at least " + (3 - blood) + " more day(s) a week!");
        }
    }

    /**
     * Method print result for cardio health
     */
    private void resultCardio() {
        if (cardio>4){
            System.out.println("Cardiovascular health: " +
                    "Great job! You've done enough exercise for cardiovascular health.");
        }
        else {
            System.out.println("Cardiovascular health: " +
                    " You needed to train hard for at least " + (5 - cardio) + " more day(s) a week!");
        }
    }


    /**
     * Method calculates users number
     * @param i user number
     */
    private void calculate(int i) {
        calculateForCardio(i);
        calculateForBlood(i);

    }

    /**
     * Method calculate wonderful days for bllod.
     * @param i number
     */
    private void calculateForBlood(int i) {
        if (i > BLOOD_HEALTH){
            blood = blood +1;
        }
    }
    //I created variable for count wonderful cardio days.
    int cardio = 0;

    /**
     * Method analyze number for cardio
     * @param i number
     */
    private void calculateForCardio(int i) {
        if (i > CARDIO_HEALTH){
            cardio = cardio +1;
        }
    }

    /**
     * Method read number that user train this day.
     * @param i we use it for print in console
     * @return number
     */
    private int readNumber(int i) {
        int number = readInt("How many minutes did you do on day " + (i + 1) + "?");
        return number;
    }
}