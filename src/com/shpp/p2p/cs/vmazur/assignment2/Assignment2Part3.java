package com.shpp.p2p.cs.vmazur.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
//Program creates pawprints.
public class Assignment2Part3 extends WindowProgram {

    private static final double FIRST_TOE_OFFSET_X = 0;
    private static final double FIRST_TOE_OFFSET_Y = 20;
    private static final double SECOND_TOE_OFFSET_X = 30;
    private static final double SECOND_TOE_OFFSET_Y = 0;
    private static final double THIRD_TOE_OFFSET_X = 60;
    private static final double THIRD_TOE_OFFSET_Y = 20;

    /* The position of the heel relative to the upper-left
     * corner of the pawprint.
     */
    private static final double HEEL_OFFSET_X = 20;
    private static final double HEEL_OFFSET_Y = 40;

    /* Each toe is an oval with this width and height. */
    private static final double TOE_WIDTH = 20;
    private static final double TOE_HEIGHT = 30;

    /* The heel is an oval with this width and height. */
    private static final double HEEL_WIDTH = 40;
    private static final double HEEL_HEIGHT = 60;

    /* The default width and height of the window. These constants will tell Java to
     * create a window whose size is *approximately* given by these dimensions. You should
     * not directly use these constants in your program; instead, use getWidth() and
     * getHeight(), which return the *exact* width and height of the window.
     */
    public static final int APPLICATION_WIDTH = 270;
    public static final int APPLICATION_HEIGHT = 220;

    public void run() {
        drawPawprint(20, 20);
        drawPawprint(180, 70);
    }

    /**
     * Draws a pawprint. The parameters should specify the upper-left corner of the
     * bounding box containing that pawprint.
     *
     * @param x The x coordinate of the upper-left corner of the bounding box for the pawprint.
     * @param y The y coordinate of the upper-left corner of the bounding box for the pawprint.
     */
    private void drawPawprint(double x, double y) {
        for (int i = 0; i < 4; i++) {
            creategOval(x, y, i);

        }
    }
    /*/
    Method creates simple ovals.
    He changes coordinates of ovals, and it sizes dependency of out cycles from method drawPawprint throw int i)
     */
    private void creategOval(double x, double y, int i) {
        double xx = FIRST_TOE_OFFSET_X;
        double yy = FIRST_TOE_OFFSET_Y;
        double xWidth = TOE_WIDTH;
        double yHeight = TOE_HEIGHT;

        if (i == 1) {
            xx = SECOND_TOE_OFFSET_X;
            yy = SECOND_TOE_OFFSET_Y;
        }

        if (i == 2) {
            xx = THIRD_TOE_OFFSET_X;
            yy = THIRD_TOE_OFFSET_Y;
        }

        if (i == 3) {
            xx = HEEL_OFFSET_X;
            yy = HEEL_OFFSET_Y;
            xWidth = HEEL_WIDTH;
            yHeight = HEEL_HEIGHT;
        }


        GOval gOval = new GOval(
                x + xx,
                y + yy,
                xWidth,
                yHeight);
        gOval.setFilled(true);
        gOval.setColor(Color.BLACK);
        add(gOval);
    }
}
