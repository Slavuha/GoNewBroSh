package com.shpp.p2p.cs.vmazur.assignment1;


import com.shpp.karel.KarelTheRobot;

//Program midpoint
    public class Assignment1Part3 extends KarelTheRobot {
        public void run() throws Exception {
            putBeeper();
            if (frontIsClear()) {
                move();
            }
            while (frontIsClear() && !beepersPresent()) {
                fillRow();
            }
            cleanLastBeepers();
            returnToMid();
            move();
            cleanLastBeepers();
            returnToMid();
        }
        //This method helps Karel to return to mid of level after cleaned row.
        private void returnToMid() throws Exception {
            turnArround();
            while (noBeepersPresent()) {
                move();
            }
        }
        //This method is filling beepers in Row.
        private void fillRow() throws Exception {
            while (frontIsClear() && !beepersPresent()) {
                move();
            }
            if (!beepersPresent()) {
                putBeeper();
            }
            turnArround();
            move();
            if (!beepersPresent()) {
                putBeeper();
            } else {
                move();
            }
            move();
        }
        //Karel cleaned last beepers.
        private void cleanLastBeepers() throws Exception {
            if (beepersPresent()) {
                pickBeeper();
            }
            if (frontIsClear()) {
                move();
            }
            while (frontIsClear()) {
                if (beepersPresent()) {
                    pickBeeper();
                }
                if (frontIsClear()) {
                    move();
                }
            }
            if (beepersPresent()) {
                pickBeeper();
            }
        }
        //Karel turned 180 grads.
        private void turnArround() throws Exception {
            turnLeft();
            turnLeft();
        }
    }





