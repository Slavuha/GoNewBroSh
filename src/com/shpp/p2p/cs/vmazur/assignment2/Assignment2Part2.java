package com.shpp.p2p.cs.vmazur.assignment2;

import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

// Program create optical illusion.
public class Assignment2Part2 extends WindowProgram {
    public static final int APPLICATION_WIDTH = 777;
    public static final int APPLICATION_HEIGHT = 111;
    public static final double CIRCLE_DIAMETER = (APPLICATION_HEIGHT < APPLICATION_WIDTH) ?
            (APPLICATION_HEIGHT / 3) : (APPLICATION_WIDTH / 3);

    public void run() {
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 2; x++) {
                createCircle(y, x);
            }
        }
        createRect();
    }
    //Method creates a Rect regards to task
    private void createRect() {
        GRect gRect = new GRect(
                CIRCLE_DIAMETER / 2,
                CIRCLE_DIAMETER / 2,
                getWidth() - CIRCLE_DIAMETER,
                getHeight() - CIRCLE_DIAMETER
        );
        gRect.setFilled(true);
        gRect.setColor(Color.WHITE);
        add(gRect);
    }

    // This method create circle, according to cycles.
    private void createCircle(int y, int x) {
        int yy = 0;
        int xx = 0;
        if (y == 1) {
            yy = (int) (getHeight() - CIRCLE_DIAMETER);
        }
        if (x == 1) {
            xx = (int) (getWidth() - CIRCLE_DIAMETER);

        }
        GOval gOval = new GOval(
                xx,
                yy,
                CIRCLE_DIAMETER, CIRCLE_DIAMETER);
        gOval.setFilled(true);
        gOval.setColor(Color.BLACK);
        add(gOval);
    }
}

