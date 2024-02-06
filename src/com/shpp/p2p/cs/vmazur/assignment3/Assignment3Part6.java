package com.shpp.p2p.cs.vmazur.assignment3;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

//Animation Bro
public class Assignment3Part6 extends WindowProgram {
    private static final double PAUSE_TIME = 1000.0 / 50; //Pause time for FPS
    private static final double OVAL_RADIUS = 111; //Simple radius

    private static final double TASK_TIME = 5000;

    public void run() {
        long start = System.currentTimeMillis(); //I created variable start to control time
        creteOval();

        while (System.currentTimeMillis() - start < TASK_TIME) {
            gOval.move(3, -1.5);
            pause(PAUSE_TIME);
            System.out.println(System.currentTimeMillis() - start);
        }
    }

    GOval gOval; //Here I created oval to take access to it from run.

    /**
     * Method creates simple oval in left conner of canvas.
     */
    private void creteOval() {
        gOval = new GOval(
                0,
                getHeight() - OVAL_RADIUS,
                OVAL_RADIUS,
                OVAL_RADIUS);
        gOval.setFilled(true);
        gOval.setFillColor(Color.green);
        add(gOval);
    }
}
