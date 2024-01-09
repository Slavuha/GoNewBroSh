package com.shpp.p2p.cs.vmazur.assignment2;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
//Program creates matrix for Neo
public class Assignment2Part5 extends WindowProgram {
    /* The number of rows and columns in the grid, respectively. */
    private static final int NUM_COLS = 6;
    private static final int NUM_ROWS = 5;

    /* The width and height of each box. */
    private static final double BOX_SIZE = 40;

    /* The horizontal and vertical spacing between the boxes. */
    private static final double BOX_SPACING = 10;
    //I add two different for manipulate bricks.
    double helpX = 0;
    double helpY = 0;

    public void run() {
        setSize(777, 777);
        for (int y = 1; y < NUM_ROWS + 1; y++) {
            for (int i = 1; i < NUM_COLS + 1; i++) {
                createBrick(helpX, helpY);
                helpX = i * (BOX_SIZE + BOX_SPACING);
            }
            helpY = y * (BOX_SIZE + BOX_SPACING);
            helpX = 0;


        }
    }
    //Method creates brick in need location.
    private void createBrick(double i, double y) {
        GRect gRect = new GRect(
                (getWidth() / 2 - (NUM_COLS * ((BOX_SIZE + BOX_SPACING) / 2))) + helpX,
                (getHeight() / 2 - (NUM_COLS * ((BOX_SIZE + BOX_SPACING) / 2))) + helpY,
                BOX_SIZE, BOX_SIZE
        );
        gRect.setFilled(true);
        gRect.setColor(Color.black);
        add(gRect);

    }
}
