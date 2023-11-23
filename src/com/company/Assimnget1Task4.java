package com.company;

public class Assimnget1Task4 {
    package com.shpp.p2p.cs.vmazur.assignment1;
import com.shpp.karel.KarelTheRobot;

    //Program Chess board
    public class Assignment1Part4 extends KarelTheRobot {
        @Override
        public void run() throws Exception {
            putBeeper();
            goToLeftRow();
            turnRight();
            if (frontIsClear()) {
                move();
                understandHowRight();
            }

            while (frontIsClear()) {
                undestoodDirection();
                goingToTheRowAndFillBeepers();
                understandKarel();
                if
                (frontIsClear())
                    move();
                understandHowRight();
            }
            karelExecuteLastRow();
        }
        //At this moment Karel must think, to create chess row.
        //All dependency of bipper at pervious row, so Karel return and investigate it.
        // After Karel pick right chose.
        private void understandHowRight() throws Exception {
            turnAround();
            move();
            turnAround();
            if (beepersPresent()) {
                move();
            } else {
                move();
                if (!beepersPresent())
                    putBeeper();
            }
        }
        //Karel almost finish his daily job so this is las row.
        private void karelExecuteLastRow() throws Exception {
            undestoodDirection();
            goingToTheRowAndFillBeepers();

        }
        //At this moment Karel chose rite side to go.
        //All dependency of !FasingNorth.
        private void understandKarel() throws Exception {
            if (notFacingNorth()) {
                turnLeft();
            } else {
                turnRight();
            }
        }
        //This method calculate right direction.
        //All dependence of Left is blocked.
        private void undestoodDirection() throws Exception {
            if (leftIsBlocked()) {
                turnRight();
            } else {
                turnLeft();
            }
        }

        //Karel go to his first left row. P.S. Vlad hello)
        private void goToLeftRow() throws Exception {

            turnLeft();
            goingToTheRowAndFillBeepers();

        }

        /**
         * Karel turn 1800 degree.
         *
         * @throws Exception
         */
        private void turnAround() throws Exception {
            turnLeft();
            turnLeft();
        }

        /**
         * Karel wants to turn to the clock 90 degree;
         * Result: Karel turn 90 degree.
         *
         * @throws Exception
         */
        private void turnRight() throws Exception {
            for (int i = 0; i < 3; i++) {
                turnLeft();
            }
        }

        // Karel go above all row and fill it beepers.
        private void goingToTheRowAndFillBeepers() throws Exception {
            while (frontIsClear()) {
                if (beepersPresent()) {
                    move();
                    if (frontIsClear()) {
                        move();
                        putBeeper();
                    }
                } else {
                    if (frontIsClear()) {
                        move();
                        if (!beepersPresent())
                            putBeeper();
                    }
                }
            }
        }
    }


}
