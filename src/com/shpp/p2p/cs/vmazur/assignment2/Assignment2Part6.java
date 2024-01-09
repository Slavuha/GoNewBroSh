package com.shpp.p2p.cs.vmazur.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

//Program creates caterpillar
public class Assignment2Part6 extends WindowProgram {
    public static final int LENGTH_OF_CATERPILLAR = 6;
    public static final int RADIUS_OF_CATERPILLAR = 170;

    public void run() {
        //I created two double to control x and y coordinate of ovals.
        double x = 0;
        double y = getHeight() / 2 - RADIUS_OF_CATERPILLAR / 2;
        for (int i = 1; i < LENGTH_OF_CATERPILLAR + 1; i++) {
            if (i % 2 == 0) {
                y = y - RADIUS_OF_CATERPILLAR / 3;
            }
            createOval(x, y);
            x = i * (RADIUS_OF_CATERPILLAR) / 2;
            y = getHeight() / 2 - RADIUS_OF_CATERPILLAR / 2;
        }
    }
    //Method creates ovals.
    //We located oval for task needs trowths x and y doubles from Run.
    private void createOval(double x, double y) {
        GOval gOval = new GOval(
                x,
                y,
                RADIUS_OF_CATERPILLAR,
                RADIUS_OF_CATERPILLAR);
        gOval.setFilled(true);
        gOval.setFillColor(Color.GREEN);
        gOval.setColor(Color.RED);
        add(gOval);
    }
}

