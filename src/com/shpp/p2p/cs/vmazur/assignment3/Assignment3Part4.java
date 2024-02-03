package com.shpp.p2p.cs.vmazur.assignment3;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment3Part4 extends WindowProgram {
    //I created constants regards to task: height, width of bricks and of course how many bricks in base
    private static final int BRICK_HEIGHT = 50;
    private static final int BRICK_WIDTH = 100;
    private static final int BRICKS_IN_BASE = 7;

    public void run() {
        createPyramid();
    }
    //I added variable to control process
    int counter = BRICKS_IN_BASE;

    /**
     * The method create Pyramid cycle while with counter and summon method createRow
     */
    private void createPyramid() {
        //I added this two local variable to control process
        int y = 0;
        int f = 0;

        while (counter > 0) {
            createRow(y, f);
            counter = counter - 1; //After row have been created counter decries so next row has fewer bricks
            y = y + BRICK_HEIGHT; //Here I control y coordinate
            f = f + (BRICK_WIDTH / 2); //Here I control x coordinate of bricks
        }
    }

    /**
     * Method creates row
     * @param y from method createPyramid to control y coordinate of bricks
     * @param f from method createPyramid to control x coordinate of bricks
     */
    private void createRow(int y, int f) {

        for (int i = 0; i < counter; i++) {
            creteBrick(i, y, f);
        }
    }

    /**
     * Method creates simple brick
     * @param i All these parameters regulate locations of brick regards to task
     * @param y
     * @param f
     */
    private void creteBrick(int i, int y, int f) {
        GRect gRect = new GRect(
                getWidth() / 2 - (BRICKS_IN_BASE * BRICK_WIDTH) / 2 + (i * BRICK_WIDTH) + f,
                getHeight() - BRICK_HEIGHT - y,
                BRICK_WIDTH,
                BRICK_HEIGHT
        );
        gRect.setFilled(true);
        gRect.setColor(Color.PINK);
        gRect.setFillColor(Color.GREEN);
        add(gRect);
    }
}
