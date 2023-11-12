package com.shpp.p2p.cs.vmazur.assignment1;

import com.shpp.karel.KarelTheRobot;

//Program stone mansion
public class Assignment1Part2 extends KarelTheRobot {
    public void run() throws Exception {
        turnLeft();
        goToRow();
        goBack();
        while (frontIsClear()) {
            moveToNextRowAndCheckIt();
        }
    }
    //Karel goes to next row and check it.
    private void moveToNextRowAndCheckIt() throws Exception {
        move();
        move();
        move();
        move();
        turnLeft();
        goToRow();
        goBack();

    }
    //Karel go back to start position.
    private void goBack() throws Exception {
        TurnArround();
        while (frontIsClear()) {
            move();
        }
        turnLeft();
    }
    //Simple turn around 180 gradius.
    private void TurnArround() throws Exception {
        turnLeft();
        turnLeft();
    }
    // Method witch help Karel go to the end of row and fill it beepers.
    private void goToRow() throws Exception {
        while (frontIsClear()) {
            if (!beepersPresent()) {
                putBeeper();
            }
            if (beepersPresent()) {
                move();
                if (!beepersPresent()) {
                    putBeeper();
                }
            }
        }
    }
}