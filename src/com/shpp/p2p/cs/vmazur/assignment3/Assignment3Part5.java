package com.shpp.p2p.cs.vmazur.assignment3;

import com.shpp.cs.a.console.TextProgram;

import java.util.Random;

//Program casino
public class Assignment3Part5 extends TextProgram {
    Random coin = new Random(); //I added clas Random to imitate process with coin (eagle and tail)
    int lackysMoney = 0; //I added this variable to calculate total Lack's money
    int counter = 0; //I added this variable to calculate total games
    int gameBank = 1; //I added this variable to calculate total money per game

    public void run() {
        game();
        System.out.println("It took " + counter + " games to earn $20");
    }

    /**
     * This is a main method of game.
     * It dependence of eagle or tail.
     */
    private void game() {
        while (lackysMoney < 20) { //Program stop if Lack win 20 backs
            int randomNumber = coin.nextInt(); //Here I created random number

            if (randomNumber % 2 == 0) { //If it tails.
                lackysMoney = lackysMoney + gameBank;
                System.out.println("This game, you earned " + gameBank);
                System.out.println("Your total is " + lackysMoney);
                gameBank = 1;
                counter++;
            }
            eagle(); //else eagle
        }
    }

    /**
     * This method simple pluses game bank x2 and create game again.
     */
    private void eagle() {

        gameBank = gameBank + gameBank;
        game();
    }
}
